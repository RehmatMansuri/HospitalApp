package com.hospitalapp.dao;

import java.util.List;

public interface CrudDao<T> {
	T add(T pojo);
	T update(T pojo);
	Integer delete(Integer id);
	T get(Integer id);
	List<T> getAll();
}
