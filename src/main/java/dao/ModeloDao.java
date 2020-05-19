package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Modelo;
import util.ConnectionDBUtil;

public class ModeloDao {
	
	private static ModeloDao INSTANCE = new ModeloDao();

	public static ModeloDao getInstance() {
		return INSTANCE;
	}

	public List<Modelo> getList(String filter) {

		List<Modelo> modelos = new ArrayList<Modelo>();

		return modelos;
	}
	
	public Modelo find(Modelo m) {
		Modelo modelo = null;
		
		return modelo;
	}
	
	public List<Modelo> getListFabricanteModelos(Long id) {
		List<Modelo> modelos = new ArrayList<Modelo>();
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "SELECT ID,NOME,STATUS FROM MODELO  WHERE ID_FABRICANTE="+id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				modelos.add(new Modelo(rs.getLong("ID"),rs.getString("NOME"),rs.getBoolean("STATUS")));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error find fabricante modelo : " + e.getMessage());
		}
		return modelos;
	}

	public Modelo find(Long id) {
		Modelo modelo = null;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "SELECT ID,ID_FABRICANTE,NOME,STATUS FROM MODELO  WHERE ID="+id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				modelo = new Modelo(rs.getLong("ID"),rs.getString("NOME"),rs.getBoolean("STATUS"));
			}

			conn.close();
		} catch (Exception e) {
			System.out.println("Error find modelo : " + e.getMessage());
		}

		return modelo;
	}

	public boolean create(Modelo modelo) {
		boolean status = false;

		return status;
	}

	public boolean update(Modelo modelo) {
		boolean status = false;

		return status;
	}

	public boolean delete(Modelo modelo) {
		boolean status = false;

		return status;
	};



}
