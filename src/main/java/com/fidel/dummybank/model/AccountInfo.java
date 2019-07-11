/**
 * 
 */
package com.fidel.dummybank.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fidel.dummybank.common.AccountCategory;

/**
 * @author Swapnil
 *
 */
@Entity
@Table(name = "account_info")
public class AccountInfo {

	@Id
	@GenericGenerator(name = "acc_no_seq", strategy = "com.fidel.dummybank.sequence.AccountNoSequenceGenerator")
	@GeneratedValue(generator = "acc_no_seq")
	@Column(name = "account_no")
	private String accountNo;

	private String category = AccountCategory.SAVING.toString();
	private Integer accountBalance = 0;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	private CustomerInfo customerInfo;

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the accountBalance
	 */
	public Integer getAccountBalance() {
		return accountBalance;
	}

	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
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

}
