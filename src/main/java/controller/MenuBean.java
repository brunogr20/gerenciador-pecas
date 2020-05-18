package controller;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.UserLogged;
import session.Session;

@ManagedBean(name = "MenuBean")
@SessionScoped
@ApplicationScoped
public class MenuBean {

	private UserLogged userLogged;
	Session session= new Session();

	public void logoff() {
		session.getInstance().logoff();
		try {
		FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (Exception e) {
		System.out.println("Error logoff");
		}
	}

}
