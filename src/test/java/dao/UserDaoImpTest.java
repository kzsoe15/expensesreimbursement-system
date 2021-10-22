package dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;


public class UserDaoImpTest {
	UserDao userDao = null;


	@BeforeEach
	void intializeReimbDao() throws Exception {
		System.out.println("--------------------before each--------------------");
		userDao = new UserDaoImp();
	}


	@Test
	void testUsernamePasswordShouldReturnUserFound() throws Exception {
		User userTest = userDao.getUserFromDb("manager", "password");
		assertNotNull(userTest);
		assertEquals("manager", userTest.getErsUsername()); 
		assertEquals(true, userTest.getErsUsername().equalsIgnoreCase("manager")); 
		assertTrue(userTest.getErsUsername().equalsIgnoreCase("manager")); 
		assertFalse(userTest.getErsUsername().equalsIgnoreCase(""));

		
	}

	
	@Test
	void testUserNamePasswordEmptyShouldReturnNull() throws Exception {
		User userTest = userDao.getUserFromDb("", "");
		assertNull(userTest);
	}
	
	@Test
	void testUsernamePasswordEnteredShouldReturnTrue() throws Exception {
		boolean test = userDao.checkUser("manager", "password");
		assertTrue(test);
	}

	@Test
	void testUsernamePasswordEnteredShouldReturnFalse() throws Exception {
		boolean test = userDao.checkUser("manager", "wrongpassword");
		assertFalse(test);
	}
	

}
