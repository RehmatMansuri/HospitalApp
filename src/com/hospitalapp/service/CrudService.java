package com.hospitalapp.service;

import java.util.List;

public interface CrudService<T> {
	T add(T pojo);
	T update(T pojo);
	Integer delete(Integer id);
	T get(Integer id);
	List<T> getAll();
}
