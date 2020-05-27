package edu.zut.cs.software.nurse.domain;

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
 * entity class for nurse category
 * 
 * @author Kou Shixiang
 */
@Entity
@Table(name = "T_NURSE_CATEGORY")
@NamedQueries({@NamedQuery(name = "NurseCategory.getRoot", query = "select m from NurseCategory m where m.parent is null") })
public class NurseCategory extends BaseTreeEntity<NurseCategory, Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = -6265471933426103464L;

	/**
	 * name of nurse category
	 */
	@Column
	private String name;

	/**
	 * code of nurse category
	 */
	@Column
	private String code;

	/**
	 * gender of nurse category
	 */
	@Column
	private String gender;

	/**
	 * field of nurse category
	 */
	@Column
	private String field;

	@OneToMany(mappedBy = "nurseCategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<Nurse> nurses;

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