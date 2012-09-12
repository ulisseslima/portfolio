package com.dvlcube.portfolio.dao;

import org.springframework.stereotype.Repository;

import com.dvlcube.bean.Contact;
import com.dvlcube.dao.HibernateTemplate;

@Repository
public class ContactDAOImpl extends HibernateTemplate<Contact> implements ContactDAO {

}