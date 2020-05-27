package edu.zut.cs.software.patient.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.patient.domain.PatientCategory;

/**
 * test for PatientCategory
 * 
 * @author shishuqian
 *
 */
public class PatientCategoryDaoTest extends GenericTreeDaoTestCase<Long, PatientCategory, PatientCategoryDao> {

	PatientCategoryDao patientCategoryDao;
	
	@Autowired
	public void setPatientCategoryDao(PatientCategoryDao patientCategoryDao) {
		this.patientCategoryDao = patientCategoryDao;
		this.dao = patientCategoryDao;
	}

	public PatientCategoryDaoTest() {
		super(PatientCategory.class);
	}

	
	
}
