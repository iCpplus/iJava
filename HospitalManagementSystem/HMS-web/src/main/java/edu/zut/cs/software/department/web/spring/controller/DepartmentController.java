package edu.zut.cs.software.department.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.department.domain.Department;
import edu.zut.cs.software.department.service.DepartmentManager;

/**
 * 
 * @author fanyuxin
 *
 */

@Controller
@RequestMapping("/department")
public class DepartmentController extends GenericController<Department, Long, DepartmentManager> {

	DepartmentManager departmentManager;

	@Autowired
	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
		this.manager = this.departmentManager;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/department/index";
		return result;
	}
	
}
