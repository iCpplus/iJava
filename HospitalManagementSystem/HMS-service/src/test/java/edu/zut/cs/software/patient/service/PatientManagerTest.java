package edu.zut.cs.software.patient.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.patient.domain.Patient;
import edu.zut.cs.software.patient.domain.PatientCategory;

/**
 * test for patient manager
 * 
 * @author shishuqian
 *
 */
public class PatientManagerTest extends GenericManagerTestCase<Long, Patient, PatientManager> {

	PatientManager patientManager;

	PatientCategoryManager PatientCategoryManager;
	
	@Autowired
	public void setPatientCategoryManager(PatientCategoryManager patientCategoryManager) {
		PatientCategoryManager = patientCategoryManager;
	}

	@Autowired
	public void setPatientManager(PatientManager patientManager) {
		this.patientManager = patientManager;
		this.manager = patientManager;
	}

	public PatientManagerTest() {
		super(Patient.class);
	}
	
	@Test
	public void testBuild(){
		int num_category = 3;
		int num_patient = 3;
		for (int i = 0; i < num_category; i++) {
			PatientCategory category = new PatientCategory();  // super categories
			category.setName("category_" + i);
			category = this.PatientCategoryManager.save(category);  //保存category
			for (int j = 0; j < num_category; j++) {
				PatientCategory category2 = new PatientCategory();  // current categories
				category2.setName("category_" + i + "_" + j);
				category2.setParent(category);     // set current category's parent category
				category2 = this.PatientCategoryManager.save(category2);   //保存category2
				for (int k = 0; k < num_patient; k++) {
					Patient patient = new Patient();  //patient
					patient.setName("name_" + i + "_" + j + "_" + k);
					patient.setPatientCategory(category2);   // set patient's category
					patient = this.patientManager.save(patient);    //保存patient
				}
				
			}
		}
	}

}
