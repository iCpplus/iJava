package edu.zut.software.teach.student;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import edu.zut.cs.software.teach.Domain.Student;
import edu.zut.cs.software.teach.service.StudentManager;

@ContextConfiguration(locations = { "classpath:/applicationContext-service.xml" })

public class StuentManagerTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StuentManagerTest.class.getName());

//	StudentManager studentManager = new StudentManagerImpl();

	StudentManager studentManager;

	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	@Test
	public void testEcho() {

		System.out.println("helloworld");
		String message = "world";
		String expected = "hello," + message + "!";
		String result = this.studentManager.echo(message);

		if (logger.isInfoEnabled()) {
			logger.info("testEcho() - String expected={}", expected); //$NON-NLS-1$
		}

		if (logger.isInfoEnabled()) {
			logger.info("testEcho() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);

	}

	@Test
	public void testEchoStudent() {

		Student expected = new Student();
		expected.setName("Lucy");
		Student result = new Student();
		result = this.studentManager.echo(result);

		if (logger.isInfoEnabled()) {
			logger.info("testEchoStudent() - Student expected={}", expected); //$NON-NLS-1$
		}

		if (logger.isInfoEnabled()) {
			logger.info("testEchoStudent() - Student result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);

	}

}
