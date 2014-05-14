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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rivetlogic.skype.model.SkypeGroup;

/**
 * The persistence interface for the skype group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see SkypeGroupPersistenceImpl
 * @see SkypeGroupUtil
 * @generated
 */
public interface SkypeGroupPersistence extends BasePersistence<SkypeGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SkypeGroupUtil} to access the skype group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> findByByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> findByByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> findByByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup findByByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup fetchByByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup findByByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup fetchByByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rivetlogic.skype.model.SkypeGroup[] findByByUserId_PrevAndNext(
		long skypeGroupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	/**
	* Removes all the skype groups where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or throws a {@link com.rivetlogic.skype.NoSuchSkypeGroupException} if it could not be found.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup findByByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup fetchByByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup fetchByByUserIdAndGroupName(
		long userId, java.lang.String groupName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the skype group where userId = &#63; and groupName = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the skype group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup removeByByUserIdAndGroupName(
		long userId, java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	/**
	* Returns the number of skype groups where userId = &#63; and groupName = &#63;.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the number of matching skype groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByByUserIdAndGroupName(long userId,
		java.lang.String groupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the skype group in the entity cache if it is enabled.
	*
	* @param skypeGroup the skype group
	*/
	public void cacheResult(com.rivetlogic.skype.model.SkypeGroup skypeGroup);

	/**
	* Caches the skype groups in the entity cache if it is enabled.
	*
	* @param skypeGroups the skype groups
	*/
	public void cacheResult(
		java.util.List<com.rivetlogic.skype.model.SkypeGroup> skypeGroups);

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	public com.rivetlogic.skype.model.SkypeGroup create(long skypeGroupId);

	/**
	* Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup remove(long skypeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	public com.rivetlogic.skype.model.SkypeGroup updateImpl(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the skype group with the primary key or throws a {@link com.rivetlogic.skype.NoSuchSkypeGroupException} if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup findByPrimaryKey(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rivetlogic.skype.NoSuchSkypeGroupException;

	/**
	* Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rivetlogic.skype.model.SkypeGroup fetchByPrimaryKey(
		long skypeGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the skype groups.
	*
	* @return the skype groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rivetlogic.skype.model.SkypeGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the skype groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}