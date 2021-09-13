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
		//�л�(�̸�, ����, ����, ����) -> ���л� -> ����:80�̻� -> ������.
		List<Student> list = Arrays.asList(
			new Student("������", Gender.FEMALE, 85, 89),
			new Student("ȫ�ο�", Gender.MALE, 70, 65),
			new Student("�����", Gender.FEMALE, 90, 92),
			new Student("�ֹμ�", Gender.MALE, 80, 85)
	    );
		
		//��ȯ�Ǵ� �������� ����.
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
