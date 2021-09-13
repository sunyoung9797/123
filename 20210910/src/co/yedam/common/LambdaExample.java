package co.yedam.common;

interface Runnable {
	void run();
}
class RunClass implements Runnable{

	@Override
	public void run() {
		System.out.println("시작합니다.");
	}
//	void run() {
//		System.out.println("시작합니다.");
//	}
}
class StartClass implements Runnable{

	@Override
	public void run() {
		System.out.println("시작합니다.");
	}
//	void start() {
//		System.out.println("시작합니다.");
//	}
}

@FunctionalInterface //구현해야할 메소드 1개만 !!
interface FunctionInterface {
	void showMessage(String msg);
//  void showPrint();
}
interface FunctionInterfaceWithReturn {
	String getName(String name);
}
public class LambdaExample {
	String prog;
	
	public static void main(String[] args) {
		Runnable run= new RunClass();
		run.run();
		Runnable start = new StartClass();
		start.run();
		
		// 인터페이스를 구현하는 익명의 구현객체를 만듬.
		// 람다표현식. (매개값) -> {구현코드;}
		// 기능을 구현할 때 간단하게 표현.
		//매개값이 하나만 있다면 괄호 생략 가능
		Runnable anony = () -> {
				System.out.println("또 다른 실행합니다.");			
		};
		anony.run();
		
		FunctionInterface fi = msg-> {
			for(int i=0; i<3; i++)
				System.out.println("메세지 : " + msg);
		};
		fi.showMessage("안녕하세요!!");
		
		FunctionInterfaceWithReturn fiw = name ->"반갑습니다!!" + name;
		
        String result = fiw.getName("홍길동");
        System.out.println(result);
	}

}