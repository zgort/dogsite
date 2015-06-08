package com.rum.modules.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Dog {

	private Integer id;
	private String name;
	private String desc;
	private Boolean male;
	private Boolean forSale;
	private Date dateOfBirth;
	private Date sortDate;

	private Set<File> images = new HashSet<>();
	private Set<File> reports = new HashSet<>();
	private Set<File> xRayImages = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getMale() {
		return male;
	}

	public void setMale(Boolean male) {
		this.male = male;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<File> getImages() {
		return images;
	}

	public void setImages(Set<File> images) {
		this.images = images;
	}

	public Set<File> getReports() {
		return reports;
	}

	public void setReports(Set<File> reports) {
		this.reports = reports;
	}

	public Set<File> getxRayImages() {
		return xRayImages;
	}

	public void setxRayImages(Set<File> xRayImages) {
		this.xRayImages = xRayImages;
	}

	public Date getSortDate() {
		return sortDate;
	}

	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}

	public Boolean getForSale() {
		return forSale;
	}

	public void setForSale(Boolean forSale) {
		this.forSale = forSale;
	}

}
