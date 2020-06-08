package net.xinhuamm.auth.common.mapper;

import java.util.List;

public interface BaseMapper<T, T1> {

	int insert(T e);

	int update(T e);

	int updateById(T e);

	int logicDeleteById(Long id);

	int physicDeleteById(Long id);
	
	T findById(Long id);

	List<T> findList(T1 e);

}