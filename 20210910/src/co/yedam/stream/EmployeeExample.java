package co.yedam.stream;

import java.util.List;


public class EmployeeExample{
	
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
		//개발부서 IT_PROG -> 급여의 합계.
		int sum = list.stream() // Collection으로부터 Stream 생성.
		    .filter(t -> t.getJobId().equals("IT_PROG") )// 개발부서
		    .mapToInt(t -> t.getSalary()) //사원 -> 급여
		    .sum();
		System.out.println("IT부서의 급여합계 : " + sum);
		
//		list.stream().forEach(s -> System.out.println(s));
	}

}