package com.dvlcube.rmi;

import java.util.List;

/**
 * 
 * @author wonka
 * @since 28/01/2013
 */
public interface AccountService {

	public List<Account> getAccounts(String name);

	public void insertAccount(Account account);
}