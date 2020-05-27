

package edu.zut.cs.software.department.service;

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
import edu.zut.cs.software.department.domain.Department;

/**
 * 
 * @author fanyuxin
 *
 */

public class DepartmentEntityGenerator extends GenericGenerator{
	
    List<Department> departmentList;
	
    DepartmentManager departmentManager;

	@Autowired
	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}
	
	@Before
	public void setUp() throws Exception {
		this.departmentList = new ArrayList<Department>();
		InputStream input = DepartmentManagerTest.class.getResourceAsStream("/epoch_patient_software.xlsx"); 
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Department a = new Department();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					String value = dataFormatter.formatCellValue(cell);
					if (j == 1)
						a.setName(value);
					if (j == 2)
						a.setCode(value);
					if (j == 3)
						a.setCategory(value);
				}
			}
			this.departmentList.add(a);
		}
	}
		
	@Test
	public void test() {
		this.departmentManager.deleteAll();
		this.departmentManager.save(this.departmentList);
		Iterable<Department> result = this.departmentManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<department> result=" + result); //$NON-NLS-1$
		}
	}
}