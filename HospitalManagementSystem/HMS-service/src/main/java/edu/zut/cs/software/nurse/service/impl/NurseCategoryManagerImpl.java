package edu.zut.cs.software.nurse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.nurse.dao.NurseCategoryDao;
import edu.zut.cs.software.nurse.domain.NurseCategory;
import edu.zut.cs.software.nurse.service.NurseCategoryManager;

/**
 * implement of NurseCategoryManager
 * 
 * @author Kou Shixiang
 */
@Service
public class NurseCategoryManagerImpl extends GenericTreeManagerImpl<NurseCategory, Long> implements NurseCategoryManager {

    NurseCategoryDao nurseCategoryDao;

    @Autowired
    public void setNurseCategoryDao(NurseCategoryDao nurseCategoryDao) {
        this.nurseCategoryDao = nurseCategoryDao;
        this.dao = this.nurseCategoryDao;
    }

}