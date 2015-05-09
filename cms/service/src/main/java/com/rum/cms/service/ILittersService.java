package com.rum.cms.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rum.cms.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
public interface ILittersService extends JpaRepository<Litters, Integer> {

}
