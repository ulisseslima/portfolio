package com.dvlcube.yamg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlcube.yamg.bean.Motivation;
import com.dvlcube.yamg.dao.MotivationalDao;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
@Service
public class DefaultMotivationalService implements MotivationalService {

	@Autowired
	private MotivationalDao dao;

	@Override
	@Transactional
	public boolean add(final Motivation motivation) {
		dao.create(motivation);
		return true;
	}

	@Override
	@Transactional
	public Motivation get(final long id) {
		final Motivation motivation = dao.retrieve(Motivation.class, id);
		return motivation;
	}

	@Override
	@Transactional
	public List<Motivation> list() {
		final List<Motivation> list = dao.list(Motivation.class);
		return list;
	}

	@Override
	@Transactional
	public Motivation remove(final Motivation motivation) {
		dao.delete(motivation);
		return null;
	}
}
