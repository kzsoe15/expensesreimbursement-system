package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Reimbursement;

public class ReimbursementDaoImpTest {

	ReimbursementDao reimDao = null;

	@BeforeEach
	void setUpAndIntializeReimDAO() throws Exception {
		System.out.println("--------------------before each--------------------");
		reimDao = new ReimbursementDaoImp();
	}

	@Test
	void testGetUserReimbTicketsNotNullTest() {
		List<Reimbursement> reimbTest = reimDao.getUserReimbTickets(1);
		assertNotNull(reimbTest);
	}

	@Test
	void testGetUserReimbTicketsIsEmptyTest() {
		List<Reimbursement> reimbTest = reimDao.getUserReimbTickets(-1);
		boolean emptyList;
		emptyList = reimbTest.size() == 0;
		assertTrue(emptyList);
	}

	@Test
	void testGetAllReimbTicketsNotNullTest() {
		List<Reimbursement> reimbTest = reimDao.getAllReimbTickets();
		assertNotNull(reimbTest);
	}

	@Test
	void testGetAllReimbTicketsIsEmptyTest() {
		List<Reimbursement> reimbTest = reimDao.getAllReimbTickets();
		boolean emptyList;
		emptyList = reimbTest.size() == 0;
		assertFalse(emptyList);
	}

	@Test
	void testAmountDescriptionAuthorTypeIdEnteredShouldReturnTrue() throws Exception {
		boolean test = reimDao.createNewReimbTicket(100, "something", 1, 2);
		assertTrue(test);
	}

	@Test
	void testReimIdStatusResolverAreEnteredShouldReturnTrue() throws Exception {
		boolean test = reimDao.updateReimbTicket(1, 2, 3);
		assertTrue(test);
	}

}
