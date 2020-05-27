package edu.zut.cs.software.patient.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

/**
 * entity class for patient category
 * 
 * @author shishuqian
 *
 */
@Entity
@Table(name = "T_PATIENT_CATEGORY")
@NamedQueries({ @NamedQuery(name = "PatientCategory.getRoot", query = "select m from PatientCategory m where m.parent is null") })
public class PatientCategory extends BaseTreeEntity<PatientCategory, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7117209643057766056L;

	/**
	 * code of patient category
	 */
	@Column
	private String code;
	
	/**
	 * name of patient category
	 */
	@Column
	private String name;
	
	/**
	 * gender of patient category
	 */
	@Column
	private String gender;

	/**
	 * one category of patient relate to Many patients objects
	 */
	@OneToMany(mappedBy = "patientCategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<Patient> patients;
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
