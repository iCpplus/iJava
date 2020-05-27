package edu.zut.cs.software.doctor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * entity class for doctor
 * 
 * @author lucky刘小宇
 *
 */
@Entity
@Table(name = "T_DOCTOR")
public class Doctor extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4714585375269004257L;
	/**
	 * name for doctor
	 */
	@Column
	private String name;
	/**
	 * code for doctor
	 */
	@Column
	private String code;
	/**
	 * age for doctor
	 */
	@Column
	String age;
	/**
	 * sex for doctor
	 */
	@Column
	private String sex;
	/**
	 * doctor 's title
	 */
	@Column
	private String professionalTitle;
	/**
	 * many the same profession doctor relate to one doctorcategory
	 */
	@ManyToOne
	@JoinColumn(name = "DOCTOR_CATEGORY_ID")

	DoctorCategory doctorCategory;

	public DoctorCategory getDoctorCategory() {
		return doctorCategory;
	}

	public void setDoctorCategory(DoctorCategory doctorCategory) {
		this.doctorCategory = doctorCategory;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProfessionalTitle() {
		return professionalTitle;
	}

	public void setProfessionalTitle(String professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

}
