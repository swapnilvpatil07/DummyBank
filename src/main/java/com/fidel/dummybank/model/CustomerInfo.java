/**
 * 
 */
package com.fidel.dummybank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Swapnil
 *
 */
@Entity
public class CustomerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custId;
	private String custName;
	private String address;
	private String custCntNo;

	@OneToOne(mappedBy = "customerInfo", cascade = CascadeType.ALL)
	private Credentials credentials;

	@OneToMany(mappedBy = "customerInfomation", cascade = CascadeType.ALL)
	private List<BranchInfo> branchInfoList;

	@OneToOne(mappedBy = "customerInfo", cascade = CascadeType.ALL)
	private AccountInfo accountInfo;

	@OneToMany(mappedBy = "customerInfo", cascade = CascadeType.ALL)
	private List<CardInfo> cardInfos;

	/**
	 * @return the custId
	 */
	public Integer getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the custCntNo
	 */
	public String getCustCntNo() {
		return custCntNo;
	}

	/**
	 * @param custCntNo the custCntNo to set
	 */
	public void setCustCntNo(String custCntNo) {
		this.custCntNo = custCntNo;
	}

	/**
	 * @return the credentials
	 */
	public Credentials getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials the credentials to set
	 */
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	/**
	 * @return the branchInfo
	 */
	public List<BranchInfo> getBranchInfoList() {
		return branchInfoList;
	}

	/**
	 * @param branchInfo the branchInfo to set
	 */
	public void setBranchInfoList(List<BranchInfo> branchInfoList) {
		this.branchInfoList = branchInfoList;
	}

	/**
	 * @return the accountInfo
	 */
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	/**
	 * @param accountInfo the accountInfo to set
	 */
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	/**
	 * @return the cardInfos
	 */
	public List<CardInfo> getCardInfos() {
		return cardInfos;
	}

	/**
	 * @param cardInfos the cardInfos to set
	 */
	public void setCardInfos(List<CardInfo> cardInfos) {
		this.cardInfos = cardInfos;
	}

}
