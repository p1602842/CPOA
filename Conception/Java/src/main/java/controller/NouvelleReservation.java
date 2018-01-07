package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Reservation;
import entity.TerrainEntrainement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.ReservationDAO;
import model.TerrainEntrainementDAO;
import util.Horaire;
import util.Moment;
import view.App;

public class NouvelleReservation implements Initializable {

	@FXML
	private ComboBox<String> jourBox;

	@FXML
	private ComboBox<Horaire> horaireBox;

	@FXML
	private ComboBox<TerrainEntrainement> terrainBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		jourBox.getItems().setAll(Moment.JOURS_POSSIBLES);
		jourBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				horaireBox.getSelectionModel().select(null);

				List<Horaire> horaires = new ArrayList<Horaire>();

				if(newValue instanceof String){
					String jour = (String)newValue;
					for(String nomHoraire : Horaire.HORAIRES_POSSIBLES){
						Horaire horaire = new Horaire(nomHoraire);
						if(!ReservationDAO.horairesImpossible(App.getTennisManConnecte(), jour).contains(horaire)){
							horaires.add(horaire);
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

				List<TerrainEntrainement> terrains = new ArrayList<TerrainEntrainement>();

				if(newValue instanceof Horaire){
					Horaire horaire = (Horaire)newValue;
					Moment moment = new Moment(jourBox.getSelectionModel().getSelectedItem(), horaire);
					List<TerrainEntrainement> terrainsImpossible = ReservationDAO.terrainsImpossible(moment);

					for(TerrainEntrainement terrain : TerrainEntrainementDAO.tousLesTerrainsEntrainement()){
						if(!terrainsImpossible.contains(terrain)){
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
			Reservation reservation = new Reservation(0, App.getTennisManConnecte(), terrainBox.getSelectionModel().getSelectedItem(), new Moment(jourBox.getSelectionModel().getSelectedItem(), horaireBox.getSelectionModel().getSelectedItem()));
			ReservationDAO.ajouterReservation(reservation);
			App.rechargerConteneur();
			jourBox.getSelectionModel().clearSelection();
			horaireBox.getSelectionModel().clearSelection();
			terrainBox.getSelectionModel().clearSelection();
		}
	}
}
