package edu.zut.cs.software.doctor.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.doctor.domain.Doctor;

/**
 * 
 * @author lucky刘小宇
 *
 */
public class DoctorEntityGenerator extends GenericGenerator {

	List<Doctor> doctorList;

	DoctorManager doctorManager;

	@Autowired
	public void setDoctorManager(DoctorManager doctorManager) {
		this.doctorManager = doctorManager;
	}

	@Before
	public void setUp() throws Exception {
		this.doctorList = new ArrayList<Doctor>();
		InputStream input = DoctorManagerTest.class.getResourceAsStream("/epoch_doctor_software.xls");
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(input);
		HSSFSheet sheet = wb.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Doctor s = new Doctor();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					String value = dataFormatter.formatCellValue(cell);
					if (j == 1)
						s.setName(value);
					if (j == 2)
						s.setCode(value);
					if (j == 3)
						s.setAge(value);
					if (j == 4)
						s.setProfessionalTitle(value);
				}
			}
			this.doctorList.add(s);
		}
	}

	@Test
	public void test() {
		this.doctorManager.deleteAll();
		this.doctorManager.save(this.doctorList);
		Iterable<Doctor> result = this.doctorManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Doctor> result=" + result); //$NON-NLS-1$
		}
	}

}
