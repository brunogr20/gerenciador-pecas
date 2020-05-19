package entities;

import java.util.ArrayList;

public class Fabricante {

	private Long id;
	private String nome;
	private boolean status;
	
	private Modelo modelo;

	public Fabricante() {
		this.modelo = new Modelo();
	}
	
	public Fabricante(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Fabricante(Long id, String nome,Modelo modelo, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.modelo = modelo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	
}
