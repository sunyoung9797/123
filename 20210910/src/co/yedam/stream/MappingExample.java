package co.yedam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

import oracle.jdbc.dcn.TableChangeDescription.TableOperation;
import oracle.net.aso.e;

public class MappingExample {
	public static void main(String[] args) {
		//�л�(�̸�, ����, ����, ����) -> ���л� -> ����:80�̻� -> ������.
		List<Student> list = Arrays.asList(
			new Student("������", Gender.FEMALE, 85, 89),
			new Student("ȫ�ο�", Gender.MALE, 70, 65),
			new Student("�����", Gender.FEMALE, 90, 92),
			new Student("�ֹμ�", Gender.MALE, 80, 85)
	    );
		
		list.stream()
		    .map(new Function<Student, HighStudent>() {
				@Override
				public HighStudent apply(Student t) {
					HighStudent hs = 
							new HighStudent(t.name,
									        t.gen,
									        t.eScore,
									        t.mScore,
									        (t.eScore+t.mScore)/2.0);
					return hs;
				}
			})
		    .filter(new Predicate<HighStudent>() {
				@Override
				public boolean test(HighStudent t) {
					return t.avg >= 80;
				}
			})
		    .forEach(e -> System.out.printf("�̸�: %s, ���: %s\n", e.name, e.avg));
		OptionalDouble maxValue = list.stream()
			   .filter(s -> s.gen == Gender.MALE)
			   .mapToDouble(new ToDoubleFunction<Student>() {
					@Override
					public double applyAsDouble(Student s) {
						return (s.eScore + s.mScore) / 2.0;
					}					   
		       })
			   .max();

		if(maxValue.isPresent()) {
			System.out.println("�ִ밪: " + maxValue);
		} else {
			System.out.println("�ش��� �����ϴ�.");
		}
	}

}
