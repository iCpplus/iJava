package edu.zut.cs.software.prescription.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

/**
 * entity class for Precription category
 * 
 * @author FC
 *
 */
@Entity
@Table(name="T_Prescription_Category")
@NamedQueries({ @NamedQuery(name = "PrescriptionCategory.getRoot", query = "select m from PrescriptionCategory m where m.parent is null") })
public class PrescriptionCategory extends BaseTreeEntity<PrescriptionCategory, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6107480231276422894L;
	
	/**
	 * name of Precription Category
	 */
	@Column
	String name;
	
	/**
	 * code of Precription Category
	 */
	@Column
	String code;
	
	/**
	 * one category of Prescription relate to Many Prescription objects
	 */
	@OneToMany(mappedBy = "prescriptionCategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<Prescription> prescription;

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

	

}
