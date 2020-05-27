package edu.zut.cs.software.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.patient.dao.PatientDao;
import edu.zut.cs.software.patient.domain.Gender;
import edu.zut.cs.software.patient.domain.Patient;
import edu.zut.cs.software.patient.service.PatientManager;

/**
 * 
 * @author shishuqian
 *
 */
@Service(value = "patientManager")
public class PatientManagerImpl extends GenericManagerImpl<Patient, Long> implements PatientManager {

	PatientDao patientDao;

	@Autowired
	public void setPatientDao(PatientDao patientDao) {
		this.patientDao = patientDao;
		this.dao = patientDao;
	}

	@Override
	public Patient echo(Patient patient) {
		
		patient.setName("shishuqian");
		patient.setAge("18");
		patient.setCode("201803074314");
		patient.setGender(Gender.Male);
		patient.setSymptom("发烧");
		return patient;
	}
	
	
	
	
}
