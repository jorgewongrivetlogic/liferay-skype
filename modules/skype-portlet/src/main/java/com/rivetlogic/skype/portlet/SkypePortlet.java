package com.rivetlogic.skype.portlet;

import aQute.bnd.annotation.metatype.Configurable;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.rivetlogic.skype.beans.ContactsBean;
import com.rivetlogic.skype.beans.GroupsBean;
import com.rivetlogic.skype.beans.PreferencesBean;
import com.rivetlogic.skype.config.Configuration;
import com.rivetlogic.skype.model.SkypeGroup;
import com.rivetlogic.skype.service.SkypeGroupLocalServiceUtil;
import com.rivetlogic.skype.service.persistence.SkypeGroupUtil;
import com.rivetlogic.skype.util.SkypeUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.rivetlogic.skype.util.Constants.*;
import static com.rivetlogic.skype.util.Constants.IDS;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.social",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.name=skype",
        "javax.portlet.display-name=Skype Chat & IM",
        "javax.portlet.portlet-mode=text/html;VIEW,EDIT,HELP",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.edit-jsp=/html/edit.jsp",
        "javax.portlet.init-param.help-template=/html/help.jsp",
        "javax.portlet.init-param.view-template=/html/view.jsp",
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=administrator,guest,power-user,user",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.header-portlet-css=/css/main_responsive.css",
        "com.liferay.portlet.footer-portlet-javascript=/js/main.js",
        "com.liferay.portlet.footer-portlet-javascript=/js/rivet-aui-pagination.js",
        "com.liferay.portlet.footer-portlet-javascript=/js/thirdparty/skype-uri.js"
    },
    service = Portlet.class,
    configurationPid = "com.rivetlogic.skype.config.Configuration"
)

/**
 * @author christopherjimenez
 *
 */
public class SkypePortlet extends MVCPortlet {

    private static final Log LOG = LogFactoryUtil.getLog(SkypePortlet.class);

    private volatile Configuration configuration;

