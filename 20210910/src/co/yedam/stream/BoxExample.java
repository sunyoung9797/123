package co.yedam.stream;
/*
 * Generic »ç¿ë.(<Student> ÀÌ·±°Å)
 */

class Box<T> {
	T field;
	void set(T obj) {
		field = obj;
	}
	T get() {
		return field;
	}
}
class Orange {
	
}
public class BoxExample {
	
	public static void main(String[] args) {
		
		Box<String> boxStr = new Box<String>();
		boxStr.set("Orange");
		String rstr = boxStr.get();
		
		Box<Orange> boxOra = new Box<Orange>();
		boxOra.set(new Orange());
		Orange r = boxOra.get();
		
		Box box = new Box();
		box.set("Orange");
		String result = (String) box.get();
		
		Orange orange = new Orange();
		box.set(orange);
		Orange orang = (Orange) box.get();
		
//		String oran = (String) box.get(); // Orange
		
		box.set("Orange");
		String oraa = (String) box.get();
		
		System.out.println("end");
	}
}