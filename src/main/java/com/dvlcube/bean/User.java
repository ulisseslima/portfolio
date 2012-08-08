package com.dvlcube.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wonka
 * @since 07/08/2012
 */
public class User {
	public static void main(final String[] args) {
		try {
			final User user = new User("Joe",
					new SimpleDateFormat("dd/MM/yyyy").parse("09/05/1986"));
			final long age = new Date().getTime()
					- user.getBirthDate().getTime();
			System.out.println(age);
			System.out.println(age / 1000 / 60 / 60 / 24 / 365);
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	private Date birthDate;

	private String name;

	public User(final String name) {
		this(name, null);
	}

	public User(final String name, final Date birthDate) {
		this.birthDate = birthDate;
		this.name = name;
	}

	public int getAge() {
		return birthDate == null ? 0 : (int) (birthDate.getTime() / 1000 / 60
				/ 60 / 24 / 365);
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return
	 * @author wonka
	 * @since 07/08/2012
	 */
	public String getBirthDateAsString() {
		return birthDate == null ? "-" : birthDate.toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
}
