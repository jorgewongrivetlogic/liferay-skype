/**
 * Copyright (C) 2014 Rivet Logic Corporation. All rights reserved.
 */

/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rivetlogic.skype.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rivetlogic.skype.model.SkypeGroup;
import com.rivetlogic.skype.service.base.SkypeGroupLocalServiceBaseImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the skype group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rivetlogic.skype.service.SkypeGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Rivet Logic
 * @see com.rivetlogic.skype.service.base.SkypeGroupLocalServiceBaseImpl
 * @see com.rivetlogic.skype.service.SkypeGroupLocalServiceUtil
 */
public class SkypeGroupLocalServiceImpl extends SkypeGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rivetlogic.skype.service.SkypeGroupLocalServiceUtil} to access the skype group local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SkypeGroupLocalServiceImpl.class);
	
	public List<SkypeGroup> getSkypeGroupByUserId(Long userId, int start, int end, OrderByComparator obc) throws SystemException{
		return skypeGroupPersistence.findByUserId(userId, start, end, obc);
	}
	
	public int getSkypeGroupByUserIdCount(Long userId) throws SystemException{
		return skypeGroupPersistence.countByUserId(userId);
	}
	
	public SkypeGroup createSkypeGroup(SkypeGroup skypeGroup) throws SystemException, PortalException{
		skypeGroup.setSkypeGroupId(counterLocalService.increment(SkypeGroup.class.getName()));
		User user = UserLocalServiceUtil.getUser(skypeGroup.getUserId());
		Date now = getTodayDate();
		
		skypeGroup.setUserName(user.getScreenName());
		skypeGroup.setCreateDate(now);
		skypeGroup.setModifiedDate(now);
		
		skypeGroupPersistence.update(skypeGroup);
		LOG.debug("New skypeGroup: " + skypeGroup.toJSON());
		return skypeGroup;
	}
	
	public SkypeGroup updateSkypeGroup(SkypeGroup skypeGroup) throws SystemException{
		Date now = getTodayDate();
		skypeGroup.setModifiedDate(now);
		skypeGroupPersistence.update(skypeGroup);
		LOG.debug("Contacts: " + skypeGroup.getSkypeContacts());
		return skypeGroup;
	}
	
	public SkypeGroup findByUserIdAndGroupName(Long userId, String groupName){
		SkypeGroup skypeGroup = null;
		try{
			skypeGroup = skypeGroupPersistence.findByUserIdAndGroupName(userId, groupName);
		}catch (Exception e) {
			
		}
		return skypeGroup;
	}
	
	public int countByUserIdAndGroupName(Long userId, String groupName){
		int count = 0;
		try {
			count = skypeGroupPersistence.countByUserIdAndGroupName(userId, groupName);
		} catch (SystemException e) {
			count = -1;
			LOG.error(e);
		}
		return count;
	}
	
	private Date getTodayDate(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
}