/**
 * 
 */
package com.fidel.dummybank.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Swapnil
 *
 */
@Entity
public class Credentials {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer credRcdId;
	private Integer transPin;
	private String transPassword;

	public Integer getCredRcdId() {
		return credRcdId;
	}

	public void setCredRcdId(Integer credRcdId) {
		this.credRcdId = credRcdId;
	}

	public Integer getTransPin() {
		return transPin;
	}

	public void setTransPin(Integer transPin) {
		this.transPin = transPin;
	}

	public String getTransPassword() {
		return transPassword;
	}

	public void setTransPassword(String transPassword) {
		this.transPassword = transPassword;
	}

	/**
	 * @return the customerInfo
	 */
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "custId")
	private CustomerInfo customerInfo;
}
