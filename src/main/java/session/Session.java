package session;

import model.UserLogged;

public class Session {

	private static Session INSTANCE = new Session();

	private UserLogged userLogged = null;

	public static Session getInstance() {
		return INSTANCE;
	}

	public boolean isUserLogged() {
		if (this.userLogged == null) {
			return false;
		} else {
			return true;
		}
	}

	public UserLogged getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(UserLogged userLogged) {
		this.userLogged = userLogged;
	}

	public void logoff() {
		this.userLogged = null;
	}

}
