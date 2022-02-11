import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import student.manage.Student;
import student.manage.StudentDao;

public class Start {
	
	public static void main(String[] args)throws IOException, ParseException{
		System.out.println("Welcome to Student CURD Operation ");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("PRESS 1 to ADD Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("PRESS 3 to Display Student");
			System.out.println("PRESS 4 to Update Student");
			System.out.println("PRESS 5 to Exit Student");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1) {
				
				System.out.print("Enter Student Name : ");
				String name=br.readLine();
				
				System.out.print("Enter Student DOB : ");
				String dob=br.readLine();
				
				System.out.print("Enter Student DOJ : ");
				String doj=br.readLine();
				
				//convert String date value to java.lang.Date class
		          //for date of birth
		          SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
		          java.util.Date udob = sdf1.parse(dob);
		          java.sql.Date sqdob = new java.sql.Date(udob.getTime());
		          //for date of joining(yyyy-mm-dd)
		          java.sql.Date sqdoj = java.sql.Date.valueOf(doj);
				
				Student st = new Student(name, sqdob, sqdoj);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}else
				{
					System.out.println("Something went worng try again...");
				}
				System.out.println(st);
				
			}else if(c==2) {
				//delete
				System.out.print("Enter student ID to delete : ");
				int userID=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userID);
				if(f) {
					System.out.println("Deleted successfully...");
				}else
				{
					System.out.println("Something went worng try again...");
				}
				
			}else if(c==3) {
				//display
				
				StudentDao.showALLStudent();
				
				
			}else if(c==4) {
				//update
				System.out.print("Enter student ID to update : ");
				int userID=Integer.parseInt(br.readLine());
				
				
				System.out.print("Enter New Student Name : ");
				String name=br.readLine();
				
				System.out.print("Enter New Student DOB : ");
				String dob=br.readLine();
				
				System.out.print("Enter New Student DOJ : ");
				String doj=br.readLine();
				
				//convert String date value to java.lang.Date class
		          //for date of birth
		          SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yy");
		          java.util.Date udob = sdf1.parse(dob);
		          java.sql.Date sqdob = new java.sql.Date(udob.getTime());
		          //for date of joining(yyyy-mm-dd)
		          java.sql.Date sqdoj = java.sql.Date.valueOf(doj);
				
				Student ud = new Student(name, sqdob, sqdoj);
				boolean f = StudentDao.updateStudent(userID, ud);
				
				if(f) {
					System.out.println("Updated successfully...");
				}else
				{
					System.out.println("Something went worng try again...");
				}
				
			}else if(c==5) {
				break;
			}
			
		}
	}

}
