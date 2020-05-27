package edu.zut.cs.software.nurse.dao;

import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.nurse.domain.NurseCategory;

/**
 * test for NurseCategoryDao
 * 
 * @author Kou Shixiang
 */
public class NurseCategoryDaoTest extends GenericTreeDaoTestCase<Long, NurseCategory, NurseCategoryDao> {

    NurseCategoryDao nurseCategoryDao;

    @Autowired
    public void setNurseCategoryDao(NurseCategoryDao nurseCategoryDao) {
        this.nurseCategoryDao = nurseCategoryDao;
        this.dao = this.nurseCategoryDao;
    }

    public NurseCategoryDaoTest() {
        super(NurseCategory.class);
    }

}