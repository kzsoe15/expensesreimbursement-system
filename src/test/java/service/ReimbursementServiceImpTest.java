package service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Reimbursement;

public class ReimbursementServiceImpTest {
ReimbursementService reimbServ = null;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		/*
		 * We would use before each to reset the initial conditions.
		 */
		System.out.println("--------------------before each--------------------");
		reimbServ = new ReimbursementServiceImp();
	}
	
	@Test
	void testGetUserReimbTicketsNotNullTest() {
		HashMap<Integer,Reimbursement> test = reimbServ.getUserReimbTickets(1);
		assertNotNull(test);
	}
	
	@Test
	void testGetUserReimbTicketsDoesNotExistTest() {	
		HashMap<Integer,Reimbursement> test = reimbServ.getUserReimbTickets(-1);
		boolean empty;
		empty = test.size() == 0;
		assertTrue(empty);
	}
	
	@Test
	void getAllTicketsNotNullTest() {
		HashMap<Integer,Reimbursement> test = reimbServ.getAllReimbTickets();
		assertNotNull(test);
	}
	
	@Test
	void getAllTicketsIsEmptyTest() {	
		HashMap<Integer,Reimbursement> test = reimbServ.getAllReimbTickets();
		boolean empty;
		empty = test.size() == 0;
		assertTrue(empty);
	}

}
