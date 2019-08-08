/**
 * 
 */
package com.fidel.dummybank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.fidel.dummybank.repository.CredentialsRepository;
import com.fidel.dummybank.service.CredService;

/**
 * @author Swapnil
 *
 */
public class CredServiceImpl implements CredService {

	@Autowired
	private CredentialsRepository credentialsRepository;

	/**
	 * 
	 */
	public CredServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
