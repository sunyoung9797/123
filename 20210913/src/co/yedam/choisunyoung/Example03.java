package co.yedam.choisunyoung;

import java.util.List;
import java.util.OptionalDouble;

public class Example03 {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
		
		OptionalDouble avg = list.stream()
				.filter(t -> t.getHireDate().substring(5,7).equals("05"))
                .mapToDouble(t -> t.getSalary()).average();
                
		
		if(avg.isPresent()) {
			System.out.println("평균급여 : " + avg);
		} else {
			System.out.println("해당요소 없습니다.");
		}

	}

}
