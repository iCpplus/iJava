package edu.zut.software.teach.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.teach.domain.Student;
import edu.zut.cs.software.teach.service.StudentManager;

public class TeachEntityGenerator extends GenericGenerator {

	List<Student> studentList;

	StudentManager studentManager;

	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}

	@Before
	public void setUp() throws Exception {
		this.studentList = new ArrayList<Student>();
		InputStream input = TeachEntityGenerator.class.getResourceAsStream("/sample_student_test.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Student s = new Student();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					String value = row.getCell(j).getStringCellValue().trim();
					if (j == 1)
						s.setGrade(value);
					if (j == 2)
						s.setMajor(value);
					if (j == 3)
						s.setSchoolClass(value);
					if (j == 4)
						s.setCode(value);
					if (j == 5)
						s.setName(value);

				}
			}
			this.studentList.add(s);
		}
	}

	@Test
	public void test() {
		// this.studentManager.deleteAll();
	
		for (Student student : studentList) {
			this.studentManager.save(student);
		}
		// this.studentManager.save(this.studentList);
		Iterable<Student> result = this.studentManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Student> result=" + result); //$NON-NLS-1$
		}
	}
}
