package edu.zut.cs.software.department.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * 
 * @author fanyuxin
 *
 */
@Entity
@Table(name = "T_Department")
public class Department extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 247190830154008049L;
	
	/**
	 * 
	 * department category
	 *
	 */
	@Column
	private String category;
	
	/**
	 * 
	 * department's name
	 *
	 */
	@Column
	private String name;
	
	@Column
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_CATEGORY_ID")
	DepartmentCategory departmentCategory;

	

	public DepartmentCategory getDepartmentCategory() {
		return departmentCategory;
	}

	public void setDepartmentCategory(DepartmentCategory departmentCategory) {
		this.departmentCategory = departmentCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
