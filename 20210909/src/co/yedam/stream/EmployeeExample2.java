package co.yedam.stream;

public class EmployeeExample2 {
	
	public static void main(String[] args) {
		
		//����߿��� �޿� 5000 ���� ������� �̸��� �̸��� ���.
		EmpDAO dao = new EmpDAO();
		dao.getEmpList().stream()// Stream ����
		                .filter(e -> e.getSalary() <=5000)
		                .forEach(e -> System.out.printf
		                		("�̸�: %s, �̸��� : %s\n", e.getLastName(), e.getEmail()));
			
		
	}

}
