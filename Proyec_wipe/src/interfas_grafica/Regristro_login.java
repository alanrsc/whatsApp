	package interfas_grafica;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Regristro_login {
	private Label titulolabel;
	private Label userlabel;
	private TextField usertext;
	private Label clavelabel;
	private PasswordField clavetext;
	private Button iniciar;
	private AnchorPane anchorPane;
	private Button regresar;
	private HBox hbox1;
	private HBox hbox2;
	private Label avisolabel;
	private VBox vbox1;
	private VBox vbox2;
	
	
	
	
	public Regristro_login() {
		//
		titulolabel = new Label("Wipe");
		userlabel = new Label("Correo:           ");
		usertext = new TextField();
		clavelabel = new Label("contraseña:");
		clavetext = new PasswordField();
		iniciar = new Button("Entrar");
		
		

		avisolabel = new Label();
		regresar = new Button("ACEPTAR");
		hbox1 = new HBox(10);
		hbox2 = new HBox(30);
		vbox1 = new VBox(20);;
		anchorPane = new AnchorPane();
		
	}

	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public Button getIniciar() {
		return iniciar;
	}

	public Button getRegresar() {
		return regresar;
	}

	public HBox getHbox1() {
		return hbox1;
	}
	
	public HBox getHbox2() {
		return hbox2;
	}

	public Label getTitulolabel() {
		return titulolabel;
	}

	public Label getClavelabel() {
		return clavelabel;
	}

	public Label getUserlabel() {
		return userlabel;
	}

	public Label getAvisolabel() {
		return avisolabel;
	}

	public void setAvisolabel(Label avisolabel) {
		this.avisolabel = avisolabel;
	}

	public PasswordField getClavetext() {
		return clavetext;
	}

	public void setClavetext(PasswordField clavetext) {
		this.clavetext = clavetext;
	}

	public TextField getUsertext() {
		return usertext;
	}

	public void setUsertext(TextField usertext) {
		this.usertext = usertext;
	}

	public VBox getVbox1() {
		return vbox1;
	}

	public void setVbox(VBox vbox1) {
		this.vbox1 = vbox1;
	}
	
	public VBox getVbox2() {
		return vbox2;
	}

	public void setVbox2(VBox vbox2) {
		this.vbox2 = vbox2;
	}
	
	public void contenidoVbox1() {
		hbox1.getChildren().addAll(userlabel, usertext);
		hbox2.getChildren().addAll(clavelabel, clavetext);
		vbox1.getChildren().addAll(hbox1, hbox2);	
		
	}
	
	public VBox contenidoVbox2() {
		vbox2 = new VBox(15, avisolabel, regresar); //ASDASDASD
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setId("vbox");
		return vbox2;
	}
	
	public void Notificacion(String username, String password) {
		if(username.equals("") || password.equals(""))
			avisolabel.setText("ERROR, porfavor revise los campos, su correo o contrasenia estan incorrectas");
		else {
			avisolabel.setText("ERROR, porfavor revise los campos, su correo o contrasenia estan incorrectas");
		}
	}
	
	public AnchorPane anchor() {
		anchorPane.getChildren().addAll(titulolabel, vbox1, iniciar);
		AnchorPane.setLeftAnchor(titulolabel, 125d);
    	AnchorPane.setTopAnchor(titulolabel, 40d);
    	AnchorPane.setLeftAnchor(iniciar, 150d);
    	AnchorPane.setBottomAnchor(iniciar, 110d);
    	AnchorPane.setLeftAnchor(vbox1, 30d);
    	AnchorPane.setTopAnchor(vbox1, 195d);
    	return anchorPane;
	}
	
	public void styles() {
		iniciar.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		regresar.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);\r\n");
		
		titulolabel.setStyle("-fx-font-weight: bold;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 450%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		userlabel.setStyle("-fx-font-weight: bold;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		clavelabel.setStyle("-fx-font-weight: bold;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
		
		usertext.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 120%;\r\n"
				+ "	-fx-focus-traversable: false;");
		
		clavetext.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 120%;\r\n"
				+ "	-fx-focus-traversable: false;\r\n");
		
		avisolabel.setStyle("-fx-font-weight: normal;\r\n"
				+ "	-fx-font-family: 'Microsoft Sans Serif';\r\n"
				+ "	-fx-font-size: 150%;\r\n"
				+ "	-fx-text-fill: rgb(0,0,0);");
	}
}
