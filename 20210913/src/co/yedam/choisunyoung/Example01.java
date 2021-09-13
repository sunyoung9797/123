package co.yedam.choisunyoung;

import java.util.List;
import java.util.stream.Collectors;

public class Example01 {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> toList = dao.getEmpList().stream()
		                .filter((t) -> 5000<= t.getSalary() && t.getSalary()<=10000)
		                .collect(Collectors.toList()); 
		System.out.println("�޿��� 5000���� 10000������ �������Ʈ");
		for(Employee emp : toList) {
			System.out.printf("�����ȣ: %s, �̸�: %s, �̸��� : %s, �޿�:%s\n",
					          emp.getEmployeeId(),
		                      emp.getLastName() ,
					          emp.getEmail(),
					          emp.getSalary());
		}
	}

}
