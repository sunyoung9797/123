package co.yedam.stream;

import java.util.List;


public class EmployeeExample{
	
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
		//���ߺμ� IT_PROG -> �޿��� �հ�.
		int sum = list.stream() // Collection���κ��� Stream ����.
		    .filter(t -> t.getJobId().equals("IT_PROG") )// ���ߺμ�
		    .mapToInt(t -> t.getSalary()) //��� -> �޿�
		    .sum();
		System.out.println("IT�μ��� �޿��հ� : " + sum);
		
//		list.stream().forEach(s -> System.out.println(s));
	}

}
