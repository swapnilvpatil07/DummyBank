/**
 * 
 */
package com.fidel.dummybank.data;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.dummybank.common.AccountCategory;
import com.fidel.dummybank.common.CardType;
import com.fidel.dummybank.model.AccountInfo;
import com.fidel.dummybank.model.BranchInfo;
import com.fidel.dummybank.model.CardInfo;
import com.fidel.dummybank.model.Credentials;
import com.fidel.dummybank.model.CustomerInfo;
import com.fidel.dummybank.repository.CustomerRepository;
import com.github.javafaker.Faker;

/**
 * @author Swapnil
 *
 */
@Service
public class DataLoader {

	static int basaCode = 8520;
	private Faker faker;

	@Autowired
	private CustomerRepository customerRepository;

	public DataLoader() {
		faker = new Faker(Locale.getDefault());

	}

	@PostConstruct
	private void loadCustomerData() {
		CustomerInfo customerInfo;
		Credentials credentials;
		BranchInfo branchInfo;
		AccountInfo accountInfo;
		CardInfo cardInfo;

		for (int i = 0; i < 10; i++) {
			customerInfo = new CustomerInfo();
			credentials = new Credentials();
			branchInfo = new BranchInfo();
			accountInfo = new AccountInfo();
			cardInfo = new CardInfo();

			cardInfo.setCardCategory(CardType.DEBIT.toString());
			if (i % 2 == 0) {
				cardInfo.setCardNo(faker.numerify("4###-####-####-####"));
			} else {
				if (new Random().nextInt(10) % 2 == 0) {
					cardInfo.setCardNo(faker.numerify("34##-####-####-####"));
				} else {
					cardInfo.setCardNo(faker.numerify("51##-####-####-####"));
				}
			}

			cardInfo.setCvv(
					Integer.parseInt(faker.numerify("###").replace("0", String.valueOf(new Random().nextInt(9)))));
			cardInfo.setExpiry("02/25");

			accountInfo.setAccountBalance(i * 100);
			accountInfo.setCategory(AccountCategory.SAVING.toString());

			// branchInfo.setBranchCode(i + basaCode);
			branchInfo.setBranchAddress(faker.streetAddress(true));
			branchInfo.setBranchName("Branch-" + i);

			// customerInfo.setCustId(fake.numerify("540" + i));
			customerInfo.setAddress(faker.streetAddress(true));
			customerInfo.setCustCntNo(faker.numerify("9198########"));
			customerInfo.setCustName(faker.firstName() + " " + faker.lastName());

			credentials.setTransPin(1234);
			credentials.setTransPassword("123456");

			credentials.setCustomerInfo(customerInfo);
			customerInfo.setCredentials(credentials);

			branchInfo.setCustomerInfo(customerInfo);
			customerInfo.setBranchInfoList(Arrays.asList(branchInfo));

			accountInfo.setCustomerInfo(customerInfo);
			customerInfo.setAccountInfo(accountInfo);

			cardInfo.setCustomerInfo(customerInfo);
			customerInfo.setCardInfos(Arrays.asList(cardInfo));

			customerRepository.save(customerInfo);
		}
	}

	@PreDestroy
	private void removeCustomerData() {
		customerRepository.deleteAll();
	}

}
