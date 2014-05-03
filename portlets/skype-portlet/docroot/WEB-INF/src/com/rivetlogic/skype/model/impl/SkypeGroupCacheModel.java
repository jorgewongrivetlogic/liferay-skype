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

package com.rivetlogic.skype.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rivetlogic.skype.model.SkypeGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SkypeGroup in entity cache.
 *
 * @author Rivet Logic
 * @see SkypeGroup
 * @generated
 */
public class SkypeGroupCacheModel implements CacheModel<SkypeGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{skypeGroupId=");
		sb.append(skypeGroupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", skypeContacts=");
		sb.append(skypeContacts);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SkypeGroup toEntityModel() {
		SkypeGroupImpl skypeGroupImpl = new SkypeGroupImpl();

		skypeGroupImpl.setSkypeGroupId(skypeGroupId);
		skypeGroupImpl.setUserId(userId);

		if (userName == null) {
			skypeGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			skypeGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			skypeGroupImpl.setCreateDate(null);
		}
		else {
			skypeGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			skypeGroupImpl.setModifiedDate(null);
		}
		else {
			skypeGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (groupName == null) {
			skypeGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			skypeGroupImpl.setGroupName(groupName);
		}

		if (skypeContacts == null) {
			skypeGroupImpl.setSkypeContacts(StringPool.BLANK);
		}
		else {
			skypeGroupImpl.setSkypeContacts(skypeContacts);
		}

		skypeGroupImpl.resetOriginalValues();

		return skypeGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		skypeGroupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		groupName = objectInput.readUTF();
		skypeContacts = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(skypeGroupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (skypeContacts == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skypeContacts);
		}
	}

	public long skypeGroupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String groupName;
	public String skypeContacts;
}