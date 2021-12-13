package com.hcl.payservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class UPIAccount {

	private static final String PAYTM_UPI = "@paytm";
	private static final String G_PAY_UPI = "@oaxis";
	private static final String PHONE_PAY_UPI = "@ybl";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "UPI_account_holder_name")
	private String name;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "upi_application_name")
	private String applicationName;

	@Column(name = "UPI_id")
	private String upi_id;
	
	@CreationTimestamp
	private LocalDateTime inserted_date;

	public UPIAccount() {

	}

	public UPIAccount(String name, String mobileNumber, String applicationName, String upi_id) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.applicationName = applicationName;
		this.upi_id = upi_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getUpi_id() {

		return upi_id;
	}

	public void setUpi_id(String upi_id) {

		if (applicationName.equals("phonepay")) {
			this.upi_id = this.mobileNumber + PHONE_PAY_UPI;
		} else if (applicationName.equals("gpay")) {
			this.upi_id = this.mobileNumber + G_PAY_UPI;
		} else if (applicationName.equals("paytm")) {
			this.upi_id = this.mobileNumber + PAYTM_UPI;
		} else {
			this.upi_id = upi_id;
		}

	}

	@Override
	public String toString() {
		return "UPIAccount [name=" + name + ", mobileNumber=" + mobileNumber + ", applicationName=" + applicationName
				+ "]";
	}

}
