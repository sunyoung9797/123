package co.yedam.choisunyoung;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Example04 {
	
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> toList = dao.getEmpList().stream()
				     .filter(t -> t.getJobId().equals("SA_REP"))
				     .collect(Collectors.toList()); 
		
		ExcelWriter writer = new ExcelWriter();
		writer.xlsWriter(toList);
		System.out.println("end of prog");
	}
	
	public static class ExcelWriter {
		
		public Field[] getFields() {
			Field[] fields = Employee.class.getDeclaredFields();
			for(Field field : fields) {
				System.out.println(field.getName());
			}
			return fields;
		}
		
		public void xlsWriter(List<Employee> list) {
			
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			workbook.setSheetName(0, "sarep");
			int rowCnt = 0;
			HSSFRow row = sheet.createRow(rowCnt++);
			HSSFCell cell;
			
			int cellCnt = 0;
			Field[] fields = getFields();
			for(Field field : fields) {
				cell = row.createCell(cellCnt++);
				cell.setCellValue(field.getName());		
			}

			for(Employee emp : list) { 
				cellCnt =0;
				row = sheet.createRow(rowCnt++); 
			    
				cell = row.createCell(cellCnt++); 
				cell.setCellValue(emp.getEmployeeId());
				
				cell = row.createCell(cellCnt++); 
				cell.setCellValue(emp.getLastName());
				
				cell = row.createCell(cellCnt++); 
				cell.setCellValue(emp.getEmail());
				
				cell = row.createCell(cellCnt++); 
				cell.setCellValue(emp.getSalary());
				
			}
			
			File file = new File("sales.xls");
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

}
