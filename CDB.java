package student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CDB {
	
	static Connection con;
	
	
	public static Connection createC(){
		String user = "root";
		String password = "9774";
		String url = "jdbc:mysql://localhost:3306/student_manage";
		try {
			
			Class.forName("com.mysql.jdbc.Driver"); 
			
					
			con =DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the Database Succesfully...");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return con;
	}
}
