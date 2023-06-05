package repositorio;

import java.util.ArrayList;
import java.util.List;

import dominios.Dominio_Chat;
import dominios.Mensaje;
import dominios.Usuario;

public class Repositorio_Chat {
	
	private Repositorio_usuario usuario;
	private Repositorio_Mensaje mensaje;
	
	public Repositorio_Chat() {
		usuario = new Repositorio_usuario();
		mensaje = new Repositorio_Mensaje();
	}

	public Repositorio_usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Repositorio_usuario usuario) {
		this.usuario = usuario;
	}

	public Repositorio_Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Repositorio_Mensaje mensaje) {
		this.mensaje = mensaje;
	}
	
	public List<Dominio_Chat> getChat(int userId){
		List<Dominio_Chat> contactMsj = new ArrayList<Dominio_Chat>();
		List<Usuario> contactos = usuario.getUsuarios();
		
		for(Usuario l: contactos) {
			if(l.getId() == userId)
				continue;
			
			Mensaje ultimoMsj = mensaje.getUltimoMsj(userId, l.getId());
			
			if(ultimoMsj == null)
				continue;
			
			Usuario contacto = usuario.userId(l.getId());
			
			contactMsj.add(new Dominio_Chat(contacto, ultimoMsj));
			
		}		
		
		return contactMsj;
		
	}

}
