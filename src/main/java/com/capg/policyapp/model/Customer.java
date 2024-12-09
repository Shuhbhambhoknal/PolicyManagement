package com.capg.policyapp.model;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long customerId;

	
	private String name;

	private String gender;
	
	
	private LocalDate dateOfBirth;

	private String emailId;

	private String contactNumber;

	private String city;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Policy> policyList;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Policy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<Policy> policyList) {
		this.policyList = policyList;
	}

	public Customer(long customerId, String name, String gender, LocalDate dateOfBirth, String emailId,
			String contactNumber, String city, List<Policy> policyList) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.city = city;
		this.policyList = policyList;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", emailId=" + emailId + ", contactNumber=" + contactNumber + ", city=" + city
				+ ", policyList=" + policyList + "]";
	}

}
