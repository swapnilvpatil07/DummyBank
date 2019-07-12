/**
 * 
 */
package com.fidel.dummybank.model;

/**
 * @author Swapnil
 *
 */
public class PayLoad {
	private Integer mId;
	private Integer ordId;
	private Integer cardId;
	private Integer cvvNo;
	private String hash;

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(Integer cvvNo) {
		this.cvvNo = cvvNo;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "PayLoad [mId=" + mId + ", ordId=" + ordId + ", cardId=" + cardId + ", cvvNo=" + cvvNo + ", hash=" + hash
				+ "]";
	}

}
