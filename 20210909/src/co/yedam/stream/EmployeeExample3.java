package co.yedam.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeExample3 {
	
	public static void main(String[] args) {
		
		//����߿��� �޿� 5000 ���� ������� �̸��� �̸��� ���.
		EmpDAO dao = new EmpDAO();
		List<Employee> toList = dao.getEmpList().stream()// Stream ����
		                .filter((t) -> t.getSalary() <=5000)
		                .collect(Collectors.toList()); // collector<Employee,A,R>
		System.out.println("�޿��� 5000������ �������Ʈ");
		for(Employee emp : toList) {
			System.out.println(emp.getLastName() + ", " + emp.getEmail());
		}
		
		Set<Employee> toSet = dao.getEmpList().stream()// Stream ����
        .filter((t) -> t.getSalary() <=5000)
        .collect(Collectors.toSet()); // collector<Employee,A,R>
		System.out.println("�޿��� 5000������ �������Ʈ");
		for(Employee emp : toSet) {
			System.out.println(emp.getLastName() + ", " + emp.getEmail());
		}
	}

}
