package co.yedam.choisunyoung;

import java.util.List;
import java.util.stream.Collectors;

public class Example01 {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> toList = dao.getEmpList().stream()
		                .filter((t) -> 5000<= t.getSalary() && t.getSalary()<=10000)
		                .collect(Collectors.toList()); 
		System.out.println("급여가 5000에서 10000사이인 사원리스트");
		for(Employee emp : toList) {
			System.out.printf("사원번호: %s, 이름: %s, 이메일 : %s, 급여:%s\n",
					          emp.getEmployeeId(),
		                      emp.getLastName() ,
					          emp.getEmail(),
					          emp.getSalary());
		}
	}

}
