package edu.zut.cs.software;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.teach.dao.StudentDao;
import edu.zut.cs.software.teach.domain.Student;

public class StudentDaoTest extends GenericDaoTestCase<Long, Student, StudentDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentDaoTest.class.getName());


	StudentDao studentDao;

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
		this.dao = studentDao;
	}

	@Test
	public void testConect() {
		this.studentDao.deleteAll();
		int num = 10;
		int id = 5;
		Student expected = null;
		for (int i = 1; i <= num; i++) {
			Student student = new Student();
			student.setId(Long.valueOf(i));
			student.setName("studentName_" + i);
			student.setAddress("stduentAddress_" + i);
			if (i == id) {
				expected = student;
			}
			this.studentDao.save(student);
		}

		Iterable<Student> result = this.studentDao.findAll();

		if (logger.isInfoEnabled()) {
			logger.info("testConect() - Iterable<Student> result={}", result); //$NON-NLS-1$
		}
	}
}
