package edu.zut.cs.software.patient.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.patient.domain.Patient;
import edu.zut.cs.software.patient.service.PatientManager;

/**
 * patient controller
 * 
 * @author shishuqian
 *
 */

@Controller
@RequestMapping("/patient")
public class PatientController extends GenericController<Patient, Long, PatientManager> {

	PatientManager patientManager;

	@Autowired
	public void setPatientManager(PatientManager patientManager) {
		this.patientManager = patientManager;
		this.manager = this.patientManager;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result = "/patient/index";
		return result;
	}
	
}
