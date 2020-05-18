package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		boolean status = false;
		//String senha =  HashUtil.getHash(usuario.getSenha());
		String senha =  usuario.getSenha();
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "INSERT INTO USUARIO (CPF,NOME,EMAIL,SEXO,SENHA) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getCpf());
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getSexo());
			ps.setString(5,senha);

			ps.execute();
			status = true;
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			status = false;
		}

		return status;
	}

	public Usuario login(String email, String senha) {
		Usuario usuario = null;
		//senha = HashUtil.getHash(senha);
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "SELECT CPF,NOME,EMAIL,SEXO FROM USUARIO WHERE EMAIL='"+email+"' AND SENHA='"+senha+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1,value);
			 
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				usuario = new Usuario(rs.getString("NOME"),rs.getString("CPF"),rs.getString("EMAIL"),rs.getString("SEXO"),"");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error login: "+e.getMessage());
		}
		System.out.println(usuario);
		return usuario;
	}

	public boolean sinbleField(String field, String value) {
		boolean status = true;
		try {
			Connection conn = ConnectionDBUtil.gecConnection();
			String sql = "SELECT CPF FROM USUARIO WHERE "+field+"= '"+value+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1,value);
			 
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			   status = false;
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			status = false;
		}

		return status;
	}

}
