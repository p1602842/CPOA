package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import util.Utile;
import view.App;

public class Banniere implements Initializable {

	@FXML
	private HBox root;

	public void initialize(URL location, ResourceBundle resources){

		root.getChildren().clear();

		if(!App.getEcran().equals("accueil")){
			final Node boutonRetour = Utile.chargerFxml("boutonRetour");

			root.getChildren().add(boutonRetour);
		}

		if(App.getConnecte()){
			try {
				final Node boutonDeconnexion = Utile.chargerFxml("boutonDeconnexion");
				
				root.getChildren().add(boutonDeconnexion);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				final Node boutonConnexionFxml = Utile.chargerFxml("boutonConnexion");

				root.getChildren().add(boutonConnexionFxml);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
