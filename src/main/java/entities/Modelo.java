package entities;

public class Modelo {
	
	private Long id;
	private String nome;
	private boolean status;
	
	public Modelo() {}
	
	public Modelo(Long id, String nome, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
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
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
