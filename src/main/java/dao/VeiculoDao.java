package dao;

import iface.CRUD;
import util.ConnectionDBUtil;
import util.HashUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Peca;
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

			String sql = "SELECT PLACA,FABRICANTE,MODELO,STATUS FROM VEICULO  ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				veiculos.add(new Veiculo(rs.getString("PLACA"), rs.getString("FABRICANTE"), rs.getString("MODELO"),
						rs.getBoolean("STATUS")));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return veiculos;
	}

	public Veiculo find(Veiculo v) {
		Veiculo veiculo = null;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "SELECT PLACA,FABRICANTE,MODELO,DESCRICAO,CHASSI,STATUS FROM VEICULO  WHERE PLACA='"
					+ v.getPlaca() + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ArrayList<String> pecas = new ArrayList<String>();
				// check se existe paças vinculadas a esse veículo
				PreparedStatement pk = conn
						.prepareStatement("SELECT ID_PECA FROM VEICULO_PECA_PK WHERE PLACA='" + v.getPlaca() + "'");
				ResultSet rsPk = pk.executeQuery();
				while (rsPk.next()) {
					pecas.add(rsPk.getString("ID_PECA"));
				}
				// fim
				veiculo = new Veiculo(rs.getString("PLACA"), "", rs.getString("FABRICANTE"), rs.getString("MODELO"),
						rs.getString("CHASSI"), rs.getString("DESCRICAO"), rs.getBoolean("STATUS"), pecas);
			}

			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return veiculo;
	}

	public boolean create(Veiculo veiculo) {
		boolean status = false;

		try {

			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "INSERT INTO VEICULO (PLACA,FABRICANTE,MODELO,CHASSI,DESCRICAO,STATUS) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getFabricante());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getChassi());
			ps.setString(5, veiculo.getDescricao());
			ps.setBoolean(6, veiculo.getStatus());
			ps.execute();

			/// cadastro de peças vinculadas ao veículo
			PreparedStatement pk;
			for (String id : veiculo.getIdsPecas()) {
				if (!id.isEmpty()) {
					pk = conn.prepareStatement("INSERT INTO VEICULO_PECA_PK(PLACA,ID_PECA) VALUES(?,?)");
					pk.setString(1, veiculo.getPlaca());
					pk.setLong(2, Integer.parseInt(id));
					pk.execute();
				}
			}
			/// fim

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

			// alterando relacionamento entre veículos e peças
			PreparedStatement pk;
			for (String id : veiculo.getIdsPecas()) {
				pk = conn.prepareStatement("SELECT ID_PECA FROM VEICULO_PECA_PK WHERE PLACA='" + veiculo.getPlaca()
						+ "' AND ID_PECA=" + id);
				ResultSet rsPk = pk.executeQuery();
				if (!rsPk.next()) {
					pk = conn.prepareStatement("INSERT INTO VEICULO_PECA_PK(PLACA,ID_PECA) VALUES(?,?)");
					pk.setString(1, veiculo.getPlaca());
					pk.setLong(2, Integer.parseInt(id));
					pk.execute();
				}
			}
			/// delete os não vinculados
			String strPecas = String.join(", ", veiculo.getIdsPecas());
			String sqlPecas = "";
			if (!strPecas.isEmpty()) {
				sqlPecas = " AND ID_PECA NOT IN(" + strPecas + ")";
			}
			pk = conn.prepareStatement("DELETE FROM VEICULO_PECA_PK WHERE PLACA=?" + sqlPecas);
			pk.setString(1, veiculo.getPlaca());
			pk.execute();
			/// fim

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

			// deletar peças vinculadas ao veículo
			PreparedStatement pk = conn.prepareStatement("DELETE FROM VEICULO_PECA_PK WHERE PLACA=?");
			pk.setString(1, veiculo.getPlaca());
			pk.execute();
			// fim

			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error delete: " + e.getMessage());
			status = false;
		}

		return status;
	};

}
