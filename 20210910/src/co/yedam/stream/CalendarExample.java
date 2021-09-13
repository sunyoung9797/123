package co.yedam.stream;

import java.util.Calendar;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CalendarExample {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("년도 입력");
		String year = scn.nextLine();
		System.out.println("월 입력");
		String month = scn.nextLine();
	
		callCalendar(year, month);
		
		scn.close();
	
    }
	
	
	public static void callCalendar(String  y, String m) {
		
		//직접해보기
		
//		System.out.printf("%s년 %s월\n",y,m);
//		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2021, 8, 1);
//		System.out.println("년도: " + cal.get(Calendar.YEAR));
//		System.out.println("월: " + cal.get(Calendar.MONTH));
//		System.out.println("일: " + cal.get(Calendar.DATE));
//		System.out.println("요일(1~7): " + cal.get(Calendar.DAY_OF_WEEK));
//		System.out.println("말일: " + cal.getActualMaximum(Calendar.DATE));
//		
//		for(int i=1; i<=30; i++) {
//			System.out.printf("%3s", i);
//			if(i % 7 == 0) { // 줄바꿈
//				System.out.println();
//			}
//			
//		}
	}

}
