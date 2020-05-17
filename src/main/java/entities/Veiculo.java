package entities;

import java.util.ArrayList;

public class Veiculo {
	
	private String placa;
	private String cpfUsuario;
	private String fabricante;
	private String modelo;
	private String chassi;
	private String descricao;
	private boolean status;
	private ArrayList<String> idsPecas;
	
	public Veiculo() {}
	
	
    // consteutor dataTble
	public Veiculo(String placa, String fabricante, String modelo, boolean status) {
		super();
		this.placa = placa;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.status = status;
	}

	public Veiculo(String placa,String cpfUsuario, String fabricante, String modelo, String chassi, String descricao,boolean status,ArrayList<String> idsPecas) {
		this.placa = placa;
		this.cpfUsuario = cpfUsuario;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.chassi = chassi;
		this.descricao = descricao;
		this.status=status;
		this.idsPecas=idsPecas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ArrayList<String> getIdsPecas() {
		return idsPecas;
	}

	public void setIdsPecas(ArrayList<String> idsPecas) {
		this.idsPecas = idsPecas;
	}
		

}
