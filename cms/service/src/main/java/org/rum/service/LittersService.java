/**
 * 
 */
package org.rum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.rum.dao.ILittersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rum.modules.pojo.Litters;

/**
 * @author Hikmat
 *
 */
@Service
class LittersService implements ILittersService {

	@Autowired
	private ILittersDAO littersDAO;

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Transactional
	public <S extends Litters> S save(S entity) {
		return littersDAO.save(entity);
	}

	/**
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	public List<Litters> findAll() {
		return littersDAO.findAll();
	}

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<Litters> findAll(Sort sort) {
		return littersDAO.findAll(sort);
	}

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<Litters> findAll(Pageable pageable) {
		return littersDAO.findAll(pageable);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public Litters findOne(Integer id) {
		return littersDAO.findOne(id);
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(java.lang.Iterable)
	 */
	public List<Litters> findAll(Iterable<Integer> ids) {
		return littersDAO.findAll(ids);
	}

	/**
	 * @param entities
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#save(java.lang.Iterable)
	 */
	public <S extends Litters> List<S> save(Iterable<S> entities) {
		return littersDAO.save(entities);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	public boolean exists(Integer id) {
		return littersDAO.exists(id);
	}

	/**
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#flush()
	 */
	public void flush() {
		littersDAO.flush();
	}

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#saveAndFlush(java.lang.Object)
	 */
	public <S extends Litters> S saveAndFlush(S entity) {
		return littersDAO.saveAndFlush(entity);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteInBatch(java.lang.Iterable)
	 */
	public void deleteInBatch(Iterable<Litters> entities) {
		littersDAO.deleteInBatch(entities);
	}

	/**
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	public long count() {
		return littersDAO.count();
	}

	/**
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch()
	 */
	public void deleteAllInBatch() {
		littersDAO.deleteAllInBatch();
	}

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	public void delete(Integer id) {
		littersDAO.delete(id);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#getOne(java.io.Serializable)
	 */
	public Litters getOne(Integer id) {
		return littersDAO.getOne(id);
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(Litters entity) {
		littersDAO.delete(entity);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends Litters> entities) {
		littersDAO.delete(entities);
	}

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() {
		littersDAO.deleteAll();
	} 

}
