package edu.zut.cs.software.nurse.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.nurse.domain.Nurse;
import edu.zut.cs.software.nurse.service.NurseManager;

/**
 * 
 * 
 * @author Kou Shixiang
 */
@Controller
@RequestMapping("/nurse")
public class NurseController extends GenericController<Nurse, Long, NurseManager> {

	NurseManager nurseManager;

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/nurse/index";
		return result;
	}

	@Autowired
	public void setStudentManager(NurseManager nurseManager) {
		this.nurseManager = nurseManager;
		this.manager = this.nurseManager;
	}
}
