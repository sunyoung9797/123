package co.yedam.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import co.yedam.stream.Employee;

public class ExcelWriter {
	
	public Field[] getFields() {
		Field[] fields = Employee.class.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getName());
		}
		return fields;
	}
	
	public void xlsWriter(List<Employee> list) {
		// eid, fname, lname
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "�������Ʈ");
		int rowCnt = 0;
		HSSFRow row = sheet.createRow(rowCnt++);
		HSSFCell cell;
		
		//Ÿ��Ʋ �κ� ���..
		int cellCnt = 0;
		Field[] fields = getFields();
		for(Field field : fields) {
			cell = row.createCell(cellCnt++);
			cell.setCellValue(field.getName());		
		}
		//������ �κ� ���..
		for(Employee emp : list) { //List<Employee>
			cellCnt =0;
			row = sheet.createRow(rowCnt++); // ������ ���� ����.
		    
			cell = row.createCell(cellCnt++); // ù��° Į��
			cell.setCellValue(emp.getEmployeeId());
			
			cell = row.createCell(cellCnt++); // �ι�° Į��
			cell.setCellValue(emp.getLastName());
			
			cell = row.createCell(cellCnt++); // ����° Į��
			cell.setCellValue(emp.getEmail());
			
			cell = row.createCell(cellCnt++); // �׹�° Į��
			cell.setCellValue(emp.getHireDate());
			
			cell = row.createCell(cellCnt++); // �ټ���° Į��
			cell.setCellValue(emp.getSalary());
			
			cell = row.createCell(cellCnt++); // ������° Į��
			cell.setCellValue(emp.getJobId());
			
		}
		
		File file = new File("������.xls");
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
