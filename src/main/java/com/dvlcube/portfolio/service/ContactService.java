package com.dvlcube.portfolio.service;

import java.util.List;

import com.dvlcube.bean.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}