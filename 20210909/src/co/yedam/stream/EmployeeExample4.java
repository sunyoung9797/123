package co.yedam.stream;

import java.io.FileOutputStream;
import java.io.IOException;


public class EmployeeExample4 {

	public static void main(String[] args) {

		// 사원중에서 급여 5000 이하 사람들의 이름과 이메일 출력.
		try {
			FileOutputStream fos = new FileOutputStream("emp.txt");
		EmpDAO dao = new EmpDAO(); //List<Employee>
		dao.getEmpList().stream()// Stream 생성
				.filter((t) -> t.getSalary() <= 5000)
				.sorted()
				.forEach(t -> {
					System.out.printf("이름: %s, 이메일 : %s\n", t.getLastName(), t.getEmail());
				    String info = t.getLastName() +","+ t.getEmail() +"," + t.getSalary()+ "\n";
					byte[] readByte = info.getBytes();
					try {
						fos.write(readByte);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}); 
		  fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
