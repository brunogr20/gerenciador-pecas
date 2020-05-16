package dao;

import iface.CRUD;
import util.ConnectionDBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Veiculo;

public class VeiculoDao implements CRUD<Veiculo> {

	private static VeiculoDao INSTANCE = new VeiculoDao();

	public static VeiculoDao getInstance() {
		return INSTANCE;
	}

	public List<Veiculo> getList(String filter) {

		List<Veiculo> veiculos = new ArrayList<Veiculo>();
		try {
			Connection conn = ConnectionDBUtil.gecConnection();

			String sql = "SELECT CPF FROM VEICULO WHERE ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				veiculos.add(new Veiculo(rs.getString("PLACA"), "", rs.getString("MARCA"), rs.getString("MODELO"),
						rs.getString("DESCRICAO"), rs.getString("CHASSI"), rs.getBoolean("STATUS")));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return veiculos;
	}

	public boolean create(Veiculo entity) {
		return true;
	}

	public boolean update(Veiculo entity) {

		return true;
	}

	public boolean delete(Veiculo entity) {

		return true;

	};

}
