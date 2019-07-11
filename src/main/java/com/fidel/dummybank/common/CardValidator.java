/**
 * 
 */
package com.fidel.dummybank.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Swapnil
 *
 */
public class CardValidator {

	private static Pattern pattern;
	private static String regexDebit = "^(?:(?<Visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<MasterCard>5[1-5][0-9]{14})|"
			+ "(?<Discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<AmericanExpress>3[47][0-9]{13})|"
			+ "(?<DinersClub>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<JCB>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

	/**
	 * Validate Different Cards
	 * 
	 * Visa : 13 or 16 digits, starting with 4.
	 * 
	 * MasterCard: 16 digits, starting with 51 through 55.
	 * 
	 * Discover : 16 digits, starting with 6011 or 65. American Express : 15 digits,
	 * starting with 34 or 37.
	 * 
	 * Diners Club : 14 digits, starting with 300 through 305, 36, or 38.
	 * 
	 * JCB : 15 digits, starting with 2131 or 1800, or 16 digits starting with 35.
	 * 
	 * @param cardNo
	 * @return
	 */
	public static String validateDebitCard(String cardNo) {
		String cardName = "";
		pattern = Pattern.compile(regexDebit);
		cardNo = cardNo.replaceAll("-", "");

		Matcher matcher = pattern.matcher(cardNo);

		if (matcher.matches()) {
			for (DebitCards debitCards : DebitCards.values())
				if (matcher.group(debitCards.toString()) != null) {
					cardName = debitCards.toString();
				}
		}
		return cardName;
	}

	public static DebitCards validateCreditCard(String cardNo) {

		return DebitCards.Visa;
	}

	public static void main(String[] args) {
		String type = validateDebitCard("4900-1534-6100-0226");
		System.out.println(type);
		type = validateDebitCard("5103-7203-5165-6283");
		System.out.println(type);
	}
}
