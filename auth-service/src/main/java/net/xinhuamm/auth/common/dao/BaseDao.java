package net.xinhuamm.auth.common.dao;

import java.util.List;

public interface BaseDao<T, T1> {

	/**
	 * 1. 保存数据
	 * @author  huangwz
	 * @created 2020年05月09日 上午10:28:04
	 */
	int insert(T e);

	/**
	 * 1. 根据主键更新数据（推荐）
	 * @author  huangwz
	 * @created 2020年05月09日 上午10:28:04
	 */
	int updateById(T e);

	/**
	 * 1. 根据主键ID删除数据
	 * @author  huangwz
	 * @created 2020年05月09日 上午10:28:04
	 */
	int physicDeleteById(Long id);

	/**
	 * 1. 单条数据查询
	 * @author  huangwz
	 * @created 2020年05月09日 上午10:28:04
	 */
	T find(T1 e);
	
	/**
	 * 1. 按主键查询
	 * @author  huangwz
	 * @created 2020年05月09日 上午10:28:04
	 */
	T findById(Long id);

	/**
	 * 1. 多条数据查询,最多1000条
	 * @author  huangwz
	 * @created 2020年05月09日 上午10:28:04
	 */
	List<T> findList(T1 e);

}
