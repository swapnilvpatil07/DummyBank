/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fidel.dummybank.model.BranchInfo;

/**
 * @author Swapnil
 *
 */
@Repository
public interface BranchRepository extends JpaRepository<BranchInfo, Integer> {

}
