package com.dvlcube.motivation.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlcube.dao.DaoCRUD;
import com.dvlcube.dao.ServiceCRUD;
import com.dvlcube.motivation.bean.Identifiable;
import com.dvlcube.util.I18n;

/**
 * 
 * @author wonka
 * @since 15/09/2012
 */
@Service
@Transactional(rollbackFor = Exception.class)
public abstract class ServiceTemplate<T extends Identifiable> implements ServiceCRUD<T> {

	@Override
	public Response<T> add(final T entity) {
		getDao().create(entity);
		final Response<T> response = new Response<T>(true);
		response.setMessage(I18n.Response.SUCCESS.key());
		return response;
	}

	@Override
	public Response<T> delete(final long id) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public Response<T> delete(final T entity) {
		getDao().delete(entity);
		return new Response<>(true);
	}

	@Override
	public Response<T> get(final long id) {
		final T motivation = getDao().retrieve(getT(), id);
		return new Response<T>(true, motivation);
	}

	/**
	 * @return The implementing DAO.
	 * @author wonka
	 * @since 16/09/2012
	 */
	protected abstract DaoCRUD<T> getDao();

	/**
	 * @return The implementing class type.
	 * @author wonka
	 * @since 16/09/2012
	 */
	protected abstract Class<T> getT();

	@Override
	public Response<T> list() {
		final List<T> list = getDao().list(getT());
		return new Response<T>(true, list);
	}

	@Override
	public Response<T> list(final Integer start, final Integer maxResults) {
		return list(start, maxResults, null);
	}

	@Override
	public Response<T> list(final Integer start, final Integer maxResults, final List<Order> orders) {
		return list(start, maxResults, orders, new Criterion[0]);
	}

	@Override
	public Response<T> list(
		final Integer start,
		final Integer maxResults,
		final List<Order> orders,
		final Criterion... conditions) {
		final List<T> list = getDao().list(getT(), start, maxResults, orders, conditions);
		return new Response<T>(true, list);
	}

	@Override
	public Response<T> update(final long id) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	@Override
	public Response<T> update(final T entity) {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}
