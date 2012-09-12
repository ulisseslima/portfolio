package com.dvlcube.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author wonka
 * @since 11/08/2012
 */
@Repository
@SuppressWarnings("unchecked")
public abstract class HibernateTemplate<E> {
	public class CubeCriteria<T> {
		private final Criteria criteria;

		public CubeCriteria(final Class<?> entity, final Criterion... restrictions) {
			criteria = getSession().createCriteria(entity);
			for (final Criterion criterion : restrictions) {
				criteria.add(criterion);
			}
		}

		public List<T> list() {
			return criteria.list();
		}
	}

	public class CubeQuery<T> {
		private final Query query;

		public CubeQuery(final String string) {
			query = getSession().createQuery(string);
		}

		public List<T> list() {
			return query.list();
		}
	}

	@Autowired
	public SessionFactory sessionFactory;

	public void create(final E entity) {
		getSession().save(entity);
	}

	public boolean delete(final Class<E> entity, final long id) {
		final E object = (E) getSession().load(entity, id);
		if (null != object) {
			getSession().delete(object);
			return true;
		} else {
			return false;
		}
	}

	public void delete(final E entity) {
		getSession().delete(entity);
	}

	/**
	 * @return hibernate session.
	 * @author wonka
	 * @since 11/08/2012
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<E> list(final Class<E> entity) {
		return new CubeCriteria<E>(entity).list();
	}

	public E retrieve(final Class<E> entity, final long id) {
		return (E) getSession().load(entity, id);
	}

	public boolean update(final Class<E> entity, final long id) {
		final E object = (E) getSession().load(entity, id);
		if (null != object) {
			getSession().merge(object);
			return true;
		} else {
			return false;
		}
	}

	public void update(final E entity) {
		getSession().merge(entity);
	}
}
