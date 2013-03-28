package com.dvlcube.rmi;

import java.util.List;

/**
 * 
 * @author wonka
 * @since 28/01/2013
 */
public class AccountServiceImpl implements AccountService {

	public List<Account> getAccounts(final String name) {
		System.out.println("public List<Account> getAccounts(final String name)");
		return null;
	}

	public void insertAccount(final Account acc) {
		System.out.println("public void insertAccount(final Account acc)");
	}
}
