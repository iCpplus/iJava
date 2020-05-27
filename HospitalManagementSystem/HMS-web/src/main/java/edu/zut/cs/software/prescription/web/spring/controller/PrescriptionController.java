package edu.zut.cs.software.prescription.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.zut.cs.software.base.web.spring.controller.GenericController;
import edu.zut.cs.software.prescription.domain.Prescription;
import edu.zut.cs.software.prescription.service.PrescriptionManager;

/**
 * 
 * Prescription Controller
 * @author FC
 *
 */
@Controller
@RequestMapping("/prescription")
public class PrescriptionController extends GenericController<Prescription, Long, PrescriptionManager>{

	PrescriptionManager prescriptionManager;

	@Autowired
	public void setPrescriptionManager(PrescriptionManager prescriptionManager) {
		this.prescriptionManager = prescriptionManager;
		this.manager=this.prescriptionManager;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/index.html")
	public String index() {
		String result="/prescription/index";
		return result;
		
	}
}
