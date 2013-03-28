package com.dvlcube.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.dvlcube.motivation.bean.Identifiable;

@Entity
@Table(name = "contact")
public class Contact implements Identifiable {
	private static final long serialVersionUID = -9039959000104998903L;

	@Column(name = "age")
	private Integer age;

	@Column(name = "birthDate")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date birthDate;

	@Column(name = "email")
	private String email;

	@Column(name = "firstname")
	private String firstname;

	@Id
	@Column(name = "id")
	@GeneratedValue
	private Integer id;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "telephone")
	private String telephone;

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the first name
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getLabel() {
		return toString();
	}

	/**
	 * @return the last name
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(final Integer age) {
		this.age = age;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @param firstname
	 *            the first name to set
	 */
	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @param lastname
	 *            the last name to set
	 */
	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}
}