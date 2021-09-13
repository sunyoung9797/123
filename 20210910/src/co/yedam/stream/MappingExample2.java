package co.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import oracle.jdbc.dcn.TableChangeDescription.TableOperation;
import oracle.net.aso.e;

public class MappingExample2 {
	public static void main(String[] args) {
		//학생(이름, 성별, 영어, 수학) -> 여학생 -> 영어:80이상 -> 명단출력.
		List<Student> list = Arrays.asList(
			new Student("박지민", Gender.FEMALE, 85, 89),
			new Student("홍민우", Gender.MALE, 70, 65),
			new Student("김수지", Gender.FEMALE, 90, 92),
			new Student("최민수", Gender.MALE, 80, 85)
	    );
		
		//반환되는 데이터의 유형.
		List<Student> l = list.stream().collect(Collectors.toList());
		List<String> s = list.stream()
		    .map(new Function<Student, String>() {
				@Override
				public String apply(Student t) {
					return null;
				}
			
		    })
		    .collect(Collectors.toList());
	
	}

}
