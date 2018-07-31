package com.JDBCassign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDOA implements CommonDAO<Customer> {

	private List<Customer> cardlist = new ArrayList<Customer>();
	private static final String SQL_SELECT_ID = "select id, firstname, lastname, email from Customer where id=?";
	private static final String SQL_SELECT = "select * from Customer";
	// private static final String SQL_DELETE = "delete from emp2 where
	// empid=?";
	private static final String SQL_INSERT = "insert into Customer(id, firstname, lastname, email) values(?,?,?,?)";

	@Override
	public void create(Customer object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setInt(1, object.getId());
			ps.setString(2, object.getFirstname());
			ps.setString(3, object.getLastname());
			ps.setString(4, object.getEmail());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Customer findById(int id) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Customer e = new Customer();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setFirstname(rs.getString(2));
				e.setLastname((rs.getString(3)));
				e.setEmail((rs.getString(4)));

			}

			return e;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Customer> findAll() {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			// ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Customer card = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				cardlist.add(card);
			}

			return cardlist;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

}
