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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rivetlogic.skype.NoSuchSkypeGroupException;
import com.rivetlogic.skype.model.SkypeGroup;
import com.rivetlogic.skype.model.impl.SkypeGroupImpl;
import com.rivetlogic.skype.model.impl.SkypeGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the skype group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see SkypeGroupPersistence
 * @see SkypeGroupUtil
 * @generated
 */
public class SkypeGroupPersistenceImpl extends BasePersistenceImpl<SkypeGroup>
	implements SkypeGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SkypeGroupUtil} to access the skype group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SkypeGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, SkypeGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, SkypeGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, SkypeGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, SkypeGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SkypeGroupModelImpl.USERID_COLUMN_BITMASK |
			SkypeGroupModelImpl.MODIFIEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the skype groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching skype groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SkypeGroup> findByUserId(long userId) throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SkypeGroup> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<SkypeGroup> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<SkypeGroup> list = (List<SkypeGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SkypeGroup skypeGroup : list) {
				if ((userId != skypeGroup.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SKYPEGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SkypeGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SkypeGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SkypeGroup>(list);
				}
				else {
					list = (List<SkypeGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public SkypeGroup findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSkypeGroupException, SystemException {
		SkypeGroup skypeGroup = fetchByUserId_First(userId, orderByComparator);

		if (skypeGroup != null) {
			return skypeGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSkypeGroupException(msg.toString());
	}

	/**
	 * Returns the first skype group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching skype group, or <code>null</code> if a matching skype group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SkypeGroup> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SkypeGroup findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSkypeGroupException, SystemException {
		SkypeGroup skypeGroup = fetchByUserId_Last(userId, orderByComparator);

		if (skypeGroup != null) {
			return skypeGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSkypeGroupException(msg.toString());
	}

	/**
	 * Returns the last skype group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching skype group, or <code>null</code> if a matching skype group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SkypeGroup> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public SkypeGroup[] findByUserId_PrevAndNext(long skypeGroupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSkypeGroupException, SystemException {
		SkypeGroup skypeGroup = findByPrimaryKey(skypeGroupId);

		Session session = null;

		try {
			session = openSession();

			SkypeGroup[] array = new SkypeGroupImpl[3];

			array[0] = getByUserId_PrevAndNext(session, skypeGroup, userId,
					orderByComparator, true);

			array[1] = skypeGroup;

			array[2] = getByUserId_PrevAndNext(session, skypeGroup, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SkypeGroup getByUserId_PrevAndNext(Session session,
		SkypeGroup skypeGroup, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SKYPEGROUP_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SkypeGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(skypeGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SkypeGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the skype groups where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (SkypeGroup skypeGroup : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(skypeGroup);
		}
	}

	/**
	 * Returns the number of skype groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching skype groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SKYPEGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "skypeGroup.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, SkypeGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserIdAndGroupName",
			new String[] { Long.class.getName(), String.class.getName() },
			SkypeGroupModelImpl.USERID_COLUMN_BITMASK |
			SkypeGroupModelImpl.GROUPNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME = new FinderPath(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndGroupName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the skype group where userId = &#63; and groupName = &#63; or throws a {@link com.rivetlogic.skype.NoSuchSkypeGroupException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the matching skype group
	 * @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a matching skype group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup findByUserIdAndGroupName(long userId, String groupName)
		throws NoSuchSkypeGroupException, SystemException {
		SkypeGroup skypeGroup = fetchByUserIdAndGroupName(userId, groupName);

		if (skypeGroup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", groupName=");
			msg.append(groupName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSkypeGroupException(msg.toString());
		}

		return skypeGroup;
	}

	/**
	 * Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup fetchByUserIdAndGroupName(long userId, String groupName)
		throws SystemException {
		return fetchByUserIdAndGroupName(userId, groupName, true);
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
	@Override
	public SkypeGroup fetchByUserIdAndGroupName(long userId, String groupName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, groupName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					finderArgs, this);
		}

		if (result instanceof SkypeGroup) {
			SkypeGroup skypeGroup = (SkypeGroup)result;

			if ((userId != skypeGroup.getUserId()) ||
					!Validator.equals(groupName, skypeGroup.getGroupName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SKYPEGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_USERID_2);

			boolean bindGroupName = false;

			if (groupName == null) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_1);
			}
			else if (groupName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_3);
			}
			else {
				bindGroupName = true;

				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindGroupName) {
					qPos.add(groupName);
				}

				List<SkypeGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
						finderArgs, list);
				}
				else {
					SkypeGroup skypeGroup = list.get(0);

					result = skypeGroup;

					cacheResult(skypeGroup);

					if ((skypeGroup.getUserId() != userId) ||
							(skypeGroup.getGroupName() == null) ||
							!skypeGroup.getGroupName().equals(groupName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
							finderArgs, skypeGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SkypeGroup)result;
		}
	}

	/**
	 * Removes the skype group where userId = &#63; and groupName = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the skype group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup removeByUserIdAndGroupName(long userId, String groupName)
		throws NoSuchSkypeGroupException, SystemException {
		SkypeGroup skypeGroup = findByUserIdAndGroupName(userId, groupName);

		return remove(skypeGroup);
	}

	/**
	 * Returns the number of skype groups where userId = &#63; and groupName = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the number of matching skype groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndGroupName(long userId, String groupName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME;

		Object[] finderArgs = new Object[] { userId, groupName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SKYPEGROUP_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_USERID_2);

			boolean bindGroupName = false;

			if (groupName == null) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_1);
			}
			else if (groupName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_3);
			}
			else {
				bindGroupName = true;

				query.append(_FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindGroupName) {
					qPos.add(groupName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_USERID_2 = "skypeGroup.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_1 = "skypeGroup.groupName IS NULL";
	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_2 = "skypeGroup.groupName = ?";
	private static final String _FINDER_COLUMN_USERIDANDGROUPNAME_GROUPNAME_3 = "(skypeGroup.groupName IS NULL OR skypeGroup.groupName = '')";

	public SkypeGroupPersistenceImpl() {
		setModelClass(SkypeGroup.class);
	}

	/**
	 * Caches the skype group in the entity cache if it is enabled.
	 *
	 * @param skypeGroup the skype group
	 */
	@Override
	public void cacheResult(SkypeGroup skypeGroup) {
		EntityCacheUtil.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupImpl.class, skypeGroup.getPrimaryKey(), skypeGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
			new Object[] { skypeGroup.getUserId(), skypeGroup.getGroupName() },
			skypeGroup);

		skypeGroup.resetOriginalValues();
	}

	/**
	 * Caches the skype groups in the entity cache if it is enabled.
	 *
	 * @param skypeGroups the skype groups
	 */
	@Override
	public void cacheResult(List<SkypeGroup> skypeGroups) {
		for (SkypeGroup skypeGroup : skypeGroups) {
			if (EntityCacheUtil.getResult(
						SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
						SkypeGroupImpl.class, skypeGroup.getPrimaryKey()) == null) {
				cacheResult(skypeGroup);
			}
			else {
				skypeGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all skype groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SkypeGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SkypeGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skype group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkypeGroup skypeGroup) {
		EntityCacheUtil.removeResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupImpl.class, skypeGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(skypeGroup);
	}

	@Override
	public void clearCache(List<SkypeGroup> skypeGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SkypeGroup skypeGroup : skypeGroups) {
			EntityCacheUtil.removeResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
				SkypeGroupImpl.class, skypeGroup.getPrimaryKey());

			clearUniqueFindersCache(skypeGroup);
		}
	}

	protected void cacheUniqueFindersCache(SkypeGroup skypeGroup) {
		if (skypeGroup.isNew()) {
			Object[] args = new Object[] {
					skypeGroup.getUserId(), skypeGroup.getGroupName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
				args, skypeGroup);
		}
		else {
			SkypeGroupModelImpl skypeGroupModelImpl = (SkypeGroupModelImpl)skypeGroup;

			if ((skypeGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skypeGroup.getUserId(), skypeGroup.getGroupName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					args, skypeGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(SkypeGroup skypeGroup) {
		SkypeGroupModelImpl skypeGroupModelImpl = (SkypeGroupModelImpl)skypeGroup;

		Object[] args = new Object[] {
				skypeGroup.getUserId(), skypeGroup.getGroupName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
			args);

		if ((skypeGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					skypeGroupModelImpl.getOriginalUserId(),
					skypeGroupModelImpl.getOriginalGroupName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
				args);
		}
	}

	/**
	 * Creates a new skype group with the primary key. Does not add the skype group to the database.
	 *
	 * @param skypeGroupId the primary key for the new skype group
	 * @return the new skype group
	 */
	@Override
	public SkypeGroup create(long skypeGroupId) {
		SkypeGroup skypeGroup = new SkypeGroupImpl();

		skypeGroup.setNew(true);
		skypeGroup.setPrimaryKey(skypeGroupId);

		return skypeGroup;
	}

	/**
	 * Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param skypeGroupId the primary key of the skype group
	 * @return the skype group that was removed
	 * @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup remove(long skypeGroupId)
		throws NoSuchSkypeGroupException, SystemException {
		return remove((Serializable)skypeGroupId);
	}

	/**
	 * Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skype group
	 * @return the skype group that was removed
	 * @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup remove(Serializable primaryKey)
		throws NoSuchSkypeGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SkypeGroup skypeGroup = (SkypeGroup)session.get(SkypeGroupImpl.class,
					primaryKey);

			if (skypeGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSkypeGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(skypeGroup);
		}
		catch (NoSuchSkypeGroupException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SkypeGroup removeImpl(SkypeGroup skypeGroup)
		throws SystemException {
		skypeGroup = toUnwrappedModel(skypeGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(skypeGroup)) {
				skypeGroup = (SkypeGroup)session.get(SkypeGroupImpl.class,
						skypeGroup.getPrimaryKeyObj());
			}

			if (skypeGroup != null) {
				session.delete(skypeGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (skypeGroup != null) {
			clearCache(skypeGroup);
		}

		return skypeGroup;
	}

	@Override
	public SkypeGroup updateImpl(
		com.rivetlogic.skype.model.SkypeGroup skypeGroup)
		throws SystemException {
		skypeGroup = toUnwrappedModel(skypeGroup);

		boolean isNew = skypeGroup.isNew();

		SkypeGroupModelImpl skypeGroupModelImpl = (SkypeGroupModelImpl)skypeGroup;

		Session session = null;

		try {
			session = openSession();

			if (skypeGroup.isNew()) {
				session.save(skypeGroup);

				skypeGroup.setNew(false);
			}
			else {
				session.merge(skypeGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SkypeGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((skypeGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skypeGroupModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { skypeGroupModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupImpl.class, skypeGroup.getPrimaryKey(), skypeGroup);

		clearUniqueFindersCache(skypeGroup);
		cacheUniqueFindersCache(skypeGroup);

		return skypeGroup;
	}

	protected SkypeGroup toUnwrappedModel(SkypeGroup skypeGroup) {
		if (skypeGroup instanceof SkypeGroupImpl) {
			return skypeGroup;
		}

		SkypeGroupImpl skypeGroupImpl = new SkypeGroupImpl();

		skypeGroupImpl.setNew(skypeGroup.isNew());
		skypeGroupImpl.setPrimaryKey(skypeGroup.getPrimaryKey());

		skypeGroupImpl.setSkypeGroupId(skypeGroup.getSkypeGroupId());
		skypeGroupImpl.setUserId(skypeGroup.getUserId());
		skypeGroupImpl.setUserName(skypeGroup.getUserName());
		skypeGroupImpl.setCreateDate(skypeGroup.getCreateDate());
		skypeGroupImpl.setModifiedDate(skypeGroup.getModifiedDate());
		skypeGroupImpl.setGroupName(skypeGroup.getGroupName());
		skypeGroupImpl.setSkypeContacts(skypeGroup.getSkypeContacts());

		return skypeGroupImpl;
	}

	/**
	 * Returns the skype group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skype group
	 * @return the skype group
	 * @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkypeGroupException, SystemException {
		SkypeGroup skypeGroup = fetchByPrimaryKey(primaryKey);

		if (skypeGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkypeGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skypeGroup;
	}

	/**
	 * Returns the skype group with the primary key or throws a {@link com.rivetlogic.skype.NoSuchSkypeGroupException} if it could not be found.
	 *
	 * @param skypeGroupId the primary key of the skype group
	 * @return the skype group
	 * @throws com.rivetlogic.skype.NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup findByPrimaryKey(long skypeGroupId)
		throws NoSuchSkypeGroupException, SystemException {
		return findByPrimaryKey((Serializable)skypeGroupId);
	}

	/**
	 * Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skype group
	 * @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SkypeGroup skypeGroup = (SkypeGroup)EntityCacheUtil.getResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
				SkypeGroupImpl.class, primaryKey);

		if (skypeGroup == _nullSkypeGroup) {
			return null;
		}

		if (skypeGroup == null) {
			Session session = null;

			try {
				session = openSession();

				skypeGroup = (SkypeGroup)session.get(SkypeGroupImpl.class,
						primaryKey);

				if (skypeGroup != null) {
					cacheResult(skypeGroup);
				}
				else {
					EntityCacheUtil.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
						SkypeGroupImpl.class, primaryKey, _nullSkypeGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
					SkypeGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return skypeGroup;
	}

	/**
	 * Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param skypeGroupId the primary key of the skype group
	 * @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SkypeGroup fetchByPrimaryKey(long skypeGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)skypeGroupId);
	}

	/**
	 * Returns all the skype groups.
	 *
	 * @return the skype groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SkypeGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SkypeGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SkypeGroup> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SkypeGroup> list = (List<SkypeGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SKYPEGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SKYPEGROUP;

				if (pagination) {
					sql = sql.concat(SkypeGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SkypeGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SkypeGroup>(list);
				}
				else {
					list = (List<SkypeGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the skype groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SkypeGroup skypeGroup : findAll()) {
			remove(skypeGroup);
		}
	}

	/**
	 * Returns the number of skype groups.
	 *
	 * @return the number of skype groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKYPEGROUP);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the skype group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rivetlogic.skype.model.SkypeGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SkypeGroup>> listenersList = new ArrayList<ModelListener<SkypeGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SkypeGroup>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SkypeGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SKYPEGROUP = "SELECT skypeGroup FROM SkypeGroup skypeGroup";
	private static final String _SQL_SELECT_SKYPEGROUP_WHERE = "SELECT skypeGroup FROM SkypeGroup skypeGroup WHERE ";
	private static final String _SQL_COUNT_SKYPEGROUP = "SELECT COUNT(skypeGroup) FROM SkypeGroup skypeGroup";
	private static final String _SQL_COUNT_SKYPEGROUP_WHERE = "SELECT COUNT(skypeGroup) FROM SkypeGroup skypeGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skypeGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SkypeGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SkypeGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SkypeGroupPersistenceImpl.class);
	private static SkypeGroup _nullSkypeGroup = new SkypeGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SkypeGroup> toCacheModel() {
				return _nullSkypeGroupCacheModel;
			}
		};

	private static CacheModel<SkypeGroup> _nullSkypeGroupCacheModel = new CacheModel<SkypeGroup>() {
			@Override
			public SkypeGroup toEntityModel() {
				return _nullSkypeGroup;
			}
		};
}