package com.dvlcube.motivation.dao;

import org.springframework.stereotype.Repository;

import com.dvlcube.dao.HibernateTemplate;
import com.dvlcube.motivation.bean.Motivation;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
@Repository
public class HibernateMotivationDao extends HibernateTemplate<Motivation> implements MotivationDao {

}
