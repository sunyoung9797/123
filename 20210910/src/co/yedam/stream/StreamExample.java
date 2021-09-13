package co.yedam.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * stream : ����, �ó��� -> �������� �帧.
 */

public class StreamExample {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello", "Nice" , "Good");
		Iterator<String> iter = list.iterator(); // �ݺ���
		while(iter.hasNext()) {
			String result = iter.next();
			System.out.println(result);
		}
		System.out.println("========");
		
		Stream<String> stream = list.stream();
		long cnt = stream
		   .filter((String t) -> {
				return t.length() == 4;			
		   })
//		   .forEach((t) -> System.out.println(t));
		   .count(); // ����ó���޼ҵ� : ����(count, sum, forEach)
		System.out.println("����ó������� ����: "+ cnt);
		
//		for(int i=0; i < list.size(); i++) {
//			list.get(i);
//		}
	}

}