package view;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.AccesBD;
import util.Utile;

public class App extends Application {

	public static boolean connecte = false;

	@Override
	public void start(Stage stage) throws IOException{

		URL fxmlUrl = Utile.recupererFichier("/Interface/Content/accueil.fxml").toURI().toURL();
		FXMLLoader chargeurFxml = new FXMLLoader(fxmlUrl);
		final Node accueilFxml = chargeurFxml.load();
		BorderPane accueil = (BorderPane)accueilFxml;

		final Scene scene = new Scene(accueil, 800, 600);

		stage.setTitle("GPTL");
		stage.setScene(scene);

		stage.show();
	}

	@Override
	public void stop(){

		AccesBD.getInstance().fermerConnexion();
	}

	public static void main(String[] args){

		launch(args);
	}
}
