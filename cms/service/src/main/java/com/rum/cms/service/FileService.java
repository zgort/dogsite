package com.rum.cms.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rum.cms.dao.IFileDAO;
import com.rum.cms.modules.pojo.File;

/**
 * @author Hikmat
 *
 */
@Service
class FileService implements IFileService {

	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(FileService.class);

	/**
	 * 
	 */
	@Autowired
	private IFileDAO fileDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rum.cms.service.IFileService#saveImage(org.springframework.web.multipart.MultipartFile, java.lang.String)
	 */
	public File saveImage(MultipartFile multipartFile) {
		File file = generateFile(multipartFile);
		String fileName = file.getFileName();
		try {
			fileDAO.saveImage(multipartFile, fileName);
		} catch (IllegalStateException | IOException e) {
			LOGGER.error("Error on saving image name: " + fileName, e);
		}
		return file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rum.cms.service.IFileService#saveReport(org.springframework.web.multipart.MultipartFile, java.lang.String)
	 */
	public File saveReport(MultipartFile multipartFile) {
		File file = generateFile(multipartFile);;
		String fileName = file.getFileName();
		try {
			fileDAO.saveReport(multipartFile, fileName);
		} catch (IllegalStateException | IOException e) {
			LOGGER.error("Error on saving report name: " + fileName, e);
		}
		return file;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.rum.cms.service.IFileService#saveXRayImage(org.springframework.web.multipart.MultipartFile, java.lang.String)
	 */
	public File saveXRayImage(MultipartFile multipartFile) {
		File file = generateFile(multipartFile);
		String fileName = file.getFileName();
		try {
			fileDAO.saveXRayImage(multipartFile, fileName);
		} catch (IllegalStateException | IOException e) {
			LOGGER.error("Error on saving XRay image name: " + fileName, e);
		}
		return file;
	}

	/**
	 * @param multipartFile
	 * @return
	 */
	private File generateFile(MultipartFile multipartFile) {
		File file = new File();
		String referance = UUID.randomUUID().toString();
		String contentType = multipartFile.getContentType();
		String originalFilename = multipartFile.getOriginalFilename();
		long fileSize = multipartFile.getSize();
		file.setReferance(referance);
		file.setFileType(contentType);
		file.setFileName(originalFilename);
		file.setFileSize(fileSize);
		return file;
	}

	/* (non-Javadoc)
	 * @see com.rum.cms.service.IFileService#saveImage(java.util.Set)
	 */
	@Override
	public Set<File> saveImage(Set<MultipartFile> multipartFiles) {
		Set<File> files = new HashSet<File>();
		for (MultipartFile multipartFile : multipartFiles) {
			File saveImage = saveImage(multipartFile);
			files.add(saveImage);
		}
		return files;
	}

	/* (non-Javadoc)
	 * @see com.rum.cms.service.IFileService#saveReport(java.util.Set)
	 */
	@Override
	public Set<File> saveReport(Set<MultipartFile> multipartFiles) {
		Set<File> files = new HashSet<File>();
		for (MultipartFile multipartFile : multipartFiles) {
			File saveImage = saveReport(multipartFile);
			files.add(saveImage);
		}
		return files;
	}

	/* (non-Javadoc)
	 * @see com.rum.cms.service.IFileService#saveXRayImage(java.util.Set)
	 */
	@Override
	public Set<File> saveXRayImage(Set<MultipartFile> multipartFiles) {
		Set<File> files = new HashSet<File>();
		for (MultipartFile multipartFile : multipartFiles) {
			File saveImage = saveXRayImage(multipartFile);
			files.add(saveImage);
		}
		return files;
	}

}
