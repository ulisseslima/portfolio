package com.dvlcube.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dvlcube.bean.Contact;
import com.dvlcube.portfolio.dao.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	@Override
	@Transactional
	public void addContact(final Contact contact) {
		contactDAO.addContact(contact);
	}

	@Override
	@Transactional
	public List<Contact> listContact() {
		return contactDAO.listContact();
	}

	@Override
	@Transactional
	public void removeContact(final Integer id) {
		contactDAO.removeContact(id);
	}
}