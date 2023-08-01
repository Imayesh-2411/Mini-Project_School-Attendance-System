package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentAttendance {
	public int tid;
	public int studentId;
	public String studentName;
	public String className;
	public String section;
	public String date;
	public String attendanceStatus;
	
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public StudentAttendance(int tid, int studentId, String studentName, String className, String section, String date,
			String attendanceStatus) {
		super();
		this.tid = tid;
		this.studentId = studentId;
		this.studentName = studentName;
		this.className = className;
		this.section = section;
		this.date = date;
		this.attendanceStatus = attendanceStatus;
	}
	public StudentAttendance(int studentId,String attendanceStatus) {
		this.studentId = studentId;
		this.attendanceStatus = attendanceStatus;

	}

	public StudentAttendance(String studentName) {
		super();
		this.studentName = studentName;
	}

	public void addStudentAttendance() throws SQLException {
		String jdbcUrl = "jdbc:mysql://localhost/attendance";
        String username = "root";
        String password = "iniimay@2409";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        String sql = "INSERT INTO studentAttendance (tid,studentId,studentName,className,section,date,attendanceStatus) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        	statement.setInt(1, getTid());
            statement.setInt(2, getStudentId());
            statement.setString(3,getStudentName());
            statement.setString(4,getClassName());
            statement.setString(5,getSection());
            statement.setString(6, getDate());
            statement.setString(7,getAttendanceStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Added!");
	}
	 public void modifyStudentAttendance() throws SQLException {
		 	String jdbcUrl = "jdbc:mysql://localhost/attendance";
	        String username = "root";
	        String password = "iniimay@2409";
	        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	        String sql = "UPDATE studentAttendance SET attendanceStatus=? WHERE studentId=?";
	        try (PreparedStatement statement1 = connection.prepareStatement(sql)) {
	        	statement1.setString(1,getAttendanceStatus());
	            statement1.setInt(2, getStudentId());
	            statement1.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Modified!");
	 }
	 public void deleteStudentAttendance() throws SQLException {
		 	String jdbcUrl = "jdbc:mysql://localhost/attendance";
	        String username = "root";
	        String password = "iniimay@2409";
	        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	        String sql = "DELETE FROM student WHERE StudentName=?";
	        String sq = "DELETE FROM studentAttendance WHERE studentName=?";
	        try (PreparedStatement statement1 = connection.prepareStatement(sql)) {
	            statement1.setString(1, getStudentName());
	            statement1.executeUpdate();
	        }
	        try (PreparedStatement statement1 = connection.prepareStatement(sq)) {
	            statement1.setString(1, getStudentName());
	            statement1.executeUpdate();
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Deleted!");
		}
}
