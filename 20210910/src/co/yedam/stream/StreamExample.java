package co.yedam.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * stream : 개울, 시냇물 -> 데이터의 흐름.
 */

public class StreamExample {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello", "Nice" , "Good");
		Iterator<String> iter = list.iterator(); // 반복자
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
		   .count(); // 최종처리메소드 : 집계(count, sum, forEach)
		System.out.println("최종처리요소의 갯수: "+ cnt);
		
//		for(int i=0; i < list.size(); i++) {
//			list.get(i);
//		}
	}

}