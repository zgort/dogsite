package com.rum.cms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rum.cms.modules.pojo.Dog;

/**
 * @author Hikmat
 *
 */
@NoRepositoryBean
public interface IDogService extends JpaRepository<Dog, java.lang.Integer> {

	/**
	 * @param pageable
	 * @return
	 */
	public Page<Dog> getFemales(Pageable pageable);
	
	/**
	 * @param pageable
	 * @return
	 */
	public Page<Dog> getMales(Pageable pageable);
	
	/**
	 * @param pageable
	 * @return
	 */
	public Page<Dog> getForSale(Pageable pageable);
	
}
