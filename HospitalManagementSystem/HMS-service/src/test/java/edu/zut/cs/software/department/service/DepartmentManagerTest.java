package edu.zut.cs.software.department.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.department.domain.Department;
import edu.zut.cs.software.department.domain.DepartmentCategory;

/**
 * 
 * @author fanyuxin
 *
 */

public class DepartmentManagerTest extends GenericManagerTestCase<Long, Department, DepartmentManager> {

	DepartmentManager departmentManager;
	
	DepartmentCategoryManager DepartmentCategoryManager;
	
	public DepartmentManagerTest() {
		super(Department.class);
		
	}

	@Autowired
	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
		this.manager = departmentManager;
	}
	
	@Autowired
	public void setDepartmentCategoryManager(DepartmentCategoryManager departmentCategoryManager) {
		DepartmentCategoryManager = departmentCategoryManager;
	}

	@Test
	public void testBuild(){
		int num_category = 3;
		int num_department = 3;
		for (int i=0;i<num_category;i++) {
			DepartmentCategory category=new DepartmentCategory();
			category.setLeaderCode("category_"+i);
			category=this.DepartmentCategoryManager.save(category);
			for (int j=0;j<num_category;j++) {
				DepartmentCategory c=new DepartmentCategory();
				c.setLeaderCode("category_"+i+"_"+j);
				c.setParent(category);
				c=this.DepartmentCategoryManager.save(c);
				for(int k=0;k<num_department;k++) {
					Department department=new Department();
					department.setName("name_"+i+"_"+j+"_"+k);
					department.setDepartmentCategory(c);
					department=this.departmentManager.save(department);
				}
			}
		}
	}
	
}

