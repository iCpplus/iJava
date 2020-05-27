package edu.zut.cs.software.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.doctor.dao.DoctorDao;
import edu.zut.cs.software.doctor.domain.Doctor;
import edu.zut.cs.software.doctor.service.DoctorManager;

/**
 * 
 * @author lucky刘小宇
 *
 */
@Service(value = "doctorManager")
public class DoctorManagerImpl extends GenericManagerImpl<Doctor, Long> implements DoctorManager {

	DoctorDao doctorDao;

	@Autowired
	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
		this.dao = doctorDao;
	}

}
