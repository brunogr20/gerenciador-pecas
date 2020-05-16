package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.script.*;
import dao.UsuarioDao;
import entities.Usuario;

@ManagedBean(name = "LoginBean")
@SessionScoped

public class LoginBean implements Serializable {

	private boolean exibirCadastro = false;
	private String loginRedirect = "livros.xhtml";

	private String txtEmail = "";
	private String txtSenha = "";

	public String getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail = txtEmail;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public boolean getExibirCadastro() {
		return exibirCadastro;
	}

	public void setExibirCadastro(boolean exibirCadastro) {
		this.exibirCadastro = exibirCadastro;
	}

	public boolean entrar() throws IOException {
		
		if(this.getTxtEmail().isEmpty()) {
			this.alert("ATENCAO","Preecha o campo e-mail!");
           return false;				
		}
		if (this.getTxtEmail().indexOf("@")<1) {
			this.alert("ATENCAO", "O e-mail é inválido!");
			return false;
		}
		if(this.getTxtSenha().isEmpty()) {
			this.alert("ATENCAO","Preecha o campo senha!");
           return false;				
		}
		UsuarioDao usuarioDao = new UsuarioDao();
		
		if(usuarioDao.login(this.getTxtEmail(),this.getTxtSenha())) {
			this.alert("SUCCESSO","Usuario logado com sucesso!");
			FacesContext.getCurrentInstance().getExternalContext().redirect(this.loginRedirect);
			this.setTxtEmail("");
			this.setTxtSenha("");
			return true;
		}else {
			this.alert("ATENCAO","E-mail ou senha não encontrado!");
			return false;
		}
		
		
	}

	public void toggleExibicao() {
		if (this.exibirCadastro == true) {
			this.exibirCadastro = false;
		} else {
			this.exibirCadastro = true;
		}
	}

	public void alert(String tipo, String msg) {

		if (tipo == "SUCCESSO") {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg));
		} else if (tipo == "ATENCAO") {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", msg));
		}
	}

}
