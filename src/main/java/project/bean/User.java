package project.bean;

import java.util.Date;

public class User {
	private String firstName;
	private String lastName;
	private int sex;
	private Date birthDate;
	private String phone;
	private String country;
	private String emailAddress;
	private String password;
	private double expectedSalary;
	private boolean Accept;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccept() {
		return Accept;
	}

	public void setAccept(boolean accept) {
		Accept = accept;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", birthDate=" + birthDate
				+ ", country=" + getCountry() + ", emailAddress=" + emailAddress + ", password=" + password
				+ ", Accept=" + Accept + "]";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
