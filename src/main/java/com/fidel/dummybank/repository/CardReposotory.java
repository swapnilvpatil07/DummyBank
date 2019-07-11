/**
 * 
 */
package com.fidel.dummybank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fidel.dummybank.model.CardInfo;

/**
 * @author Swapnil
 *
 */
public interface CardReposotory extends JpaRepository<CardInfo, Integer> {

}
