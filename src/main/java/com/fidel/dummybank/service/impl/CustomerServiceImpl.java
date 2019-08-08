/**
 * 
 */
package com.fidel.dummybank.service.impl;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.dummybank.model.CustomerInfo;
import com.fidel.dummybank.model.PayLoad;
import com.fidel.dummybank.repository.CustomerRepository;
import com.fidel.dummybank.service.CustomerService;

/**
 * @author Swapnil
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * 
	 */
	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUniqCustId(PayLoad payLoad) {
		CustomerInfo custDetailsByMob = customerRepository.findUserByMobNo(payLoad.getMobileNo());
		CustomerInfo custDetailsByEmail = customerRepository.findUserByEmail(payLoad.getEmail());

		if (custDetailsByMob.getCustId() == custDetailsByEmail.getCustId()) {
			return custDetailsByEmail.getCustId().toString();
		}
		return StringUtils.EMPTY;
	}

	@Override
	public CustomerInfo finaById(String uniqCustId) {
		Optional<CustomerInfo> cust = customerRepository.findById(Integer.parseInt(uniqCustId));
		CustomerInfo custInfo = null;
		if (cust.isPresent()) {
			custInfo = cust.get();
		} else {
			custInfo = new CustomerInfo();
		}
		return custInfo;
	}

	@Override
	public CustomerInfo findUserByMobNo(String mobileNo) {
		customerRepository.findUserByMobNo(mobileNo);
		return null;
	}

}
