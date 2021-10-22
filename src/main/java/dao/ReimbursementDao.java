package dao;

import java.util.ArrayList;

import model.Reimbursement;



public interface ReimbursementDao {
	/**
	 * get reimbursement that belongs to user
	 *  
	 * @param id
	 * @return arraylist of Reimbursement object
	 */
	public ArrayList<Reimbursement> getUserReimbTickets(int id);
	
	/**
	 * create new reimb ticket for user
	 * 
	 * @param reimAmount
	 * @param reimDescription
	 * @param reimAuthor
	 * @param reimTypeId
	 * @return boolean
	 */
	public boolean createNewReimbTicket(int reimAmount, String reimDescription, int reimAuthor, 
			int reimTypeId);
	
	/**
	 * return all reimbursements 
	 * @return arraylist
	 */
	public ArrayList<Reimbursement> getAllReimbTickets();

	/**
	 * 
	 * @param reimbId
	 * @param reimbStatusId
	 * @param reimbResolver
	 * @return
	 */
	public boolean updateReimbTicket(int reimbId, int reimbStatusId, int reimbResolver);

}
