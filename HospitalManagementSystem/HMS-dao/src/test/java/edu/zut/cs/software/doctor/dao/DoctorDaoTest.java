package edu.zut.cs.software.doctor.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.doctor.domain.Doctor;

/**
 * 
 * @author lucky刘小宇
 *
 */

public class DoctorDaoTest extends GenericDaoTestCase<Long, Doctor, DoctorDao> {

	DoctorDao doctorDao;

	@Autowired
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
		this.dao = doctorDao;
	}

	public DoctorDaoTest() {
		super(Doctor.class);
	}

}
