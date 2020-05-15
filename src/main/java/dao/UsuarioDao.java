package dao;

import java.util.ArrayList;
import entities.Usuario;

public class UsuarioDao {
	
	private static UsuarioDao INSTANCE = new UsuarioDao();
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public static UsuarioDao getInstance() {
		return INSTANCE;
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}
	
	public boolean criarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
		return true;
	}
	
	

}
