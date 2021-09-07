package co.yedam.hospital;

public class MedicalVO {
	private String medCode;
	private String disease;
	private String doctor;
	
	public String getMedCode() {
		return medCode;
	}
	public void setMedCode(String medCode) {
		this.medCode = medCode;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	@Override
	public String toString() {
		return "MedicalVO [medCode=" + medCode + ", disease=" + disease + ", doctor=" + doctor + "]";
	}
	


}
