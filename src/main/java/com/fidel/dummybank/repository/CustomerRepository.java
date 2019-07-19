/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fidel.dummybank.model.CustomerInfo;

/**
 * @author Swapnil
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM customer_info c WHERE c.cust_cnt_no = :mobile_no")
	CustomerInfo findUserByMobNo(@Param("mobile_no") String MobileNo);
}
