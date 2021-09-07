package co.yedam.hospital;

public class PatientVO {
	private String code ;
	private String name ;
	private int age ;
	private String callNumber ;
	private String latestDate;
	
	//get, set ¸¸µé±â
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}
	public String getLatestDate() {
		return latestDate;
	}
	public void setLatestDate(String latestDate) {
		this.latestDate = latestDate;
	}
	@Override
	public String toString() {
		return "PatientVO [code=" + code + ", name=" + name + ", age=" + age + ", callNumber=" + callNumber
				+ ", latestDate=" + latestDate + "]";
	}
	
}
