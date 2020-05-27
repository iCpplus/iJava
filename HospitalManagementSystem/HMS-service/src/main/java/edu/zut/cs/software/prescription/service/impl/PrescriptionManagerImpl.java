package edu.zut.cs.software.prescription.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.prescription.dao.PrescriptionDao;
import edu.zut.cs.software.prescription.domain.Prescription;
import edu.zut.cs.software.prescription.service.PrescriptionManager;

@Service
public class PrescriptionManagerImpl extends GenericManagerImpl<Prescription, Long> implements PrescriptionManager {

	PrescriptionDao prescriptionDao;

	@Autowired
	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
		this.dao = prescriptionDao;
	}
	
	
}
