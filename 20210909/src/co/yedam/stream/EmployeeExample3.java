package co.yedam.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeExample3 {
	
	public static void main(String[] args) {
		
		//사원중에서 급여 5000 이하 사람들의 이름과 이메일 출력.
		EmpDAO dao = new EmpDAO();
		List<Employee> toList = dao.getEmpList().stream()// Stream 생성
		                .filter((t) -> t.getSalary() <=5000)
		                .collect(Collectors.toList()); // collector<Employee,A,R>
		System.out.println("급여가 5000이하인 사원리스트");
		for(Employee emp : toList) {
			System.out.println(emp.getLastName() + ", " + emp.getEmail());
		}
		
		Set<Employee> toSet = dao.getEmpList().stream()// Stream 생성
        .filter((t) -> t.getSalary() <=5000)
        .collect(Collectors.toSet()); // collector<Employee,A,R>
		System.out.println("급여가 5000이하인 사원리스트");
		for(Employee emp : toSet) {
			System.out.println(emp.getLastName() + ", " + emp.getEmail());
		}
	}

}
