package com.JDBCassign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDOA implements CommonDAO<Card> {
	private List<Card> cardlist = new ArrayList<Card>();
	private static final String SQL_SELECT_ID = "select id,expiry,customer_id,balance,credit_limit from Card where id=?";
	private static final String SQL_SELECT = "select * from Card";
	// private static final String SQL_DELETE = "delete from emp2 where
	// empid=?";
	private static final String SQL_INSERT = "insert into Card values(?,?,?,?,?)";

	@Override
	public void create(Card object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setInt(1, object.getId());
			ps.setDate(2, object.getExpiry());
			ps.setInt(3, object.getCustomer_id());
			ps.setFloat(4, object.getBalance());
			ps.setFloat(5, object.getCredit_limit());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Card findById(int id) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Card e = new Card();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setExpiry(rs.getDate(2));
				e.setCustomer_id((rs.getInt(3)));
				e.setBalance((rs.getFloat(4)));
				e.setCredit_limit((rs.getFloat(5)));
			}

			return e;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Card> findAll() {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);
			// ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Card card = new Card(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getFloat(4), rs.getFloat(5));
				cardlist.add(card);
			}

			return cardlist;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}
}

// @Override
// public List<Card> findAll() {
// try (Connection con = ConnectionUtil.getConnection()) {
// PreparedStatement ps = con.prepareStatement(SQL_SELECT);
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery();
// Card e = new Card();
// while (rs.next()) {
//
//
//
// return cardlist;
// } catch (SQLException ex) {
// ex.printStackTrace();
// return null;
// }
//
//
// }
// }
