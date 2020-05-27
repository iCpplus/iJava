package edu.zut.cs.software.doctor.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.doctor.domain.Doctor;
import edu.zut.cs.software.doctor.service.DoctorManager;

/**
 * 
 * @author lucky刘小宇
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController extends GenericController<Doctor, Long, DoctorManager> {
	DoctorManager doctorManager;

	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/doctor/index";
		return result;
	}

	@Autowired
	public void setDoctorManager(DoctorManager doctorManager) {
		this.doctorManager = doctorManager;
		this.manager = this.doctorManager;
	}

}
