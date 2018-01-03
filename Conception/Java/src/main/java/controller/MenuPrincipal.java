package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.TilePane;
import util.Utile;
import view.App;

public class MenuPrincipal implements Initializable {

	@FXML
	private TilePane menuPrincipal;

	public void initialize(URL location, ResourceBundle resources){

		if(App.getConnecte()){
			if(App.getRpConnecte() != null){
				Parent boutonModifierPlanning = (Parent)Utile.chargerFxml("boutonModifierPlanning");

				menuPrincipal.getChildren().add(boutonModifierPlanning);
			}
			else {
				Parent boutonReservationEntrainement = (Parent)Utile.chargerFxml("boutonReservationEntrainement");

				menuPrincipal.getChildren().add(boutonReservationEntrainement);
			}
		}
	}
}
