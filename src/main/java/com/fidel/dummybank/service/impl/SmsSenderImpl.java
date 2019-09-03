package com.fidel.dummybank.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.fidel.dummybank.common.CommUtils;
import com.fidel.dummybank.model.AccountInfo;
import com.fidel.dummybank.model.PayLoad;
import com.fidel.dummybank.service.SmsSender;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsSenderImpl implements SmsSender {

	private static final String AUTH_TOKEN = "";
	private static final String ACCOUNT_SID = "";
	private static final String TWILIO_NUMBER = "+12055764162";
	private Integer otp;
	private String sms;

	public SmsSenderImpl() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	@Override
	public boolean send(String number, AccountInfo accountInfo, PayLoad payLoad) {
		// TODO: Mobile number validation

		sms = "Acct XXX"
				+ accountInfo.getAccountNo().substring(accountInfo.getAccountNo().length() - 5,
						accountInfo.getAccountNo().length() - 1)
				+ " debited with INR " + payLoad.getTxnAmount() + " on " + CommUtils.getDateTime() + ". Avbl Bal: INR "
				+ accountInfo.getAccountBalance() + ".";

		Message msg = Message.creator(new PhoneNumber("+91" + number), new PhoneNumber(TWILIO_NUMBER), sms).create();

		ResourceSet<Message> messages = Message.reader().read();
		Message message = msg;
		for (Message message1 : messages) {
			message = message1;
			System.out.println(message1.getSid() + " : " + message1.getStatus());
		}

		/*
		 * messages.iterator() .forEachRemaining(message2 ->
		 * System.out.println(message2.getSid() + " : " + message2.getStatus()));
		 */
		return message.getStatus().equals(Message.Status.DELIVERED) ? true : false;
	}

	/**
	 * 
	 * @param i
	 * @return
	 */
	private String getOtp(int otpTmp) {
		Random random = new Random();
		otp = otpTmp;

		int length = String.valueOf(otp).length();
		if (length == 4) {
			return otp.toString();
		} else {
			if (length < 4) {
				getOtp(random.nextInt(9999));
			}
		}
		return otp.toString();
	}

	@Override
	public boolean verify(String otp) {
		if (this.otp == Integer.parseInt(otp)) {
			return true;
		}
		return false;
	}

}
