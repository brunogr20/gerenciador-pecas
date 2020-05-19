package entities;

import java.util.ArrayList;

public class Veiculo {
	
	private String placa;
	private String cpfUsuario;
	private Fabricante fabricante = new Fabricante();
	private String chassi;
	private String descricao;
	private boolean status;
	private ArrayList<String> idsPecas;
	
	public Veiculo() {}
	
	
    // consteutor dataTble
	public Veiculo(String placa,Fabricante fabricante, boolean status) {
		super();
		this.placa = placa;
		this.fabricante = fabricante;
		this.status = status;
	}

	public Veiculo(String placa,String cpfUsuario, Fabricante fabricante, String chassi, String descricao,boolean status,ArrayList<String> idsPecas) {
		this.placa = placa;
		this.cpfUsuario = cpfUsuario;
		this.fabricante = fabricante;
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

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
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
