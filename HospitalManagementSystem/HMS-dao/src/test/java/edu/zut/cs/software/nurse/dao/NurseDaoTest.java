package edu.zut.cs.software.nurse.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.nurse.domain.Nurse;

/**
 * test for NurseDao
 * 
 * @author Kou Shixiang
 */
public class NurseDaoTest extends GenericDaoTestCase<Long, Nurse, NurseDao> {

	NurseDao nurseDao;

	@Autowired
	public void setNurseDao(NurseDao nurseDao) {
		this.nurseDao = nurseDao;
		this.dao = nurseDao;
	}

	public NurseDaoTest() {
		super(Nurse.class);

	}

}
