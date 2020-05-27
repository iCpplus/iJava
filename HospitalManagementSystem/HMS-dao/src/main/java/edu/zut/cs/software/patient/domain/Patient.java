package edu.zut.cs.software.patient.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;


/**
 * entity class for patient
 * 
 * @author shishuqian
 */

@Entity
@Table(name = "T_PATIENT")
public class Patient extends BaseEntity<Long> {

	/**
	 * 
	 */

	private static final long serialVersionUID = -8856817762351917958L;

	/**
	 * name of patient
	 */
	@Column
	private String name;

	/**
	 * age of patient
	 */
	@Column
	private String age;

	/**
	 * gender of patient
	 */
	@Column
	private Gender gender;

	/**
	 * code of patient
	 */
	@Column
	private String code;
	
	/**
	 * symptom of patient
	 */
	@Column
	private String symptom;

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	/**
	 * Many patient objects relate to one category of patient.
	 */
	@ManyToOne
	@JoinColumn(name = "PATIENT_CATEGORY_ID")
	PatientCategory patientCategory;

	public PatientCategory getPatientCategory() {
		return patientCategory;
	}

	public void setPatientCategory(PatientCategory patientCategory) {
		this.patientCategory = patientCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