    @Override
    public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        PreferencesBean prefBean = new PreferencesBean(request, getDefaultDeltaView());
        request.setAttribute(SIGNED_IN, themeDisplay.isSignedIn());
        request.setAttribute(PREF_BEAN, prefBean);
        super.render(request, response);
    }

    public void savePreferences(ActionRequest request, ActionResponse response) throws ReadOnlyException, ValidatorException, IOException{
        PreferencesBean prefBean = new PreferencesBean();
        prefBean.save(request);
        SessionMessages.add(request, PortalUtil.getPortletId(request) +
                SessionMessages.KEY_SUFFIX_UPDATED_PREFERENCES);

        String redirect = getRedirect(request, response);

        if (Validator.isNotNull(redirect)) {
            response.sendRedirect(redirect);
        }
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response)
            throws IOException, PortletException {
        String cmd = ParamUtil.getString(request, CMD);
        JSONObject jsonResponse = null;

        if (CMD_LIST_USERS.equalsIgnoreCase(cmd)) {
            listUsers(request, response);
        } else if(CMD_LIST_GROUPS.equalsIgnoreCase(cmd)){
            listGroups(request, response);
        } else if(CMD_ADD_GROUP.equalsIgnoreCase(cmd)){
            jsonResponse = JSONFactoryUtil.createJSONObject();
            addGroup(request, response, jsonResponse);
        } else if(CMD_UPDATE_GROUP.equalsIgnoreCase(cmd)){
            jsonResponse = JSONFactoryUtil.createJSONObject();
            updateGroup(request, response, jsonResponse);
        } else if(CMD_UPDATE_GROUP_NAME.equalsIgnoreCase(cmd)){
            jsonResponse = JSONFactoryUtil.createJSONObject();
            updateGroupName(request, response, jsonResponse);
        } else if(CMD_GET_GROUP.equalsIgnoreCase(cmd)){
            jsonResponse = JSONFactoryUtil.createJSONObject();
            getGroupInfo(request, response, jsonResponse);
        } else if(CMD_REMOVE_GROUP.equalsIgnoreCase(cmd)){
            jsonResponse = JSONFactoryUtil.createJSONObject();
            removeGroup(request, response, jsonResponse);
        }

        if(jsonResponse != null){
            SkypeUtil.returnJSONObject(response, jsonResponse);
        }
    }

    private void listUsers(PortletRequest request, PortletResponse response){
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        ContactsBean cb = new ContactsBean(themeDisplay.getUserId(), themeDisplay.getCompanyId(), getDefaultDeltaView());
        cb.setCurPage(ParamUtil.getInteger(request, CURRENT_PAGE, DEFAULT_ELEMENT_VALUE));
        cb.setDelta(ParamUtil.getInteger(request, DELTA, getDefaultDeltaView()));
        cb.setStart(cb.getCurPage() * cb.getDelta() - cb.getDelta());
        cb.setEnd(cb.getStart() + cb.getDelta());

        cb.setObc(SkypeUtil.getSkypeComparator(ParamUtil.getString(request, ORDER_BY_COL, FIRST_NAME),
                ParamUtil.getBoolean(request, IS_ASC, true)));
        cb.setSearch(ParamUtil.getString(request, SEARCH, null));

        cb.load();

        LOG.debug("Results: " + cb.toJSON());
        SkypeUtil.returnJSONObject(response, cb.toJSON());
    }

    private void listGroups(PortletRequest request, PortletResponse response){
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        GroupsBean gb = new GroupsBean(themeDisplay.getUserId(), getDefaultDeltaView());
        gb.setCurPage(ParamUtil.getInteger(request, CURRENT_PAGE, DEFAULT_ELEMENT_VALUE));
        gb.setDelta(ParamUtil.getInteger(request, DELTA, getDefaultDeltaView()));
        gb.setStart(gb.getCurPage() * gb.getDelta() - gb.getDelta());
        gb.setEnd(gb.getStart() + gb.getDelta());

        gb.load();

        LOG.debug("Results: " + gb.toJSON());
        SkypeUtil.returnJSONObject(response, gb.toJSON());
    }

    private void addGroup(PortletRequest request, PortletResponse response, JSONObject jsonResponse){
        try {
            List<String> errors = new ArrayList<String>();
            SkypeGroup sg = skypeGroupFromRequest(request);
            if(SkypePortletValidator.validateCreateGroup(sg, errors)){
                SkypeGroupLocalServiceUtil.createSkypeGroup(sg);
                jsonResponse.put(SKYPE_GROUP_ID, sg.getSkypeGroupId());
                jsonResponse.put(CMD_SUCCESS, true);
            }else{
                jsonResponse.put(ERRORS, ListUtil.toString(errors, StringPool.BLANK, StringPool.COMMA));
                jsonResponse.put(CMD_SUCCESS, false);
            }

        } catch (JSONException e) {
            jsonResponse.put(CMD_SUCCESS, false);
            LOG.error("Wrong format in ids: ", e);
        }catch(Exception se){
            jsonResponse.put(CMD_SUCCESS, false);
            LOG.error(se);
        }

    }

    private void updateGroup(PortletRequest request, PortletResponse response, JSONObject jsonResponse){
        Long skypeGroupId = ParamUtil.getLong(request, SKYPE_GROUP_ID, UNDEFINED_ID);
        SkypeGroup skypeGroup = null;
        if(UNDEFINED_ID != skypeGroupId){
            try {
                List<String> errors = new ArrayList<String>();
                skypeGroup = SkypeGroupLocalServiceUtil.getSkypeGroup(skypeGroupId);
                JSONArray obj = contactsFromRequest(request);
                skypeGroup.setGroupName(ParamUtil.getString(request, SKYPE_GROUP_NAME));
                skypeGroup.setSkypeContacts(obj.toString());

                if(SkypePortletValidator.validateUpdateGroup(skypeGroup, errors)){
                    SkypeGroupLocalServiceUtil.updateSkypeGroup(skypeGroup);
                    jsonResponse.put(CMD_SUCCESS, true);
                }else{
                    jsonResponse.put(ERRORS, ListUtil.toString(errors, StringPool.BLANK, StringPool.COMMA));
                    jsonResponse.put(CMD_SUCCESS, false);
                }

            }catch (JSONException e) {
                jsonResponse.put(CMD_SUCCESS, false);
                LOG.error("Wrong format in ids: ", e);
            }catch (Exception e) {
                jsonResponse.put(CMD_SUCCESS, false);
                LOG.error(e);
            }

        }else{
            jsonResponse.put(CMD_SUCCESS, false);
        }
    }

    private void updateGroupName(PortletRequest request, PortletResponse response, JSONObject jsonResponse){
        Long skypeGroupId = ParamUtil.getLong(request, SKYPE_GROUP_ID, UNDEFINED_ID);
        SkypeGroup skypeGroup = null;
        if(UNDEFINED_ID != skypeGroupId){
            try {
                List<String> errors = new ArrayList<String>();
                skypeGroup = SkypeGroupLocalServiceUtil.getSkypeGroup(skypeGroupId);
                skypeGroup.setGroupName(ParamUtil.getString(request, SKYPE_GROUP_NAME));
                if(SkypePortletValidator.validateUpdateGroup(skypeGroup, errors)){
                    SkypeGroupLocalServiceUtil.updateSkypeGroup(skypeGroup);
                    jsonResponse.put(CMD_SUCCESS, true);
                }else{
                    jsonResponse.put(CMD_SUCCESS, false);
                }

            }catch (JSONException e) {
                jsonResponse.put(CMD_SUCCESS, false);
                LOG.error("Wrong format in ids: ", e);
            }catch (Exception e) {
                jsonResponse.put(CMD_SUCCESS, false);
                LOG.error(e);
            }

        }else{
            jsonResponse.put(CMD_SUCCESS, false);
        }
    }

    private void getGroupInfo(PortletRequest request, PortletResponse response, JSONObject jsonResponse){
        Long skypeGroupId = ParamUtil.getLong(request, SKYPE_GROUP_ID, UNDEFINED_ID);
        SkypeGroup skypeGroup = null;
        if(UNDEFINED_ID != skypeGroupId){
            try {
                skypeGroup = SkypeGroupLocalServiceUtil.getSkypeGroup(skypeGroupId);
                jsonResponse.put(GROUP_INFO, skypeGroup.toJSON());
            } catch (Exception e) {
                jsonResponse.put(CMD_SUCCESS, false);
                LOG.error(e);
            }
        }else{
            jsonResponse.put(CMD_SUCCESS, false);
        }
    }

    private void removeGroup(PortletRequest request, PortletResponse response, JSONObject jsonResponse){
        Long skypeGroupId = ParamUtil.getLong(request, SKYPE_GROUP_ID, UNDEFINED_ID);

        if(UNDEFINED_ID != skypeGroupId){
            try {
                SkypeGroupLocalServiceUtil.deleteSkypeGroup(skypeGroupId);
                jsonResponse.put(CMD_SUCCESS, true);
            }catch (Exception e) {
                jsonResponse.put(CMD_SUCCESS, false);
                LOG.error(e);
            }
        }else{
            jsonResponse.put(CMD_SUCCESS, false);
        }
    }

    private SkypeGroup skypeGroupFromRequest(PortletRequest request) throws JSONException{
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        //TODO change id on create
        SkypeGroup skypeGroup = SkypeGroupUtil.create(0l);
        skypeGroup.setGroupName(ParamUtil.getString(request, SKYPE_GROUP_NAME));
        skypeGroup.setUserId(themeDisplay.getUserId());
        JSONArray obj = contactsFromRequest(request);
        skypeGroup.setSkypeContacts(obj.toString());
        return skypeGroup;
    }

    private JSONArray contactsFromRequest(PortletRequest request) throws JSONException{
        return JSONFactoryUtil.createJSONArray(ParamUtil.getString(request, IDS));
    }

    private int getDefaultDeltaView() {
        return Integer.parseInt(configuration.getDefaultDeltaView());
    }

    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        configuration = Configurable.createConfigurable(Configuration.class, properties);
    }
}
