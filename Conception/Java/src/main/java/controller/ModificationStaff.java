package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Arbitre;
import entity.Match;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import model.RamasseursDAO;

public class ModificationStaff implements Initializable {

	@FXML
	private TableView<Arbitre> arbitresInitialContainer;

	@FXML
	private TreeTableView<Arbitre> arbitresFinalContainer;

	@FXML
	private TableView<Integer> ramasseursInitialContainer;

	@FXML
	private TableView<Integer> ramasseursFinalContainer;

	@FXML
	private Button ajouterArbitreChaise;

	@FXML
	private Button ajouterArbitreLigne;

	@FXML
	private Button retirerArbitre;

	@FXML
	private Button ajouterRamasseurs;

	@FXML
	private Button retirerRamasseurs;

	@FXML
	private Label matchLabel;

	@FXML
	private Label horaireEmplacement;

	Match match;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		match = PagePlanning.getMatchSelectionne();

		matchLabel.setText("Match n°" + match.getId() + " (" + match.getPhaseTournoi() + ") : " + match.getOpposants());
		horaireEmplacement.setText(match.getTerrain() + " - " + match.getMoment());

		ramasseursInitialContainer.getColumns().setAll(colonneRamasseurs());
		ramasseursFinalContainer.getColumns().setAll(colonneRamasseurs());

		ajouterRamasseurs.setDisable(ramasseursInitialContainer.getSelectionModel().getSelectedItem() == null);
		retirerRamasseurs.setDisable(ramasseursFinalContainer.getSelectionModel().getSelectedItem() == null);

		ramasseursInitialContainer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				ajouterRamasseurs.setDisable(ramasseursInitialContainer.getSelectionModel().getSelectedItem() == null);
			}
			
		});

		ramasseursFinalContainer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				retirerRamasseurs.setDisable(ramasseursFinalContainer.getSelectionModel().getSelectedItem() == null);
			}
			
		});

		rechargerRamasseurs();
	}

	@FXML
	private void ajouterArbitreChaise(){

		
	}

	@FXML
	private void ajouterArbitreLigne(){
		
	}

	@FXML
	private void retirerArbitre(){
		
	}

	@FXML
	private void ajouterRamasseurs(){

		RamasseursDAO.ajouterRamassage(ramasseursInitialContainer.getSelectionModel().getSelectedItem().intValue(), match);

		rechargerRamasseurs();
	}

	@FXML
	private void retirerRamasseurs(){

		RamasseursDAO.retirerRamassage(ramasseursFinalContainer.getSelectionModel().getSelectedItem().intValue(), match);

		rechargerRamasseurs();
	}

	private TableColumn<Integer, String> colonneRamasseurs(){

		final TableColumn<Integer, String> colonneRamasseurs = new TableColumn<>("Numéro Équipe");
		colonneRamasseurs.setCellValueFactory(param -> {
			final Integer num = param.getValue();
			String aff = num.toString();
			return(new SimpleStringProperty(aff));
		});

		return(colonneRamasseurs);
	}

	private void rechargerRamasseurs(){

		List<Integer> ramasseursPossibles = new ArrayList<Integer>();
		List<Integer> ramasseursPasDispos = RamasseursDAO.ramasseursPasDispos(match.getMoment());

		for(Integer equipeRamasseurs : RamasseursDAO.toutesLesEquipesDeRamasseurs()){
			if(!ramasseursPasDispos.contains(equipeRamasseurs)){
				ramasseursPossibles.add(equipeRamasseurs);
			}
		}

		ramasseursInitialContainer.getItems().setAll(ramasseursPossibles);

		List<Integer> ramasseursActuels = RamasseursDAO.ramasseursMatch(match);

		ramasseursFinalContainer.getItems().setAll(ramasseursActuels);
	}
}
