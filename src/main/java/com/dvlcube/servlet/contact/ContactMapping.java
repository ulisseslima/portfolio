package com.dvlcube.servlet.contact;

import com.dvlcube.servlet.Mapping;

/**
 * 
 * @author wonka
 * @since 10/08/2012
 */
public interface ContactMapping extends Mapping {
	public interface Add {
		String CONTEXT = "/add";
		String VAR_CONTACT = "contact";
	}

	public interface Ajax {
		String CONTEXT = "/ajax/{say}";
		String VAR_MESSAGE = "say";
	}

	public interface Delete {
		String CONTEXT = "/delete/{contactId}";
		String VAR_CONTACT = "contactId";
	}

	public enum View {
		contact
	}

	String ROOT_CONTEXT = "/contact";
}