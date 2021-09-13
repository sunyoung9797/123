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
				new Student("박지민", Gender.FEMALE, 85, 89),
				new Student("홍민우", Gender.MALE, 70, 65),
				new Student("김수지", Gender.FEMALE, 90, 92),
				new Student("최민수", Gender.MALE, 50, 85)
		);
		// 여학생 -> 수학점수평균..
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
				System.out.printf("이름: %s, 영어: %d, 수학: %d\n", name, english, math);//printf :포멧
			}
			
		}); // => 전체학생 이름, 영어, 수학 출력.
		studentStream = list.stream();
		OptionalDouble avg1 = studentStream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.gen == Gender.FEMALE && t.mScore >95;
			}
			
		// 여학생 스트림.. => 수학점수 
		}).mapToInt(new ToIntFunction<Student>() { // int IntStream vs Integer (Stream<Interger>) integer: 클래스타입

			@Override
			public int applyAsInt(Student t) {
				return t.mScore;
			}
			
		}).average();
		
		if(avg1.isPresent()) {
			System.out.println(avg1.getAsDouble());
		} else {
			System.out.println("해당요소가 없습니다");
		}
		
		System.out.println(avg1.getAsDouble());
		
	} //end of main()

}