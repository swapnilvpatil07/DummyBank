/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fidel.dummybank.model.CustomerInfo;

/**
 * @author Swapnil
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerInfo, Integer> {

}
