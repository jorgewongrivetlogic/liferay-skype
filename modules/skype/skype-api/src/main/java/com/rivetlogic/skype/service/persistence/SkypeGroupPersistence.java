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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.rivetlogic.skype.exception.NoSuchSkypeGroupException;
import com.rivetlogic.skype.model.SkypeGroup;

/**
 * The persistence interface for the skype group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see com.rivetlogic.skype.service.persistence.impl.SkypeGroupPersistenceImpl
 * @see SkypeGroupUtil
 * @generated
 */
@ProviderType
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
	*/
	public java.util.List<SkypeGroup> findByUserId(long userId);

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
	public java.util.List<SkypeGroup> findByUserId(long userId, int start,
		int end);

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
	public java.util.List<SkypeGroup> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator);

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
	public java.util.List<SkypeGroup> findByUserId(long userId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group
	* @throws NoSuchSkypeGroupException if a matching skype group could not be found
	*/
	public SkypeGroup findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator)
		throws NoSuchSkypeGroupException;

	/**
	* Returns the first skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public SkypeGroup fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator);

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group
	* @throws NoSuchSkypeGroupException if a matching skype group could not be found
	*/
	public SkypeGroup findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator)
		throws NoSuchSkypeGroupException;

	/**
	* Returns the last skype group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public SkypeGroup fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator);

	/**
	* Returns the skype groups before and after the current skype group in the ordered set where userId = &#63;.
	*
	* @param skypeGroupId the primary key of the current skype group
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next skype group
	* @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	*/
	public SkypeGroup[] findByUserId_PrevAndNext(long skypeGroupId,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator)
		throws NoSuchSkypeGroupException;

	/**
	* Removes all the skype groups where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of skype groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching skype groups
	*/
	public int countByUserId(long userId);

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or throws a {@link NoSuchSkypeGroupException} if it could not be found.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group
	* @throws NoSuchSkypeGroupException if a matching skype group could not be found
	*/
	public SkypeGroup findByUserIdAndGroupName(long userId,
		java.lang.String groupName) throws NoSuchSkypeGroupException;

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public SkypeGroup fetchByUserIdAndGroupName(long userId,
		java.lang.String groupName);

	/**
	* Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	*/
	public SkypeGroup fetchByUserIdAndGroupName(long userId,
		java.lang.String groupName, boolean retrieveFromCache);

	/**
	* Removes the skype group where userId = &#63; and groupName = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the skype group that was removed
	*/
	public SkypeGroup removeByUserIdAndGroupName(long userId,
		java.lang.String groupName) throws NoSuchSkypeGroupException;

	/**
	* Returns the number of skype groups where userId = &#63; and groupName = &#63;.
	*
	* @param userId the user ID
	* @param groupName the group name
	* @return the number of matching skype groups
	*/
	public int countByUserIdAndGroupName(long userId, java.lang.String groupName);

	/**
	* Caches the skype group in the entity cache if it is enabled.
	*
	* @param skypeGroup the skype group
	*/
	public void cacheResult(SkypeGroup skypeGroup);

	/**
	* Caches the skype groups in the entity cache if it is enabled.
	*
	* @param skypeGroups the skype groups
	*/
	public void cacheResult(java.util.List<SkypeGroup> skypeGroups);

	/**
	* Creates a new skype group with the primary key. Does not add the skype group to the database.
	*
	* @param skypeGroupId the primary key for the new skype group
	* @return the new skype group
	*/
	public SkypeGroup create(long skypeGroupId);

	/**
	* Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group that was removed
	* @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	*/
	public SkypeGroup remove(long skypeGroupId)
		throws NoSuchSkypeGroupException;

	public SkypeGroup updateImpl(SkypeGroup skypeGroup);

	/**
	* Returns the skype group with the primary key or throws a {@link NoSuchSkypeGroupException} if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group
	* @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	*/
	public SkypeGroup findByPrimaryKey(long skypeGroupId)
		throws NoSuchSkypeGroupException;

	/**
	* Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param skypeGroupId the primary key of the skype group
	* @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	*/
	public SkypeGroup fetchByPrimaryKey(long skypeGroupId);

	@Override
	public java.util.Map<java.io.Serializable, SkypeGroup> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the skype groups.
	*
	* @return the skype groups
	*/
	public java.util.List<SkypeGroup> findAll();

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
	public java.util.List<SkypeGroup> findAll(int start, int end);

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
	public java.util.List<SkypeGroup> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator);

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
	public java.util.List<SkypeGroup> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SkypeGroup> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the skype groups from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of skype groups.
	*
	* @return the number of skype groups
	*/
	public int countAll();
}