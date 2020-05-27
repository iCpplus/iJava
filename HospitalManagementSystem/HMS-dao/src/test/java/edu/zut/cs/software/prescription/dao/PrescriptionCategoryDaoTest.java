package edu.zut.cs.software.prescription.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.prescription.domain.PrescriptionCategory;

/**
 * test for PrescriptionCategory
 * 
 * @author FC
 *
 */
public class PrescriptionCategoryDaoTest
		extends GenericTreeDaoTestCase<Long, PrescriptionCategory, PrescriptionCategoryDao> {

	PrescriptionCategoryDao prescriptionCategoryDao;
	


	@Autowired
	public void setPrescriptionCategoryDao(PrescriptionCategoryDao prescriptionCategoryDao) {
		this.prescriptionCategoryDao = prescriptionCategoryDao;
		this.dao=prescriptionCategoryDao;
	}



	public PrescriptionCategoryDaoTest() {
		super(PrescriptionCategory.class);
		
	}

}
