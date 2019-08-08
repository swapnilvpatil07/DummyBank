/**
 * 
 */
package com.fidel.dummybank.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.SerializationUtils;

import com.fidel.dummybank.model.PayLoad;

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

	public static String toChecksum(String key) {
		return DigestUtils.sha256Hex(key);
	}

	public static String toChecksum(Map<String, String> key) {
		return DigestUtils.sha512Hex(SerializationUtils.serialize(key));
	}

	public static void main(String[] args) {
		String str = toChecksum("secrate");
		System.out.println(str);

		PayLoad load = new PayLoad();
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", "123456");
		map.put("mobile_no", "8698484304");
		map.put("email_id", "swapnilvpatil07@gamil.com");
		map.put("m_id", "PayTm");

		String str1 = toChecksum(map);
		System.out.println(str1);

		Map<String, String> map2 = new HashMap<String, String>();
		map.put("user_id", "123456");
		map.put("mobile_no", "8698484304");
		map.put("email_id", "swapnilvpatil07@gamil.com");
		map.put("m_id", "PayTm");

		String str2 = toChecksum(map2);
		System.out.println(str2);
	}

	public static String getDateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return now.format(format);
	}

}
