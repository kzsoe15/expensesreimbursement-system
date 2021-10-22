package dao;

import java.util.ArrayList;
import org.apache.log4j.Logger;

import model.Reimbursement;
import service.utils.MyConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReimbursementDaoImp implements ReimbursementDao {
	private static final Logger loggy = Logger.getLogger(ReimbursementDao.class);

	@Override
	public ArrayList<Reimbursement> getUserReimbTickets(int id) {

		ArrayList<Reimbursement> myReimbs = new ArrayList<Reimbursement>();
		try (Connection conn = MyConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM reimb_table_view WHERE reimb_author = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myReimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getString("author_name"),
						rs.getInt("reimb_resolver"), rs.getString("resolver_name"), rs.getString("reimb_status"), rs.getString("reimb_type")));
			}
			loggy.info("Number of tickets returned: " + myReimbs.size());
			return myReimbs;
		} catch (SQLException e) {
			loggy.error("Sorry, unable to get user tickets from the DB", e);
			return null;
		}
	}

	@Override
	public boolean createNewReimbTicket(int reimbAmount, String reimbDescription, int reimbAuthor, int reimbTypeId) {

		try (Connection conn = MyConnectionFactory.getConnection()) {
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, 1, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimbAmount);
			ps.setString(2, reimbDescription);
			ps.setInt(3, reimbAuthor);
			ps.setInt(4, reimbTypeId);
			ps.executeUpdate();
			loggy.info("Created new ticket for " + reimbAuthor);
		} catch (SQLException e) {
			loggy.error("Failed to create ticket in the Db: ", e);
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbTickets() {
		ArrayList<Reimbursement> allReimbs = new ArrayList<Reimbursement>();
		try (Connection conn = MyConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM reimb_table_view";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				allReimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"), rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"), rs.getInt("reimb_author"), rs.getString("author_name"),
						rs.getInt("reimb_resolver"), rs.getString("resolver_name"), rs.getString("reimb_status"), rs.getString("reimb_type")));

			}
			loggy.info("Retrieved got all tickets.");
			return allReimbs;

		} catch (SQLException e) {
			loggy.error("Failed to get all tickets from the Db: ", e);
			return null;
		}

	}

	@Override
	public boolean updateReimbTicket(int reimId, int reimStatusId, int reimResolver) {
		try (Connection conn = MyConnectionFactory.getConnection()) {
			
			String sql = "UPDATE ers_reimbursement SET reimb_resolved = now() , reimb_status_id = ?, reimb_resolver = ? WHERE reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(3, reimId);
			ps.setInt(1, reimStatusId);
			ps.setInt(2, reimResolver);
			ps.executeUpdate();

			loggy.info("Updated ticket: " + reimId);

		} catch (SQLException e) {
			// e.printStackTrace();
			loggy.error("Failed to update the Db: ", e);
			return false;
		}
		return true;
	}
}
