package edu.zut.cs.software.patient.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.patient.domain.Patient;

/**
 * test for PatientDao
 * 
 * @author shishuqian
 *
 */
public class PatientDaoTest extends GenericDaoTestCase<Long, Patient, PatientDao> {

	PatientDao patientDao;

	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
		this.dao = patientDao;
	}

	public PatientDaoTest() {
		super(Patient.class);
	}

}
