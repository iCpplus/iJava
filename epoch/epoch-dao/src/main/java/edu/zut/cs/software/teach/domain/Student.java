package edu.zut.cs.software.teach.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * 
 * @author KouShiXiang
 *
 */

@Table(name = "T_Student")
@Entity
public class Student extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3067406775979333926L;

	/**
	 * code of this student
	 */
	@Column
	String code;

	/**
	 * name of this student
	 */
	@Column
	String name;

	/**
	 * address of this student
	 */
	@Column
	String address;

	/**
	 * gender of this student
	 */
	@Column
	String gender;

	/**
	 * grade of this student
	 */
	@Column
	String grade;

	/**
	 * major of this student
	 */
	@Column
	String major;

	/**
	 * schoolClass of this student
	 */
	@Column
	String schoolClass;

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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
