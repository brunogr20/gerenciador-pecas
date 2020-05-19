package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Fabricante;
import entities.Modelo;
import entities.Peca;
import util.ConnectionDBUtil;

public class FabricanteDao {
	
	private static FabricanteDao INSTANCE = new FabricanteDao();

	public static FabricanteDao getInstance() {
		return INSTANCE;
	}

	public List<Fabricante> getList(String filter) {

		List<Fabricante> fabricantes = new ArrayList<Fabricante>();
		
		try {

			Connection conn = ConnectionDBUtil.gecConnection();

			String sql = "SELECT ID,NOME,STATUS FROM FABRICANTE ORDER BY NOME";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				fabricantes.add(new Fabricante(rs.getLong("ID"), rs.getString("NOME")));
			}
			conn.close();

		} catch (Exception e) {
			System.out.print("Error lista fabricante :"+e.getMessage());
		}

		return fabricantes;
	}
	
	public Fabricante find(Fabricante v) {
		Fabricante fabricante = null;
		
		return fabricante;
	}

	public Fabricante find(Long id) {
		Fabricante fabricante = null;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "SELECT ID,NOME,STATUS FROM FABRICANTE  WHERE ID="+id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Modelo modelo =new Modelo();
				fabricante = new Fabricante(rs.getLong("ID"),rs.getString("NOME"),modelo,rs.getBoolean("STATUS"));
			}

			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return fabricante;
	}

	public boolean create(Fabricante fabricante) {
		boolean status = false;

		return status;
	}

	public boolean update(Fabricante fabricante) {
		boolean status = false;

		return status;
	}

	public boolean delete(Fabricante fabricante) {
		boolean status = false;

		return status;
	};


}
