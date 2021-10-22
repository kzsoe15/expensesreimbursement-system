package model;

public class User {
	private int ersUsersID;
	private String ersUsername;
	private String ersPassword;
	private String usersFirstName;
	private String usersLastName; 
	private String usersEmail;
	private String userType;
	
	
	
	public User(int ersUsersID, String ersUsername, String ersPassword, String usersFirstName, String usersLastName,
			String usersEmail, String userType) {
		super();
		this.ersUsersID = ersUsersID;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.usersFirstName = usersFirstName;
		this.usersLastName = usersLastName;
		this.usersEmail = usersEmail;
		this.userType = userType;
	}

	public int getErsUsersID() {
		return ersUsersID;
	}
	public void setErsUsersID(int ersUsersID) {
		this.ersUsersID = ersUsersID;
	}
	public String getErsUsername() {
		return ersUsername;
	}
	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}
	public String getErsPassword() {
		return ersPassword;
	}
	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}
	public String getUsersFirstName() {
		return usersFirstName;
	}
	public void setUsersFirstName(String usersFirstName) {
		this.usersFirstName = usersFirstName;
	}
	public String getUsersLastName() {
		return usersLastName;
	}
	public void setUsersLastName(String usersLastName) {
		this.usersLastName = usersLastName;
	}
	public String getUsersEmail() {
		return usersEmail;
	}
	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "User [ersUsersID=" + ersUsersID + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", usersFirstName=" + usersFirstName + ", usersLastName=" + usersLastName + ", usersEmail="
				+ usersEmail + "]";
	}

}
