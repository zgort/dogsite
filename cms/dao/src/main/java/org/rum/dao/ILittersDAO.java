package org.rum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rum.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
public interface ILittersDAO extends JpaRepository<Litters, Integer> {

}
