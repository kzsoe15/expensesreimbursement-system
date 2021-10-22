package controller;

import org.apache.log4j.Logger;

import io.javalin.http.Context;
import model.User;
import service.ReimbursementService;
import service.ReimbursementServiceImp;

public class ReimbursementController {

	private static ReimbursementService myReimbServices = new ReimbursementServiceImp();
	private static final Logger loggy = Logger.getLogger(ReimbursementController.class);


	/**
	 * get all reimb tickets for manager
	 * 
	 * @param context
	 */
	public static void getAllReimbTickets(Context context) {
		//use the context.json to set the response which will be returned to the user.
		context.json(myReimbServices.getAllReimbTickets());
		loggy.info("getAllReimbTickets was called from ReimbursementController");
	}

	/**
	 * get reimb tickets for employee
	 * 
	 * @param context
	 */
	public static void getReimbTickets(Context context) { 
		int reimbAuthor = ((User) context.sessionAttribute("currentUser")).getErsUsersID();
		context.json(myReimbServices.getUserReimbTickets(reimbAuthor));
		loggy.info("Retrieved reimbursement tickes for employee.");
	}

	/**
	 * create new reimb ticket with employee input
	 * 
	 * @param context
	 */
	public static void createReimbTicket(Context context) {
		
		int reimbAmount = Integer.parseInt(context.formParam("reimbAmount"));
		int reimbAuthor = ((User) context.sessionAttribute("currentUser")).getErsUsersID();
		String reimbDes = context.formParam("reimbDes");
		int reimbType = Integer.parseInt(context.formParam("reimbType"));

		//System.out.println(reimbAmount +" " + reimbDes +" "+ reimbAuthor + " " + reimType);
		if (myReimbServices.createNewReimbTicket(reimbAmount, reimbDes, reimbAuthor, reimbType)) {
			context.redirect("/html/employee.html");
			loggy.info("Created a new reimbursement ticket for employee");
		}
	}

	/**
	 * update reimb ticket
	 * 
	 * @param context
	 */
	public static void updateReimbTicket(Context context) {
		int reimbId = Integer.parseInt(context.formParam("reimbId"));
		int reimbStatusId = Integer.parseInt(context.formParam("reimbStatusId"));
		int userId = ((User)context.sessionAttribute("currentUser")).getErsUsersID(); 

		if (myReimbServices.updateReimbTicket(reimbId, reimbStatusId, userId)) {
			context.redirect("/html/manager.html");
			loggy.info("The ticket has a been updated: " + myReimbServices.updateReimbTicket(reimbId, reimbStatusId, userId));

		}
	}

}
