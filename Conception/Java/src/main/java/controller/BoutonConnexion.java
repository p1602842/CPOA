package controller;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.Utile;

public class BoutonConnexion {

	@FXML
	private void onButtonActivated(){

		try{
			URL fxmlUrl = Utile.recupererFichier("/Interface/Content/connexion.fxml").toURI().toURL();
			FXMLLoader chargeurFxml = new FXMLLoader(fxmlUrl);
			final Node rootFxml = chargeurFxml.load();
			Parent root = (Parent)rootFxml;

			Stage stage = new Stage();

			stage.setTitle("Connexion");
			stage.setScene(new Scene(root, 330, 200));
			stage.initStyle(StageStyle.UTILITY);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
