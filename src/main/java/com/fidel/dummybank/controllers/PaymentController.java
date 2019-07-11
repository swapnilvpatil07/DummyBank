/**
 * 
 */
package com.fidel.dummybank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fidel.dummybank.model.Credentials;
import com.fidel.dummybank.repository.CredentialsRepository;

/**
 * @author Swapnil
 *
 */
@Controller
@RequestMapping(path = "/api/v1")
public class PaymentController {

	@Autowired
	private CredentialsRepository credentialsRepository;

	@PostMapping(path = "/charge")
	public String charge(/* @RequestAttribute("custInfo") CustomerInfo customerInfo, */Model model) {
		Credentials creds = credentialsRepository.findCredentialsById(1/* customerInfo.getCustId() */);

		if (creds == null)
			return "init_credentials";

		return "charge";
	}

	@GetMapping(path = "/test")
	public String testBank(Model model) {
		// TODO Auto-generated method stub
		return "test";
	}
}
