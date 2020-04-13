package edu.zut.cs.software.teach.service;

import edu.zut.cs.software.teach.domain.Student;
import edu.zut.software.base.service.GenericManager;

public interface StudentManager extends GenericManager<Long, Student> {

	/**
	 * 
	 * @param the input message
	 * @return the response message
	 */
	String echo(String message);

	/**
	 * 
	 * @param the input student
	 * @return the response student
	 */
	Student echo(Student student);
}
