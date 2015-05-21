package com.rum.cms.dao;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Hikmat
 *
 */
@Repository
class FileDAO implements IFileDAO{

	@Value("${image.dir}")
	private String imageDir;
	@Value("${report.dir}")
	private String reportDir;
	@Value("${XRayImage.dir}")
	private String xrayImageDir;

	@Override
	public void saveImage(MultipartFile multipartFile, String fileName) throws IllegalStateException, IOException {
		saveFile(multipartFile, fileName, imageDir);
	}

	@Override
	public void saveReport(MultipartFile multipartFile, String fileName) throws IllegalStateException, IOException{
		saveFile(multipartFile, fileName, reportDir);
	}

	@Override
	public void saveXRayImage(MultipartFile multipartFile, String fileName) throws IllegalStateException, IOException{
		saveFile(multipartFile, fileName, xrayImageDir);
	}
	
	/**
	 * @param multipartFile
	 * @param fileName
	 * @param dir
	 * @throws IOException
	 */
	private void saveFile(MultipartFile multipartFile, String fileName, String dir) throws IOException {
		File file = new File(dir+"/"+fileName);
		multipartFile.transferTo(file);
	}	
	
}
