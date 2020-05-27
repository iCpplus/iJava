package edu.zut.cs.software.prescription.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.prescription.domain.Prescription;
import edu.zut.cs.software.prescription.domain.PrescriptionCategory;

public class PrescriptionManagerTest extends GenericManagerTestCase<Long, Prescription, PrescriptionManager> {


	PrescriptionManager prescriptionManager;
	
	PrescriptionCategoryManager prescriptionCategoryManager;
	
	public PrescriptionManagerTest() {
		super(Prescription.class);
	}
	@Autowired
	public void setPrescriptionCategoryManager(PrescriptionCategoryManager prescriptionCategoryManager) {
		this.prescriptionCategoryManager = prescriptionCategoryManager;
	}

	
	@Autowired
	public void setPrescriptionManager(PrescriptionManager prescriptionManager) {
		this.prescriptionManager = prescriptionManager;
		this.manager = prescriptionManager;

	}
	@Test
	public void testBuild(){
		int num_category=2;
		int num_prescription=2;
		for(int i=0;i<num_category;i++) {
			PrescriptionCategory category=new PrescriptionCategory();
			category.setName("category_"+i);
			category=this.prescriptionCategoryManager.save(category);
			for(int j=0;j<num_category;j++) {
				PrescriptionCategory category2=new PrescriptionCategory();
				category2.setName("category_"+i+"_"+j);
				category2=this.prescriptionCategoryManager.save(category2);
				for(int k=0;k<num_prescription;k++) {
					Prescription prescription=new Prescription();
					prescription.setDrugName("name_"+i+"_"+j+"_"+k);
					prescription.setPrescriptionCategory(category2);
					prescription=this.prescriptionManager.save(prescription);
				}
			}
		}
	}

}
