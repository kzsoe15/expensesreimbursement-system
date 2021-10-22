package dao;

import model.User;

public interface UserDao {
	/**
	 * check if user is in user_table_view 
     * 
	 * @param username
	 * @param password
	 * @return boolean value 
	 */
	public boolean checkUser(String username, String password);
	
	
	/**
	 * get user details from user_table_view where the username and password matches the one provided by the user
	 * 
	 * @param username
	 * @param password
	 * @return User
	 */
	public User getUserFromDb(String username, String password) throws Exception ;



}
