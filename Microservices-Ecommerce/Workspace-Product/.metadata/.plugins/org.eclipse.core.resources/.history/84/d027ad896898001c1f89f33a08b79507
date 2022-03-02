package com.abc.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "customer_tbl")
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@ApiModelProperty(notes = "ID of the customer",name="customerId",required=false,value="Auto generated")
	private int customerId;

	@Column(name = "customer_name")
	private String customerName;

	@ApiModelProperty(notes = "Email of the customer",name="email",required=true,value="test email")
	@Column(name = "email")
	private String email;

	@ApiModelProperty(notes = "Mobile Number of the customer",name="mobile",required=true,value="Accept only 10 digits")
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "address")
	private String address;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}