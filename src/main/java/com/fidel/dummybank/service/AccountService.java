/**
 * 
 */
package com.fidel.dummybank.service;

import com.fidel.dummybank.model.AccountInfo;
import com.fidel.dummybank.model.PayLoad;

/**
 * @author Swapnil
 *
 */
public interface AccountService {

	boolean updateBalance(PayLoad payLoad);

	AccountInfo findById(String custId);

}
