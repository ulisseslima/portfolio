package com.dvlcube.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.dvlcube.motivation.bean.Identifiable;

/**
 * @author wonka
 * @since 11/08/2012
 */
public interface DaoCRUD<E extends Identifiable> extends CRUD<E> {

	/**
	 * @param entity
	 * @param id
	 * @return
	 * @author wonka
	 * @since 13/09/2012
	 */
	boolean delete(Class<E> entity, long id);

	/**
	 * @param entity
	 * @return
	 * @author wonka
	 * @since 13/09/2012
	 */
	List<E> list(Class<E> entity);

	/**
	 * @param entity
	 * @param start
	 * @param maxResults
	 * @return
	 * @author wonka
	 * @since 13/09/2012
	 */
	List<E> list(Class<E> entity, Integer start, Integer maxResults);

	/**
	 * @param entity
	 * @param start
	 * @param maxResults
	 * @param orders
	 * @return Ordered results.
	 * @author wonka
	 * @since 22/09/2012
	 */
	List<E> list(Class<E> entity, Integer start, Integer maxResults, List<Order> orders);

	/**
	 * @param entity
	 * @param start
	 * @param maxResults
	 * @param orders
	 * @param conditions
	 * @return
	 * @author wonka
	 * @since 22/09/2012
	 */
	List<E> list(
		Class<E> entity,
		Integer start,
		Integer maxResults,
		List<Order> orders,
		Criterion... conditions);

	/**
	 * @param entity
	 * @param id
	 * @return
	 * @author wonka
	 * @since 13/09/2012
	 */
	E retrieve(Class<E> entity, long id);

	/**
	 * @param entity
	 * @param id
	 * @return
	 * @author wonka
	 * @since 13/09/2012
	 */
	boolean update(Class<E> entity, long id);
}
