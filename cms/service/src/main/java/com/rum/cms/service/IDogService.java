package com.rum.cms.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rum.cms.modules.pojo.Dog;

/**
 * @author Hikmat
 *
 */
public interface IDogService extends JpaRepository<Dog, java.lang.Integer> {

}
