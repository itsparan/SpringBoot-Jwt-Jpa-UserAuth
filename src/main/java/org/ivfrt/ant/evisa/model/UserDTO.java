package org.ivfrt.ant.evisa.model;

import javax.persistence.Column;

public class UserDTO {
	private String username;
	private String password;
	private String useremail;
	private String usertype;
	private String user_regstration_id;


	public String getUseremail() {
			return useremail;
		}

		public void setUseremail(String useremail) {
			this.useremail = useremail;
		}

		public String getUsertype() {
			return usertype;
		}

		public void setUsertype(String usertype) {
			this.usertype = usertype;
		}

		public String getUser_regstration_id() {
			return user_regstration_id;
		}

		public void setUser_regstration_id(String user_regstration_id) {
			this.user_regstration_id = user_regstration_id;
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}