package com.rum.cms.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rum.cms.dao.IDogDAO;
import com.rum.cms.modules.pojo.Dog;
import com.rum.cms.modules.pojo.File;

@Service
class DogService implements IDogService {

	@Autowired
	private IDogDAO dogDAO;
	@Autowired
	private ServiceFactory serviceFactory;

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Transactional
	public <S extends Dog> S save(S entity) {
		IFileService fileService = serviceFactory.getFileService();
		MultipartFile mainImageFile = entity.getMainImageFile();
		Set<MultipartFile> imagesFile = entity.getImagesFile();
		Set<MultipartFile> xRayImagesFile = entity.getxRayImagesFile();
		Set<MultipartFile> reportsFile = entity.getReportsFile();

		File mainImage = fileService.saveImage(mainImageFile);
		Set<File> images = fileService.saveImage(imagesFile);
		Set<File> reports = fileService.saveReport(reportsFile);
		Set<File> xRayImages = fileService.saveXRayImage(xRayImagesFile);
		
		entity.setMainImage(mainImage);
		entity.setImages(images);
		entity.setReports(reports);
		entity.setxRayImages(xRayImages);
		
		return dogDAO.save(entity);
	}

	/**
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	public List<Dog> findAll() {
		return dogDAO.findAll();
	}

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<Dog> findAll(Sort sort) {
		return dogDAO.findAll(sort);
	}

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<Dog> findAll(Pageable pageable) {
		return dogDAO.findAll(pageable);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public Dog findOne(Integer id) {
		return dogDAO.findOne(id);
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(java.lang.Iterable)
	 */
	public List<Dog> findAll(Iterable<Integer> ids) {
		return dogDAO.findAll(ids);
	}

	/**
	 * @param entities
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#save(java.lang.Iterable)
	 */
	@Transactional
	public <S extends Dog> List<S> save(Iterable<S> entities) {
		return dogDAO.save(entities);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	public boolean exists(Integer id) {
		return dogDAO.exists(id);
	}

	/**
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#flush()
	 */
	public void flush() {
		dogDAO.flush();
	}

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#saveAndFlush(java.lang.Object)
	 */
	public <S extends Dog> S saveAndFlush(S entity) {
		return dogDAO.saveAndFlush(entity);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteInBatch(java.lang.Iterable)
	 */
	public void deleteInBatch(Iterable<Dog> entities) {
		dogDAO.deleteInBatch(entities);
	}

	/**
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	public long count() {
		return dogDAO.count();
	}

	/**
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch()
	 */
	public void deleteAllInBatch() {
		dogDAO.deleteAllInBatch();
	}

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	public void delete(Integer id) {
		dogDAO.delete(id);
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.jpa.repository.JpaRepository#getOne(java.io.Serializable)
	 */
	public Dog getOne(Integer id) {
		return dogDAO.getOne(id);
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(Dog entity) {
		if(entity.getId() == null || entity.getId() < 1){
			return;
		}
		dogDAO.delete(entity);
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends Dog> entities) {
		dogDAO.delete(entities);
	}

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() {
		dogDAO.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.rum.cms.service.IDogService#getFemales(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Dog> getFemales(Pageable pageable) {
		return dogDAO.findByMaleAndPublish(Boolean.FALSE, Boolean.TRUE, pageable);
	}

	/* (non-Javadoc)
	 * @see com.rum.cms.service.IDogService#getMales(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Dog> getMales(Pageable pageable) {
		return dogDAO.findByMaleAndPublish(Boolean.TRUE, Boolean.TRUE, pageable);
	}

	/* (non-Javadoc)
	 * @see com.rum.cms.service.IDogService#getForSale(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Dog> getForSale(Pageable pageable) {
		return dogDAO.findByForSaleAndPublish(Boolean.TRUE, Boolean.TRUE, pageable);
	}
	
	
}
