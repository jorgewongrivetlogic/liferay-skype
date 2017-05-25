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

package com.rivetlogic.skype.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.rivetlogic.skype.model.SkypeGroup;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the skype group service. This utility wraps {@link com.rivetlogic.skype.service.persistence.impl.SkypeGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see SkypeGroupPersistence
 * @see com.rivetlogic.skype.service.persistence.impl.SkypeGroupPersistenceImpl
 * @generated
 */
@ProviderType
public class SkypeGroupUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(SkypeGroup skypeGroup) {
		getPersistence().clearCache(skypeGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SkypeGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SkypeGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SkypeGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SkypeGroup update(SkypeGroup skypeGroup) {
		return getPersistence().update(skypeGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SkypeGroup update(SkypeGroup skypeGroup,
		ServiceContext serviceContext) {
		return getPersistence().update(skypeGroup, serviceContext);
	}

	/**
	* Returns all the skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching skype groups
	*/
	public static List<SkypeGroup> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the skype groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @return the range of matching skype groups
	*/
	public static List<SkypeGroup> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the skype groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching skype groups
	*/
	public static List<SkypeGroup> findByUserId(long userId, int start,
		int end, OrderByComparator<SkypeGroup> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the skype groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching skype groups
	*/
	public static List<SkypeGroup> findByUserId(long userId, int start,
		int end, OrderByComparator<SkypeGroup> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group
	* @throws NoSuchSkypeGroupException if a matching skype group could not be found
	*/
	public static SkypeGroup findByUserId_First(long userId,
		OrderByComparator<SkypeGroup> orderByComparator)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public static SkypeGroup fetchByUserId_First(long userId,
		OrderByComparator<SkypeGroup> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group
	* @throws NoSuchSkypeGroupException if a matching skype group could not be found
	*/
	public static SkypeGroup findByUserId_Last(long userId,
		OrderByComparator<SkypeGroup> orderByComparator)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public static SkypeGroup fetchByUserId_Last(long userId,
		OrderByComparator<SkypeGroup> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the skype groups before and after the current skype group in the ordered set where userId = &#63;.
	*
	* @param skypeGroupId the primary key of the current skype group
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next skype group
	* @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	*/
	public static SkypeGroup[] findByUserId_PrevAndNext(long skypeGroupId,
		long userId, OrderByComparator<SkypeGroup> orderByComparator)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence()
				   .findByUserId_PrevAndNext(skypeGroupId, userId,
			orderByComparator);
	}

	/**
	* Removes all the skype groups where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching skype groups
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or throws a {@link NoSuchSkypeGroupException} if it could not be found.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group
	* @throws NoSuchSkypeGroupException if a matching skype group could not be found
	*/
	public static SkypeGroup findByUserIdAndGroupName(long userId,
		java.lang.String groupName)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence().findByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public static SkypeGroup fetchByUserIdAndGroupName(long userId,
		java.lang.String groupName) {
		return getPersistence().fetchByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public static SkypeGroup fetchByUserIdAndGroupName(long userId,
		java.lang.String groupName, boolean retrieveFromCache) {
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
	*/
	public static SkypeGroup removeByUserIdAndGroupName(long userId,
		java.lang.String groupName)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence().removeByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Returns the number of skype groups where userId = &#63; and groupName = &#63;.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the number of matching skype groups
	*/
	public static int countByUserIdAndGroupName(long userId,
		java.lang.String groupName) {
		return getPersistence().countByUserIdAndGroupName(userId, groupName);
	}

	/**
	* Caches the skype group in the entity cache if it is enabled.
	*
	* @param skypeGroup the skype group
	*/
	public static void cacheResult(SkypeGroup skypeGroup) {
		getPersistence().cacheResult(skypeGroup);
	}

	/**
	* Caches the skype groups in the entity cache if it is enabled.
	*
	* @param skypeGroups the skype groups
	*/
	public static void cacheResult(List<SkypeGroup> skypeGroups) {
		getPersistence().cacheResult(skypeGroups);
	}

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	public static SkypeGroup create(long skypeGroupId) {
		return getPersistence().create(skypeGroupId);
	}

	/**
	* Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	*/
	public static SkypeGroup remove(long skypeGroupId)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence().remove(skypeGroupId);
	}

	public static SkypeGroup updateImpl(SkypeGroup skypeGroup) {
		return getPersistence().updateImpl(skypeGroup);
	}

	/**
	* Returns the skype group with the primary key or throws a {@link NoSuchSkypeGroupException} if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	*/
	public static SkypeGroup findByPrimaryKey(long skypeGroupId)
		throws com.rivetlogic.skype.exception.NoSuchSkypeGroupException {
		return getPersistence().findByPrimaryKey(skypeGroupId);
	}

	/**
	* Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	*/
	public static SkypeGroup fetchByPrimaryKey(long skypeGroupId) {
		return getPersistence().fetchByPrimaryKey(skypeGroupId);
	}

	public static java.util.Map<java.io.Serializable, SkypeGroup> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the skype groups.
	*
	* @return the skype groups
	*/
	public static List<SkypeGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the skype groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @return the range of skype groups
	*/
	public static List<SkypeGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the skype groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of skype groups
	*/
	public static List<SkypeGroup> findAll(int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the skype groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SkypeGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of skype groups
	* @param end the upper bound of the range of skype groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of skype groups
	*/
	public static List<SkypeGroup> findAll(int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the skype groups from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SkypeGroupPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SkypeGroupPersistence, SkypeGroupPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SkypeGroupPersistence.class);
}