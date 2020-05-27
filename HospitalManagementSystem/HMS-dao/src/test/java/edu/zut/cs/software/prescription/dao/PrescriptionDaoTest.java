package edu.zut.cs.software.prescription.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.prescription.domain.Prescription;

/**
 * test for Prescription
 * 
 * @author FC
 *
 */
public class PrescriptionDaoTest extends GenericDaoTestCase<Long, Prescription, PrescriptionDao> {

	PrescriptionDao prescriptionDao;

	@Autowired
	public void setPrescriptionDao(PrescriptionDao prescriptionDao) {
		this.prescriptionDao = prescriptionDao;
		this.dao = prescriptionDao;
	}

	public PrescriptionDaoTest() {
		super(Prescription.class);
	}

}
