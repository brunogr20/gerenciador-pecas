package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.VeiculoDao;
import dao.PecaDao;
import entities.Veiculo;
import entities.Peca;

@ManagedBean(name = "VeiculoBean")
@SessionScoped
@ApplicationScoped
public class VeiculoBean extends GenericBean {

	private List<Veiculo> veiculos;
	private List<Veiculo> filteredItens;
	private Veiculo veiculo;

	PecaDao pecaDao;
	private List<Peca> pecasDisponives;

	VeiculoDao veiculoDao;

	public VeiculoBean() {
		veiculoDao = new VeiculoDao();
		pecaDao = new PecaDao();

		this.veiculo = new Veiculo();
		this.loadGrid();

		pecasDisponives = pecaDao.getInstance().getList("");

	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		int filterInt = this.getInteger(filterText);

		Veiculo item = (Veiculo) value;

		// if(!livro.getId().equals("")&&livro.getId()==filterText) {
		if (item.getPlaca() != null && item.getPlaca().toString().contains(filterText)) {
			return true;
		}
		if (item.getFabricante() != null && item.getFabricante().toLowerCase().contains(filterText)) {
			return true;
		}
		if (item.getDescricao() != null && item.getDescricao().toLowerCase().contains(filterText)) {
			return true;
		}

		return false;
	}

	public void loadGrid() {
		this.veiculos = VeiculoDao.getInstance().getList("");
	}

	public boolean editForm() {
		Veiculo find = veiculoDao.getInstance().find(this.veiculos.get(this.getIndexSelected())); 
		if(find==null) {
			this.addMessage("ERROR", "O item selecionado não foi encontrado!");
			return false;
		}
		this.setTitleTabFrom("Edição");
		this.setCreateItem(false);
		this.veiculo=find;
		return true;
	}

	public void create() {
		this.cleanForm();
	}

	public void cleanForm() {
		this.setTitleTabFrom("Inserção");
		this.setCreateItem(true);
		this.veiculo = new Veiculo();
	}

	public boolean save() {

		if (this.veiculo.getPlaca() == null || this.veiculo.getPlaca().equals("")) {
			this.addMessage("WARNING", "Preencha o campo placa!");
			return false;
		}
		/*
		 * if (this.livro.getAutor() == null || this.livro.getAutor().equals("")) {
		 * this.addMessage("WARNING", "Preencha o campo autor!"); return false; }
		 */
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
			status = veiculoDao.getInstance().create(veiculo);
		} else {
			status = veiculoDao.getInstance().update(veiculo);
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
		if (veiculoDao.getInstance().delete(this.veiculos.get(this.getIndexSelected()))) {
			this.addMessage("SUCCESS", "Item deletado com sucesso!");
			this.cleanForm();
			this.loadGrid();
		} else {
			this.addMessage("ERROR", "Não foi possível deletar esse item!");
		}
	}

	/// ********* GETTERS AND SETTERS **********///

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public List<Veiculo> getFilteredItens() {
		return filteredItens;
	}

	public void setFilteredItens(List<Veiculo> filteredItens) {
		this.filteredItens = filteredItens;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Peca> getPecasDisponives() {
		return pecasDisponives;
	}

	public void setPecasDisponives(List<Peca> pecasDisponives) {
		this.pecasDisponives = pecasDisponives;
	}

}
