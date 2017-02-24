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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SkypeGroup. This utility wraps
 * {@link com.rivetlogic.skype.service.impl.SkypeGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Rivet Logic
 * @see SkypeGroupLocalService
 * @see com.rivetlogic.skype.service.base.SkypeGroupLocalServiceBaseImpl
 * @see com.rivetlogic.skype.service.impl.SkypeGroupLocalServiceImpl
 * @generated
 */
@ProviderType
public class SkypeGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rivetlogic.skype.service.impl.SkypeGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the skype group to the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was added
	*/
	public static com.rivetlogic.skype.model.SkypeGroup addSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup) {
		return getService().addSkypeGroup(skypeGroup);
	}

	public static com.rivetlogic.skype.model.SkypeGroup createSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().createSkypeGroup(skypeGroup);
	}

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	public static com.rivetlogic.skype.model.SkypeGroup createSkypeGroup(
		long skypeGroupId) {
		return getService().createSkypeGroup(skypeGroupId);
	}

	/**
	* Deletes the skype group from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was removed
	*/
	public static com.rivetlogic.skype.model.SkypeGroup deleteSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup) {
		return getService().deleteSkypeGroup(skypeGroup);
	}

	/**
	* Deletes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws PortalException if a skype group with the primary key could not be found
	*/
	public static com.rivetlogic.skype.model.SkypeGroup deleteSkypeGroup(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSkypeGroup(skypeGroupId);
	}

	public static com.rivetlogic.skype.model.SkypeGroup fetchSkypeGroup(
		long skypeGroupId) {
		return getService().fetchSkypeGroup(skypeGroupId);
	}

	public static com.rivetlogic.skype.model.SkypeGroup findByUserIdAndGroupName(
		java.lang.Long userId, java.lang.String groupName) {
		return getService().findByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the skype group with the primary key.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws PortalException if a skype group with the primary key could not be found
	*/
	public static com.rivetlogic.skype.model.SkypeGroup getSkypeGroup(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSkypeGroup(skypeGroupId);
	}

	/**
	* Updates the skype group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was updated
	* @throws SystemException
	*/
	public static com.rivetlogic.skype.model.SkypeGroup updateSkypeGroup(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSkypeGroup(skypeGroup);
	}

	public static int countByUserIdAndGroupName(java.lang.Long userId,
		java.lang.String groupName) {
		return getService().countByUserIdAndGroupName(userId, groupName);
	}

	public static int getSkypeGroupByUserIdCount(java.lang.Long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSkypeGroupByUserIdCount(userId);
	}

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	*/
	public static int getSkypeGroupsCount() {
		return getService().getSkypeGroupsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> getSkypeGroupByUserId(
		java.lang.Long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSkypeGroupByUserId(userId, start, end, obc);
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
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> getSkypeGroups(
		int start, int end) {
		return getService().getSkypeGroups(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static SkypeGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkypeGroupLocalService, SkypeGroupLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SkypeGroupLocalService.class);
}