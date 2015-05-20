package com.rum.cms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rum.cms.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
@NoRepositoryBean
public interface ILittersService extends JpaRepository<Litters, Integer> {

}
