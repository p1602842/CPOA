package controller;

import view.App;

public class BoutonRetour {

	public void onButtonActivated(){

		if(App.getEcran().equals("reserverTerrainEntrainement") || App.getEcran().equals("modifierPlanning")){

			App.setEcran("accueil");
		}

		if(App.getEcran().equals("horairesEmplacementsStaffScores")){

			App.setEcran("modifierPlanning");
		}

		if(App.getEcran().equals("modifierStaff")){

			App.setEcran("horairesEmplacementsStaffScores");
		}
	}
}
