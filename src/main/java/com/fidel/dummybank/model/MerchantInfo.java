/**
 * 
 */
package com.fidel.dummybank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Swapnil
 *
 */
@Entity
public class MerchantInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mId;
	private String mName;

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

}
