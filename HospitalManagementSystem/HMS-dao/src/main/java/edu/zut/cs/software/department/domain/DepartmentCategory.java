package edu.zut.cs.software.department.domain;

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

@Entity
@Table(name = "T_DEPARTMENT_CATEGORY")
@NamedQueries({
		@NamedQuery(name = "DepartmentCategory.getRoot", query = "select m from DepartmentCategory m where m.parent is null") })
public class DepartmentCategory extends BaseTreeEntity<DepartmentCategory, Long> {

	private static final long serialVersionUID = 5662751680417561916L;
	/**
	 * leader's code for department 
	 */
	@Column
	String leaderCode;
	/**
	 * one leader is responsible for departments
	 */
	@OneToMany(mappedBy = "departmentCategory", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	List<Department> department;
	
	public String getLeaderCode() {
		return leaderCode;
	}
	public void setLeaderCode(String leaderCode) {
		this.leaderCode = leaderCode;
	}
	

	

}
