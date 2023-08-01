package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Teacher {
	private String teacherName;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public Teacher(String teacherName) {
		super();
		this.teacherName = teacherName;
	}
	public Teacher() {
		
	}
	public void addTeacher() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost/attendance";
        String username = "root";
        String password = "iniimay@2409";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        String sql = "INSERT INTO teacher (teacherName) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, getTeacherName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Added!");
	}
	public void teacherAttendance() throws SQLException {
		System.out.println("1.To Add Teacher - Enter 'A' : ");
		System.out.println("2.To Add Teacher Attendance - Enter 'TA' : ");
		System.out.println("3.To Modify Teacher Attendance - Enter 'M' : ");
		System.out.println("4.To View Teacher Attendance - Enter 'V' : ");
		System.out.println("5.To Remove Teacher Attendance - Enter 'R' : ");
		Scanner scc=new Scanner(System.in); 
		String x=scc.nextLine();
		x=x.toUpperCase();
		switch(x) {
		case "V":
			System.out.print("Enter Teacher Name :");
			Scanner sc=new Scanner(System.in);
			String tName=sc.nextLine();
			sc.close();
			ViewTeacher vt=new ViewTeacher();
			vt.viewTeach(tName); 
			break;
		case "TA":
			System.out.print("Enter Teacher Name: ");
			String teName=scc.nextLine();
			System.out.print("FacultyId: ");
			int fid=scc.nextInt();
			scc.nextLine();
			System.out.print("Subject: ");
			String subject=scc.nextLine();
			System.out.print("AttendanceStatus: ");
			String attendanceStatus=scc.nextLine();
			System.out.print("Date: ");
			String date=scc.nextLine();
//			scc.close();
			TeacherAttendance ta=new TeacherAttendance(fid,teName,subject,attendanceStatus,date);
			ta.addTeacherAttendance();
			break;
		case "A":
			System.out.print("Enter Teacher Name: ");
			Scanner in=new Scanner(System.in);
			String Name=in.nextLine();
			in.close();
			this.teacherName=Name;
			addTeacher();
			break;
		case "M":
			modifyTAttendance();
			break;
		case "R":
			deleteTAttendance();
			break;
			
		}
	}
	
	public void studentAttendance(String m) throws SQLException {
		if(m.equals("A")) {
			Scanner in=new Scanner(System.in);
			System.out.print("Enter Student Id: ");
			int studentId=in.nextInt();
			in.nextLine();
			System.out.print("Enter Student Name: ");
			String studentName=in.nextLine();
			System.out.print("Enter Class: ");
			String className=in.nextLine();
			System.out.print("Enter Section: ");
			String section=in.nextLine();
			Student s=new Student(studentId,studentName,className,section);
			s.addStudent();
			
		}
		else {
			Scanner in=new Scanner(System.in);
			System.out.print("Enter Student Id: ");
			int studentId=in.nextInt();
			in.nextLine();
			System.out.print("Enter Student Name: ");
			String studentName=in.nextLine();
			System.out.print("Enter Class: ");
			String className=in.nextLine();
			System.out.print("Enter Section: ");
			String section=in.nextLine();
			System.out.print("Enter Teacher Id: ");
			int tid=in.nextInt();
			in.nextLine();
			System.out.print("Enter Date: ");
			String date=in.nextLine();
			
//			LocalDate myObj = LocalDate.now();
//			String date=myObj.toString();
//			System.out.println(myObj);
			System.out.print("Enter Attendance Status: ");
			String attendanceStatus=in.nextLine();
			StudentAttendance st=new StudentAttendance(tid,studentId,studentName,className,section,date,attendanceStatus);
			st.addStudentAttendance();
			
		}
	}
	public void modifyTAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Teacher Name: ");
		String teacherName=in.nextLine();
		System.out.print("Enter Attendance Status: ");
		String attendanceStatus=in.nextLine();
		in.close();
		TeacherAttendance st=new TeacherAttendance(teacherName,attendanceStatus);
		st.modifyTeacherAttendance();
			
	}
	public void deleteTAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Teacher Name: ");
		String teacherName=in.nextLine();
		in.close();
		TeacherAttendance st=new TeacherAttendance(teacherName);
		st.deleteTeacherAttendance();
			
	}
	
	public void modifySAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Student Id: ");
		int studentId=in.nextInt();
		in.nextLine();
		System.out.print("Enter Attendance Status: ");
		String attendanceStatus=in.nextLine();
		in.close();
		StudentAttendance st=new StudentAttendance(studentId,attendanceStatus);
		st.modifyStudentAttendance();
			
	}
	public void deleteSAttendance()throws SQLException{
		Scanner in=new Scanner(System.in);
		System.out.print("Enter Student Name: ");
		String studentName=in.nextLine();
		in.close();
		StudentAttendance st=new StudentAttendance(studentName);
		st.deleteStudentAttendance();
			
	}
	public void viewSAttendance()throws SQLException{
		ViewStudent v=new ViewStudent();
		v.viewStudentAttendance();
		
	}
	public void select() throws SQLException {		
		Scanner sc=new Scanner(System.in);
		System.out.print("For Student Details - Enter 'S' or For Teacher Details - Enter 'T' : ");
		String s=sc.nextLine();
		String str=s.toUpperCase();
		if(str.equals("S")) {
			System.out.println("1.To Add Student - Enter 'A' : ");
			System.out.println("2.To Add Student Attendance - Enter 'SA' : ");
			System.out.println("3.To Modify Student Attendance - Enter 'M' : ");
			System.out.println("4.To View Student Attendance - Enter 'V' : ");
			System.out.println("5.To Remove Student Attendance - Enter 'R' : ");
			String m=sc.nextLine().toUpperCase();
			if(m.equals("M")) {
				modifySAttendance();
			}
			else if(m.equals("V")) {
				viewSAttendance();
			}
			else if(m.equals("A")||m.equals("SA")) {
				studentAttendance(m);
				
			}
			else if(m.equals("R")) {
				deleteSAttendance();
			}
			else {
				System.out.println("Please enter valid keyword!");
				select();
			}
			
		}
		else if(str.equals("T")) {
			teacherAttendance();
		}
		else {
			System.out.println("Please enter valid keyword!");
			select();
		}
	}
}