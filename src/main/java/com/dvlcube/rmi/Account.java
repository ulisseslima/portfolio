package com.dvlcube.rmi;

import java.io.Serializable;

/**
 * 
 * @author wonka
 * @since 28/01/2013
 */
public class Account implements Serializable {
	private static final long serialVersionUID = -5962822687608050878L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}