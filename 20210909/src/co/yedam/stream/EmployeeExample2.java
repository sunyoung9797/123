package co.yedam.stream;

public class EmployeeExample2 {
	
	public static void main(String[] args) {
		
		//사원중에서 급여 5000 이하 사람들의 이름과 이메일 출력.
		EmpDAO dao = new EmpDAO();
		dao.getEmpList().stream()// Stream 생성
		                .filter(e -> e.getSalary() <=5000)
		                .forEach(e -> System.out.printf
		                		("이름: %s, 이메일 : %s\n", e.getLastName(), e.getEmail()));
			
		
	}

}
