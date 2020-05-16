package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Peca;
import util.ConnectionDBUtil;

public class PecaDao {
	private static PecaDao INSTANCE = new PecaDao();

	public static PecaDao getInstance() {
		return INSTANCE;
	}

	public Long getSequence() {
		Long seq = null;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = " select S_PECA.nextval from dual";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				seq = rs.getLong(1);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error sequence: " + e.getMessage());
		}
		return seq;
	}

	public List<Peca> getList(String filter) {

		List<Peca> pecas = new ArrayList<Peca>();
		try {

			Connection conn = ConnectionDBUtil.gecConnection();

			String sql = "SELECT ID,NOME,DESCRICAO,DESCRICAO,VALOR,STATUS FROM PECA ORDER BY NOME";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pecas.add(new Peca(rs.getLong("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"),
						rs.getDouble("VALOR"), rs.getBoolean("STATUS")));
			}
			conn.close();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return pecas;
	}

	public boolean create(Peca peca) {
		boolean status = false;
		try {
			Long id = this.getSequence();
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "INSERT INTO PECA (ID,NOME,VALOR,DESCRICAO,STATUS) VALUES (" + id + ",?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, peca.getNome());
			ps.setDouble(2, peca.getValor());
			ps.setString(3, peca.getDescricao());
			ps.setBoolean(4, peca.getStatus());

			ps.execute();
			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			status = false;
		}

		return status;
	}

	public boolean update(Peca peca) {
		boolean status = false;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "UPDATE PECA SET NOME=?,VALOR=?, DESCRICAO=?,STATUS=? WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, peca.getNome());
			ps.setDouble(2, peca.getValor());
			ps.setString(3, peca.getDescricao());
			ps.setBoolean(4, peca.getStatus());
			ps.setLong(5, peca.getId());

			ps.execute();
			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error update: " + e.getMessage());
			status = false;
		}

		return status;
	}

	public boolean delete(Peca peca) {
		boolean status = false;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "DELETE FROM PECA WHERE ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, peca.getId());

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
