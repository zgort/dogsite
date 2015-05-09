package com.rum.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rum.cms.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
public interface ILittersDAO extends JpaRepository<Litters, Integer> {

}
