/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fidel.dummybank.model.AccountInfo;

/**
 * @author Swapnil
 *
 */
@Repository
public interface AccountRepositiory extends JpaRepository<AccountInfo, Integer> {

}
