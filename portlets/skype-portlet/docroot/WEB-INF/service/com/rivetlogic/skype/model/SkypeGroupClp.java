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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rivetlogic.skype.service.ClpSerializer;
import com.rivetlogic.skype.service.SkypeGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rivet Logic
 */
public class SkypeGroupClp extends BaseModelImpl<SkypeGroup>
	implements SkypeGroup {
	public SkypeGroupClp() {
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
	public long getPrimaryKey() {
		return _skypeGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSkypeGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _skypeGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSkypeGroupId() {
		return _skypeGroupId;
	}

	@Override
	public void setSkypeGroupId(long skypeGroupId) {
		_skypeGroupId = skypeGroupId;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setSkypeGroupId", long.class);

				method.invoke(_skypeGroupRemoteModel, skypeGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_skypeGroupRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_skypeGroupRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_skypeGroupRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_skypeGroupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupName() {
		return _groupName;
	}

	@Override
	public void setGroupName(String groupName) {
		_groupName = groupName;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupName", String.class);

				method.invoke(_skypeGroupRemoteModel, groupName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSkypeContacts() {
		return _skypeContacts;
	}

	@Override
	public void setSkypeContacts(String skypeContacts) {
		_skypeContacts = skypeContacts;

		if (_skypeGroupRemoteModel != null) {
			try {
				Class<?> clazz = _skypeGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setSkypeContacts", String.class);

				method.invoke(_skypeGroupRemoteModel, skypeContacts);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		try {
			String methodName = "toJSON";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.json.JSONObject returnObj = (com.liferay.portal.kernel.json.JSONObject)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSkypeGroupRemoteModel() {
		return _skypeGroupRemoteModel;
	}

	public void setSkypeGroupRemoteModel(BaseModel<?> skypeGroupRemoteModel) {
		_skypeGroupRemoteModel = skypeGroupRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _skypeGroupRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_skypeGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SkypeGroupLocalServiceUtil.addSkypeGroup(this);
		}
		else {
			SkypeGroupLocalServiceUtil.updateSkypeGroup(this);
		}
	}

	@Override
	public SkypeGroup toEscapedModel() {
		return (SkypeGroup)ProxyUtil.newProxyInstance(SkypeGroup.class.getClassLoader(),
			new Class[] { SkypeGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SkypeGroupClp clone = new SkypeGroupClp();

		clone.setSkypeGroupId(getSkypeGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGroupName(getGroupName());
		clone.setSkypeContacts(getSkypeContacts());

		return clone;
	}

	@Override
	public int compareTo(SkypeGroup skypeGroup) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				skypeGroup.getModifiedDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SkypeGroupClp)) {
			return false;
		}

		SkypeGroupClp skypeGroup = (SkypeGroupClp)obj;

		long primaryKey = skypeGroup.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{skypeGroupId=");
		sb.append(getSkypeGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", groupName=");
		sb.append(getGroupName());
		sb.append(", skypeContacts=");
		sb.append(getSkypeContacts());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.skype.model.SkypeGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>skypeGroupId</column-name><column-value><![CDATA[");
		sb.append(getSkypeGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupName</column-name><column-value><![CDATA[");
		sb.append(getGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skypeContacts</column-name><column-value><![CDATA[");
		sb.append(getSkypeContacts());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _skypeGroupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _groupName;
	private String _skypeContacts;
	private BaseModel<?> _skypeGroupRemoteModel;
}