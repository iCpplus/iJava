package edu.zut.cs.software.doctor.domain;

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
 * entity class for doctor category
 * 
 * @author lucky刘小宇
 *
 */

@Entity
@Table(name = "T_DOCTOR_CATEGORY")
@NamedQueries({
		@NamedQuery(name = "DoctorCategory.getRoot", query = "select m from DoctorCategory m where m.parent is null") })
public class DoctorCategory extends BaseTreeEntity<DoctorCategory, Long> {

	private static final long serialVersionUID = 5662751680417561916L;
	/**
	 * doctor's department
	 */
	@Column
	String Stept;
	/**
	 * one department relate to many doctors
	 */
	@OneToMany(mappedBy = "doctorCategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<Doctor> doctors;

	public String getStept() {
		return Stept;
	}

	public void setStept(String stept) {
		Stept = stept;
	}

}
