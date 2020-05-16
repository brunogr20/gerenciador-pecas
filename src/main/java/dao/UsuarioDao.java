package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Usuario;



public class UsuarioDao {

	private static UsuarioDao INSTANCE = new UsuarioDao();

	//private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public static UsuarioDao getInstance() {
		return INSTANCE;
	}

	/*public ArrayList<Usuario> getUsuarios() {
		return this.usuarios;
	}*/

	public boolean create(Usuario usuario) {

		boolean status = false;

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
