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
public interface SmsSender {

	boolean send(String number, AccountInfo accountInfo, PayLoad payLoad);

	boolean verify(String otp);

}
