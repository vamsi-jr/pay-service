package com.hcl.payservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IMPSTransfer implements Serializable {



	/**
	 * Generated Serial Id
	 */
	private static final long serialVersionUID = -1923123326141661075L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;

	@Column(name = "txn_amount")
	private double amount;

	@Column(name = "Account_holder_name")
	private String name;

	@Column(name = "benificary_name")
	private String benificary_name;

	@Column
	private String benificary_account_number;

	@Column
	private String benificary_ifsc;

	@Column
	private String benificary_bank;

	@Column
	private LocalDateTime imps_intiated_date;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBenificary_name() {
		return benificary_name;
	}

	public void setBenificary_name(String benificary_name) {
		this.benificary_name = benificary_name;
	}

	public String getBenificary_account_number() {
		return benificary_account_number;
	}

	public void setBenificary_account_number(String benificary_account_number) {
		this.benificary_account_number = benificary_account_number;
	}

	public String getBenificary_ifsc() {
		return benificary_ifsc;
	}

	public void setBenificary_ifsc(String benificary_ifsc) {
		this.benificary_ifsc = benificary_ifsc;
	}

	public String getBenificary_bank() {
		return benificary_bank;
	}

	public void setBenificary_bank(String benificary_bank) {
		this.benificary_bank = benificary_bank;
	}

	public LocalDateTime getNeft_intiated_date() {
		return imps_intiated_date;
	}

	public void setNeft_intiated_date(LocalDateTime imps_intiated_date) {
		this.imps_intiated_date = imps_intiated_date;
	}

}
