package controller;

import javafx.fxml.FXML;
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
			Parent root = (Parent)Utile.chargerFxml("connexion");

			Stage stage = new Stage();

			stage.setTitle("Connexion");
			stage.setScene(new Scene(root, 280, 160));
			stage.initStyle(StageStyle.UTILITY);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			stage.show();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
