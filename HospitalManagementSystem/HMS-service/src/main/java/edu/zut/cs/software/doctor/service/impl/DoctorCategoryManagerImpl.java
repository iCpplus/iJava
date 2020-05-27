package edu.zut.cs.software.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.doctor.dao.DoctorCategoryDao;
import edu.zut.cs.software.doctor.domain.DoctorCategory;
import edu.zut.cs.software.doctor.service.DoctorCategoryManager;

/**
 * 
 * @author lucky刘小宇
 *
 */
@Service(value = "doctorCategoryManager")
public class DoctorCategoryManagerImpl extends GenericTreeManagerImpl<DoctorCategory, Long>
		implements DoctorCategoryManager {
	DoctorCategoryDao doctorCategoryDao;

	@Autowired
	public void setDoctorCategoryDao(DoctorCategoryDao doctorCategoryDao) {
		this.doctorCategoryDao = doctorCategoryDao;
		this.dao = this.doctorCategoryDao;
	}

}
