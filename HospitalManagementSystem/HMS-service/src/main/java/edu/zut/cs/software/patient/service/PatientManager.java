package edu.zut.cs.software.patient.service;

/**
 * 
 * @author shishuqian
 * 
 */
import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.patient.domain.Patient;

public interface PatientManager extends GenericManager<Patient, Long> {
	
	/**
	 * 
	 * @param the input patient
	 * @return the response patient
	 */
	Patient echo(Patient patient);


}
