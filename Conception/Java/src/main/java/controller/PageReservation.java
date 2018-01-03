package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entity.Reservation;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.ReservationDAO;
import view.App;

public class PageReservation implements Initializable {

	@FXML
	private BorderPane pageReservation;

	@FXML
	private TableView<Reservation> table;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		List<Reservation> reservations = ReservationDAO.reservationsJoueur(App.getTennisManConnecte());

		table.getItems().setAll(reservations);

		final TableColumn<Reservation, String> colonneTerrain = new TableColumn<>("Terrain");
		colonneTerrain.setCellValueFactory(param -> {
			final Reservation reservation = param.getValue();
			return(new SimpleStringProperty(reservation.getTerrain().getNom()));
		});

		final TableColumn<Reservation, String> colonneHoraire = new TableColumn<>("Horaire");
		colonneHoraire.setCellValueFactory(param -> {
			final Reservation reservation = param.getValue();
			return(new SimpleStringProperty(reservation.getMomentReservation().toString()));
		});

		final TableColumn<Reservation, String> colonneAnnuler = new TableColumn<>();
		colonneAnnuler.setCellValueFactory(new PropertyValueFactory<>("coucou"));

		Callback<TableColumn<Reservation, String>, TableCell<Reservation, String>> cellFactory = new Callback<TableColumn<Reservation, String>, TableCell<Reservation, String>>(){

			@Override
			public TableCell<Reservation, String> call(TableColumn<Reservation, String> param) {

				final TableCell<Reservation, String> cell = new TableCell<Reservation, String>() {

					final Button bouton = new Button("Annuler");

					@Override
					public void updateItem(String item, boolean empty){
						super.updateItem(item, empty);
						if(empty){
							setGraphic(null);
							setText(null);
						} else {
							bouton.setOnAction(event -> {
								System.out.println(ReservationDAO.annulerReservation(getTableView().getItems().get(getIndex()).getId()));
								App.rechargerConteneur();
							});
							setGraphic(bouton);
							setText(null);
						}
					}
				};
				return(cell);
			}
			
		};

		colonneAnnuler.setCellFactory(cellFactory);

		table.getColumns().setAll(colonneTerrain, colonneHoraire, colonneAnnuler);
	}
}
