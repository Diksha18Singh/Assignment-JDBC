package com.JDBCex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.JDBCassign.ConnectionUtil;

public class Main2 {

	public static void main(String[] args) {

		String driver = "org.apache.derby.jdbc.ClientDriver";
		String url = "jdbc:derby://localhost:1527/sample";
		String user = "user";
		String pass = "pass";

		try (Connection con = ConnectionUtil.getConnection(driver, url, user, pass)) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT);

			while (rs.next()) {
				City city = convertResults(rs);
				System.out.println("Name" + city.getName() + "Population" + city.getPopulation());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
