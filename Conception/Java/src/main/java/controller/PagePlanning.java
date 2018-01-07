package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import entity.Arbitre;
import entity.Match;
import entity.MatchDouble;
import entity.MatchSimple;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.MatchDoubleDAO;
import model.MatchSimpleDAO;
import model.TennisManDAO;
import model.TerrainDAO;
import util.Horaire;
import util.Moment;
import util.PhaseTournoi;

public class PagePlanning implements Initializable {

	@FXML
	private TableView<MatchSimple> tableQ16;

	@FXML
	private TableView<MatchSimple> tableQ8;

	@FXML
	private TableView<MatchSimple> tableQ4;

	@FXML
	private TableView<MatchSimple> tableS16;

	@FXML
	private TableView<MatchSimple> tableS8;

	@FXML
	private TableView<MatchSimple> tableS4;

	@FXML
	private TableView<MatchSimple> tableS2;

	@FXML
	private TableView<MatchSimple> tableS1;

	@FXML
	private TableView<MatchDouble> tableD16;

	@FXML
	private TableView<MatchDouble> tableD8;

	@FXML
	private TableView<MatchDouble> tableD4;

	@FXML
	private TableView<MatchDouble> tableD2;

	@FXML
	private TableView<MatchDouble> tableD1;

	@FXML
	private VBox boxQ16;

	@FXML
	private VBox boxQ8;

	@FXML
	private VBox boxQ4;

	@FXML
	private VBox boxS16;

	@FXML
	private VBox boxS8;

	@FXML
	private VBox boxS4;

	@FXML
	private VBox boxS2;

	@FXML
	private VBox boxS1;

	@FXML
	private VBox boxD16;

	@FXML
	private VBox boxD8;

	@FXML
	private VBox boxD4;

	@FXML
	private VBox boxD2;

	@FXML
	private VBox boxD1;

	private MatchSimple matchQ16;

	private List<TableView<MatchSimple>> tablesSimple = Arrays.asList(tableQ16, tableQ8, tableQ4, tableS16, tableS8, tableS4, tableS2, tableS1);

	private List<TableView<MatchDouble>> tablesDouble = Arrays.asList(tableD16, tableD8, tableD4, tableD2, tableD1);

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableQ16.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableQ8.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableQ4.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableS16.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableS8.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableS4.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableS2.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableS1.getColumns().setAll(colonneIdSimpleFactory(), colonneTerrainSimpleFactory(), colonneHoraireSimpleFactory());
		tableD16.getColumns().setAll(colonneIdDoubleFactory(), colonneTerrainDoubleFactory(), colonneHoraireDoubleFactory());
		tableD8.getColumns().setAll(colonneIdDoubleFactory(), colonneTerrainDoubleFactory(), colonneHoraireDoubleFactory());
		tableD4.getColumns().setAll(colonneIdDoubleFactory(), colonneTerrainDoubleFactory(), colonneHoraireDoubleFactory());
		tableD2.getColumns().setAll(colonneIdDoubleFactory(), colonneTerrainDoubleFactory(), colonneHoraireDoubleFactory());
		tableD1.getColumns().setAll(colonneIdDoubleFactory(), colonneTerrainDoubleFactory(), colonneHoraireDoubleFactory());

