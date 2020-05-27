package edu.zut.cs.software.nurse.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.nurse.domain.Nurse;
/**
 * import data of entities from excel.
 * 
 * @author Kou Shixiang
 */
public class NurseEntityGenerator extends GenericGenerator {
    List<Nurse> nurseList;

	NurseManager nurseManager;

	@Autowired
	public void setNurseManager(NurseManager nurseManager) {
		this.nurseManager = nurseManager;
	}

	@Before
	public void setUp() throws Exception {
		this.nurseList = new ArrayList<Nurse>();
		InputStream input = NurseManagerTest.class.getResourceAsStream("/epoch_nurse_software.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Nurse s = new Nurse();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					String value = dataFormatter.formatCellValue(cell);
					if (j == 1)
						s.setField(value);
					if (j == 2)
						s.setCode(value);
					if (j == 3)
						s.setName(value);
					if (j == 4)
						s.setGender(value);
				}
			}
			this.nurseList.add(s);
		}
	}

	@Test
	public void test() {
		this.nurseManager.deleteAll();
		this.nurseManager.save(this.nurseList);
		Iterable<Nurse> result = this.nurseManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Nurse> result=" + result); //$NON-NLS-1$
		}
	}
}