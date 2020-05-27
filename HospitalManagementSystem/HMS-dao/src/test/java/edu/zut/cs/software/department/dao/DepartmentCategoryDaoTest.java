package edu.zut.cs.software.department.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.department.domain.DepartmentCategory;

public class DepartmentCategoryDaoTest extends GenericDaoTestCase<Long, DepartmentCategory, DepartmentCategoryDao> {

	DepartmentCategoryDao departmentCategoryDao;

	public DepartmentCategoryDaoTest() {
		super(DepartmentCategory.class);
	}

	@Autowired
	public void setDepartmentCategoryDao(DepartmentCategoryDao departmentCategoryDao) {
		this.departmentCategoryDao = departmentCategoryDao;
		this.dao = departmentCategoryDao;
	}

}