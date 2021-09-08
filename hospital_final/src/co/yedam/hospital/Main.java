package co.yedam.hospital;

import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
			System.out.println("1.�Է� 2.��ȸ 3.���� 4.���� 5.����");
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu == 1) {
				System.out.println("<�Է�>");
				addPatient();
			} else if(menu == 2) {
				System.out.println("<��ȸ>");
				searchPatient();
			} else if(menu == 3) {
				System.out.println("<����>");
				modifyPatient();
			} else if(menu == 4) {
				System.out.println("<����>");
				removePatient();
			} else if(menu == 5) {
				break;
			}
		}
		scn.close();
		System.out.println("end of program");
	}
	
	public static void addPatient() {
		System.out.println("ȯ���ڵ带 �Է��ϼ���>>");
		String code = scn.nextLine();
		System.out.println("ȯ���̸��� �Է��ϼ���>>");
		String name = scn.nextLine();
		System.out.println("ȯ�ڳ��̸� �Է��ϼ���>>");
		int age = scn.nextInt();
		scn.nextLine();
		System.out.println("ȯ����ȭ��ȣ�� �Է��ϼ���>>");
		String callNumber = scn.nextLine();
		System.out.println("�ֱٹ湮��¥�� �Է��ϼ���(YYYY-MM-DD)>>");
		String latestDate = scn.nextLine();
		
		System.out.println("ȯ�ں����� �Է��ϼ���>>");
		String disease = scn.nextLine();
		System.out.println("����ǻ縦 �Է��ϼ���>>");
		String doctor = scn.nextLine();
		
		PatientVO pnt = new PatientVO();
		pnt.setCode(code);
		pnt.setName(name);
		pnt.setAge(age);
		pnt.setCallNumber(callNumber);
		pnt.setLatestDate(latestDate);
		
		MedicalVO med = new MedicalVO();
		med.setMedCode(code);
		med.setDisease(disease);
		med.setDoctor(doctor);
		
		PatientDAO dao = new PatientDAO();
		dao.insertPatient(pnt);
		MedicalDAO dao2 = new MedicalDAO();
		dao2.insertPatient(med);
		
	}
	//��ȭ��ȣ �˻��� �߰��ϱ�
	public static void searchPatient() {
		System.out.println("(��ü��ȸ�� ���Ѵٸ� ���͸� ��� �����ּ���)");
		System.out.println("ȯ���̸��� �Է��ϼ���>>");
		String name = scn.nextLine();
		System.out.println("ȯ����ȭ��ȣ�� �Է��ϼ���>>");
		String callNumber = scn.nextLine();
		System.out.println("ȯ�ں����� �Է��ϼ���>>");
		String disease = scn.nextLine();
		System.out.println("����ǻ縦 �Է��ϼ���>>");
		String doctor = scn.nextLine();
		
		PatientVO pnt = new PatientVO();
		pnt.setName(name);
		pnt.setCallNumber(callNumber);
		
		MedicalVO med = new MedicalVO();
		med.setDisease(disease);
		med.setDoctor(doctor);
		
		PatientDAO dao = new PatientDAO();
		List<PatientVO> list = dao.searchPatient(pnt);
		for(PatientVO pt : list) {
			System.out.println(pt.toString());
		}
		
		MedicalDAO dao2 = new MedicalDAO();
		List<MedicalVO> list2 = dao2.searchPatient(med);
		for(MedicalVO md : list2) {
			System.out.println(md.toString());
		}
		
	}
	
	public static void modifyPatient() {
		System.out.println("[�ʼ�]������ ȯ���ڵ带 �Է��ϼ���>>");
		String code = scn.nextLine();
		
		PatientDAO dao = new PatientDAO();
		PatientVO rpnt = dao.getPatientVO(code);
		
		MedicalDAO dao2 = new MedicalDAO();
		MedicalVO rmed = dao2.getMedicalVO(code);

		System.out.println("(������ ������ ���ٸ� ���͸� ��� �����ּ���)");
		System.out.println("ȯ���̸��� �Է��ϼ���>>");
		String name = scn.nextLine();
		if(!name.equals("")) {
			rpnt.setName(name);
		}		
		System.out.println("ȯ�ڳ��̸� �Է��ϼ���>>");
		String age = scn.nextLine();
		if(!age.equals("")) {
			rpnt.setAge(Integer.parseInt(age));
		}
		System.out.println("ȯ����ȭ��ȣ�� �Է��ϼ���>>");
		String callNumber = scn.nextLine();
		if(!callNumber.equals("")) {
			rpnt.setCallNumber(callNumber);
		}
		System.out.println("�ֱٹ湮��¥�� �Է��ϼ���(YYYY-MM-DD)>>");
		String latestDate = scn.nextLine();
		if(!latestDate.equals("")) {
			rpnt.setLatestDate(latestDate);
		}
		
		System.out.println("ȯ�ں����� �Է��ϼ���>>");
		String disease = scn.nextLine();
		if(!disease.equals("")) {
			rmed.setDisease(disease);
		}	
		System.out.println("����ǻ縦 �Է��ϼ���>>");
		String doctor = scn.nextLine();
		if(!doctor.equals("")) {
			rmed.setDoctor(doctor);
		}
		
		dao.updatePatient(rpnt);
		dao2.updatePatient(rmed);
	}
	
	public static void removePatient() {
		System.out.println("[�ʼ�]������ ȯ���ڵ带 �Է��ϼ���>>");
		String Code = scn.nextLine();
		
		PatientDAO dao = new PatientDAO();
		dao.deletePatient(Code);
		MedicalDAO dao2 = new MedicalDAO();
		dao2.deletePatient(Code);
		
	}

}
