package edu.zut.cs.software.department.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.department.domain.Department;

public class DepartmentDaoTest extends GenericDaoTestCase<Long, Department, DepartmentDao> {

	DepartmentDao departmentDao;

	public DepartmentDaoTest() {
		super(Department.class);
	}

	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
		this.dao = departmentDao;
	}

}
