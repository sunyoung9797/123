package co.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

enum Gender {
	MALE,FEMALE;
}

class Student {
	String name;
	Gender gen;
	int mScore;//��������
	int eScore;//��������
	Student(String n, Gender g, int m, int e) {
		name = n;
		gen = g;
		mScore = m;
		eScore = e;
	}
	
}

public class StudentStreamExample {
	
	public static void main(String[] args) {
		//�л�(�̸�, ����, ����, ����) -> ���л� -> ����:80�̻� -> ������.
		List<Student> list = Arrays.asList(
				new Student("������", Gender.FEMALE, 85, 89),
				new Student("ȫ�ο�", Gender.MALE, 70, 65),
				new Student("�����", Gender.FEMALE, 90, 92),
				new Student("�ֹμ�", Gender.MALE, 50, 85)
		);
		 Stream<Student> stream = list.stream();
		 Stream<Student> femaleStudent = 
			     stream.filter(new Predicate<Student>() {
					 @Override
					 public boolean test(Student t) {
						 return t.gen == Gender.FEMALE && t.eScore >= 80;
					 }
			 
		         });
		 femaleStudent.forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.printf("�̸�: %s, ���� : %d, ����: %d\n", t.name, t.eScore, t.mScore);
			}		 
		 });
	}

}