		boxQ16.getChildren().setAll(panneauMatchSimple(tableQ16.getSelectionModel().selectedItemProperty()));
		boxQ8.getChildren().setAll(panneauMatchSimple(tableQ8.getSelectionModel().selectedItemProperty()));
		boxQ4.getChildren().setAll(panneauMatchSimple(tableQ4.getSelectionModel().selectedItemProperty()));
		boxS16.getChildren().setAll(panneauMatchSimple(tableS16.getSelectionModel().selectedItemProperty()));
		boxS8.getChildren().setAll(panneauMatchSimple(tableS8.getSelectionModel().selectedItemProperty()));
		boxS4.getChildren().setAll(panneauMatchSimple(tableS4.getSelectionModel().selectedItemProperty()));
		boxS2.getChildren().setAll(panneauMatchSimple(tableS2.getSelectionModel().selectedItemProperty()));
		boxS1.getChildren().setAll(panneauMatchSimple(tableS1.getSelectionModel().selectedItemProperty()));
		boxD16.getChildren().setAll(panneauMatchDouble(tableD16.getSelectionModel().selectedItemProperty()));
		boxD8.getChildren().setAll(panneauMatchDouble(tableD8.getSelectionModel().selectedItemProperty()));
		boxD4.getChildren().setAll(panneauMatchDouble(tableD4.getSelectionModel().selectedItemProperty()));
		boxD2.getChildren().setAll(panneauMatchDouble(tableD2.getSelectionModel().selectedItemProperty()));
		boxD1.getChildren().setAll(panneauMatchDouble(tableD1.getSelectionModel().selectedItemProperty()));

