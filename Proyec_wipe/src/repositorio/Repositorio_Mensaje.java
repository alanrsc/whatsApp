package repositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dominios.Mensaje;
import dominios.Usuario;

public class Repositorio_Mensaje {
	
	private List<Mensaje> mensajes = new ArrayList<Mensaje>();
	private Repositorio_usuario usuario = new Repositorio_usuario();
	
	public Repositorio_Mensaje() {
		Usuario jaime = usuario.userId(1);
		Usuario alan = usuario.userId(2);
		Usuario cusme = usuario.userId(3);
		Usuario naula = usuario.userId(4);
		Usuario messi = usuario.userId(5);
		Usuario genesis = usuario.userId(6);
		Usuario aaron = usuario.userId(7);
		
		//CONVERSACIONES DE MAURICIO//
				
		mensajes.add(new Mensaje(3, jaime, alan, LocalDateTime.of(2022, 11, 16, 21, 12), "man, ya hiciste la tarea?"));
		mensajes.add(new Mensaje(4, alan, jaime, LocalDateTime.of(2022, 11, 16, 22, 31), "no, ando por baru, pilas cae"));
		
		mensajes.add(new Mensaje(5, jaime, cusme, LocalDateTime.of(2022, 11, 16, 21, 34), "Cuñado, como esta?"));
		mensajes.add(new Mensaje(6, cusme, jaime, LocalDateTime.of(2022, 11, 16, 22, 41), "no me diga asi oiga"));
		
		mensajes.add(new Mensaje(7, naula, jaime, LocalDateTime.of(2022, 11, 16, 21, 30), "Cual era el tema de contabilidad?"));
		mensajes.add(new Mensaje(8, jaime, naula, LocalDateTime.of(2022, 11, 16, 23, 30), "lo mismo me preguntó"));
		
		mensajes.add(new Mensaje(9, jaime, messi, LocalDateTime.of(2022, 11, 16, 12, 16), "hoy te caigo para celebrar"));
		mensajes.add(new Mensaje(10, messi, jaime, LocalDateTime.of(2022, 11, 16, 21, 53), "sha aqui te espero, trae a la gente pa"));
	
		mensajes.add(new Mensaje(13, genesis, jaime, LocalDateTime.of(2022, 11, 16, 3, 30), "hola, mor como te va en el proyecto"));
		mensajes.add(new Mensaje(14, jaime, genesis, LocalDateTime.of(2022, 11, 16, 3, 31), "aqui, decente"));
		
		mensajes.add(new Mensaje(14, jaime, aaron, LocalDateTime.of(2022, 11, 16, 21, 30), "Aaron pilas ese lonchis"));
		mensajes.add(new Mensaje(15, aaron, jaime, LocalDateTime.of(2022, 11, 16, 21, 40), "pilas man"));
		

	}
	
	public List<Mensaje> getMensajes(){
		return mensajes;
	}
	
	public List<Mensaje> conversaciones(int usuario1, int usuario2) {
		List<Mensaje> resultado = new ArrayList<Mensaje>();
		for(Mensaje msj: mensajes) {
			if((msj.getUsuario1().getId() == usuario1 && msj.getUsuario2().getId() == usuario2) || (
					msj.getUsuario1().getId() == usuario2 && msj.getUsuario2().getId() == usuario1))
				resultado.add(msj);
		}
		return resultado;		
	}
	
	public Mensaje getUltimoMsj(int usuario1, int usuario2) {
		List<Mensaje> resultado = conversaciones(usuario1, usuario2);
		
		if(resultado.size() == 0)
			return null;
		return resultado.get(resultado.size()-1);		
	}
	
	public void addMensajes(Mensaje mensaje) {
		mensajes.add(mensaje);		
	}

}
