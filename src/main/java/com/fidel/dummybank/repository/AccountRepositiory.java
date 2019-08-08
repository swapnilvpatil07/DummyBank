/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fidel.dummybank.model.AccountInfo;

/**
 * @author Swapnil
 *
 */
@Repository
public interface AccountRepositiory extends JpaRepository<AccountInfo, Integer> {

	@Modifying(clearAutomatically = true)
	@Query(nativeQuery = true, value = "UPDATE account_info SET account_balance= :balance WHERE cust_id= :cust_id")
	int updateBalance(@Param("cust_id") String custId, @Param("balance") String balance);

	@Query(nativeQuery = true, value = "SELECT * FROM account_info WHERE cust_id= :cust_id")
	AccountInfo findByCustId(@Param("cust_id") String custId);
}
