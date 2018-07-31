package com.JDBCex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {

	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.ClientDriver";
		String url = "jdbc:derby://localhost:1527/sample";
		String user = "user";
		String pass = "pass";

		try (Connection con = ConnectionUtil.getConnection(driver, url, user, pass)) {
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			System.out.println("Before delete");
			readEmp(st);
			deleteEmp(st);
			System.out.println("Before delete");
			readEmp(st);
			con.rollback(st);
			System.out.println("After rollback");
			readEmp(st);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void readEmp(Statement st) throws SQLException {
		ResultSet rs = st.executeQuery("select * from emp2");
		while (rs.next()) {
			System.out.print("Record found: ");
			System.out.println("Ename : " + rs.getString("ename"));
		}
	}

}
