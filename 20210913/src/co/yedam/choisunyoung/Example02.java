package co.yedam.choisunyoung;

import java.util.List;
import java.util.OptionalDouble;

public class Example02 {
	
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
				
				
		OptionalDouble maxValue = list.stream()
				.filter(t -> t.getJobId().equals("ST_CLERK"))
                .mapToDouble(t -> t.getSalary())
                .max(); 
		
		if(maxValue.isPresent()) {
			System.out.println("�޿��� ���� ���� ����� �޿�: " + maxValue);
		} else {
			System.out.println("�ش��� �����ϴ�.");
		}
		
		
	}

}
