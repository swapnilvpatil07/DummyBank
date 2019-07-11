/**
 * 
 */
package com.fidel.dummybank.common;

/**
 * @author Swapnil
 *
 */
public enum AccountCategory {
	SAVING("Saving"), CURRENT("Current");

	private String category;

	AccountCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}
