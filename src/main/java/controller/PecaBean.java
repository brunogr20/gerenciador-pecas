package controller;

import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.PecaDao;
import entities.Peca; 

@ManagedBean(name = "PecaBean")
@SessionScoped
@ApplicationScoped
public class PecaBean extends GenericBean {

	private List<Peca> pecas;
	private List<Peca> filteredItens;
	private Peca peca;

	PecaDao pecaDao;

	public PecaBean(){
		pecaDao = new  PecaDao();
		
		this.peca = new Peca();
		this.loadGrid();     	        
	}


	
	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		int filterInt = this.getInteger(filterText);

		Peca item = (Peca) value;

		 if(item.getId() != null&&item.getId()==filterInt) {
		//if (item.getId() != null && item.getId().toLowerCase().contains(filterText)) {
			return true;
		}
		
		if (item.getNome() != null && item.getNome().toString().contains(filterText)) {
			return true;
		}
		
		if (item.getDescricao() != null && item.getDescricao().toLowerCase().contains(filterText)) {
			return true;
		}

		return false;
	}

	public void loadGrid() {
		this.pecas = PecaDao.getInstance().getList("");
	}

	public void editForm() {
		this.setTitleTabFrom("Edição");
		this.setCreateItem(false);
		this.peca = this.pecas.get(this.getIndexSelected());
	}

	public void create() {
		this.cleanForm();
	}

	public void cleanForm() {
		this.setTitleTabFrom("Inserção");
		this.setCreateItem(true);
		this.peca = new Peca();
	}

	public boolean save() {

		if (this.peca.getNome() == null || this.peca.getNome().equals("")) {
			this.addMessage("WARNING", "Preencha o campo placa!");
			return false;
		}
		/*if (this.livro.getAutor() == null || this.livro.getAutor().equals("")) {
			this.addMessage("WARNING", "Preencha o campo autor!");
			return false;
		}*/
		/*
		 * if(this.livro.getPreco().toString().equals("")) { this.addMessage("WARNING",
		 * "Preencha o campo preço!"); return false; }
		 * System.out.println(this.isDouble(this.livro.getPreco().toString()));
		 * System.out.println("passou");
		 * if(this.isDouble(this.livro.getPreco().toString())) {
		 * this.addMessage("WARNING", "Preencha o campo preço!"); return false; }
		 */

		boolean status;
		if (this.isCreateItem()) {
			status = pecaDao.getInstance().create(peca);
		} else {
			status = pecaDao.getInstance().update(peca);
		}

		if (status == true) {
			this.addMessage("SUCCESS", "Item salvo com sucesso!");
			this.cleanForm();
			this.loadGrid();
		} else {
			this.addMessage("ERROR", "Não foi possível salvar o item!");
		}
		return true;
	}

	public void delete() {
		if (pecaDao.getInstance().delete(this.pecas.get(this.getIndexSelected()))) {
			this.addMessage("SUCCESS", "Item deletado com sucesso!");
			this.cleanForm();
			this.loadGrid();
		} else {
			this.addMessage("ERROR", "Não foi possível deletar esse item!");
		}
	}
	
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public List<Peca> getFilteredItens() {
		return filteredItens;
	}

	public void setFilteredItens(List<Peca> filteredItens) {
		this.filteredItens = filteredItens;
	}

	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}

