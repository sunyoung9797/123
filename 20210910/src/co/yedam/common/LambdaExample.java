package co.yedam.common;

interface Runnable {
	void run();
}
class RunClass implements Runnable{

	@Override
	public void run() {
		System.out.println("�����մϴ�.");
	}
//	void run() {
//		System.out.println("�����մϴ�.");
//	}
}
class StartClass implements Runnable{

	@Override
	public void run() {
		System.out.println("�����մϴ�.");
	}
//	void start() {
//		System.out.println("�����մϴ�.");
//	}
}

@FunctionalInterface //�����ؾ��� �޼ҵ� 1���� !!
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
		
		// �������̽��� �����ϴ� �͸��� ������ü�� ����.
		// ����ǥ����. (�Ű���) -> {�����ڵ�;}
		// ����� ������ �� �����ϰ� ǥ��.
		//�Ű����� �ϳ��� �ִٸ� ��ȣ ���� ����
		Runnable anony = () -> {
				System.out.println("�� �ٸ� �����մϴ�.");			
		};
		anony.run();
		
		FunctionInterface fi = msg-> {
			for(int i=0; i<3; i++)
				System.out.println("�޼��� : " + msg);
		};
		fi.showMessage("�ȳ��ϼ���!!");
		
		FunctionInterfaceWithReturn fiw = name ->"�ݰ����ϴ�!!" + name;
		
        String result = fiw.getName("ȫ�浿");
        System.out.println(result);
	}

}