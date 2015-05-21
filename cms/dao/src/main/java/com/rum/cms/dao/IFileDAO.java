package com.rum.cms.dao;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hikmat
 *
 */
public interface IFileDAO {

	/**
	 * @param multipartFile
	 * @param fileName
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public abstract void saveImage(MultipartFile multipartFile, String fileName) throws IllegalStateException, IOException;
	/**
	 * @param multipartFile
	 * @param fileName
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public abstract void saveReport(MultipartFile multipartFile, String fileName) throws IllegalStateException, IOException;
	/**
	 * @param multipartFile
	 * @param fileName
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public abstract void saveXRayImage(MultipartFile multipartFile, String fileName) throws IllegalStateException, IOException;
	
}
