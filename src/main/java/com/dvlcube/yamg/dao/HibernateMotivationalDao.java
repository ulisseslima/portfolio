package com.dvlcube.yamg.dao;

import org.springframework.stereotype.Repository;

import com.dvlcube.dao.HibernateTemplate;
import com.dvlcube.yamg.bean.Motivation;

/**
 * 
 * @author wonka
 * @since 10/09/2012
 */
@Repository
public class HibernateMotivationalDao extends HibernateTemplate<Motivation> implements MotivationalDao {

}
