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

package com.rivetlogic.skype.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rivetlogic.skype.model.SkypeGroup;

import java.util.List;

/**
 * The persistence utility for the skype group service. This utility wraps {@link SkypeGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see SkypeGroupPersistence
 * @see SkypeGroupPersistenceImpl
 * @generated
 */
public class SkypeGroupUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SkypeGroup skypeGroup) {
		getPersistence().clearCache(skypeGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SkypeGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SkypeGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SkypeGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SkypeGroup update(SkypeGroup skypeGroup)
		throws SystemException {
		return getPersistence().update(skypeGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SkypeGroup update(SkypeGroup skypeGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(skypeGroup, serviceContext);
	}

	/**
	* Returns all the skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the skype groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.skype.model.impl.SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @return the range of matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the skype groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.skype.model.impl.SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the skype groups before and after the current skype group in the ordered set where userId = &#63;.
	*
	* @param skypeGroupId the primary key of the current skype group
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup[] findByUserId_PrevAndNext(
		long skypeGroupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence()
				   .findByUserId_PrevAndNext(skypeGroupId, userId,
			orderByComparator);
	}

	/**
	* Removes all the skype groups where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or throws a {@link com.rivetlogic.skype.NoSuchSkypeGroupException} if it could not be found.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup findByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence().findByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup fetchByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup fetchByUserIdAndGroupName(
		long userId, java.lang.String groupName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndGroupName(userId, groupName,
			retrieveFromCache);
	}

	/**
	* Removes the skype group where userId = &#63; and groupName = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the skype group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup removeByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence().removeByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the number of skype groups where userId = &#63; and groupName = &#63;.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the number of matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndGroupName(long userId,
		java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Caches the skype group in the entity cache if it is enabled.
	*
	* @param skypeGroup the skype group
	*/
	public static void cacheResult(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup) {
		getPersistence().cacheResult(skypeGroup);
	}

	/**
	* Caches the skype groups in the entity cache if it is enabled.
	*
	* @param skypeGroups the skype groups
	*/
	public static void cacheResult(
		java.util.List<com.rivetlogic.skype.model.SkypeGroup> skypeGroups) {
		getPersistence().cacheResult(skypeGroups);
	}

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	public static com.rivetlogic.skype.model.SkypeGroup create(
		long skypeGroupId) {
		return getPersistence().create(skypeGroupId);
	}

	/**
	* Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup remove(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence().remove(skypeGroupId);
	}

	public static com.rivetlogic.skype.model.SkypeGroup updateImpl(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(skypeGroup);
	}

	/**
	* Returns the skype group with the primary key or throws a {@link com.rivetlogic.skype.NoSuchSkypeGroupException} if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup findByPrimaryKey(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException {
		return getPersistence().findByPrimaryKey(skypeGroupId);
	}

	/**
	* Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rivetlogic.skype.model.SkypeGroup fetchByPrimaryKey(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(skypeGroupId);
	}

	/**
	* Returns all the skype groups.
	*
	* @return the skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the skype groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rivetlogic.skype.model.impl.SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rivetlogic.skype.model.SkypeGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the skype groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SkypeGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SkypeGroupPersistence)PortletBeanLocatorUtil.locate(com.rivetlogic.skype.service.ClpSerializer.getServletContextName(),
					SkypeGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(SkypeGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SkypeGroupPersistence persistence) {
	}

	private static SkypeGroupPersistence _persistence;
}