package controller;

import java.io.IOException;
import java.util.List;
import session.Session;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.UserLogged;

public class GenericBean<Generic> {

	private String titleTabFrom = "Inserção";
	private int indexSelected;
	private boolean createItem = true;
	private UserLogged userLogged;

	Session session;

	public GenericBean() {
		session = new Session();
		this.isLogged();
		this.userLogged = session.getInstance().getUserLogged();
	}

	/*
	 * função usada em globalFilterFunction
	 **/
	public int getInteger(String string) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	public void addMessage(String type, String msg) {
		if (type == "SUCCESS") {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else if (type == "WARNING") {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "", msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else if (type == "ERROR") {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public boolean isLogged() {
		boolean status = true;
		try {
			if (!session.getInstance().isUserLogged()) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
				status = false;
			}
		} catch (Exception e) {
			status = false;
		}

		return status;
	}

	public UserLogged getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(UserLogged userLogged) {
		this.userLogged = userLogged;
	}

	public String getTitleTabFrom() {
		return titleTabFrom;
	}

	public void setTitleTabFrom(String titleTabFrom) {
		this.titleTabFrom = titleTabFrom;
	}

	public int getIndexSelected() {
		return indexSelected;
	}

	public void setIndexSelected(int indexSelected) {
		this.indexSelected = indexSelected;
	}

	public boolean isCreateItem() {
		return createItem;
	}

	public void setCreateItem(boolean createItem) {
		this.createItem = createItem;
	}

}
