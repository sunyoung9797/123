package co.yedam.stream;

import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CalendarExample {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("�⵵ �Է�");
		String year = scn.nextLine();
		System.out.println("�� �Է�");
		String month = scn.nextLine();
	
		callCalendar(year, month);
		
		scn.close();
	
    }
	
	
	public static void callCalendar(String  y, String m) {
		
		//�����غ���
		
//		System.out.printf("%s�� %s��\n",y,m);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2021, 8, 1);
//		System.out.println("�⵵: " + cal.get(Calendar.YEAR));
//		System.out.println("��: " + cal.get(Calendar.MONTH));
//		System.out.println("��: " + cal.get(Calendar.DATE));
//		System.out.println("����(1~7): " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("����: " + cal.getActualMaximum(Calendar.DATE));
//		
//		for(int i=1; i<=30; i++) {
//			System.out.printf("%3s", i);
//			if(i % 7 == 0) { // �ٹٲ�
//				System.out.println();
//			}
//			
//		}
	}

}
