/**
 * 
 */
package com.fidel.dummybank.common;

import java.util.ArrayList;

/**
 * @author Swapnil
 *
 */
public class CommUtils {
	protected static ArrayList<String> genBranchCd() {
		ArrayList<String> brachCds = new ArrayList<String>();
		for (int i = 0; i < 100; i++)
			brachCds.add("10" + i);
		return brachCds;
	}
}
