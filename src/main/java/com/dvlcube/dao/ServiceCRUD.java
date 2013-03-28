package com.dvlcube.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.dvlcube.motivation.service.Response;

/**
 * 
 * @author wonka
 * @since 15/09/2012
 */
public interface ServiceCRUD<T> {
	/**
	 * @param entity
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> add(T entity);

	/**
	 * @param id
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> delete(long id);

	/**
	 * @param entity
	 * @author wonka
	 * @since 13/09/2012
	 */
	Response<T> delete(T entity);

	/**
	 * @param id
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> get(long id);

	/**
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> list();

	/**
	 * @param start
	 * @param maxResults
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> list(Integer start, Integer maxResults);

	/**
	 * @param start
	 * @param maxResults
	 * @param order
	 * @return Ordered list.
	 * @author wonka
	 * @since 22/09/2012
	 */
	Response<T> list(Integer start, Integer maxResults, List<Order> order);

	/**
	 * @param start
	 * @param maxResults
	 * @param order
	 * @param conditions
	 * @return Conditional results.
	 * @author wonka
	 * @since 22/09/2012
	 */
	Response<T> list(Integer start, Integer maxResults, List<Order> order, Criterion... conditions);

	/**
	 * @param id
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> update(long id);

	/**
	 * @param entity
	 * @return
	 * @author wonka
	 * @since 15/09/2012
	 */
	Response<T> update(T entity);
}