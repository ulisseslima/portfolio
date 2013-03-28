package com.dvlcube.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 
 * @author wonka
 * @since 28/01/2013
 */
public interface RemoteAccountService extends Remote {
	public List<Account> getAccounts(String name) throws RemoteException;

	public void insertAccount(Account account) throws RemoteException;
}
