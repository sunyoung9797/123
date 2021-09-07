package co.yedam.hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	protected Connection conn;
	protected Statement stmt;
	protected ResultSet rs;
	protected PreparedStatement psmt;
	
	
	String user = "hr";
	String pass = "hr";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	protected void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		    System.out.println("���Ἲ��.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void disconnect() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
