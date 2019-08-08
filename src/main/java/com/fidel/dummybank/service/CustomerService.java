/**
 * 
 */
package com.fidel.dummybank.service;

import com.fidel.dummybank.model.CustomerInfo;
import com.fidel.dummybank.model.PayLoad;

/**
 * @author Swapnil
 *
 */
public interface CustomerService {

	String getUniqCustId(PayLoad payLoad);

	Object finaById(String uniqCustId);

	CustomerInfo findUserByMobNo(String mobileNo);

}
