package edu.zut.cs.software.doctor.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.doctor.dao.DoctorCategoryDao;
import edu.zut.cs.software.doctor.domain.DoctorCategory;
/**
 * 
 * @author lucky刘小宇
 *
 */
public class DoctorCategoryTest extends GenericTreeDaoTestCase<Long, DoctorCategory, DoctorCategoryDao> {

	DoctorCategoryDao doctorCategoryDao;

	@Autowired
	public void setDoctorCategoryDao(DoctorCategoryDao doctorCategoryDao) {
		this.doctorCategoryDao = doctorCategoryDao;
		this.dao = this.doctorCategoryDao;
	}

	public DoctorCategoryTest() {
		super(DoctorCategory.class);
	}

}
