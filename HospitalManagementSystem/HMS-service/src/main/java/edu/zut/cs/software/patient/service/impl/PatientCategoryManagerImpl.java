package edu.zut.cs.software.patient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.patient.dao.PatientCategoryDao;
import edu.zut.cs.software.patient.domain.PatientCategory;
import edu.zut.cs.software.patient.service.PatientCategoryManager;

/**
 * 
 * @author shishuqian
 *
 */
@Service(value = "pratientCategoryManager")
public class PatientCategoryManagerImpl extends GenericTreeManagerImpl<PatientCategory, Long>
		implements PatientCategoryManager {

	PatientCategoryDao patientCategoryDao;

	@Autowired
	public void setPatientCategoryDao(PatientCategoryDao patientCategoryDao) {
		this.patientCategoryDao = patientCategoryDao;
		this.dao = patientCategoryDao;
	}
	
	
}
