package controller;

import javafx.fxml.FXML;
import view.App;

public class BoutonReservation {

	@FXML
	private void onButtonActivated(){

		App.setEcran("reserverTerrainEntrainement");
	}
}
