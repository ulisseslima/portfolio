package com.dvlcube.portfolio.dao;

import java.util.List;

/**
 * @author wonka
 * @since 11/08/2012
 */
public interface CRUD<E> {
	void create(E entity);

	boolean delete(Class<E> entity, int id);

	void delete(E entity);

	List<E> list(Class<E> entity);

	E retrieve(Class<E> entity, int id);

	boolean update(Class<E> entity, int id);

	void update(E entity);
}
