package student.manage;

import java.sql.Date;

public class Student {

	private int studentId;
	private String studentName;
	private Date studentDob;
	private Date studentDoj;
	
	public Student(int studentId, String studentName, Date studentDob, Date studentDoj) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDob = studentDob;
		this.studentDoj = studentDoj;
	}

	public Student(String studentName, Date sqdob, Date sqdoj) {
		super();
		this.studentName = studentName;
		this.studentDob = sqdob;
		this.studentDoj = sqdoj;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getStudentDob() {
		return studentDob;
	}

	public void setStudentDob(Date studentDob) {
		this.studentDob = studentDob;
	}

	public Date getStudentDoj() {
		return studentDoj;
	}

	public void setStudentDoj(Date studentDoj) {
		this.studentDoj = studentDoj;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDob=" + studentDob
				+ ", studentDoj=" + studentDoj + "]";
	}
	
	
	

}
