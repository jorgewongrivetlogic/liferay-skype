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

package com.rivetlogic.skype.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SkypeGroup}.
 * </p>
 *
 * @author Rivet Logic
 * @see SkypeGroup
 * @generated
 */
public class SkypeGroupWrapper implements SkypeGroup, ModelWrapper<SkypeGroup> {
	public SkypeGroupWrapper(SkypeGroup skypeGroup) {
		_skypeGroup = skypeGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return SkypeGroup.class;
	}

	@Override
	public String getModelClassName() {
		return SkypeGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("skypeGroupId", getSkypeGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupName", getGroupName());
		attributes.put("skypeContacts", getSkypeContacts());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long skypeGroupId = (Long)attributes.get("skypeGroupId");

		if (skypeGroupId != null) {
			setSkypeGroupId(skypeGroupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String skypeContacts = (String)attributes.get("skypeContacts");

		if (skypeContacts != null) {
			setSkypeContacts(skypeContacts);
		}
	}

	/**
	* Returns the primary key of this skype group.
	*
	* @return the primary key of this skype group
	*/
	@Override
	public long getPrimaryKey() {
		return _skypeGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this skype group.
	*
	* @param primaryKey the primary key of this skype group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_skypeGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the skype group ID of this skype group.
	*
	* @return the skype group ID of this skype group
	*/
	@Override
	public long getSkypeGroupId() {
		return _skypeGroup.getSkypeGroupId();
	}

	/**
	* Sets the skype group ID of this skype group.
	*
	* @param skypeGroupId the skype group ID of this skype group
	*/
	@Override
	public void setSkypeGroupId(long skypeGroupId) {
		_skypeGroup.setSkypeGroupId(skypeGroupId);
	}

	/**
	* Returns the user ID of this skype group.
	*
	* @return the user ID of this skype group
	*/
	@Override
	public long getUserId() {
		return _skypeGroup.getUserId();
	}

	/**
	* Sets the user ID of this skype group.
	*
	* @param userId the user ID of this skype group
	*/
	@Override
	public void setUserId(long userId) {
		_skypeGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this skype group.
	*
	* @return the user uuid of this skype group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skypeGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this skype group.
	*
	* @param userUuid the user uuid of this skype group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_skypeGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this skype group.
	*
	* @return the user name of this skype group
	*/
	@Override
	public java.lang.String getUserName() {
		return _skypeGroup.getUserName();
	}

	/**
	* Sets the user name of this skype group.
	*
	* @param userName the user name of this skype group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_skypeGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this skype group.
	*
	* @return the create date of this skype group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _skypeGroup.getCreateDate();
	}

	/**
	* Sets the create date of this skype group.
	*
	* @param createDate the create date of this skype group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_skypeGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this skype group.
	*
	* @return the modified date of this skype group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _skypeGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this skype group.
	*
	* @param modifiedDate the modified date of this skype group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_skypeGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the group name of this skype group.
	*
	* @return the group name of this skype group
	*/
	@Override
	public java.lang.String getGroupName() {
		return _skypeGroup.getGroupName();
	}

	/**
	* Sets the group name of this skype group.
	*
	* @param groupName the group name of this skype group
	*/
	@Override
	public void setGroupName(java.lang.String groupName) {
		_skypeGroup.setGroupName(groupName);
	}

	/**
	* Returns the skype contacts of this skype group.
	*
	* @return the skype contacts of this skype group
	*/
	@Override
	public java.lang.String getSkypeContacts() {
		return _skypeGroup.getSkypeContacts();
	}

	/**
	* Sets the skype contacts of this skype group.
	*
	* @param skypeContacts the skype contacts of this skype group
	*/
	@Override
	public void setSkypeContacts(java.lang.String skypeContacts) {
		_skypeGroup.setSkypeContacts(skypeContacts);
	}

	@Override
	public boolean isNew() {
		return _skypeGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_skypeGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _skypeGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_skypeGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _skypeGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _skypeGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_skypeGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _skypeGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_skypeGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_skypeGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_skypeGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SkypeGroupWrapper((SkypeGroup)_skypeGroup.clone());
	}

	@Override
	public int compareTo(com.rivetlogic.skype.model.SkypeGroup skypeGroup) {
		return _skypeGroup.compareTo(skypeGroup);
	}

	@Override
	public int hashCode() {
		return _skypeGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rivetlogic.skype.model.SkypeGroup> toCacheModel() {
		return _skypeGroup.toCacheModel();
	}

	@Override
	public com.rivetlogic.skype.model.SkypeGroup toEscapedModel() {
		return new SkypeGroupWrapper(_skypeGroup.toEscapedModel());
	}

	@Override
	public com.rivetlogic.skype.model.SkypeGroup toUnescapedModel() {
		return new SkypeGroupWrapper(_skypeGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _skypeGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _skypeGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_skypeGroup.persist();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return _skypeGroup.toJSON();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkypeGroupWrapper)) {
			return false;
		}

		SkypeGroupWrapper skypeGroupWrapper = (SkypeGroupWrapper)obj;

		if (Validator.equals(_skypeGroup, skypeGroupWrapper._skypeGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SkypeGroup getWrappedSkypeGroup() {
		return _skypeGroup;
	}

	@Override
	public SkypeGroup getWrappedModel() {
		return _skypeGroup;
	}

	@Override
	public void resetOriginalValues() {
		_skypeGroup.resetOriginalValues();
	}

	private SkypeGroup _skypeGroup;
}