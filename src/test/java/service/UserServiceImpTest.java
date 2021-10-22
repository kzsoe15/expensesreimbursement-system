package service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;

public class UserServiceImpTest {
UserService userServ = null;
	
	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		/*
		 * We would use before each to reset the initial conditions.
		 */
		System.out.println("--------------------before each--------------------");
		userServ = new UserServiceImp();
	}
	
	@Test
	void testUsernamePasswordShouldReturnTrue() throws Exception {
		boolean test = userServ.login("manager", "password");
		assertTrue(test);
	}
	
	@Test
	void testUsernamePasswordShouldReturnFalse() throws Exception {
		boolean test = userServ.login("manager", "wrongpassword");
		assertFalse(test);
	}
	
	@Test
	void testGetUserFromDbShouldReturnTrue() throws Exception {
		User test = userServ.getUserFromDb("manager", "password");
		assertNotNull(test);
	}
	
	@Test
	void testGetUserFromDbShouldReturnFalse() throws Exception {
		User test = userServ.getUserFromDb("manager", "wrongpassword");
		assertNull(test);
	}

}
