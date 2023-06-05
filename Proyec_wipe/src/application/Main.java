package application;
	
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import com.conexion.Conexion;

import dominios.Dominio_Chat;
import dominios.Mensaje;
import dominios.Usuario;
import interfas_grafica.Enviar_bt;
import interfas_grafica.Regristro_login;
import interfas_grafica.Target_info;
import interfas_grafica.Chat_ms;
import interfas_grafica.Ubicaciones;
import interfas_grafica.Target_Personal;
import repositorio.Repositorio_Chat;
import repositorio.Repositorio_Mensaje;
import repositorio.Repositorio_usuario;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Main extends Application {


	Repositorio_usuario usuarios = new Repositorio_usuario();
	Repositorio_Mensaje mensajes = new Repositorio_Mensaje();
	Repositorio_Chat chats = new Repositorio_Chat();
	
    @Override
    public void start(Stage stage1) throws Exception { 	
    	Regristro_login regis_login = new Regristro_login();
    	regis_login.contenidoVbox1();  
    	Scene scene1 = new Scene(regis_login.anchor(), 370, 460); // VENTA INCIO
    	stage1.getIcons().add(new Image("H:\\images\\iconos\\logotipo.png"));
    	scene1.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
    	stage1.setTitle("Wipe");
    	stage1.setScene(scene1);
    	stage1.show();  	
    	regis_login.styles();
    	regis_login.getIniciar().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(usuarios.password(regis_login.getUsertext().getText(), regis_login.getClavetext().getText()) == null) { // si sale error
					regis_login.Notificacion(regis_login.getUsertext().getText(), regis_login.getClavetext().getText());
					stage1.close();
					Stage stage2 = new Stage();
					Scene scene2 = new Scene(regis_login.contenidoVbox2(), 770, 100); //VENTANA ERROR
					
					
					stage2.getIcons().add(new Image("H:\\images\\iconos\\logotipo.png"));
					scene2.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
					stage2.setTitle("ChatSpace");
					stage2.setScene(scene2);
					stage2.show();
					
					regis_login.getRegresar().setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent event) {
							regis_login.getUsertext().clear();
							regis_login.getClavetext().clear();
							stage2.close();
							stage1.show();
						}
					});				
				}
				
				else {
					stage1.close();
					
					Ubicaciones secondgui = new Ubicaciones(10);
					secondgui.getPanelIzq().setContent(secondgui.getVbox());
					
					Target_Personal topleft = new Target_Personal(regis_login.getUsertext().getText());
					topleft.styles();
					Target_Personal topright = new Target_Personal();
					Enviar_bt inferior = new Enviar_bt();
					inferior.styles();
					secondgui.setInferior(inferior.getHbox());
					topleft.topLeft();
					secondgui.setTopleft(topleft.getTopleft());
					secondgui.setTopright(topright.getTopright());
					secondgui.anchor1();
										
					Usuario usuario = usuarios.userName(regis_login.getUsertext().getText());
					
					int incremento = 0;
					for(Dominio_Chat activos: chats.getChat(usuario.getId())) {
						Target_info leftdesign = new Target_info();
						leftdesign.styles();
						leftdesign.contenido(activos.getUsuario().getImagen(), activos.getUsuario().getNombre(), 
						activos.getMensaje().getMensaje(), activos.getMensaje().getFecha());
						
						leftdesign.leftDesign();
						leftdesign.getLeftdesign().setId(String.valueOf(activos.getUsuario().getId()));	
						
						secondgui.setLeftdesign(leftdesign.getLeftdesign());
						secondgui.getVbox().getChildren().add(secondgui.getLeftdesign());
						
						incremento = incremento + 1;

						leftdesign.getLeftdesign().addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

							@Override
							public void handle(MouseEvent event) {	
								Ubicaciones fp = new Ubicaciones();	
								Usuario contacto = usuarios.userId(Integer.valueOf(leftdesign.getLeftdesign().getId()));
								
								topright.getTopright().getChildren().clear();
								topright.topRight(contacto.getId());
								
								secondgui.visible();
								secondgui.styles();
								secondgui.getPanelDer().setVvalue(1.0);									
							
								for(Mensaje msj: mensajes.conversaciones(usuario.getId(), contacto.getId())) {
									Chat_ms rightdesign = new Chat_ms();
									rightdesign.styles();
									
									if(msj.getUsuario1().getId() == usuario.getId()) {		
										rightdesign.messageUser(msj.getUsuario1().getImagen(), msj.getMensaje(), msj.getFecha());										
										fp.getFlowpane().getChildren().add(rightdesign.getRightdesign());
									}
									
									else {
										rightdesign.messageContact(msj.getUsuario1().getImagen(), msj.getMensaje(), msj.getFecha());
										fp.getFlowpane().getChildren().add(rightdesign.getRightdesign());	
									}

									inferior.getBoton().setOnAction(new EventHandler<ActionEvent>() {
										
										@Override
										public void handle(ActionEvent event) {
											if(!inferior.getTexto().getText().equals("")) {	
												
												DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("              HH:mm");
												LocalDateTime fecha = LocalDateTime.now();
												
												Chat_ms rightdesign = new Chat_ms();
												rightdesign.styles();
		
												rightdesign.messageUser(usuario.getImagen(), inferior.getTexto().getText(), fecha);

												fp.getFlowpane().getChildren().add(rightdesign.getRightdesign());
													
												leftdesign.getMensaje().setText(inferior.getTexto().getText());
												leftdesign.getDatetime().setText(datetimeformat.format(fecha));
													
												secondgui.ajusteDesplDer(fp.getFlowpane());
												
												Mensaje newMessage = new Mensaje(activos.getMensaje().getId()+1, usuario, contacto, fecha, inferior.getTexto().getText());											
												mensajes.addMensajes(newMessage);
												inferior.getTexto().clear();
												
											}
										}
									});
									
									secondgui.getPanelDer().setContent(fp.getFlowpane());
								}			
							}
						});
					}	
					
					Stage stage3 = new Stage();
					Scene scene3 = new Scene(secondgui.getAnchorPane(), 970, 550);
					stage3.getIcons().add(new Image("H:\\images\\iconos\\logotipo.png"));
					scene3.getStylesheets().add(String.valueOf(this.getClass().getResource("application.css")));
					stage3.setTitle("WiPe");
					stage3.setScene(scene3);
					stage3.show();
					
					topleft.getLogout().setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {

							topleft.getLogout().setText(topleft.getLogout().getText().equals("Activo") ? "Inactivo" : "Activo");

						}
					});
				}	
			}
		});
    }
	
	public static void main(String[] args) {
		try {
			Connection con = Conexion.crearConexion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	
	launch(args);

	}
}
