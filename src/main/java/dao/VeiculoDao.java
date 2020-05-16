package dao;

import iface.CRUD;
import util.ConnectionDBUtil;
import util.HashUtil;

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

			String sql = "SELECT PLACA,MARCA,MODELO,DESCRICAO,CHASSI,STATUS FROM VEICULO  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				veiculos.add(new Veiculo(rs.getString("PLACA"), "", rs.getString("MARCA"), rs.getString("MODELO"),
						 rs.getString("CHASSI"),rs.getString("DESCRICAO"), rs.getBoolean("STATUS")));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return veiculos;
	}

	public boolean create(Veiculo veiculo) {
		boolean status = false;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "INSERT INTO VEICULO (PLACA,MARCA,MODELO,CHASSI,DESCRICAO,STATUS) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getMarca());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getChassi());
			ps.setString(5, veiculo.getDescricao());
			ps.setBoolean(6, veiculo.getStatus());

			ps.execute();
			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			status = false;
		}

		return status;
	}

	public boolean update(Veiculo veiculo) {
		boolean status = false;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "UPDATE VEICULO SET DESCRICAO=?,STATUS=? WHERE PLACA=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getDescricao());
			ps.setBoolean(2, veiculo.getStatus());
			ps.setString(3, veiculo.getPlaca());

			ps.execute();
			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error update: " + e.getMessage());
			status = false;
		}

		return status;
	}

	public boolean delete(Veiculo veiculo) {
		boolean status = false;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "DELETE FROM VEICULO WHERE PLACA=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getPlaca());

			ps.execute();
			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error delete: " + e.getMessage());
			status = false;
		}

		return status;
	};

}
