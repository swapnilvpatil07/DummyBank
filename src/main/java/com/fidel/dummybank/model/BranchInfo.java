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
import javax.persistence.ManyToOne;

/**
 * @author Swapnil
 *
 */
@Entity
public class BranchInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer branchCode;
	private String branchName;
	private String branchAddress;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id", referencedColumnName = "custId")
	private CustomerInfo customerInfomation;

	/**
	 * @return the branchCode
	 */
	public Integer getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchAddress
	 */
	public String getBranchAddress() {
		return branchAddress;
	}

	/**
	 * @param branchAddress the branchAddress to set
	 */
	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	/**
	 * @return the customerInfoList
	 */
	public CustomerInfo getCustomerInfo() {
		return customerInfomation;
	}

	/**
	 * @param customerInfoList the customerInfoList to set
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfomation = customerInfo;
	}

}
