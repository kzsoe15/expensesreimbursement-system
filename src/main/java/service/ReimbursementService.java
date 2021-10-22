package service;

import java.util.HashMap;

import model.Reimbursement;

public interface ReimbursementService {
	/**
	 * @param reimbAmount
	 * @param reimbDescription
	 * @param reimbAuthor
	 * @param reimbTypeId
	 * @return
	 */
	public boolean createNewReimbTicket(int reimbAmount, String reimbDescription, int reimbAuthor, 
			int reimbTypeId);

	/**
	 * @param reimId
	 * @param reimStatus
	 * @param reimResolver
	 * @return
	 */
	boolean updateReimbTicket(int reimId, int reimStatus, int reimResolver);

	/**
	 * @return
	 */
	public HashMap<Integer,Reimbursement> getAllReimbTickets();

	/**
	 * @param id
	 * @return
	 */
	public HashMap<Integer,Reimbursement> getUserReimbTickets(int id);

}
