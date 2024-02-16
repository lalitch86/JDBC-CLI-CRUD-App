package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		// JDBC code ...
		try {
			Connection con = connectionProvider.CreateConnection();
			String query = "insert into students(sname,sphone,scity) values(?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.executeUpdate();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;

	}

	public static boolean deleteStudent(int sid) {
		boolean f = false;
		// JDBC code ...
		try {
			Connection con = connectionProvider.CreateConnection();
			String query = "delete from students where sid = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sid);

			pstmt.executeUpdate();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;

	}

	public static void showStudents() {

		// JDBC code ...
		try {
			Connection con = connectionProvider.CreateConnection();
			String query = "select * from students";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getString(4);
				System.out.println("Id : " + id);
				System.out.println("Name : " + name);
				System.out.println("Phone No : " + phone);
				System.out.println("City : " + city);
				System.out.println("====================================================");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Boolean updateStudent(Student st) {
		boolean f = false;
		// JDBC code ...
		try {
			Connection con = connectionProvider.CreateConnection();
			String q = "select count(*) from students where sid =" + st.getStudentID();
			q = q.toString();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			rs.next();
			if (rs.getInt(1) == 0) {
				f = false;
			} else {
				String query = "update students SET sname=?,sphone=?,scity=? where sid= ?";

				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, st.getStudentName());
				pstmt.setString(2, st.getStudentPhone());
				pstmt.setString(3, st.getStudentCity());
				pstmt.setInt(4, st.getStudentID());
				pstmt.executeUpdate();
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static Boolean checkId(int sid) {
		boolean f = false;
		// JDBC code ...
		try {
			Connection con = connectionProvider.CreateConnection();
			String q = "select count(*) from students where sid =" + sid;
			q = q.toString();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			rs.next();
			if (rs.getInt(1) == 1) {
				f = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;

	}

}
