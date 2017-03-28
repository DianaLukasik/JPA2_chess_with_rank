package com.capgemini.chess.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.chess.dao.Dao;
import com.capgemini.chess.service.Service;

public abstract class AbstractService<T, K extends Serializable> implements Service<T, K> {

	@Autowired
	Dao<T, K> dao;

	@Override
	public void add(T entity) {
		dao.save(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Override
	public void delete(K id) {
		dao.delete(id);
	}

	@Override
	public T update(T entity) {
		return dao.update(entity);
	}

	@Override
	public T findOne(K id) throws EntityNotFoundException {
		T entity = dao.findOne(id);
		if (entity == null) {
			throw new EntityNotFoundException();
		}
		return dao.findOne(id);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public boolean exists(K id) {
		return dao.exists(id);
	}

}