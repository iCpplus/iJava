package edu.zut.cs.software.department.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.department.dao.DepartmentCategoryDao;
import edu.zut.cs.software.department.domain.DepartmentCategory;
import edu.zut.cs.software.department.service.DepartmentCategoryManager;

/**
 * 
 * @author fanyuxin
 *
 */

@Service(value = "departmentCategoryManager")
public class DepartmentCategoryManagerImpl extends GenericTreeManagerImpl<DepartmentCategory, Long>
implements DepartmentCategoryManager {

	DepartmentCategoryDao departmentCategoryDao;

@Autowired
public void setDepartmentCategoryDao(DepartmentCategoryDao departmentCategoryDao) {
this.departmentCategoryDao = departmentCategoryDao;
this.dao = departmentCategoryDao;
}


}