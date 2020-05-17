package controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class GenericBean<Generic> {

	private String titleTabFrom = "Inserção";
	private int indexSelected;
	private boolean createItem = true;

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

}
