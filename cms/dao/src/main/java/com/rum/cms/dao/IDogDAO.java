package com.rum.cms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rum.cms.modules.pojo.Dog;

/**
 * @author Hikmat
 *
 */
@Repository
public interface IDogDAO extends JpaRepository<Dog, Integer> {

	/**
	 * @param male
	 * @param publish
	 * @param pageable
	 * @return
	 */
	public Page<Dog> findByMaleAndPublish(Boolean male, Boolean publish, Pageable pageable);
	
	/**
	 * @param forSale
	 * @param publish
	 * @param pageable
	 * @return
	 */
	public Page<Dog> findByForSaleAndPublish(Boolean forSale, Boolean publish, Pageable pageable);
	
}
