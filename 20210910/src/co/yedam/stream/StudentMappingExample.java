package co.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StudentMappingExample {
	
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("������", Gender.FEMALE, 85, 89),
				new Student("ȫ�ο�", Gender.MALE, 70, 65),
				new Student("�����", Gender.FEMALE, 90, 92),
				new Student("�ֹμ�", Gender.MALE, 50, 85)
		);
		// ���л� -> �����������..
		int sum = 0, rcnt = 0;
		for(int i=0, cnt=list.size(); i<cnt; i++) {
			if(list.get(i).gen == Gender.FEMALE) {
				sum += list.get(i).mScore;
				rcnt++;
			}
		}
		double avg = sum / rcnt;
		
		// stream 
		Stream<Student> studentStream = list.stream();
		studentStream.forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				String name = t.name;
				int math = t.mScore;
				int english = t.eScore;
				System.out.printf("�̸�: %s, ����: %d, ����: %d\n", name, english, math);//printf :����
			}
			
		}); // => ��ü�л� �̸�, ����, ���� ���.
		studentStream = list.stream();
		OptionalDouble avg1 = studentStream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.gen == Gender.FEMALE && t.mScore >95;
			}
			
		// ���л� ��Ʈ��.. => �������� 
		}).mapToInt(new ToIntFunction<Student>() { // int IntStream vs Integer (Stream<Interger>) integer: Ŭ����Ÿ��

			@Override
			public int applyAsInt(Student t) {
				return t.mScore;
			}
			
		}).average();
		
		if(avg1.isPresent()) {
			System.out.println(avg1.getAsDouble());
		} else {
			System.out.println("�ش��Ұ� �����ϴ�");
		}
		
		System.out.println(avg1.getAsDouble());
		
	} //end of main()

}