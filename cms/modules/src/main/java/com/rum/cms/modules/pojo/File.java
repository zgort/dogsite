package com.rum.cms.modules.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author Hikmat
 *
 */
@Entity
public class File {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String fileName;
	private FileType fileType;
	@Lob
	private String desc;
	private String referance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getReferance() {
		return referance;
	}

	public void setReferance(String referance) {
		this.referance = referance;
	}

}
