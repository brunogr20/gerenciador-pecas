package entities;

public class Veiculo {
	
	private String placa;
	private String cpfUsuario;
	private String marca;
	private String modelo;
	private String chassi;
	private String descricao;
	private boolean status;
	
	public Veiculo() {}

	public Veiculo(String placa,String cpfUsuario, String marca, String modelo, String chassi, String descricao,boolean status) {
		this.placa = placa;
		this.cpfUsuario = cpfUsuario;
		this.marca = marca;
		this.modelo = modelo;
		this.chassi = chassi;
		this.descricao = descricao;
		this.status=status;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
	
	
	

}
