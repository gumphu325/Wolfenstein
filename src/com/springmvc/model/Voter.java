/**
 * 
 */
package com.springmvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author debiray
 *
 */
@Document(collection="VOTERS")
public class Voter {

	@Id
	private String id;
	
	private String voterName;

	@Indexed(unique=true)
	private String emailId;

	private String phoneNumber;

	private String nationality;

	private Address address;

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Voter [voterName=" + voterName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", nationality=" + nationality + ", address=" + address + "]";
	}
}
