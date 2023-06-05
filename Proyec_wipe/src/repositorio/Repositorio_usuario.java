package repositorio;

import java.util.ArrayList;
import java.util.List;

import dominios.Usuario;

public class Repositorio_usuario {

private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Repositorio_usuario() {
		usuarios.add(new Usuario(1, "Jaime", "Barcos", "Jaime08032003@gmail.com", "H:\\images\\Jaime.jpg", "08032003Jaime", "conectado"));
		usuarios.add(new Usuario(2, "Alan 18", "Salas", "Alangoat10@gmail.com", "H:\\images\\18.jpg", "1234", "inactivo"));
		usuarios.add(new Usuario(3, "Cuñado", "Cusme", "Cusme@gmail.com", "H:\\images\\CUSME.jpg", "1234", "inactivo"));
		usuarios.add(new Usuario(4, "Naula", "Lucio", "garañonTroncal@gmail.com", "H:\\images\\NAULA.jpg", "1234", "conectado"));
		usuarios.add(new Usuario(5, "Messi", "lapulga", "Lapulga10@gmail.com", "H:\\images\\messi.jpg", "1234", "inactivo"));
		usuarios.add(new Usuario(6, "Genesis", "Bautista", "genesis2002@gmail.com", "H:\\images\\Genesis.jpg", "1234", "inactivo"));
		usuarios.add(new Usuario(7, "Aaron", "Barcos", "Dios@gmail.com", "H:\\images\\Aaron.jpg", "1234", "conectado"));

	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Usuario userId(int id) {
		for(Usuario user: usuarios) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public Usuario userName(String username) {
		for(Usuario user: usuarios) {
			if(user.getcorreo().equals(username))
				return user;
		}
		return null;
	}
	
	public Usuario password(String username, String clave) {
		for(Usuario user: usuarios) {
			if(user.getcorreo().equals(username) && user.getClave().equals(clave))
				return user;
		}
		return null;
	}
	
}
