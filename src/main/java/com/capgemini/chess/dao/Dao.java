package com.capgemini.chess.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, K extends Serializable> {

	void save(T entity);

	void delete(T entity);

	void delete(K id);

	T update(T entity);

	T findOne(K id);

	List<T> findAll();

	void deleteAll();

	long count();

	boolean exists(K id);

}
