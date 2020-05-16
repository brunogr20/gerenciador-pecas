package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import entities.Usuario;
import util.ConnectionDBUtil;
import util.HashUtil;

public class UsuarioDao {

	private static UsuarioDao INSTANCE = new UsuarioDao();

	// private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public static UsuarioDao getInstance() {
		return INSTANCE;
	}

	/*
	 * public ArrayList<Usuario> getUsuarios() { return this.usuarios; }
	 */

	public boolean create(Usuario usuario) {
		boolean status=false;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();

			String sql = "INSERT INTO USUARIO (CPF,NOME,EMAIL,SEXO,SENHA) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getCpf());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSexo());
			ps.setString(5, HashUtil.getHash(usuario.getSenha()));

			ps.execute();
			status = true;
		} catch (Exception e){
			System.out.println("Error: "+e.getMessage());
		 status = false;
		}

		return status;
	}

	public boolean login(String cpf, String senha) {
		return true;
	}

	public boolean sinbleField(String type, String field) {
		String sql = "";
		boolean status = true;

		return status;
	}

}
