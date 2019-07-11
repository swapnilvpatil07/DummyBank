/**
 * 
 */
package com.fidel.dummybank.sequence;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import com.fidel.dummybank.common.Constants;

/**
 * @author Swapnil
 *
 */
@Component
public class AccountNoSequenceGenerator implements IdentifierGenerator {

	private int tempId = -1;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String code = "";
		Connection conn = session.connection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT MAX(account_no) as account_no from dummy_bank.account_info");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt("account_no");
				if (id != tempId) {
					if (id == 0) {
						id = 1;
					} else {
						tempId = id;
						id = Integer.parseInt(id.toString().substring(3));
						id = id + 1;
					}
				} else {
					return null;
				}
				code = id.toString();
				System.out.println("Generated Code: " + code);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Constants.BNAK_CODE + code;
	}

}
