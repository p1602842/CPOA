package controller;

import view.App;

public class BoutonRetour {

	public void onButtonActivated(){

		if(App.getEcran().equals("reserverTerrainEntrainement")){

			App.setEcran("accueil");
		}
	}
}
