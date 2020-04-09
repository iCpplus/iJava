package edu.zut.cs.software.teach.service;

import edu.zut.cs.software.teach.Domain.Student;

public interface StudentManager {
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
