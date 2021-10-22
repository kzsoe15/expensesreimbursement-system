package controller;

import org.apache.log4j.Logger;

import io.javalin.http.Context;
import model.User;
import service.UserServiceImp;

public class UserController {
	private static UserServiceImp userServ = new UserServiceImp();
	private static final Logger loggy = Logger.getLogger(UserController.class);

	/**
	 * login with username and password
	 * 
	 * @param context
	 * @throws Exception
	 */
	public static void login(Context context) throws Exception {

		String username = context.formParam("myUsername");
		String password = context.formParam("myPassword");

		User user = userServ.getUserFromDb(username, password);

		if (user != null) {
			context.sessionAttribute("currentUser", user);

			if (((User) context.sessionAttribute("currentUser")).getUserType().equals("EMPLOYEE")) {
				loggy.info("current user is an employee");
				context.redirect("/html/employee.html");
			} else {
				loggy.info("current user is a manager");
				context.redirect("/html/manager.html");
			}
		} else {
			context.redirect("/index.html");
		}
	}

	/**
	 * logout and set current user session to null
	 * @param context
	 */
	public static void logout(Context context) {
		context.sessionAttribute("currentUser", null); 					
		loggy.info("The current user is null.");
		context.redirect("/index.html"); 
	}

}
