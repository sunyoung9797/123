package co.yedam.common;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
class Student {
	String name;
	int score;
}
public class ConsumerExample {
	
	public static void main(String[] args) {
		Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);				
			}
		};
		consumer.accept("ȫ�浿");
		
		Student s1 = new Student();
		s1.name = "ȫ�浿";
		s1.score = 80;
		BiConsumer<Student, String> bicon = (student, message) -> {			
			System.out.println("�л��̸�: " + student.name + "����: " + student.score);
			System.out.println("�޼���: " +message);
		}; 
		bicon.accept(s1, "�ݰ����ϴ�.");
		// Student, Integer
        BiConsumer<Student, Integer> bin = (student, cnt) -> {
        	for(int i=0; i<cnt; i++) {
        		System.out.printf("�л��̸�: %s, ����: %d \n", student.name, student.score);
        	}
        };
        bin.accept(s1, 3);
	}

}