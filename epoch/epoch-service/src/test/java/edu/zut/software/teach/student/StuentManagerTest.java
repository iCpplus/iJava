package edu.zut.software.teach.student;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.zut.cs.software.teach.Domain.Student;
import edu.zut.cs.software.teach.impl.StudentManagerImpl;
import edu.zut.cs.software.teach.service.StudentManager;

public class StuentManagerTest {

	StudentManager studentmanager = new StudentManagerImpl();

	@Test
	public void testEcho() {

		String message = "world";
		String expected = "hello," + message + "!";
		String result = this.studentmanager.echo(message);
		assertEquals(expected, result);

	}

	@Test
	public void testEchoStudent() {

		Student expected = new Student();
		expected.setName("Lucy");
		Student result = new Student();
		result = this.studentmanager.echo(result);
		assertEquals(expected, result);

	}

}
