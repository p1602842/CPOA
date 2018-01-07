package controller;

import javafx.fxml.FXML;
import view.App;

public class BoutonModifier {

	@FXML
	private void onButtonActivated(){

		App.setEcran("modifierPlanning");
	}
}
