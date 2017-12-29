package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import util.Utile;
import view.App;

public class Banniere implements Initializable {

	@FXML
	private HBox root;

	@Override
	public void initialize(URL location, ResourceBundle resources){

		URL fxmlUrl;
		if(App.connecte){
			try {
				fxmlUrl = Utile.recupererFichier("/Interface/Content/boutonDeconnexion.fxml").toURI().toURL();
				FXMLLoader chargeurFxml = new FXMLLoader(fxmlUrl);
				final Node boutonDeconnexionFxml = chargeurFxml.load();
				root.getChildren().setAll(boutonDeconnexionFxml);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				fxmlUrl = Utile.recupererFichier("/Interface/Content/boutonConnexion.fxml").toURI().toURL();
				FXMLLoader chargeurFxml = new FXMLLoader(fxmlUrl);
				final Node boutonConnexionFxml = chargeurFxml.load();
				root.getChildren().setAll(boutonConnexionFxml);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
