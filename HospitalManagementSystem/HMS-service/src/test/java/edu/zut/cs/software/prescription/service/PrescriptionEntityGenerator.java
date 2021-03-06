package edu.zut.cs.software.prescription.service;

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
import edu.zut.cs.software.prescription.domain.Prescription;




/**
 * Entity Generator for prescription package.
 * 
 * @author FC
 *
 */
public class PrescriptionEntityGenerator extends GenericGenerator {

	List<Prescription> prescriptionList;
	
	PrescriptionManager prescriptionManager;

	@Autowired
	public void setPrescriptionManager(PrescriptionManager prescriptionManager) {
		this.prescriptionManager = prescriptionManager;
	}

	@Before
	public void setUp() throws Exception {
		this.prescriptionList = new ArrayList<Prescription>();
		InputStream input = PrescriptionManagerTest.class.getResourceAsStream("/epoch_prescription_software.xlsx");  //读取excel文件
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(input);   //解析excel文件
		XSSFSheet sheet = wb.getSheetAt(0);   //取第一个子表
		DataFormatter dataFormatter = new DataFormatter();  //格式化存储在单元格中的值
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {  //获取当前工作表的最后一行的行号
			Row row = sheet.getRow(i);    //返回当前行的行号
			Prescription s = new Prescription();
			for (int j = 0; j < row.getLastCellNum(); j++) {  //获取列数
				Cell cell = row.getCell(j);  //获取当前表格中的内容
				if (cell != null) {
					String value = dataFormatter.formatCellValue(cell);
					if (j == 1)
						s.setDrugName(value);
					
				}
			}
			this.prescriptionList.add(s);
		}
	}
		
	@Test
	public void test() {
		this.prescriptionManager.deleteAll();
		this.prescriptionManager.save(this.prescriptionList);
		Iterable<Prescription> result = this.prescriptionManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Prescreption> result=" + result); //$NON-NLS-1$
		}
	}

}