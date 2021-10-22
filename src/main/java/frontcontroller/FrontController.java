package frontcontroller;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class FrontController {
	Javalin app;
	Dispatcher dispatcher;

	///////////// CONSTRUCTOR
	/**
	 * 
	 * @param app
	 */
	public FrontController(Javalin app) {
		this.app = app; // configuration
		app.before("/api/*", FrontController::checkAllRequests); // checking if requests exist
		this.dispatcher = new Dispatcher(app);
	}

	/////////////// MIDDLEWARE LOGIC
	/*
	 * THIS is where you'd check to see if they are logged in, via checking their
	 * current session object and you'll see what role they are logged in as.
	 * 
	 * For example, employees shouldn't be able to trigger admin functionality just
	 * because they hardcoded the admin url into their browser.
	 * 
	 */

	/**
	 * @param context
	 */
	public static void checkAllRequests(Context context) {
//		System.out.println("In front controller!  " + context.path());
		if (context.path().equals("/api/user/login")) {
//			System.out.println("True");
			return;
		}

//		System.out.println("passed check point. my path is the same.");
		// check if the current user is null
		if (context.sessionAttribute("currentUser") == null) {
//			System.out.println("null");
			// redirect the current user to index page to login
			context.redirect("/index.html");
		}

	}
}
