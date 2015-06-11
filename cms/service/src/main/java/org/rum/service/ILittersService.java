package org.rum.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rum.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
public interface ILittersService extends JpaRepository<Litters, Integer> {

}
