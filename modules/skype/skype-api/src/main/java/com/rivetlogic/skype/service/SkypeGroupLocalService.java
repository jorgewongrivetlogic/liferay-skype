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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rivetlogic.skype.model.SkypeGroup;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for SkypeGroup. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Rivet Logic
 * @see SkypeGroupLocalServiceUtil
 * @see com.rivetlogic.skype.service.base.SkypeGroupLocalServiceBaseImpl
 * @see com.rivetlogic.skype.service.impl.SkypeGroupLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SkypeGroupLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkypeGroupLocalServiceUtil} to access the skype group local service. Add custom service methods to {@link com.rivetlogic.skype.service.impl.SkypeGroupLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the skype group to the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public SkypeGroup addSkypeGroup(SkypeGroup skypeGroup);

	public SkypeGroup createSkypeGroup(SkypeGroup skypeGroup)
		throws PortalException, SystemException;

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	public SkypeGroup createSkypeGroup(long skypeGroupId);

	/**
	* Deletes the skype group from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public SkypeGroup deleteSkypeGroup(SkypeGroup skypeGroup);

	/**
	* Deletes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws PortalException if a skype group with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public SkypeGroup deleteSkypeGroup(long skypeGroupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SkypeGroup fetchSkypeGroup(long skypeGroupId);

	public SkypeGroup findByUserIdAndGroupName(java.lang.Long userId,
		java.lang.String groupName);

	/**
	* Returns the skype group with the primary key.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws PortalException if a skype group with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SkypeGroup getSkypeGroup(long skypeGroupId)
		throws PortalException;

	/**
	* Updates the skype group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param skypeGroup the skype group
	* @return the skype group that was updated
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.REINDEX)
	public SkypeGroup updateSkypeGroup(SkypeGroup skypeGroup)
		throws SystemException;

	public int countByUserIdAndGroupName(java.lang.Long userId,
		java.lang.String groupName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSkypeGroupByUserIdCount(java.lang.Long userId)
		throws SystemException;

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSkypeGroupsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SkypeGroup> getSkypeGroupByUserId(java.lang.Long userId,
		int start, int end, OrderByComparator obc) throws SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SkypeGroup> getSkypeGroups(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}