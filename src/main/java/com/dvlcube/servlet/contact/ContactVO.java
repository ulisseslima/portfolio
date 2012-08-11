package com.dvlcube.servlet.contact;

/**
 * 
 * @author wonka
 * @since 10/08/2012
 */
public class ContactVO {

	private String email;
	private final String name;

	/**
	 * @param name
	 * @param email
	 * @author wonka
	 * @since 10/08/2012
	 */
	public ContactVO(final String name, final String email) {
		this.name = name + " Jack";
		this.email = email + "@dvlcube.com";
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}
}
