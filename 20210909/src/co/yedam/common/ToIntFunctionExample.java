package co.yedam.common;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

/*
 *  �л����� �Է¹޾Ƽ� �л��� ������ ��ȯ���ִ� ���
 */

public class ToIntFunctionExample {
	
	public static void main(String[] args) {
		ToIntFunction<Student> tif = (student) -> {
			return student.name.length();
		};
		Student s1 = new Student();
		s1.name = "Hong";
		s1.score = 90;
		
		int score = tif.applyAsInt(s1);
		System.out.println(score);
		
		// �л��� �����հ� ���ϵ���.
		Student s2 = new Student();
		s2.name = "�ڹμ�";
		s2.score = 80;
		
		Student s3 = new Student();
		s3.name = "������";
		s3.score = 90;
		
		List<Student> list = Arrays.asList(s1,s2,s3);
		ToIntFunction<Student> fi = (value) -> value.score;
			
		scoreSum(list, fi);
	}
	
	static void scoreSum(List<Student> list, ToIntFunction<Student> fi) {
		int sum = 0;		
		for(Student student : list) {
			sum += fi.applyAsInt(student);
		}
		System.out.println("�л������հ�: "+ sum);
	}
	
	static int sum (int a, int b) {
		return a+b;
	}

}
