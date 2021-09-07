package co.yedam.hospital;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalDAO extends DAO {
	
	public void insertPatient(MedicalVO med) {
		String sql = "insert into medical_info(patient_code, patient_disease, patient_doctor)"+
	                 "values(?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, med.getMedCode());
			psmt.setString(2, med.getDisease());
			psmt.setString(3, med.getDoctor());
			
			int r= psmt.executeUpdate();
			System.out.println("진료정보입력완료"+ r);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public List<MedicalVO> searchPatient(MedicalVO med) {
		String sql = "select * from patient_info m\r\n" + 
				"left outer join medical_info i\r\n" + 
				"on m.patient_code = i.patient_code ";
		if(med.getDisease() != null) {
			sql += "where patient_disease like '%'||?||'%' ";
		} else if(med.getDoctor() != null) {
			sql += "where patient_doctor like '%'||?||'%' ";
		}
		List<MedicalVO> medList = new ArrayList<MedicalVO>();
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			if(med.getDisease() != null) {
				psmt.setString(1, med.getDisease());;
			} else if(med.getDoctor() != null) {
				psmt.setString(1, med.getDoctor());
			} 
			rs = psmt.executeQuery();
			while(rs.next()) {
				MedicalVO md = new MedicalVO();
				md.setMedCode(rs.getString("patient_code"));
				md.setDisease(rs.getString("patient_disease"));
				md.setDoctor(rs.getString("patient_doctor"));
				
				medList.add(md);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return medList;
	} 
	
	public MedicalVO getMedicalVO(String code) {
		String sql = "select * from medical_info where patient_code = ?";
	    MedicalVO med = null;
	    connect();
	    try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			if(rs.next()) {
				med = new MedicalVO();
				med.setMedCode(rs.getString("patient_code"));
				med.setDisease(rs.getString("patient_disease"));	
				med.setDoctor(rs.getString("patient_doctor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	    return med;
	}
	
	public void updatePatient(MedicalVO med) {
		System.out.println(med);
		String sql = "update medical_info set patient_disease=?, patient_doctor=? "
				   + "                                     where patient_code = ? ";
		connect();
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, med.getDisease());
			psmt.setString(2, med.getDoctor());
			psmt.setString(3, med.getMedCode());
			
			int r = psmt.executeUpdate();
			System.out.println("진료정보수정완료 : " + r);	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public void deletePatient (String patientCode) {
		String sql = "delete from medical_info where patient_code = ?";
	    connect();
	    try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, patientCode);
			
			int r = psmt.executeUpdate();
			System.out.println("진료정보삭제완료 : " + r);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	

}
