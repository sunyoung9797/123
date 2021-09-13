package co.yedam.excel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import co.yedam.stream.EmpDAO;
import co.yedam.stream.Employee;
import oracle.net.aso.e;

public class ExcelWriterExample {
	public static void main(String[] args) {
		
		//�������  IT_PROG �������.
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
		//���� ��Ʈ��
		List<Employee> itList = null;
		
		itList = list.stream()
	//	             .filter(e -> e.getJobId().equals("IT_PROG"))
				     .filter(new Predicate<Employee>() {
					     @Override
				    	public boolean test(Employee t) {
					    	return t.getJobId().equals("IT_PROG");
					     }
				     })
		             .collect(Collectors.toList());
		 
		ExcelWriter writer = new ExcelWriter();
		writer.xlsWriter(itList);
//		writer.getFields();
		System.out.println("end of prog");
	}

}
