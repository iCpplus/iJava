package edu.zut.software.teach.student;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.teach.Domain.Student;
import edu.zut.cs.software.teach.service.StudentManager;

@ContextConfiguration(locations = { "classpath:/applicationContext-service.xml" })

/**
 * 
 * test for StudentManager.
 * 
 * @author KouShiXiang
 *
 */

public class StudentManagerTest extends AbstractJUnit4SpringContextTests {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentManagerTest.class.getName());

//	StudentManager studentManager = new StudentManagerImpl();
//	use Spring Bean
	
	StudentManager studentManager;

	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	@Test
	public void testEcho() {

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
