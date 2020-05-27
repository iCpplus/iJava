package edu.zut.cs.software.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.department.dao.DepartmentDao;
import edu.zut.cs.software.department.domain.Department;
import edu.zut.cs.software.department.service.DepartmentManager;

/**
 * 
 * @author fanyuxin
 *
 */
@Service(value = "departmentManager")

public class DepartmentManagerImpl extends GenericManagerImpl<Department, Long> implements DepartmentManager {

	DepartmentDao departmentDao;

	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
		this.dao = departmentDao;
	}
	
	

}
