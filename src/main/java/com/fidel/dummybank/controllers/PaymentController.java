/**
 * 
 */
package com.fidel.dummybank.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fidel.dummybank.common.CommUtils;
import com.fidel.dummybank.common.Constants;
import com.fidel.dummybank.model.CustomerInfo;
import com.fidel.dummybank.model.MerchantInfo;
import com.fidel.dummybank.model.PayLoad;
import com.fidel.dummybank.service.AccountService;
import com.fidel.dummybank.service.CustomerService;
import com.fidel.dummybank.service.MerchantService;
import com.fidel.dummybank.service.SmsSender;

/**
 * @author Swapnil
 *
 */
@Controller
@RequestMapping(path = "/api/v1")
public class PaymentController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private SmsSender sender;

	// logger
	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping(path = "/charge")
	public String charge(@ModelAttribute("pay-load") PayLoad payLoad, Model model) {
		CustomerInfo custDetails = customerService.findUserByMobNo(payLoad.getMobileNo());
		if (custDetails == null)
			// view to render
			return "init_credentials";

		// view to render
		return "confirm";
	}

	@PostMapping(path = "/net-pay")
	public String netPay(@RequestParam(name = "bnk", required = false) String bnk,
			@RequestParam(name = "othr-bnk", required = false) String othrBnk, PayLoad payLoad, Model model,
			HttpServletRequest request, HttpServletResponse response) {

		// mobile number & email check
		if (payLoad.getMobileNo() == null && payLoad.getEmail() == null) {
			payLoad.setReqType(Constants.CNCL);
			model.addAttribute("payload", payLoad);
			model.addAttribute(Constants.STATUS, Constants.ERROR);
			model.addAttribute(Constants.MESSAGE, "User data mismatch.");

			// view to render
			return "error-request";
		}

		// get customer id from database
		String uniqCustId = customerService.getUniqCustId(payLoad);

		// customer id empty check
		if (uniqCustId.isEmpty()) {
			payLoad.setReqType(Constants.CNCL);
			model.addAttribute("payload", payLoad);
			model.addAttribute(Constants.STATUS, Constants.ERROR);
			model.addAttribute(Constants.MESSAGE, "User not registered with bank.");
			return "error-request";
		}

		// get merchant details
		MerchantInfo mrInfo = merchantService.findById(Integer.parseInt(bnk));
		if (mrInfo.getmId() == null) {
			payLoad.setReqType(Constants.CNCL);
			model.addAttribute("payload", payLoad);
			model.addAttribute(Constants.STATUS, Constants.ERROR);
			model.addAttribute(Constants.MESSAGE, "Merchant not found.");

			// view to render
			return "error-request";
		}

		// response preparation
		model.addAttribute("mrData", mrInfo);
		model.addAttribute("processUrl", "/api/v1/process-payment");
		payLoad.setCustId(uniqCustId);
		model.addAttribute("payload", payLoad);
		model.addAttribute("data", customerService.finaById(uniqCustId));
		model.addAttribute("curDate", CommUtils.getDateTime());

		// view to render
		return "net-payment";
	}

	@PostMapping(path = "/process-payment")
	public String processPayment(@RequestParam("status") String status, PayLoad payLoad, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		if (status.equals("cancel")) {
			payLoad.setReqType(Constants.CNCL);
			model.addAttribute("payload", payLoad);
			model.addAttribute(Constants.STATUS, Constants.ERROR);
			model.addAttribute(Constants.MESSAGE, "Payment Error");

			// view to render
			return "net-pay-status";
		}

		String message = "Payment Successful!";
		status = "success";

		if (!accountService.updateBalance(payLoad)) {
			payLoad.setReqType(Constants.CNCL);
			model.addAttribute("payload", payLoad);
			model.addAttribute(Constants.STATUS, Constants.ERROR);
			model.addAttribute(Constants.MESSAGE, "Payment Error");

			// view to render
			return "net-pay-status";
		}

		model.addAttribute("payload", payLoad);
		model.addAttribute("status", status);
		model.addAttribute("message", message);

		try {
			sender.send(payLoad.getMobileNo(), accountService.findById(payLoad.getCustId()), payLoad);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		// view to render
		return "net-pay-status";
	}

	@GetMapping(path = "/paymentStatus")
	public String paymentStatus(@RequestParam("status") String status, @RequestParam("message") String message,
			PayLoad payLoad, Model model, HttpServletRequest request, HttpServletResponse response) {

		model.addAttribute("status", status);
		model.addAttribute("message", message);
		model.addAttribute("payload", payLoad);

		return "redirect:https://localhost:8084/wallet/txnStatus?status=" + status + "&message=" + message + "&"
				+ payLoad.toString();
		// return "redirect:http://localhost:8084/wallet/txnStatus?status=" + status +
		// "&message=" + message + "&"
		// + payLoad.toString();
	}

}
