package service.utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class MyConnectionFactory {
	private static final Logger loggy = Logger.getLogger(MyConnectionFactory.class);

	// CONNECT TO THE DATABASE BY USING URL, USERNAME, PASSWORD
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static final String URL = "";

	public static Connection getConnection() throws SQLException {
		loggy.info("Connection established to connect to the Database.");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

}
