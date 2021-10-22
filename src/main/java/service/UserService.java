package service;

import model.User;

public interface UserService {
	
	/**
	 * check if the username and password are in the database
	 * 
	 * @param username
	 * @param password
	 * @return user form the database
	 */
    public boolean login(String username, String password);

    /**
     * get the user from the database using their username and password
     * 
     * @param username
     * @param password
     * @return
     * @throws Exception 
     */
    public User getUserFromDb(String username, String password) throws Exception;

}
