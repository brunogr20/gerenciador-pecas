package controller;

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
	private String loginRedirect = "calculadora.xhtml";

	private String txtCpf = "";
	private String txtSenha = "";

	public String getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(String txtCpf) {
		this.txtCpf = txtCpf;
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

	public String entrar() {
		
		if(this.getTxtCpf().isEmpty()) {
			this.alert("ATENCAO","Preecha o campo CPF!");
           return "";				
		}
		if(this.getTxtSenha().isEmpty()) {
			this.alert("ATENCAO","Preecha o campo senha!");
           return "";				
		}
		UsuarioDao usuarioDao = new UsuarioDao();
		ArrayList<Usuario> usuarios = usuarioDao.getInstance().getUsuarios();
		
		boolean existeUsario =false;
		System.out.println(usuarios.toString());
		for(Usuario u : usuarios){
			if(u.getCpf().equals(this.getTxtCpf())&&u.getSenha().equals(this.getTxtSenha())) {
				existeUsario=true;
			}
		}
		
		if(existeUsario==true) {
			this.alert("SUCCESSO","Usuario logado com sucesso!");
			return this.loginRedirect;
		}else {
			this.alert("ATENCAO","E-mail ou senha não encontrado!");
			return "";
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
