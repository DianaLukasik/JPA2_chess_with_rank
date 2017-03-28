package com.capgemini.chess.service;

import java.io.Serializable;
import java.util.List;

public interface Service<T, K extends Serializable> {

	void add(T entity);

	void delete(T entity);

	void delete(K id);

	T update(T entity);

	T findOne(K id);

	List<T> findAll();

	void deleteAll();

	long count();

	boolean exists(K id);

}