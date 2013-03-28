package com.dvlcube.motivation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvlcube.motivation.bean.Motivation;
import com.dvlcube.motivation.dao.MotivationDao;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
@Service
public class MotivationWebService extends ServiceTemplate<Motivation> implements MotivationService {

	@Autowired
	private MotivationDao dao;

	@Override
	protected MotivationDao getDao() {
		return dao;
	}

	@Override
	protected Class<Motivation> getT() {
		return Motivation.class;
	}
}
