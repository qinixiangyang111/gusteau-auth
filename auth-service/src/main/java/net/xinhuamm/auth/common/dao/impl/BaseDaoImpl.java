package net.xinhuamm.auth.common.dao.impl;



import net.xinhuamm.auth.common.dao.BaseDao;
import net.xinhuamm.auth.common.mapper.BaseMapper;

import java.util.List;

/**
 * 数据库公共操作类
 * @author  huangwz
 * @created 2020年05月09日 上午10:37:33
 */
public abstract class BaseDaoImpl<T, T1> implements BaseDao<T, T1> {

	public abstract BaseMapper<T, T1> getMapper();

	/**
	 * 保存数据
	 */
	@Override
	public int insert(T e) {
		return getMapper().insert(e);
	}

	/**
	 * 根据主键更新数据
	 */
	@Override
	public int updateById(T e) {
		return getMapper().updateById(e);
	}

	/**
	 * 根据主键删除数据
	 */
	@Override
	public int physicDeleteById(Long id) {
		return getMapper().logicDeleteById(id);
	}

	/**
	 * 查询单条数据
	 */
	@Override
	public T find(T1 e) {
		List<T> tList = findList(e);
		if (tList.isEmpty()) {
			return null;
		}
		return tList.get(0);
	}

	/**
	 * 根据主键查询单条数据
	 */
	@Override
	public T findById(Long id) {
		return getMapper().findById(id);
	}
	
	/**
	 * 查询多条数据,最多1000条，并排序
	 */
	@Override
	public List<T> findList(T1 e) {
		if (e == null) {
			return null;
		}
		return getMapper().findList(e);
	}
}
