package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Reimbursement {
	
	private int reimbAmount;
	private Timestamp reimbDateSubmitted;
	private Timestamp reimbDateResolved;
	private String reimbDescription;
	private int authorId;
	private int resolverId;
	private int reimbId;
	private String authorName;
	private String resolverName;
	private String status;
	private String type;
	private String submitDate = "";
	private String resolvedDate = "";
	
	public Reimbursement(int reimbId, int reimbAmount, Timestamp reimbDateSubmitted, Timestamp reimbDateResolved,
			String reimbDescription, int authorId, String authorName, int resolverId, String resolverName, String status, String type) {
		
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDateSubmitted = reimbDateSubmitted;
		this.reimbDateResolved = reimbDateResolved;
		this.reimbDescription = reimbDescription;
		this.authorId = authorId;
		this.authorName = authorName;
		this.resolverId = resolverId;
		this.resolverName = resolverName;
		this.status = status;
		this.type = type ;
		this.submitDate = new SimpleDateFormat("MM/dd/yyyy").format(reimbDateSubmitted);
		if(null != reimbDateResolved) 	this.resolvedDate = new SimpleDateFormat("MM/dd/yyyy").format(reimbDateResolved); 
	}

	
	public int getReimAmount() {
		return reimbAmount;
	}
	public void setReimAmount(int reimAmount) {
		this.reimbAmount = reimAmount;
	}
	public Timestamp getReimDateSubmitted() {
		return reimbDateSubmitted;
	}
	public void setReimDateSubmitted(Timestamp reimDateSubmitted) {
		this.reimbDateSubmitted = reimDateSubmitted;
	}
	public Timestamp getReimDateResolved() {
		return reimbDateResolved;
	}
	public void setReimDateResolved(Timestamp reimDateResolved) {
		this.reimbDateResolved = reimDateResolved;
	}
	public String getReimDescription() {
		return reimbDescription;
	}
	public void setReimDescription(String reimDescription) {
		this.reimbDescription = reimDescription;
	}
	public int getAuthor() {
		return authorId;
	}
	public void setAuthor(int author) {
		this.authorId = author;
	}
	public int getResolver() {
		return resolverId;
	}
	public void setResolver(int resolver) {
		this.resolverId = resolver;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getResolverName() {
		return resolverName;
	}
	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimAmount=" + reimbAmount + ", reimDescription=" + reimbDescription + ", author=" + authorId
				+ ", resolver=" + resolverId + ", reimId=" + reimbId + ", authorName=" + authorName + ", resolverName="
				+ resolverName + ", status=" + status + ", type=" + type + ", submitDate=" + submitDate
				+ ", resolvedDate=" + resolvedDate + "]";
	}

}
