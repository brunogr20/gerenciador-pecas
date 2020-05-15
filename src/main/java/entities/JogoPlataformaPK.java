package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JOGO_PLATAFORMA")
public class JogoPlataformaPK {
	
	@ManyToOne
	@JoinColumn(name = "ID_JOGO")
	private Jogo id_jogo;

	@ManyToOne
	@JoinColumn(name = "ID_PLATAFORMA")	
	private Plataforma id_plataforma;

	public Jogo getId_jogo() {
		return id_jogo;
	}

	public void setId_jogo(Jogo id_jogo) {
		this.id_jogo = id_jogo;
	}

	public Plataforma getId_plataforma() {
		return id_plataforma;
	}

	public void setId_plataforma(Plataforma id_plataforma) {
		this.id_plataforma = id_plataforma;
	}
	
	
	

}
