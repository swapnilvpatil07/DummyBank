/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fidel.dummybank.model.MerchantInfo;

/**
 * @author Swapnil
 *
 */
public interface MerchantRepository extends JpaRepository<MerchantInfo, Integer> {

}
