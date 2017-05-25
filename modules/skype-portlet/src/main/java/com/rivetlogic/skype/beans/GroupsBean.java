/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
 
package com.rivetlogic.skype.beans;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.rivetlogic.skype.model.SkypeGroup;
import com.rivetlogic.skype.util.Constants;
import com.rivetlogic.skype.util.SkypeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author christopherjimenez
 *
 */
public class GroupsBean extends PaginationBean {
	
	private Long userId;
	private List<SkypeGroup> groups;
	
	public GroupsBean(Long userId, int end) {
		super(end);
		this.userId = userId;
		groups = new ArrayList<SkypeGroup>();
	}
	
	public JSONObject toJSON(){
		JSONObject doc = JSONFactoryUtil.createJSONObject();
		doc.put(Constants.USER_ID, userId);
		doc.put(Constants.TOTAL, total);
		doc.put(Constants.GROUPS, groupsToJSON());
		return doc;
	}
	
	private JSONArray groupsToJSON(){
		JSONArray jsonGroups = JSONFactoryUtil.createJSONArray();
		for(SkypeGroup sg : groups){
			jsonGroups.put(sg.toJSON());
		}
		return jsonGroups;
	}
	
	@Override
	public void load() {
		total  = SkypeUtil.getSkypeGroupsCount(userId);
		groups = SkypeUtil.getSkypeGroups(userId, start, end, obc);
	}
}
