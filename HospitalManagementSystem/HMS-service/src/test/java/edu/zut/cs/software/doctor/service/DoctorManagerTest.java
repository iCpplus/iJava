package edu.zut.cs.software.doctor.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.doctor.domain.Doctor;
import edu.zut.cs.software.doctor.domain.DoctorCategory;
/**
 * 
 * @author lucky刘小宇
 *
 */
public class DoctorManagerTest extends GenericManagerTestCase<Long, Doctor, DoctorManager> {

	DoctorManager doctorManager;
	DoctorCategoryManager doctorCategoryManager;
	

	public DoctorManagerTest() {
		super(Doctor.class);

	}
	
	@Autowired
	public void setDoctorCategoryManager(DoctorCategoryManager doctorCategoryManager) {
		this.doctorCategoryManager = doctorCategoryManager;
	}
	
	@Autowired
	public void setDoctorManager(DoctorManager doctorManager) {
		this.doctorManager = doctorManager;
		this.manager = doctorManager;
	}
	
	@Test
	public void testBuild() {
		int num_category=3;
		int num_doctor=3;
		for (int i=0;i<num_category;i++) {
			DoctorCategory category=new DoctorCategory();
			category.setStept("category_"+i);
			category=this.doctorCategoryManager.save(category);
			for (int j=0;j<num_category;j++) {
				DoctorCategory c=new DoctorCategory();
				c.setStept("category_"+i+"_"+j);
				c.setParent(category);
				c=this.doctorCategoryManager.save(c);
				for(int k=0;k<num_doctor;k++) {
					Doctor doctor=new Doctor();
					doctor.setName("name_"+i+"_"+j+"_"+k);
					doctor.setDoctorCategory(c);
					doctor=this.doctorManager.save(doctor);
				}
			}
		}
		
	}
	

}
