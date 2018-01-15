package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Match;
import entity.MatchDouble;
import entity.MatchSimple;
import entity.Terrain;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.MatchDAO;
import model.TerrainDAO;
import util.Horaire;
import util.Moment;
import util.PhaseTournoi;

public class ModificationHoraireEmplacement implements Initializable {

	@FXML
	private ComboBox<String> jourBox;

	@FXML
	private ComboBox<Horaire> horaireBox;

	@FXML
	private ComboBox<Terrain> terrainBox;

	Match matchActuel;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		jourBox.getItems().clear();

		Match match = (Match)PagePlanning.getMatchSelectionne();
		matchActuel = match;

		List<Moment> momentsPossibles = momentsPossibles(match);

		if(match instanceof MatchSimple){
			if(PhaseTournoi.PHASES_QUALIFS.contains(match.getPhaseTournoi())){
				for(Moment moment : momentsPossibles){
					if(Moment.JOURS_POSSIBLES_QUALIFS.contains(moment.getJour())){
						if(!jourBox.getItems().contains(moment.getJour())){
							jourBox.getItems().add(moment.getJour());
						}
					}
				}
			}
			else {
				for(Moment moment : momentsPossibles){
					if(Moment.JOURS_POSSIBLES_TOURNOI.contains(moment.getJour())){
						if(!jourBox.getItems().contains(moment.getJour())){
							jourBox.getItems().add(moment.getJour());
						}
					}
				}
			}
		}
		else if(match instanceof MatchDouble){
			for(Moment moment : momentsPossibles){
				if(Moment.JOURS_POSSIBLES_TOURNOI.contains(moment.getJour())){
					if(!jourBox.getItems().contains(moment.getJour())){
						jourBox.getItems().add(moment.getJour());
					}
				}
			}
		}

		jourBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				horaireBox.getSelectionModel().select(null);

				List<Horaire> horaires = new ArrayList<Horaire>();

				if(newValue instanceof String){
					String jour = (String)newValue;
					for(Moment moment : momentsPossibles){
						if(jour.equals(moment.getJour())){
							if(!horaires.contains(moment.getHoraire())){
								horaires.add(moment.getHoraire());
							}
						}
					}
				}

				horaireBox.getItems().setAll(horaires);
			}
		});

		horaireBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				terrainBox.getSelectionModel().select(null);

				List<Terrain> terrains = new ArrayList<Terrain>();

				if(newValue instanceof Horaire){
					Horaire horaire = (Horaire)newValue;
					Moment moment = new Moment(jourBox.getSelectionModel().getSelectedItem(), horaire);
					List<Terrain> terrainsImpossible = MatchDAO.terrainsImpossibles(moment);

					for(Terrain terrain : TerrainDAO.tousLesTerrains()){
						if(!terrainsImpossible.contains(terrain)){
							terrains.add(terrain);
						}
						if((moment.equals(match.getMoment())) && (terrain.equals(match.getTerrain()))){
							terrains.add(terrain);
						}
					}
				}

				terrainBox.getItems().setAll(terrains);
			}
		});
	}

	@FXML
	public void onButtonActivated(){

		if(!jourBox.getSelectionModel().isEmpty() && !horaireBox.getSelectionModel().isEmpty() && !terrainBox.getSelectionModel().isEmpty()){
			MatchDAO.modifierHoraireEmplacementMatch(matchActuel, new Moment(jourBox.getSelectionModel().getSelectedItem(), horaireBox.getSelectionModel().getSelectedItem()), terrainBox.getSelectionModel().getSelectedItem());
		}
	}

	public static List<Moment> momentsPossibles(Match match){

		List<Moment> momentsPossibles = new ArrayList<Moment>();
		List<?> matchsPrecedents = match.getMatchsPrecedents();
		Match suivant = match.getMatchSuivant();
		Match precedentPlusTardif = null;

		if(!matchsPrecedents.isEmpty()){
			precedentPlusTardif = (Match)matchsPrecedents.get(0);

			for(Object o : matchsPrecedents){
				Match matchPrec = (Match)o;
				if(matchPrec.getMoment().estApres(precedentPlusTardif.getMoment())){
					precedentPlusTardif = matchPrec;
				}
			}
		}

		for(Moment moment : Moment.tousLesMoments()){
			if(((precedentPlusTardif == null) || (moment.estApres(precedentPlusTardif.getMoment()))) && ((suivant == null) || (moment.estAvant(suivant.getMoment())))){
				if(!MatchDAO.momentsImpossibles(match).contains(moment)){
					
					momentsPossibles.add(moment);
				}
			}
		}

		return(momentsPossibles);
	}
}