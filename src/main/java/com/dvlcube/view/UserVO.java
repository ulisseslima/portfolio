package com.dvlcube.view;

import com.dvlcube.bean.User;

/**
 * @author wonka
 * @since 07/08/2012
 */
public class UserVO {
	private final int age;
	private final String birthDate;
	private final String name;

	public UserVO(final User user) {
		birthDate = user.getBirthDateAsString();
		name = user.getName();
		age = user.getAge();
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
