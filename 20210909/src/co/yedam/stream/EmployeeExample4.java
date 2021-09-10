package co.yedam.stream;

import java.io.FileOutputStream;
import java.io.IOException;


public class EmployeeExample4 {

	public static void main(String[] args) {

		// ����߿��� �޿� 5000 ���� ������� �̸��� �̸��� ���.
		try {
			FileOutputStream fos = new FileOutputStream("emp.txt");
		EmpDAO dao = new EmpDAO(); //List<Employee>
		dao.getEmpList().stream()// Stream ����
				.filter((t) -> t.getSalary() <= 5000)
				.sorted()
				.forEach(t -> {
					System.out.printf("�̸�: %s, �̸��� : %s\n", t.getLastName(), t.getEmail());
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
