package com.rum.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Hikmat
 *
 */
/**
 * @author Hikmat
 *
 */
@Service
@Scope
public class ServiceFactory {

	@Autowired
	private IDogService dogService;
	@Autowired
	private ILittersService littersService;
	@Autowired
	private IFileService fileService;

	/**
	 * @return the dogService
	 */
	public IDogService getDogService() {
		return dogService;
	}

	/**
	 * @return the littersService
	 */
	public ILittersService getLittersService() {
		return littersService;
	}

	/**
	 * @return the fileService
	 */
	public IFileService getFileService() {
		return fileService;
	}

}
