package co.yedam.common;

import java.util.function.BinaryOperator;

public class OperatorExample {
	
	public static void main(String[] args) {
		BinaryOperator<Student> bio = new BinaryOperator<Student>() {
			@Override
			public Student apply(Student t, Student u) {
				return t.score > u.score ? t: u;
			}
		};
		Student s1 = new Student();
		s1.name = "�踻��";
		s1.score = 80;
		Student s2 = new Student();
		s2.name= "������";
		s2.score = 70;
		Student s3 = bio.apply(s1, s2);
		System.out.printf("�л��̸�=> %s, ����=> %d\n", s3.name, s3.score);
	}

}
