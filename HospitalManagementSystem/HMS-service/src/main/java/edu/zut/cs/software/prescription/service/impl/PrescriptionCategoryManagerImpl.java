package edu.zut.cs.software.prescription.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.prescription.dao.PrescriptionCategoryDao;
import edu.zut.cs.software.prescription.domain.PrescriptionCategory;
import edu.zut.cs.software.prescription.service.PrescriptionCategoryManager;
/**
 * 
 * @author FC
 *
 */
@Service
public class PrescriptionCategoryManagerImpl extends GenericTreeManagerImpl<PrescriptionCategory,Long>implements PrescriptionCategoryManager{

	PrescriptionCategoryDao prescriptionCategoryDao;

	@Autowired
	public void setPrescriptionCategoryDao(PrescriptionCategoryDao prescriptionCategoryDao) {
		this.prescriptionCategoryDao = prescriptionCategoryDao;
		this.dao=prescriptionCategoryDao;
	}
	
}
