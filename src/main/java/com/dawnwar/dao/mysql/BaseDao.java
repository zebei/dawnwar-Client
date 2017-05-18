package com.dawnwar.dao.mysql;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.dawnwar.utils.Paging;

/**
 * 公用Dao基类
 * 
 * @param <T>
 *            泛型
 */
public abstract class BaseDao<T> extends SqlSessionDaoSupport {
	protected static final String CREATE = "create";
	protected static final String CREATES = "creates";
	protected static final String DELETE = "delete";
	protected static final String DELETES = "deletes";
	protected static final String UPDATE = "update";
	protected static final String LOAD = "load";
	protected static final String LOADS = "loads";
	protected static final String LIST = "list";
	protected static final String COUNT = "count";
	protected static final String PAGING = "paging";
	public final String nameSpace;

	@SuppressWarnings("rawtypes")
	public BaseDao() {
		if ((getClass().getGenericSuperclass() instanceof ParameterizedType)) {
			this.nameSpace = ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
		} else
			this.nameSpace = ((Class) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
	}

	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	public Boolean create(T t) {
		return Boolean.valueOf(getSqlSession().insert(sqlId("create"), t) == 1);
	}

	public Integer creates(List<T> ts) {
		return Integer.valueOf(getSqlSession().insert(sqlId("creates"), ts));
	}

	public Integer creates(T t0, T t1, T[] tn) {
		return Integer.valueOf(getSqlSession().insert(sqlId("creates"), Arrays.asList(new Object[] { t0, t1, tn })));
	}

	public Boolean delete(Long id) {
		return Boolean.valueOf(getSqlSession().delete(sqlId("delete"), id) == 1);
	}

	public Integer deletes(List<Long> ids) {
		return Integer.valueOf(getSqlSession().delete(sqlId("deletes"), ids));
	}

	public Integer deletes(Long id0, Long id1, Long[] idn) {
		return Integer.valueOf(getSqlSession().delete(sqlId("deletes"), Arrays.asList(new Serializable[] { id0, id1, idn })));
	}

	public Boolean update(T t) {
		return Boolean.valueOf(getSqlSession().update(sqlId("update"), t) == 1);
	}

	public T load(Integer id) {
		return load(Long.valueOf(id));
	}

	public T load(Long id) {
		return getSqlSession().selectOne(sqlId("load"), id);
	}

	public T load(String id) {
		return load(Long.valueOf(id));
	}

	public List<T> loads(List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return Collections.emptyList();
		}
		return getSqlSession().selectList(sqlId("loads"), ids);
	}

	public List<T> loads(Long id0, Long id1, Long[] idn) {
		return getSqlSession().selectList(sqlId("loads"), Arrays.asList(new Serializable[] { id0, id1, idn }));
	}

	public List<T> list(T t) {
		return getSqlSession().selectList(sqlId("list"), t);
	}

	public List<T> list(Map<?, ?> criteria) {
		return getSqlSession().selectList(sqlId("list"), criteria);
	}

	public Long count(Map<String, Object> criteria) {
		return getSqlSession().selectOne(sqlId("count"), criteria);
	}

	public Long count(T criteria) {
		return getSqlSession().selectOne(sqlId("count"), criteria);
	}

	/**
	 * 分页方法
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Paging<T> paging(Integer offset, Integer limit) {
		return paging(offset, limit, new HashMap<String, Object>());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Paging<T> paging(Integer offset, Integer limit, T criteria) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (criteria != null) {
			// 对象转换Map
			String jsonString = JSON.toJSONString(criteria);
			Map<String, Object> map = JSON.parseObject(jsonString, Map.class);
			params.putAll(map);
		}
		Long total = (Long) getSqlSession().selectOne(sqlId("count"), criteria);
		if (total.longValue() <= 0L) {
			return new Paging(Long.valueOf(0L), Collections.emptyList());
		}
		params.put("offset", offset);
		params.put("limit", limit);

		List<T> datas = getSqlSession().selectList(sqlId("paging"), params);
		return new Paging(total, datas);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Paging<T> paging(Integer offset, Integer limit, Map<String, Object> criteria) {
		if (criteria == null) {
			criteria = new HashMap<String, Object>();
		}

		Long total = (Long) getSqlSession().selectOne(sqlId("count"), criteria);
		if (total.longValue() <= 0L) {
			return new Paging(Long.valueOf(0L), Collections.emptyList());
		}
		criteria.put("offset", offset);
		criteria.put("limit", limit);

		List<T> datas = getSqlSession().selectList(sqlId("paging"), criteria);
		return new Paging(total, datas);
	}

	protected String sqlId(String id) {
		System.out.println(this.nameSpace + "." + id);
		return this.nameSpace + "." + id;
	}
}