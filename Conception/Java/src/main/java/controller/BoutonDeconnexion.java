package controller;

import javafx.fxml.FXML;
import view.App;

public class BoutonDeconnexion {

	@FXML
	private void onButtonActivated(){

		App.deconnecter();
	}
}