		tableQ16.getItems().setAll(MatchSimpleDAO.trouver(1, 16));
		tableQ8.getItems().setAll(MatchSimpleDAO.trouver(17, 24));
		tableQ4.getItems().setAll(MatchSimpleDAO.trouver(25, 28));
		tableS16.getItems().setAll(MatchSimpleDAO.trouver(29, 44));
		tableS8.getItems().setAll(MatchSimpleDAO.trouver(45, 52));
		tableS4.getItems().setAll(MatchSimpleDAO.trouver(53, 56));
		tableS2.getItems().setAll(MatchSimpleDAO.trouver(57, 58));
		tableS1.getItems().setAll(MatchSimpleDAO.trouver(59, 59));
		tableD16.getItems().setAll(MatchDoubleDAO.trouver(1, 16));
		tableD8.getItems().setAll(MatchDoubleDAO.trouver(17, 24));
		tableD4.getItems().setAll(MatchDoubleDAO.trouver(25, 28));
		tableD2.getItems().setAll(MatchDoubleDAO.trouver(29, 30));
		tableD1.getItems().setAll(MatchDoubleDAO.trouver(31, 31));
		
	}

	@FXML
	private void onButtonHorairesActivated(){
		
	}

	@FXML
	private void onButtonStaffActivated(){
		
	}

	@FXML
	private void onButtonScoresActivated(){
		
	}

	private TableColumn<MatchSimple, String> colonneIdSimpleFactory(){

		final TableColumn<MatchSimple, String> colonneId = new TableColumn<>("ID");
		colonneId.setCellValueFactory(param -> {
			final Match match = param.getValue();
			return(new SimpleStringProperty(((Integer)match.getId()).toString()));
		});

		return(colonneId);
	}

	private TableColumn<MatchSimple, String> colonneTerrainSimpleFactory(){

		final TableColumn<MatchSimple, String> colonneTerrain = new TableColumn<>("Terrain");
		colonneTerrain.setCellValueFactory(param -> {
			final Match match = param.getValue();
			String nom = "";
			if(match.getTerrain() != null) nom = match.getTerrain().getNom();
			return(new SimpleStringProperty(nom));
		});

		return(colonneTerrain);
	}

	private TableColumn<MatchSimple, String> colonneHoraireSimpleFactory(){

		final TableColumn<MatchSimple, String> colonneHoraire = new TableColumn<>("Horaire");
		colonneHoraire.setCellValueFactory(param -> {
			final Match match = param.getValue();
			String moment = "";
			if(match.getMoment() != null) moment = match.getMoment().toString();
			return(new SimpleStringProperty(moment));
		});

		return(colonneHoraire);
	}

	private TableColumn<MatchDouble, String> colonneIdDoubleFactory(){

		final TableColumn<MatchDouble, String> colonneId = new TableColumn<>("ID");
		colonneId.setCellValueFactory(param -> {
			final Match match = param.getValue();
			return(new SimpleStringProperty(((Integer)match.getId()).toString()));
		});

		return(colonneId);
	}

	private TableColumn<MatchDouble, String> colonneTerrainDoubleFactory(){

		final TableColumn<MatchDouble, String> colonneTerrain = new TableColumn<>("Terrain");
		colonneTerrain.setCellValueFactory(param -> {
			final Match match = param.getValue();
			String moment = "";
			if(match.getMoment() != null) moment = match.getMoment().toString();
			return(new SimpleStringProperty(moment));
		});

		return(colonneTerrain);
	}

	private TableColumn<MatchDouble, String> colonneHoraireDoubleFactory(){

		final TableColumn<MatchDouble, String> colonneHoraire = new TableColumn<>("Horaire");
		colonneHoraire.setCellValueFactory(param -> {
			final Match match = param.getValue();
			String moment = "";
			if(match.getMoment() != null) moment = match.getMoment().toString();
			return(new SimpleStringProperty(moment));
		});

		return(colonneHoraire);
	}

	@SuppressWarnings("unchecked")
	private List<Node> panneauMatchSimple(ReadOnlyObjectProperty<MatchSimple> match){

		List<Node> elements = new ArrayList<Node>();

		Text tennisMan1 = new Text();
		Text vs = new Text("VS");
		Text tennisMan2 = new Text();
		Text score = new Text();

		Text arbitres = new Text("Arbitres :");
		Text arbitreChaise = new Text("Arbitre chaise : ");
		Text arbitresLigne = new Text("Arbitres ligne :");
		Text arbitreLigne1 = new Text();
		Text arbitreLigne2 = new Text();
		Text arbitreLigne3 = new Text();
		Text arbitreLigne4 = new Text();
		Text arbitreLigne5 = new Text();
		Text arbitreLigne6 = new Text();
		Text arbitreLigne7 = new Text();
		Text arbitreLigne8 = new Text();

		elements.add(tennisMan1);
		elements.add(vs);
		elements.add(tennisMan2);
		elements.add(score);
		elements.add(arbitres);
		elements.add(arbitreChaise);
		elements.add(arbitresLigne);
		elements.add(arbitreLigne1);
		elements.add(arbitreLigne2);
		elements.add(arbitreLigne3);
		elements.add(arbitreLigne4);
		elements.add(arbitreLigne5);
		elements.add(arbitreLigne6);
		elements.add(arbitreLigne7);
		elements.add(arbitreLigne8);

		match.addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				MatchSimple nouveauMatch = (MatchSimple)newValue;
				if(nouveauMatch.getTennisMan(1) != null) tennisMan1.setText(nouveauMatch.getTennisMan(1).getPrenomNom());
				else tennisMan1.setText("");
				if(nouveauMatch.getTennisMan(2) != null) tennisMan2.setText(nouveauMatch.getTennisMan(2).getPrenomNom());
				else tennisMan2.setText("");
				score.setText(nouveauMatch.getScore());
				if(nouveauMatch.getArbitreChaise() != null) arbitreChaise.setText("Arbitre chaise : " + nouveauMatch.getArbitreChaise().getPrenomNom());
				else arbitreChaise.setText("Arbitre chaise : ");
				if(nouveauMatch.getArbitresLigne().size() >= 1) arbitreLigne1.setText("- " + nouveauMatch.getArbitresLigne().get(0).getPrenomNom());
				else arbitreLigne1.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 2) arbitreLigne2.setText("- " + nouveauMatch.getArbitresLigne().get(1).getPrenomNom());
				else arbitreLigne2.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 3) arbitreLigne3.setText("- " + nouveauMatch.getArbitresLigne().get(2).getPrenomNom());
				else arbitreLigne3.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 4) arbitreLigne4.setText("- " + nouveauMatch.getArbitresLigne().get(3).getPrenomNom());
				else arbitreLigne4.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 5) arbitreLigne5.setText("- " + nouveauMatch.getArbitresLigne().get(4).getPrenomNom());
				else arbitreLigne5.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 6) arbitreLigne6.setText("- " + nouveauMatch.getArbitresLigne().get(5).getPrenomNom());
				else arbitreLigne6.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 7) arbitreLigne7.setText("- " + nouveauMatch.getArbitresLigne().get(6).getPrenomNom());
				else arbitreLigne7.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 8) arbitreLigne8.setText("- " + nouveauMatch.getArbitresLigne().get(7).getPrenomNom());
				else arbitreLigne8.setText("");
			}
			
		});

		return(elements);
	}

	@SuppressWarnings("unchecked")
	private List<Node> panneauMatchDouble(ReadOnlyObjectProperty<MatchDouble> match){

		List<Node> elements = new ArrayList<Node>();

		Text tennisMan1 = new Text();
		Text vs = new Text("VS");
		Text tennisMan2 = new Text();
		Text score = new Text();

		Text arbitres = new Text("Arbitres :");
		Text arbitreChaise = new Text("Arbitre chaise : ");
		Text arbitresLigne = new Text("Arbitres ligne :");
		Text arbitreLigne1 = new Text();
		Text arbitreLigne2 = new Text();
		Text arbitreLigne3 = new Text();
		Text arbitreLigne4 = new Text();
		Text arbitreLigne5 = new Text();
		Text arbitreLigne6 = new Text();
		Text arbitreLigne7 = new Text();
		Text arbitreLigne8 = new Text();

		elements.add(tennisMan1);
		elements.add(vs);
		elements.add(tennisMan2);
		elements.add(score);
		elements.add(arbitres);
		elements.add(arbitreChaise);
		elements.add(arbitresLigne);
		elements.add(arbitreLigne1);
		elements.add(arbitreLigne2);
		elements.add(arbitreLigne3);
		elements.add(arbitreLigne4);
		elements.add(arbitreLigne5);
		elements.add(arbitreLigne6);
		elements.add(arbitreLigne7);
		elements.add(arbitreLigne8);

		match.addListener(new ChangeListener() {

			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				MatchDouble nouveauMatch = (MatchDouble)newValue;
				if(nouveauMatch.getEquipe(1) != null) tennisMan1.setText(nouveauMatch.getEquipe(1).getNomsMembres());
				else tennisMan1.setText("");
				if(nouveauMatch.getEquipe(2) != null) tennisMan2.setText(nouveauMatch.getEquipe(2).getNomsMembres());
				else tennisMan2.setText("");
				score.setText(nouveauMatch.getScore());
				if(nouveauMatch.getArbitreChaise() != null) arbitreChaise.setText("Arbitre chaise : " + nouveauMatch.getArbitreChaise().getPrenomNom());
				else arbitreChaise.setText("Arbitre chaise : ");
				if(nouveauMatch.getArbitresLigne().size() >= 1) arbitreLigne1.setText("- " + nouveauMatch.getArbitresLigne().get(0).getPrenomNom());
				else arbitreLigne1.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 2) arbitreLigne2.setText("- " + nouveauMatch.getArbitresLigne().get(1).getPrenomNom());
				else arbitreLigne2.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 3) arbitreLigne3.setText("- " + nouveauMatch.getArbitresLigne().get(2).getPrenomNom());
				else arbitreLigne3.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 4) arbitreLigne4.setText("- " + nouveauMatch.getArbitresLigne().get(3).getPrenomNom());
				else arbitreLigne4.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 5) arbitreLigne5.setText("- " + nouveauMatch.getArbitresLigne().get(4).getPrenomNom());
				else arbitreLigne5.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 6) arbitreLigne6.setText("- " + nouveauMatch.getArbitresLigne().get(5).getPrenomNom());
				else arbitreLigne6.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 7) arbitreLigne7.setText("- " + nouveauMatch.getArbitresLigne().get(6).getPrenomNom());
				else arbitreLigne7.setText("");
				if(nouveauMatch.getArbitresLigne().size() >= 8) arbitreLigne8.setText("- " + nouveauMatch.getArbitresLigne().get(7).getPrenomNom());
				else arbitreLigne8.setText("");
			}
			
		});

		return(elements);
	}
}
