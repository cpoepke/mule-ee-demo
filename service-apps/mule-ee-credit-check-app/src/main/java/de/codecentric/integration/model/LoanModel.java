package de.codecentric.integration.model;

import java.util.Date;

public class LoanModel {

	private String name;
	
	private String street;
	
	private int houseNumber;
	
	private int areaCode;
	
	private String city;
	
	private String email;
	
	private Date birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "LoanModel [name=" + name + ", street=" + street
				+ ", houseNumber=" + houseNumber + ", areaCode=" + areaCode
				+ ", city=" + city + ", email=" + email + ", birthday="
				+ birthday + "]";
	}

}
