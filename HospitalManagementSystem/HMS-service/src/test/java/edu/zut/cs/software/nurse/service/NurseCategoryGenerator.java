package edu.zut.cs.software.nurse.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.nurse.domain.NurseCategory;

/**
 * generator for NurseCategory.
 * 
 * @author Kou Shixiang
 * 
 */

public class NurseCategoryGenerator extends GenericGenerator {
    @Autowired
    NurseCategoryManager nurseCategoryManager;

    @Test
    public void testGeneration() {
        for (int i = 0; i < 10; i++) {
            NurseCategory d = new NurseCategory();
            d.setName("nurseCategory_" + i);
            this.nurseCategoryManager.save(d);
            List<NurseCategory> list = new ArrayList<NurseCategory>();
            for (int j = 0; j < 10; j++) {
                NurseCategory nurseCategory = new NurseCategory();
                nurseCategory.setName("nurseCategory_" + i + "_" + j);
                nurseCategory.setParent(d);
                list.add(nurseCategory);
            }
            this.nurseCategoryManager.save(list);
        }
    }

}