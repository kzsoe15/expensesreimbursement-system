package frontcontroller;

import static io.javalin.apibuilder.ApiBuilder.*; //this is where "path" came from

import org.apache.log4j.Logger;

import controller.ReimbursementController;
import controller.UserController;
import io.javalin.Javalin;

public class Dispatcher {
	private static final Logger loggy = Logger.getLogger(Dispatcher.class);
	/**
	 * setup all the paths 
	 * 
	 * @param app
	 */
	public Dispatcher(Javalin app) {
		setupAllPaths(app);
	}

	public static void setupAllPaths(Javalin app) {
		setupUserControllerPaths(app);
		setUpReimbursementControllerPaths(app);
	}

	
	/**
	 * user paths
	 * 
	 * @param app
	 */
	public static void setupUserControllerPaths(Javalin app) {
		app.routes(()->{
			path("/api/user", ()->{
				path("/login", ()->{
					loggy.info("APOST request for /api/user/login.");
					post(UserController::login);
				});
				path("/logout", ()->{
					loggy.info("GET request for /api/user/logout.");
					get(UserController::logout);
				});
			});
		});
	}
	
	/**
	 * reimbursement paths
	 * 
	 * @param app
	 */
	public static void setUpReimbursementControllerPaths(Javalin app) {
		app.routes(()->{
			path("/user/employee/reimb", ()->{ 
				loggy.info("GET request for /user/employee/reimb.");
				get(ReimbursementController::getReimbTickets);
				path("/create", ()->{
					loggy.info("POST request for /user/employee/reimb/create.");
					post(ReimbursementController::createReimbTicket);
				});	
			});
			path("/user/manager/reimb", ()->{
				loggy.info("GET request for /user/manager/reimb.");
				get(ReimbursementController::getAllReimbTickets);
				path("/update", ()->{
					loggy.info("POST request for /user/manager/reimb/update.");
					post(ReimbursementController::updateReimbTicket);
				});
				
			});
		});
	}

}
