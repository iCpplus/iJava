package edu.zut.cs.software.nurse.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.nurse.domain.Nurse;
import edu.zut.cs.software.nurse.domain.NurseCategory;

/**
 * test for NurseManager.
 * 
 * @author Kou Shixiang
 * 
 */
public class NurseManagerTest extends GenericManagerTestCase<Long, Nurse, NurseManager> {

	NurseManager nurseManager;
	NurseCategoryManager nurseCategoryManager;

	@Autowired
	public void setNurseCategoryManager(NurseCategoryManager nurseCategoryManager) {
		this.nurseCategoryManager = nurseCategoryManager;
	}

	@Autowired
	public void setNurseManager(NurseManager nurseManager) {
		this.nurseManager = nurseManager;
		this.manager = this.nurseManager;
	}

	public NurseManagerTest() {
		super(Nurse.class);
	}

	@Test
	public void testBuild() {
		int num_category = 3;
		int num_nurse = 3;
		for (int i = 0; i < num_category; i++) {
			NurseCategory category = new NurseCategory();
			category.setName("category_" + i);
			category = this.nurseCategoryManager.save(category);
			for (int j = 0; j < num_category; j++) {
				NurseCategory c = new NurseCategory();
				c.setName("category_" + i + "_" + j);
				c.setParent(category);
				c = this.nurseCategoryManager.save(c);
				for (int k = 0; k < num_nurse; k++) {
					Nurse nurse = new Nurse();
					nurse.setName("name_" + i + "_" + j + "_" + k);
					nurse.setNurseCategory(c);
					nurse = this.nurseManager.save(nurse);
				}
			}
		}
	}
}
