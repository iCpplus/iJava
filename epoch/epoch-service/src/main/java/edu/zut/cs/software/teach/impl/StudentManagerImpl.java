package edu.zut.cs.software.teach.impl;

import edu.zut.cs.software.teach.Domain.Student;
import edu.zut.cs.software.teach.service.StudentManager;

public class StudentManagerImpl implements StudentManager {
	
	
	@Override
	public String echo(String message) {
		String result = "hello" + message + "!";
		return result;
	}

	
	@Override
	public Student echo(Student student) {
		student.setName("Lucy");
		return student;
	}
}
