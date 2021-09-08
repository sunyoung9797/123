package co.yedam.hospital;

import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
			System.out.println("1.입력 2.조회 3.수정 4.삭제 5.종료");
			int menu = scn.nextInt();
			scn.nextLine();
			if(menu == 1) {
				System.out.println("<입력>");
				addPatient();
			} else if(menu == 2) {
				System.out.println("<조회>");
				searchPatient();
			} else if(menu == 3) {
				System.out.println("<수정>");
				modifyPatient();
			} else if(menu == 4) {
				System.out.println("<삭제>");
				removePatient();
			} else if(menu == 5) {
				break;
			}
		}
		scn.close();
		System.out.println("end of program");
	}
	
	public static void addPatient() {
		System.out.println("환자코드를 입력하세요>>");
		String code = scn.nextLine();
		System.out.println("환자이름을 입력하세요>>");
		String name = scn.nextLine();
		System.out.println("환자나이를 입력하세요>>");
		int age = scn.nextInt();
		scn.nextLine();
		System.out.println("환자전화번호를 입력하세요>>");
		String callNumber = scn.nextLine();
		System.out.println("최근방문날짜를 입력하세요(YYYY-MM-DD)>>");
		String latestDate = scn.nextLine();
		
		System.out.println("환자병명을 입력하세요>>");
		String disease = scn.nextLine();
		System.out.println("담당의사를 입력하세요>>");
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
	//전화번호 검색도 추가하기
	public static void searchPatient() {
		System.out.println("(전체조회를 원한다면 엔터를 계속 눌러주세요)");
		System.out.println("환자이름을 입력하세요>>");
		String name = scn.nextLine();
		System.out.println("환자전화번호를 입력하세요>>");
		String callNumber = scn.nextLine();
		System.out.println("환자병명을 입력하세요>>");
		String disease = scn.nextLine();
		System.out.println("담당의사를 입력하세요>>");
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
		System.out.println("[필수]수정할 환자코드를 입력하세요>>");
		String code = scn.nextLine();
		
		PatientDAO dao = new PatientDAO();
		PatientVO rpnt = dao.getPatientVO(code);
		
		MedicalDAO dao2 = new MedicalDAO();
		MedicalVO rmed = dao2.getMedicalVO(code);

		System.out.println("(수정할 내용이 없다면 엔터를 계속 눌러주세요)");
		System.out.println("환자이름을 입력하세요>>");
		String name = scn.nextLine();
		if(!name.equals("")) {
			rpnt.setName(name);
		}		
		System.out.println("환자나이를 입력하세요>>");
		String age = scn.nextLine();
		if(!age.equals("")) {
			rpnt.setAge(Integer.parseInt(age));
		}
		System.out.println("환자전화번호를 입력하세요>>");
		String callNumber = scn.nextLine();
		if(!callNumber.equals("")) {
			rpnt.setCallNumber(callNumber);
		}
		System.out.println("최근방문날짜를 입력하세요(YYYY-MM-DD)>>");
		String latestDate = scn.nextLine();
		if(!latestDate.equals("")) {
			rpnt.setLatestDate(latestDate);
		}
		
		System.out.println("환자병명을 입력하세요>>");
		String disease = scn.nextLine();
		if(!disease.equals("")) {
			rmed.setDisease(disease);
		}	
		System.out.println("담당의사를 입력하세요>>");
		String doctor = scn.nextLine();
		if(!doctor.equals("")) {
			rmed.setDoctor(doctor);
		}
		
		dao.updatePatient(rpnt);
		dao2.updatePatient(rmed);
	}
	
	public static void removePatient() {
		System.out.println("[필수]삭제할 환자코드를 입력하세요>>");
		String Code = scn.nextLine();
		
		PatientDAO dao = new PatientDAO();
		dao.deletePatient(Code);
		MedicalDAO dao2 = new MedicalDAO();
		dao2.deletePatient(Code);
		
	}

}
