package main;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import frontcontroller.FrontController;


public class MainDriver {
	final static Logger loggy = Logger.getLogger(MainDriver.class);

	public static void main(String[] args) {
		loggy.setLevel(Level.ALL);//all the levels
		/*
		 * start server on port 9001
		 */
		Javalin app = Javalin.create(config -> {
			config.addStaticFiles(staticFiles -> { 
				staticFiles.directory = "/"; 
				staticFiles.hostedPath = "/"; 
				staticFiles.location = Location.CLASSPATH;
			});
		}).start(9001);
		
		new FrontController(app);
	}

}
