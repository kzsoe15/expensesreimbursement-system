package service;

import org.apache.log4j.Logger;

import controller.UserController;
import dao.UserDao;
import dao.UserDaoImp;
import model.User;

public class UserServiceImp implements UserService {
	
private static final Logger loggy = Logger.getLogger(UserController.class);
	
    private UserDao userDao = new UserDaoImp();
    private User myUser;

   
    public boolean login(String username, String password) {
    	if(userDao.checkUser(username, password)){
    		loggy.info("User login");
        	return true;
        }else {
        	loggy.error("Error: cannot find user in db.");
        	return false;
        }
    }

    @Override
    public User getUserFromDb(String username, String password) throws Exception {
        User temp = userDao.getUserFromDb(username, password);
        if (temp == null) {
            return null;
        } else {
            myUser = temp;
        }
        return myUser;
    }

}
