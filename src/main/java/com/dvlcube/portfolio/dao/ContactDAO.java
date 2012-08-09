package com.dvlcube.portfolio.dao;

import java.util.List;

import com.dvlcube.bean.Contact;

public interface ContactDAO {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}