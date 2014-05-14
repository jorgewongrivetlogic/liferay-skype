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

package com.rivetlogic.skype.portlet;

import com.liferay.portal.kernel.util.StringPool;
import com.rivetlogic.skype.model.SkypeGroup;
import com.rivetlogic.skype.service.SkypeGroupLocalServiceUtil;

import static com.rivetlogic.skype.util.Constants.EMPTY_GROUP_NAME;
import static com.rivetlogic.skype.util.Constants.EMPTY_CONTACTS;
import static com.rivetlogic.skype.util.Constants.DEFAULT_ELEMENT_ID;
import static com.rivetlogic.skype.util.Constants.NOT_UNIQUE_GROUP;

import java.util.List;

/**
 * @author christopherjimenez
 *
 */
public class SkypePortletValidator {

	public static boolean validateSkypeGroup(SkypeGroup skypeGroup, List<String> errors){
		
		if(StringPool.BLANK.equals(skypeGroup.getGroupName())){
			errors.add(EMPTY_GROUP_NAME);
		}
		if(StringPool.BLANK.equals(skypeGroup.getSkypeContacts())){
			errors.add(EMPTY_CONTACTS);
		}
		
		checkUniqueName(skypeGroup, errors);
		return errors.isEmpty();
	}
	
	public static void checkUniqueName(SkypeGroup skypeGroup, List<String> errors){
		//exists, so I have to check 
		
		SkypeGroup skypeGroupFound = SkypeGroupLocalServiceUtil.
				findByByUserIdAndGroupName(skypeGroup.getUserId(), skypeGroup.getGroupName());
		if(skypeGroupFound != null){
			if(skypeGroupFound.getSkypeGroupId() != skypeGroup.getSkypeGroupId()){
				errors.add(NOT_UNIQUE_GROUP);
			}
		}
	}
}
