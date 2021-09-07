package co.yedam.hospital;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO extends DAO{
	
	//추가
	public void insertPatient(PatientVO pnt) {
		String sql = "insert into Patient_info(patient_code, patient_name, patient_age, patient_call_number, latest_date) " +
				"values(?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pnt.getCode());
			psmt.setString(2, pnt.getName());
			psmt.setInt(3, pnt.getAge());
			psmt.setString(4, pnt.getCallNumber());
			psmt.setString(5, pnt.getLatestDate());
			
			int r = psmt.executeUpdate(); 
			System.out.println("환자정보입력완료" + r);		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	//조회 
	public List<PatientVO> searchPatient(PatientVO pnt) {
		String sql = "select * from patient_info m\r\n";
		if(pnt.getName() != null) {
			sql += "where patient_name like '%'||?||'%' ";
		} else if(pnt.getCallNumber() != null) {
			sql += "where patient_call_number like '%'||?||'%' ";
		}
		List<PatientVO> pntList = new ArrayList<PatientVO>();
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			if(pnt.getName() != null) {
				psmt.setString(1, pnt.getName());;
			} else if(pnt.getCallNumber() != null) {
				psmt.setString(1, pnt.getCallNumber());
			} 
			rs = psmt.executeQuery();
			while(rs.next()) {
				PatientVO pt = new PatientVO();
				pt.setCode(rs.getString("patient_code"));
				pt.setName(rs.getString("patient_name"));
				pt.setAge(rs.getInt("patient_age"));
				pt.setCallNumber(rs.getString("patient_call_number"));
				pt.setLatestDate(rs.getString("latest_date"));
				
				pntList.add(pt);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return pntList;
	}
	
	
	//수정	
	public PatientVO getPatientVO(String patientCode) {
		String sql = "select * from patient_info where patient_code = ?";
	    PatientVO pnt = null;
	    connect();
	    try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, patientCode);
			rs = psmt.executeQuery();
			if(rs.next()) {
				pnt = new PatientVO();
				pnt.setCode(rs.getString("patient_code"));
				pnt.setName(rs.getString("patient_name"));
				pnt.setAge(rs.getInt("patient_age"));
				pnt.setCallNumber(rs.getString("patient_call_number"));
				pnt.setLatestDate(rs.getString("latest_date"));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	    return pnt;
	}
	
	public void updatePatient(PatientVO pnt) {
		System.out.println(pnt);
		String sql = "update patient_info set patient_name=?, patient_age=?, "
				+ "                    patient_call_number=?, latest_date=? "
				+ "                                  where patient_code = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, pnt.getName());
			psmt.setInt(2, pnt.getAge());
			psmt.setString(3, pnt.getCallNumber());
			psmt.setString(4, pnt.getLatestDate().substring(0,6));
			psmt.setString(5, pnt.getCode());
			
			int r = psmt.executeUpdate();
			System.out.println("환자정보수정완료 : " + r);	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public void deletePatient (String patientCode) {
		String sql = "delete from patient_info where patient_code = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, patientCode);
			
			int r = psmt.executeUpdate();
			System.out.println("환자정보삭제완료 : " + r);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();        
		}
	}
	

}




