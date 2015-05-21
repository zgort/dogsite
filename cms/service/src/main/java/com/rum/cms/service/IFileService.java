package com.rum.cms.service;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.rum.cms.modules.pojo.File;

/**
 * @author Hikmat
 *
 */
public interface IFileService {

	/**
	 * @param multipartFile
	 * @return
	 */
	public abstract File saveImage(MultipartFile multipartFile);
	
	/**
	 * @param multipartFiles
	 * @return
	 */
	public abstract Set<File> saveImage(Set<MultipartFile> multipartFiles);

	/**
	 * @param multipartFile
	 * @return
	 */
	public abstract File saveReport(MultipartFile multipartFile);
	
	/**
	 * @param multipartFiles
	 * @return
	 */
	public abstract Set<File> saveReport(Set<MultipartFile> multipartFiles);

	/**
	 * @param multipartFile
	 * @return
	 */
	public abstract File saveXRayImage(MultipartFile multipartFile);
	
	/**
	 * @param multipartFiles
	 * @return
	 */
	public abstract Set<File> saveXRayImage(Set<MultipartFile> multipartFiles);
	
}
