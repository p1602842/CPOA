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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import model.ArbitreDAO;
import model.MatchDAO;
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

	TreeItem<Arbitre> arbitreChaiseItem = new TreeItem<>(new Arbitre("Arbitre de chaise"));
	TreeItem<Arbitre> arbitresLigneItem = new TreeItem<>(new Arbitre("Arbitres de ligne"));

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		match = PagePlanning.getMatchSelectionne();

		matchLabel.setText("Match n°" + match.getId() + " (" + match.getPhaseTournoi() + ") : " + match.getOpposants());
		horaireEmplacement.setText(match.getTerrain() + " - " + match.getMoment());

		TreeItem<Arbitre> arbitres = new TreeItem<>(new Arbitre("Arbitres"));
		arbitres.getChildren().setAll(arbitreChaiseItem, arbitresLigneItem);
		arbitresFinalContainer.setRoot(arbitres);
		arbitres.setExpanded(true);
		arbitreChaiseItem.setExpanded(true);
		arbitresLigneItem.setExpanded(true);

		arbitresInitialContainer.getColumns().setAll(colonneIdArbitre(), colonneNomArbitre(), colonneNationaliteArbitre(), colonneCategorieArbitre(), colonnePeutArbitrerChaise());
		arbitresFinalContainer.getColumns().setAll(colonneTreeIdArbitre(), colonneTreeNomArbitre(), colonneTreeNationaliteArbitre(), colonneTreeCategorieArbitre());
		ramasseursInitialContainer.getColumns().setAll(colonneRamasseurs());
		ramasseursFinalContainer.getColumns().setAll(colonneRamasseurs());

		arbitresFinalContainer.setRoot(arbitres);

		ajouterArbitreChaise.setDisable((arbitresInitialContainer.getSelectionModel().getSelectedItem() == null) || !(arbitresInitialContainer.getSelectionModel().getSelectedItem().peutArbitrerChaise(match)) || (match.getArbitreChaise() != null));
		ajouterArbitreLigne.setDisable(arbitresInitialContainer.getSelectionModel().getSelectedItem() == null);
		retirerArbitre.setDisable((arbitresFinalContainer.getSelectionModel().getSelectedItem() == null) || !(arbitresFinalContainer.getSelectionModel().getSelectedItem().getValue().getReel()));
		ajouterRamasseurs.setDisable(ramasseursInitialContainer.getSelectionModel().getSelectedItem() == null);
		retirerRamasseurs.setDisable(ramasseursFinalContainer.getSelectionModel().getSelectedItem() == null);

		arbitresInitialContainer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				ajouterArbitreChaise.setDisable((arbitresInitialContainer.getSelectionModel().getSelectedItem() == null) || !(arbitresInitialContainer.getSelectionModel().getSelectedItem().peutArbitrerChaise(match)) || (match.getArbitreChaise() != null));
				ajouterArbitreLigne.setDisable(arbitresInitialContainer.getSelectionModel().getSelectedItem() == null);
			}
			
		});

		arbitresFinalContainer.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				retirerArbitre.setDisable((arbitresFinalContainer.getSelectionModel().getSelectedItem() == null) || !(arbitresFinalContainer.getSelectionModel().getSelectedItem().getValue().getReel()));
			}
			
		});

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

		rechargerArbitres();
		rechargerRamasseurs();
	}

	@FXML
	private void ajouterArbitreChaise(){

		ArbitreDAO.ajouterArbitreChaise(match, arbitresInitialContainer.getSelectionModel().getSelectedItem());

		rechargerArbitres();
	}

	@FXML
	private void ajouterArbitreLigne(){

		ArbitreDAO.ajouterArbitreLigne(match, arbitresInitialContainer.getSelectionModel().getSelectedItem());

		rechargerArbitres();
	}

	@FXML
	private void retirerArbitre(){

		if(arbitresFinalContainer.getSelectionModel().getSelectedItem().getValue() != null){
			if(match.getArbitreChaise() != null){
				if(match.getArbitreChaise().equals(arbitresFinalContainer.getSelectionModel().getSelectedItem().getValue())){
					ArbitreDAO.retirerArbitreChaise(match);
				}
			}

			if(match.getArbitresLigne().contains(arbitresFinalContainer.getSelectionModel().getSelectedItem().getValue())){
				ArbitreDAO.retirerArbitreLigne(match, arbitresFinalContainer.getSelectionModel().getSelectedItem().getValue());
			}
		}

		rechargerArbitres();
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

	private TableColumn<Arbitre, String> colonneIdArbitre(){

		final TableColumn<Arbitre, String> colonneIdArbitre = new TableColumn<>("ID");
		colonneIdArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue();
			return(new SimpleStringProperty(((Integer)arbitre.getId()).toString()));
		});

		return(colonneIdArbitre);
	}

	private TableColumn<Arbitre, String> colonneNomArbitre(){

		final TableColumn<Arbitre, String> colonneNomArbitre = new TableColumn<>("Nom");
		colonneNomArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue();
			return(new SimpleStringProperty(arbitre.getPrenomNom()));
		});

		return(colonneNomArbitre);
	}

	private TableColumn<Arbitre, String> colonneNationaliteArbitre(){

		final TableColumn<Arbitre, String> colonneNationaliteArbitre = new TableColumn<>("Nationalité");
		colonneNationaliteArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue();
			return(new SimpleStringProperty(arbitre.getNationalite()));
		});

		return(colonneNationaliteArbitre);
	}

	private TableColumn<Arbitre, String> colonneCategorieArbitre(){

		final TableColumn<Arbitre, String> colonneCategorieArbitre = new TableColumn<>("Categorie");
		colonneCategorieArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue();
			return(new SimpleStringProperty(arbitre.getCategorie().getValeur()));
		});

		return(colonneCategorieArbitre);
	}

	private TableColumn<Arbitre, String> colonnePeutArbitrerChaise(){

		final TableColumn<Arbitre, String> colonnePeutArbitrerChaise = new TableColumn<>("Peut arbitrer chaise ?");
		colonnePeutArbitrerChaise.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue();
			if(arbitre.peutArbitrerChaise(match)){
				return(new SimpleStringProperty("Oui"));
			}
			else {
				return(new SimpleStringProperty("Non"));
			}
		});

		return(colonnePeutArbitrerChaise);
	}

	private TreeTableColumn<Arbitre, String> colonneTreeIdArbitre(){

		final TreeTableColumn<Arbitre, String> colonneIdArbitre = new TreeTableColumn<>("ID");
		colonneIdArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue().getValue();
			if(arbitre.getReel()){
				return(new SimpleStringProperty(((Integer)arbitre.getId()).toString()));
			}
			else {
				return(new SimpleStringProperty(arbitre.getNom()));
			}
		});

		return(colonneIdArbitre);
	}

	private TreeTableColumn<Arbitre, String> colonneTreeNomArbitre(){

		final TreeTableColumn<Arbitre, String> colonneNomArbitre = new TreeTableColumn<>("Nom");
		colonneNomArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue().getValue();
			if(arbitre.getReel()){
				return(new SimpleStringProperty(arbitre.getPrenomNom()));
			}
			else {
				return(new SimpleStringProperty());
			}
		});

		return(colonneNomArbitre);
	}

	private TreeTableColumn<Arbitre, String> colonneTreeNationaliteArbitre(){

		final TreeTableColumn<Arbitre, String> colonneNationaliteArbitre = new TreeTableColumn<>("Nationalité");
		colonneNationaliteArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue().getValue();
			if(arbitre.getReel()){
				return(new SimpleStringProperty(arbitre.getNationalite()));
			}
			else {
				return(new SimpleStringProperty());
			}
		});

		return(colonneNationaliteArbitre);
	}

	private TreeTableColumn<Arbitre, String> colonneTreeCategorieArbitre(){

		final TreeTableColumn<Arbitre, String> colonneCategorieArbitre = new TreeTableColumn<>("Catégorie");
		colonneCategorieArbitre.setCellValueFactory(param -> {
			final Arbitre arbitre = param.getValue().getValue();
			if(arbitre.getReel()){
				return(new SimpleStringProperty(arbitre.getCategorie().getValeur()));
			}
			else {
				return(new SimpleStringProperty());
			}
		});

		return(colonneCategorieArbitre);
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

	private void rechargerArbitres(){

		match = MatchDAO.recharger(match);

		List<Arbitre> arbitresPossibles = new ArrayList<Arbitre>();
		List<Arbitre> arbitresPasDispos = ArbitreDAO.pasDisponibles(match.getMoment());

		for(Arbitre arbitre : ArbitreDAO.tousLesArbitres()){
			if(!arbitresPasDispos.contains(arbitre)){
				if(!match.getArbitresLigne().contains(arbitre)){
					if((match.getArbitreChaise() == null) || (!match.getArbitreChaise().equals(arbitre))){
						arbitresPossibles.add(arbitre);
					}
				}
			}
		}

		arbitresInitialContainer.getItems().setAll(arbitresPossibles);

		arbitreChaiseItem.getChildren().clear();
		if(match.getArbitreChaise() != null){
			TreeItem<Arbitre> arbitreChaise = new TreeItem<Arbitre>(match.getArbitreChaise());
			arbitreChaiseItem.getChildren().setAll(arbitreChaise);
		}

		arbitresLigneItem.getChildren().clear();
		for(Arbitre arbitre : match.getArbitresLigne()){
			TreeItem<Arbitre> arbitreLigne = new TreeItem<Arbitre>(arbitre);
			arbitresLigneItem.getChildren().add(arbitreLigne);
		}
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
