package edu.zut.cs.software.patient.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.patient.domain.Patient;
import edu.zut.cs.software.patient.domain.Gender;



/**
 * Entity Generator for patient package.
 * 
 * @author shishuqian
 *
 */
public class PatientEntityGenerator extends GenericGenerator {

	List<Patient> patientList;
	
	PatientManager patientManager;

	@Autowired
	public void setPatientManager(PatientManager patientManager) {
		this.patientManager = patientManager;
	}
	
	@Before
	public void setUp() throws Exception {
		this.patientList = new ArrayList<Patient>();
		InputStream input = PatientManagerTest.class.getResourceAsStream("/epoch_patient_software.xlsx");  //读取excel文件
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(input);   //解析excel文件
		XSSFSheet sheet = wb.getSheetAt(0);   //取第一个子表
		DataFormatter dataFormatter = new DataFormatter();  //格式化存储在单元格中的值
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {  //获取当前工作表的最后一行的行号
			Row row = sheet.getRow(i);    //返回当前行的行号
			Patient s = new Patient();
			for (int j = 0; j < row.getLastCellNum(); j++) {  //获取列数
				Cell cell = row.getCell(j);  //获取当前表格中的内容
				if (cell != null) {
					String value = dataFormatter.formatCellValue(cell);
					if (j == 1)
						s.setAge(value);
					if (j == 2)
						s.setSymptom(value);
					if (j == 3)
						s.setCode(value);
					if (j == 4)
						s.setName(value);
					if (j == 5)
						if (StringUtils.equalsIgnoreCase("男", value)) {
							s.setGender(Gender.Male);
						} else if (StringUtils.equalsIgnoreCase("女", value)) {
							s.setGender(Gender.Female);
						}
				}
			}
			this.patientList.add(s);
		}
	}
		
	@Test
	public void test() {
		this.patientManager.deleteAll();
		this.patientManager.save(this.patientList);
		Iterable<Patient> result = this.patientManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Patient> result=" + result); //$NON-NLS-1$
		}
	}

}

