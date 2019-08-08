/**
 * 
 */
package com.fidel.dummybank.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.dummybank.model.AccountInfo;
import com.fidel.dummybank.model.PayLoad;
import com.fidel.dummybank.repository.AccountRepositiory;
import com.fidel.dummybank.service.AccountService;

/**
 * @author Swapnil
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepositiory accountRepositiory;
	private Integer remainBal;

	/**
	 * 
	 */
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean updateBalance(PayLoad payLoad) {
		AccountInfo accountInfo = accountRepositiory.findByCustId(payLoad.getCustId());
		if (accountInfo != null) {
			if (accountInfo.getAccountBalance() != null) {
				if (accountInfo.getAccountBalance() > 0
						&& accountInfo.getAccountBalance() >= Integer.parseInt(payLoad.getTxnAmount())) {
					setRemainBal(accountInfo.getAccountBalance() - Integer.parseInt(payLoad.getTxnAmount()));
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return (accountRepositiory.updateBalance(payLoad.getCustId(), getRemainBal().toString()) > 0) ? true : false;
	}

	/**
	 * @return the remainBal
	 */
	public Integer getRemainBal() {
		return remainBal;
	}

	/**
	 * @param remainBal the remainBal to set
	 */
	public void setRemainBal(Integer remainBal) {
		this.remainBal = remainBal;
	}

	@Override
	public AccountInfo findById(String custId) {
		AccountInfo accountInfo = accountRepositiory.findByCustId(custId);
		if (accountInfo == null) {
			return new AccountInfo();
		}
		return accountInfo;
	}

}
