package edu.zut.cs.software.nurse.domain;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * entity class for nurse
 * 
 * @author Kou Shixiang
 */
@Entity
@Table(name = "T_NURSE")
public class Nurse extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5179856690890955052L;

	/**
	 * name of nurse
	 */
	@Column
	private String name;

	/**
	 * code of code
	 */
	@Column
	private String code;

	/**
	 * gender of code
	 */
	@Column
	private String gender;

	/**
	 * field of nurse
	 */
	@Column
	private String field;

	/**
	 * Many nurse objects relate to one category of nurse
	 */
	@ManyToOne
	@JoinColumn(name = "NURSE_CATEGORY_ID")
	NurseCategory nurseCategory;

	public void setNurseCategory(NurseCategory nurseCategory) {
		this.nurseCategory = nurseCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
