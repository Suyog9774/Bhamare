package student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	
	public static boolean insertStudentToDB(Student st) {
		
		boolean f=false;
		
		try {
			
			Connection con = CDB.createC();
			String q= "insert into student(student_name, student_dob, student_doj) values(?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setDate(2, st.getStudentDob());
			pstmt.setDate(3, st.getStudentDoj());
			
			pstmt.executeUpdate();
			f=true;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
	}

	public static boolean deleteStudent(int userID) {
	
		boolean f=false;
		
		try {
			
			Connection con = CDB.createC();
			String q= "delete from student where student_id=?";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1, userID);
			
			
			pstmt.executeUpdate();
			f=true;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
		
	}

	public static void showALLStudent() {
		
        
		
		try {
			
			Connection con = CDB.createC();
			String q= "select * from student;";
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				
				int id=set.getInt(1);
				String name=set.getString(2);
				String dob=set.getString(3);
				String doj=set.getString(4);
				
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("DOB : "+dob);
				System.out.println("DOJ : "+doj);
				System.out.println("****************************************");
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}



	public static boolean updateStudent(int userID, Student ud) {

        boolean f=false;
		
		try {
			
			Connection con = CDB.createC();
			
			
			
			String q= "update student set student_name=?, student_dob=?, student_doj=?  where student_id=?";
			
			PreparedStatement upstmt = con.prepareStatement(q);	
			upstmt.setString(1, ud.getStudentName());
			upstmt.setDate(2, ud.getStudentDob());
			upstmt.setDate(3, ud.getStudentDoj());
			upstmt.setInt(4, userID);
				
			upstmt.executeUpdate();
			
			f=true;
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
	}

	
}
