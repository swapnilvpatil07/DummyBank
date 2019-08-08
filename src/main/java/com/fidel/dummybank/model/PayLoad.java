/**
 * 
 */
package com.fidel.dummybank.model;

/**
 * @author Swapnil
 *
 */
public class PayLoad {

	private String mId;
	private String reqType;
	private String ssoToken;
	private String orderId;
	private String custId;
	private String mobileNo;
	private String email;
	private String channelId;
	private String txnAmount;
	private String callBckUrl;

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getSsoToken() {
		return ssoToken;
	}

	public void setSsoToken(String ssoToken) {
		this.ssoToken = ssoToken;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getCallBckUrl() {
		return callBckUrl;
	}

	public void setCallBckUrl(String callBckUrl) {
		this.callBckUrl = callBckUrl;
	}

	@Override
	public String toString() {
		return "mId=" + mId + "&reqType=" + reqType + "&ssoToken=" + ssoToken + "&orderId=" + orderId + "&custId="
				+ custId + "&mobileNo=" + mobileNo + "& email=" + email + "&channelId=" + channelId + "&txnAmount="
				+ txnAmount + "&callBckUrl=" + callBckUrl;
	}

}
