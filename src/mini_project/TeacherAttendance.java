package mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherAttendance {
	public int fid;
	public String teacherName;
	public String subject;
	public String attendanceStatus;
	public String date;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAttendanceStatus() {
		return attendanceStatus;
	}
	public void setAttendanceStatus(String attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TeacherAttendance(int fid, String teacherName, String subject, String attendanceStatus, String date) {
		super();
		this.fid = fid;
		this.teacherName = teacherName;
		this.subject = subject;
		this.attendanceStatus = attendanceStatus;
		this.date = date;
	}
	
	public TeacherAttendance(String teacherName) {
		super();
		this.teacherName = teacherName;
	}
	public TeacherAttendance(String teacherName, String attendanceStatus) {
		super();
		this.teacherName = teacherName;
		this.attendanceStatus = attendanceStatus;
	}
	public void addTeacherAttendance() throws SQLException {
		
		String jdbcUrl = "jdbc:mysql://localhost/attendance";
		String username = "root";
		String password = "iniimay@2409";
		Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
		String sql = "INSERT INTO teacherAttendance VALUES (?,?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, getFid());
			statement.setString(2,getTeacherName());
			statement.setString(3,getSubject());
			statement.setString(4,getAttendanceStatus());
			statement.setString(5, getDate());
//            statement.setBoolean(3, attendance.isPresent());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Added!");
	}
	public void modifyTeacherAttendance() throws SQLException {
	 	String jdbcUrl = "jdbc:mysql://localhost/attendance";
        String username = "root";
        String password = "iniimay@2409";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        String sql = "UPDATE teacherAttendance SET attendanceStatus=? WHERE teacherName=?";
        try (PreparedStatement statement1 = connection.prepareStatement(sql)) {
        	statement1.setString(1,getAttendanceStatus());
            statement1.setString(2, getTeacherName());
            statement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Modified!");
	}
	public void deleteTeacherAttendance() throws SQLException {
	 	String jdbcUrl = "jdbc:mysql://localhost/attendance";
        String username = "root";
        String password = "iniimay@2409";
        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
        String sql = "DELETE FROM teacher WHERE teacherName=?";
        String sq = "DELETE FROM teacherAttendance WHERE teacherName=?";
        try (PreparedStatement statement1 = connection.prepareStatement(sql)) {
            statement1.setString(1, getTeacherName());
            statement1.executeUpdate();
        }
        try (PreparedStatement statement1 = connection.prepareStatement(sq)) {
            statement1.setString(1, getTeacherName());
            statement1.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted!");
	}
}
