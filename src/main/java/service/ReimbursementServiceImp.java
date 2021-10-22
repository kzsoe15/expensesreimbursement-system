package service;

import java.util.HashMap;
import java.util.List;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImp;
import model.Reimbursement;

public class ReimbursementServiceImp implements ReimbursementService{

	private ReimbursementDao reimbDao = new ReimbursementDaoImp();

	@Override
	public boolean createNewReimbTicket(int reimAmount, String reimDescription, int reimAuthor, int reimTypeId) {
		return (reimbDao.createNewReimbTicket(reimAmount, reimDescription, reimAuthor, reimTypeId));
	}

	@Override
	public HashMap<Integer,Reimbursement> getUserReimbTickets(int id) {
		List<Reimbursement> temp = reimbDao.getUserReimbTickets(id);
		HashMap<Integer,Reimbursement> storeReimbursement = new HashMap<Integer, Reimbursement>();
		if(temp == null) {
			return null;
		}else {
			for(Reimbursement reimb:temp) {
				storeReimbursement.put(reimb.getReimbId(), reimb);
			}
			return storeReimbursement;
		}
	}

	@Override
	public HashMap<Integer,Reimbursement> getAllReimbTickets() {
		List<Reimbursement> temp = reimbDao.getAllReimbTickets();
		HashMap<Integer,Reimbursement> storeReimbursement = new HashMap<Integer, Reimbursement>();
		if(temp == null) {
			return null;
		}else {
			for(Reimbursement reimb:temp) {
				storeReimbursement.put(reimb.getReimbId(), reimb);
			}
			return storeReimbursement;
		}
	}

	@Override
	public boolean updateReimbTicket(int reimId, int reimStatus, int reimResolver) {
		return reimbDao.updateReimbTicket(reimId, reimStatus, reimResolver);

	}




	

}
