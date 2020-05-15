package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USUARIO")
public class Usuario {
    @Id
    @Column(name="CPF")
	private String cpf;
    
    @Column(name="NOME")
	private String nome;
    
    @Column(name="EMAIL")
	private String email;
    
    @Column(name="SEXO")
	private String sexo;
    
    @Column(name="SENHA")
	private String senha;
	
	
	public Usuario(String nome,String cpf, String email, String sexo, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.sexo = sexo;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
