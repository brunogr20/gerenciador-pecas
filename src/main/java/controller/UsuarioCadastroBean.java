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

	@ManagedBean(name = "UsuarioCadastroBean")
	@SessionScoped

	public class UsuarioCadastroBean implements Serializable{
		
		private String txtNome = "";
		private String txtCpf = "";
		private String txtEmail = "";
		private String txtSexo = "";
		private String txtSenha = "";
		private String txtConfSenha = "";
		
		
		public String getTxtNome() {
			return txtNome;
		}

		public void setTxtNome(String txtNome) {
			this.txtNome = txtNome;
		}
		
		public String getTxtCpf() {
			return txtCpf;
		}

		public void setTxtCpf(String txtCpf) {
			this.txtCpf = txtCpf;
		}


		public String getTxtEmail() {
			return txtEmail;
		}

		public void setTxtEmail(String txtEmail) {
			this.txtEmail = txtEmail;
		}

		public String getTxtSexo() {
			return txtSexo;
		}

		public void setTxtSexo(String txtSexo) {
			this.txtSexo = txtSexo;
		}

		public String getTxtSenha() {
			return txtSenha;
		}

		public void setTxtSenha(String txtSenha) {
			this.txtSenha = txtSenha;
		}

		public String getTxtConfSenha() {
			return txtConfSenha;
		}

		public void setTxtConfSenha(String txtConfSenha) {
			this.txtConfSenha = txtConfSenha;
		}
		
		public boolean cadastrarUsuario() {
			if(this.getTxtNome().isEmpty()) {
				this.alert("ATENCAO","Preecha o campo nome!");
               return false;				
			}
			if(this.getTxtCpf().isEmpty()) {
				this.alert("ATENCAO","Preecha o campo CPF!");
               return false;				
			}
			if(this.getTxtEmail().isEmpty()) {
				this.alert("ATENCAO","Preecha o campo e-mail!");
               return false;				
			}
			if(this.getTxtSexo().isEmpty()) {
				this.alert("ATENCAO","Preecha o campo sexo!");
               return false;				
			}
			if(this.getTxtSenha().isEmpty()) {
				this.alert("ATENCAO","Preecha o campo senha!");
               return false;				
			}
			if(this.getTxtConfSenha().isEmpty()) {
				this.alert("ATENCAO","Preecha o campo confirmar senha!");
               return false;				
			}
			if(this.getTxtSenha().equals(this.getTxtConfSenha())!=true) {
				this.alert("ATENCAO","O campo confirmar senha deve ser igual ao da senha!");
               return false;				
			}
			
			UsuarioDao usuarioDao = new UsuarioDao();
			ArrayList<Usuario> usuarios = usuarioDao.getInstance().getUsuarios();
			boolean existeUsario=false;
			for(Usuario u : usuarios){
				if(u.getCpf().equals(this.getTxtCpf())) {
					existeUsario=true;
				}
			}
			
			if(existeUsario==true) {
				this.alert("ATENCAO","Já existe um usuário cadastro com esse CPF!");
	               return false;
			}
			
			
			Usuario usuario = new Usuario(this.getTxtNome(),this.getTxtCpf(),this.getTxtEmail(),this.getTxtSexo(),this.getTxtSenha());
			
			usuarioDao.getInstance().criarUsuario(usuario);
			
			this.limparCampos();
			this.alert("SUCCESSO","Cadastro realizado com sucesso!");
			return true;
		
		}
		
		public void limparCampos() {
			this.setTxtNome("");
			this.setTxtEmail("");
			this.setTxtSexo("");
		}
		
		public void alert(String tipo,String msg) {
			
			if(tipo=="SUCCESSO"){
			   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "",msg));   			     
			}else if(tipo=="ATENCAO") {
			   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "",msg));   
			}
		}



	}

