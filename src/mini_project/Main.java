package mini_project;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void role() throws SQLException {	
		System.out.print("Enter The Role(Teacher or Student) : ");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String str=s.toLowerCase();
		if(str.equals("teacher")) {
			Teacher t=new Teacher();
			t.select();
			sc.close();
		}
		else if(str.equals("student")){
			Scanner in=new Scanner(System.in);
			System.out.print("Enter Your Name: ");
			String studentName=in.nextLine();
			ViewStudent v=new ViewStudent(studentName);
			v.vStudent();
		}
		else {
			System.out.println("Please enter correct keyword!");
			role();
		}
	}
	public static void main(String args[]) throws SQLException {
		role();
	}
}
