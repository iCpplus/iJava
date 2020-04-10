package edu.zut.cs.software.teach.Domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import edu.zut.software.base.domain.BaseEntity;


public class Student extends BaseEntity<Long>{
	/**
	 * code of this student
	 */
	String code;

	/**
	 * name of this student
	 */
	String name;

	/**
	 * address of this student
	 */
	String address;

	/**
	 * gender of this student
	 */
	String gender;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
