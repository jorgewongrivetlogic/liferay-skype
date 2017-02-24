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

package com.rivetlogic.skype.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SkypeGroupLocalService}.
 *
 * @author Rivet Logic
 * @see SkypeGroupLocalService
 * @generated
 */
@ProviderType
public class SkypeGroupLocalServiceWrapper implements SkypeGroupLocalService,
	ServiceWrapper<SkypeGroupLocalService> {
	public SkypeGroupLocalServiceWrapper(
		SkypeGroupLocalService skypeGroupLocalService) {
		_skypeGroupLocalService = skypeGroupLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _skypeGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _skypeGroupLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _skypeGroupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skypeGroupLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skypeGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the skype group to the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was added
	*/
	@Override
	public com.rivetlogic.skype.model.SkypeGroup addSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup) {
		return _skypeGroupLocalService.addSkypeGroup(skypeGroup);
	}

	@Override
	public com.rivetlogic.skype.model.SkypeGroup createSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _skypeGroupLocalService.createSkypeGroup(skypeGroup);
	}

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	@Override
	public com.rivetlogic.skype.model.SkypeGroup createSkypeGroup(
		long skypeGroupId) {
		return _skypeGroupLocalService.createSkypeGroup(skypeGroupId);
	}

	/**
	* Deletes the skype group from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was removed
	*/
	@Override
	public com.rivetlogic.skype.model.SkypeGroup deleteSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup) {
		return _skypeGroupLocalService.deleteSkypeGroup(skypeGroup);
	}

	/**
	* Deletes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws PortalException if a skype group with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.skype.model.SkypeGroup deleteSkypeGroup(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skypeGroupLocalService.deleteSkypeGroup(skypeGroupId);
	}

	@Override
	public com.rivetlogic.skype.model.SkypeGroup fetchSkypeGroup(
		long skypeGroupId) {
		return _skypeGroupLocalService.fetchSkypeGroup(skypeGroupId);
	}

	@Override
	public com.rivetlogic.skype.model.SkypeGroup findByUserIdAndGroupName(
		java.lang.Long userId, java.lang.String groupName) {
		return _skypeGroupLocalService.findByUserIdAndGroupName(userId,
			groupName);
	}

	/**
	* Returns the skype group with the primary key.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws PortalException if a skype group with the primary key could not be found
	*/
	@Override
	public com.rivetlogic.skype.model.SkypeGroup getSkypeGroup(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _skypeGroupLocalService.getSkypeGroup(skypeGroupId);
	}

	/**
	* Updates the skype group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was updated
	* @throws SystemException
	*/
	@Override
	public com.rivetlogic.skype.model.SkypeGroup updateSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skypeGroupLocalService.updateSkypeGroup(skypeGroup);
	}

	@Override
	public int countByUserIdAndGroupName(java.lang.Long userId,
		java.lang.String groupName) {
		return _skypeGroupLocalService.countByUserIdAndGroupName(userId,
			groupName);
	}

	@Override
	public int getSkypeGroupByUserIdCount(java.lang.Long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skypeGroupLocalService.getSkypeGroupByUserIdCount(userId);
	}

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	*/
	@Override
	public int getSkypeGroupsCount() {
		return _skypeGroupLocalService.getSkypeGroupsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _skypeGroupLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _skypeGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.skype.model.impl.SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _skypeGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.skype.model.impl.SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _skypeGroupLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> getSkypeGroupByUserId(
		java.lang.Long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _skypeGroupLocalService.getSkypeGroupByUserId(userId, start,
			end, obc);
	}

	/**
	* Returns a range of all the skype groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.skype.model.impl.SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @return the range of skype groups
	*/
	@Override
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> getSkypeGroups(
		int start, int end) {
		return _skypeGroupLocalService.getSkypeGroups(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _skypeGroupLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _skypeGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public SkypeGroupLocalService getWrappedService() {
		return _skypeGroupLocalService;
	}

	@Override
	public void setWrappedService(SkypeGroupLocalService skypeGroupLocalService) {
		_skypeGroupLocalService = skypeGroupLocalService;
	}

	private SkypeGroupLocalService _skypeGroupLocalService;
}