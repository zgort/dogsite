package com.rum.modules.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
public class Litters {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Dog father;
	private Dog mother;
	@Lob
	private String desc;
	private Set<File> childes = new HashSet<>();
	private Date sortDate;
	private Date birthDate;
	private Boolean publish;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dog getFather() {
		return father;
	}

	public void setFather(Dog father) {
		this.father = father;
	}

	public Dog getMother() {
		return mother;
	}

	public void setMother(Dog mother) {
		this.mother = mother;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<File> getChildes() {
		return childes;
	}

	public void setChildes(Set<File> childes) {
		this.childes = childes;
	}

	public Date getSortDate() {
		return sortDate;
	}

	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getPublish() {
		return publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

}
