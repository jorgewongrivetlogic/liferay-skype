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

package com.rivetlogic.skype.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.rivetlogic.skype.exception.NoSuchSkypeGroupException;
import com.rivetlogic.skype.model.SkypeGroup;
import com.rivetlogic.skype.model.impl.SkypeGroupImpl;
import com.rivetlogic.skype.model.impl.SkypeGroupModelImpl;
import com.rivetlogic.skype.service.persistence.SkypeGroupPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the skype group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rivet Logic
 * @see SkypeGroupPersistence
 * @see com.rivetlogic.skype.service.persistence.SkypeGroupUtil
 * @generated
 */
@ProviderType
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
	 */
	@Override
	public List<SkypeGroup> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SkypeGroup> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<SkypeGroup> findByUserId(long userId, int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<SkypeGroup> findByUserId(long userId, int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator,
		boolean retrieveFromCache) {
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

		List<SkypeGroup> list = null;

		if (retrieveFromCache) {
			list = (List<SkypeGroup>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SkypeGroup skypeGroup : list) {
					if ((userId != skypeGroup.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SkypeGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * @throws NoSuchSkypeGroupException if a matching skype group could not be found
	 */
	@Override
	public SkypeGroup findByUserId_First(long userId,
		OrderByComparator<SkypeGroup> orderByComparator)
		throws NoSuchSkypeGroupException {
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
	 */
	@Override
	public SkypeGroup fetchByUserId_First(long userId,
		OrderByComparator<SkypeGroup> orderByComparator) {
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
	 * @throws NoSuchSkypeGroupException if a matching skype group could not be found
	 */
	@Override
	public SkypeGroup findByUserId_Last(long userId,
		OrderByComparator<SkypeGroup> orderByComparator)
		throws NoSuchSkypeGroupException {
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
	 */
	@Override
	public SkypeGroup fetchByUserId_Last(long userId,
		OrderByComparator<SkypeGroup> orderByComparator) {
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
	 * @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 */
	@Override
	public SkypeGroup[] findByUserId_PrevAndNext(long skypeGroupId,
		long userId, OrderByComparator<SkypeGroup> orderByComparator)
		throws NoSuchSkypeGroupException {
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
		OrderByComparator<SkypeGroup> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
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
	 */
	@Override
	public void removeByUserId(long userId) {
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
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 * Returns the skype group where userId = &#63; and groupName = &#63; or throws a {@link NoSuchSkypeGroupException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the matching skype group
	 * @throws NoSuchSkypeGroupException if a matching skype group could not be found
	 */
	@Override
	public SkypeGroup findByUserIdAndGroupName(long userId, String groupName)
		throws NoSuchSkypeGroupException {
		SkypeGroup skypeGroup = fetchByUserIdAndGroupName(userId, groupName);

		if (skypeGroup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", groupName=");
			msg.append(groupName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
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
	 */
	@Override
	public SkypeGroup fetchByUserIdAndGroupName(long userId, String groupName) {
		return fetchByUserIdAndGroupName(userId, groupName, true);
	}

	/**
	 * Returns the skype group where userId = &#63; and groupName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching skype group, or <code>null</code> if a matching skype group could not be found
	 */
	@Override
	public SkypeGroup fetchByUserIdAndGroupName(long userId, String groupName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { userId, groupName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					finderArgs, this);
		}

		if (result instanceof SkypeGroup) {
			SkypeGroup skypeGroup = (SkypeGroup)result;

			if ((userId != skypeGroup.getUserId()) ||
					!Objects.equals(groupName, skypeGroup.getGroupName())) {
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
					finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
						finderArgs, list);
				}
				else {
					SkypeGroup skypeGroup = list.get(0);

					result = skypeGroup;

					cacheResult(skypeGroup);

					if ((skypeGroup.getUserId() != userId) ||
							(skypeGroup.getGroupName() == null) ||
							!skypeGroup.getGroupName().equals(groupName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
							finderArgs, skypeGroup);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
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
	 */
	@Override
	public SkypeGroup removeByUserIdAndGroupName(long userId, String groupName)
		throws NoSuchSkypeGroupException {
		SkypeGroup skypeGroup = findByUserIdAndGroupName(userId, groupName);

		return remove(skypeGroup);
	}

	/**
	 * Returns the number of skype groups where userId = &#63; and groupName = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupName the group name
	 * @return the number of matching skype groups
	 */
	@Override
	public int countByUserIdAndGroupName(long userId, String groupName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME;

		Object[] finderArgs = new Object[] { userId, groupName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

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

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
		entityCache.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupImpl.class, skypeGroup.getPrimaryKey(), skypeGroup);

		finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
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
			if (entityCache.getResult(
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
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SkypeGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the skype group.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SkypeGroup skypeGroup) {
		entityCache.removeResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupImpl.class, skypeGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SkypeGroupModelImpl)skypeGroup);
	}

	@Override
	public void clearCache(List<SkypeGroup> skypeGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SkypeGroup skypeGroup : skypeGroups) {
			entityCache.removeResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
				SkypeGroupImpl.class, skypeGroup.getPrimaryKey());

			clearUniqueFindersCache((SkypeGroupModelImpl)skypeGroup);
		}
	}

	protected void cacheUniqueFindersCache(
		SkypeGroupModelImpl skypeGroupModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					skypeGroupModelImpl.getUserId(),
					skypeGroupModelImpl.getGroupName()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
				args, skypeGroupModelImpl);
		}
		else {
			if ((skypeGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skypeGroupModelImpl.getUserId(),
						skypeGroupModelImpl.getGroupName()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
					args, skypeGroupModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SkypeGroupModelImpl skypeGroupModelImpl) {
		Object[] args = new Object[] {
				skypeGroupModelImpl.getUserId(),
				skypeGroupModelImpl.getGroupName()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME, args);

		if ((skypeGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					skypeGroupModelImpl.getOriginalUserId(),
					skypeGroupModelImpl.getOriginalGroupName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPNAME,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_USERIDANDGROUPNAME,
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
	 * @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 */
	@Override
	public SkypeGroup remove(long skypeGroupId)
		throws NoSuchSkypeGroupException {
		return remove((Serializable)skypeGroupId);
	}

	/**
	 * Removes the skype group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the skype group
	 * @return the skype group that was removed
	 * @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 */
	@Override
	public SkypeGroup remove(Serializable primaryKey)
		throws NoSuchSkypeGroupException {
		Session session = null;

		try {
			session = openSession();

			SkypeGroup skypeGroup = (SkypeGroup)session.get(SkypeGroupImpl.class,
					primaryKey);

			if (skypeGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
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
	protected SkypeGroup removeImpl(SkypeGroup skypeGroup) {
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
	public SkypeGroup updateImpl(SkypeGroup skypeGroup) {
		skypeGroup = toUnwrappedModel(skypeGroup);

		boolean isNew = skypeGroup.isNew();

		SkypeGroupModelImpl skypeGroupModelImpl = (SkypeGroupModelImpl)skypeGroup;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (skypeGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				skypeGroup.setCreateDate(now);
			}
			else {
				skypeGroup.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!skypeGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				skypeGroup.setModifiedDate(now);
			}
			else {
				skypeGroup.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (skypeGroup.isNew()) {
				session.save(skypeGroup);

				skypeGroup.setNew(false);
			}
			else {
				skypeGroup = (SkypeGroup)session.merge(skypeGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SkypeGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((skypeGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						skypeGroupModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { skypeGroupModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		entityCache.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
			SkypeGroupImpl.class, skypeGroup.getPrimaryKey(), skypeGroup, false);

		clearUniqueFindersCache(skypeGroupModelImpl);
		cacheUniqueFindersCache(skypeGroupModelImpl, isNew);

		skypeGroup.resetOriginalValues();

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
	 * Returns the skype group with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the skype group
	 * @return the skype group
	 * @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 */
	@Override
	public SkypeGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSkypeGroupException {
		SkypeGroup skypeGroup = fetchByPrimaryKey(primaryKey);

		if (skypeGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSkypeGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return skypeGroup;
	}

	/**
	 * Returns the skype group with the primary key or throws a {@link NoSuchSkypeGroupException} if it could not be found.
	 *
	 * @param skypeGroupId the primary key of the skype group
	 * @return the skype group
	 * @throws NoSuchSkypeGroupException if a skype group with the primary key could not be found
	 */
	@Override
	public SkypeGroup findByPrimaryKey(long skypeGroupId)
		throws NoSuchSkypeGroupException {
		return findByPrimaryKey((Serializable)skypeGroupId);
	}

	/**
	 * Returns the skype group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the skype group
	 * @return the skype group, or <code>null</code> if a skype group with the primary key could not be found
	 */
	@Override
	public SkypeGroup fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
				SkypeGroupImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		SkypeGroup skypeGroup = (SkypeGroup)serializable;

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
					entityCache.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
						SkypeGroupImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
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
	 */
	@Override
	public SkypeGroup fetchByPrimaryKey(long skypeGroupId) {
		return fetchByPrimaryKey((Serializable)skypeGroupId);
	}

	@Override
	public Map<Serializable, SkypeGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, SkypeGroup> map = new HashMap<Serializable, SkypeGroup>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			SkypeGroup skypeGroup = fetchByPrimaryKey(primaryKey);

			if (skypeGroup != null) {
				map.put(primaryKey, skypeGroup);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
					SkypeGroupImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (SkypeGroup)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SKYPEGROUP_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (SkypeGroup skypeGroup : (List<SkypeGroup>)q.list()) {
				map.put(skypeGroup.getPrimaryKeyObj(), skypeGroup);

				cacheResult(skypeGroup);

				uncachedPrimaryKeys.remove(skypeGroup.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SkypeGroupModelImpl.ENTITY_CACHE_ENABLED,
					SkypeGroupImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the skype groups.
	 *
	 * @return the skype groups
	 */
	@Override
	public List<SkypeGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<SkypeGroup> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<SkypeGroup> findAll(int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<SkypeGroup> findAll(int start, int end,
		OrderByComparator<SkypeGroup> orderByComparator,
		boolean retrieveFromCache) {
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

		List<SkypeGroup> list = null;

		if (retrieveFromCache) {
			list = (List<SkypeGroup>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

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

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SkypeGroup>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

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
	 */
	@Override
	public void removeAll() {
		for (SkypeGroup skypeGroup : findAll()) {
			remove(skypeGroup);
		}
	}

	/**
	 * Returns the number of skype groups.
	 *
	 * @return the number of skype groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SKYPEGROUP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SkypeGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the skype group persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SkypeGroupImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SKYPEGROUP = "SELECT skypeGroup FROM SkypeGroup skypeGroup";
	private static final String _SQL_SELECT_SKYPEGROUP_WHERE_PKS_IN = "SELECT skypeGroup FROM SkypeGroup skypeGroup WHERE skypeGroupId IN (";
	private static final String _SQL_SELECT_SKYPEGROUP_WHERE = "SELECT skypeGroup FROM SkypeGroup skypeGroup WHERE ";
	private static final String _SQL_COUNT_SKYPEGROUP = "SELECT COUNT(skypeGroup) FROM SkypeGroup skypeGroup";
	private static final String _SQL_COUNT_SKYPEGROUP_WHERE = "SELECT COUNT(skypeGroup) FROM SkypeGroup skypeGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "skypeGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SkypeGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SkypeGroup exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SkypeGroupPersistenceImpl.class);
}