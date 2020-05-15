package entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity(name="JOGO")
public class Jogo {
	
    @Id
    @Column(name="ID")
	private int id;
    
    @Column(name="NOME")
	private String nome;
    
    @Column(name="TAMANHO")
	private double tamanho;
    
    @Column(name="DESCRICAO")
	private String descricao;
    
    @ManyToMany(mappedBy = "jogos")
	private List plataformas;
	
	public Jogo(){}
	
	public Jogo(int id, String nome,double tamanho, String descricao/*,List<Plataforma> plataformas*/) {
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
		this.descricao = descricao;
		//this.plataformas = plataformas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/*public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}*/
	
	

}
