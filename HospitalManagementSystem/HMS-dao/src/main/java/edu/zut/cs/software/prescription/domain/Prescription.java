package edu.zut.cs.software.prescription.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * entity class for Prescription
 * 
 * @author FC
 */

@Entity
@Table(name="T_PRESCRIPTION")
public class Prescription extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2920888717811068184L;
	@Column
	String drugName;
	/**
	 * Many Prescription objects relate to one category of Prescription.
	 */
	@ManyToOne
	@JoinColumn(name = "PRESCRIPTION_CATEGORY_ID")
	PrescriptionCategory prescriptionCategory;
	
	public void setPrescriptionCategory(PrescriptionCategory prescriptionCategory) {
		this.prescriptionCategory = prescriptionCategory;
	}
	
	public PrescriptionCategory getPrescriptionCategory() {
		return prescriptionCategory;
	}


	public String getDrugName() {
		return drugName;
	}
	
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	

}
