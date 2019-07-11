/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fidel.dummybank.model.Credentials;

/**
 * @author Swapnil
 *
 */
public interface CredentialsRepository extends JpaRepository<Credentials, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM Credentials c WHERE c.customer_id = :cust_id")
	Credentials findCredentialsById(@Param("cust_id") Integer custId);
}
