/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.skype.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.util.List;

/**
 * The extended model implementation for the SkypeGroup service. Represents a row in the &quot;rivetlogic_skype_SkypeGroup&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.skype.model.SkypeGroup} interface.
 * </p>
 *
 * @author Rivet Logic
 */
@ProviderType
public class SkypeGroupImpl extends SkypeGroupBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a skype group model instance should use the {@link com.rivetlogic.skype.model.SkypeGroup} interface instead.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SkypeGroupImpl.class);

	public static final String SKYPE_GROUP_ID = "skype-group-id";
	public static final String SKYPE_GROUP_NAME = "skype-group-name";
	public static final String USER_ID = "user-id";
	public static final String USER_NAME = "user-name";
	public static final String CREATE_DATE = "create-date";
	public static final String MODIFIED_DATE = "modified-date";
	public static final String IDS = "ids";
	public static final String FIRST_NAME = "first-name";
	public static final String LAST_NAME = "last-name";
	public static final String SKYPE_SCREEN_NAME = "skype-sn";
	public static final String IS_SKYPE = "is-skype";
	public static final String PRIMARY_PHONE = "primary-phone";

	public SkypeGroupImpl() {
	}

	public JSONObject toJSON(){
		JSONObject doc = JSONFactoryUtil.createJSONObject();
		doc.put(SKYPE_GROUP_ID, getSkypeGroupId());
		doc.put(SKYPE_GROUP_NAME, getGroupName());
		doc.put(USER_ID, getUserId());
		doc.put(USER_NAME, getUserName());
		doc.put(CREATE_DATE, getCreateDate());
		doc.put(MODIFIED_DATE, getModifiedDate());
		doc.put(IDS, getContactsArray());
		return doc;
	}

	private JSONArray getContactsArray() {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		Long userId = null;
		boolean isSkype = false;
		User user = null;
		JSONObject item = null;
		JSONObject value = null;
		JSONArray contacts = null;
		try {
			contacts = JSONFactoryUtil.createJSONArray(getSkypeContacts());
			if(contacts != null){
				for(int i = 0;  contacts.length() > i; i++){
					item = contacts.getJSONObject(i);
					userId = item.getLong(USER_ID);
					isSkype = item.getBoolean(IS_SKYPE);
					try {
						user = UserLocalServiceUtil.getUser(userId);
					} catch (PortalException e) {
						LOG.error(e);
					}
					if(user != null){
						value = JSONFactoryUtil.createJSONObject();
						value.put(FIRST_NAME, user.getFirstName());
						value.put(LAST_NAME, user.getLastName());
						value.put(USER_ID, user.getUserId());
						if(isSkype){
							value.put(SKYPE_SCREEN_NAME, getSkypeScreenName(user));
							value.put(PRIMARY_PHONE, StringPool.BLANK);
						}else{
							value.put(PRIMARY_PHONE, getPrimaryPhone(user));
							value.put(SKYPE_SCREEN_NAME, StringPool.BLANK);
						}

						value.put(IS_SKYPE, isSkype);
						array.put(value);
					}
				}
			}

		} catch (JSONException e) {
			LOG.error(e);
		}

		return array;
	}

	private static String getSkypeScreenName(User user){
		String skypeSN = StringPool.BLANK;
		try{
			Contact contact = user.getContact();
			if(contact.getSkypeSn() != null){
				skypeSN = contact.getSkypeSn();
			}
		}catch (Exception e) {
			LOG.debug(e);
		}
		return skypeSN;
	}

	private static String getPrimaryPhone(User user){
		String primaryPhone = StringPool.BLANK;
		try{
			List<Phone> phones = user.getPhones();
			for(Phone phone : phones){
				if(phone.isPrimary()){
					primaryPhone = phone.getNumber();
				}
			}
		}catch (Exception e) {
			LOG.debug(e);
		}
		return primaryPhone;
	}

}