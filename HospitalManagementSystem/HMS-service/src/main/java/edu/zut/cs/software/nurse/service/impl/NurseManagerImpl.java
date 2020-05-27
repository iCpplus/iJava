package edu.zut.cs.software.nurse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.nurse.dao.NurseDao;
import edu.zut.cs.software.nurse.domain.Nurse;
import edu.zut.cs.software.nurse.service.NurseManager;

/**
 * implement of NurseManager
 * 
 * @author Kou Shixiang
 */
@Service
public class NurseManagerImpl extends GenericManagerImpl<Nurse, Long> implements NurseManager {

	NurseDao nurseDao;

	@Autowired
	public void setNurseDao(NurseDao nurseDao) {
		this.nurseDao = nurseDao;
		this.dao = nurseDao;
	}

}
