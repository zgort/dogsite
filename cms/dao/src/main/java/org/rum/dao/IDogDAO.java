package org.rum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rum.modules.pojo.Dog;

/**
 * @author Hikmat
 *
 */
@Repository
public interface IDogDAO extends JpaRepository<Dog, Integer> {

}
