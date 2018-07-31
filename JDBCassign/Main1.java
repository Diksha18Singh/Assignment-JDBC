package com.JDBCassign;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.ClientDriver";
		String url = "jdbc:derby://localhost:1527/sample";
		String user = "user";
		String pass = "pass";
		try (Connection con = ConnectionUtil.getConnection(driver, url, user, pass)) {
			Statement st = con.createStatement();
			CustomerDOA c = new CustomerDOA();
			st.execute(
					"CREATE TABLE Customer(id int primary key,firstName varchar(20),lastName varchar(20),email varchar(20))");
			st.execute(
					"CREATE TABLE Card(id int primary key,expiry Date,customer_id int,balance float,credit_limit float)");
			st.close();
			String date = "1/1/2018";
			// Date date1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(date);
			// Card c1=new Card(1, date1,2,10000,"100");
			// Customer cus = new CustomerDAO();
			Card c1 = new Card(1, java.sql.Date.valueOf("2018-01-01"), 2, 10000, 100);

			c.create(new Customer(100, "Diksha", "Singh", "Diksha@gmail.com"));
			c.create(new Customer(101, "Divya", "Singh", "Divya@gmail.com"));
			System.out.println(c.findById(101).toString());
			List<Customer> list = new ArrayList<>();
			list = c.findAll();
			Iterator<Customer> it = list.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().toString());
			}
			CardDOA ca = new CardDOA();
			ca.create(c1);
			System.out.println(ca.findById(1).toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
