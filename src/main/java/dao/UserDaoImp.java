package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import model.User;
import service.utils.MyConnectionFactory;

public class UserDaoImp implements UserDao {
	private static final Logger loggy = Logger.getLogger(UserDaoImp.class);

	@Override
	public boolean checkUser(String username, String password) {
		try (Connection conn = MyConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM user_table_view WHERE ers_username = ? AND ers_password = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				loggy.info("User exist.");
				return true;
			} else {
				loggy.error("User does not exist.");
				return false;
			}

		} catch (SQLException e) {
			loggy.error("SQL Error when checking for user in db: ", e);
			return false;
		}

	}
	
	@Override
	public User getUserFromDb(String username, String password) throws Exception {
		
		User user = null;
		
		try (Connection conn = MyConnectionFactory.getConnection()) {

			String sql = "SELECT * FROM user_table_view WHERE ers_username = ? AND ers_password = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery(); 
			if (rs.next()) {
				user = new User(rs.getInt("ers_users_id"), rs.getString("ers_username"), rs.getString("ers_password"),
						rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), rs.getString("user_role"));
			}
			loggy.info("Got user from database.");

		} catch (Exception e) {
			loggy.error("User does not exist in database error: ", e);
		}
		return user;
	}
}