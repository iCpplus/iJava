package edu.zut.cs.software.teach.impl;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.impl.GenericManagerImpl;
import edu.zut.cs.software.teach.domain.Student;
import edu.zut.cs.software.teach.service.StudentManager;

@Service("studentManager")
public class StudentManagerImpl extends GenericManagerImpl<Long, Student> implements StudentManager {

	@Override
	public String echo(String message) {
		String result = "hello," + message + "!";
		return result;
	}

	@Override
	public Student echo(Student student) {
		student.setName("Lucy");
		return student;
	}

}
