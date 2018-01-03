package view;

import java.io.IOException;
import java.net.URL;

import entity.TennisMan;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.AccesBD;
import util.Utile;

public class App extends Application {

	public static boolean connecte = false;
	public static String rpConnecte = null;
	public static TennisMan tennisManConnecte = null;

	public static String ecran = "accueil";
	public static StackPane conteneur = new StackPane();

	@Override
	public void start(Stage stage) throws IOException{

		rechargerConteneur();

		final Scene scene = new Scene(conteneur, 800, 600);

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

	public static void setEcran(String newEcran){

		ecran = newEcran;
	}

	public static void setRpConnecte(String rp){

		rpConnecte = rp;
		tennisManConnecte = null;
		connecte = true;

		App.rechargerConteneur();
	}

	public static void setTennisManConnecte(TennisMan tennisMan){

		rpConnecte = null;
		tennisManConnecte = tennisMan;
		connecte = true;

		App.rechargerConteneur();
	}

	public static void deconnecter(){

		rpConnecte = null;
		tennisManConnecte = null;
		connecte = false;

		App.rechargerConteneur();
	}

	public static void rechargerConteneur(){

		conteneur.getChildren().setAll();

		try {
			URL fxmlUrl = Utile.recupererFichier("/Interface/Content/" + ecran + ".fxml").toURI().toURL();
			FXMLLoader chargeurFxml = new FXMLLoader(fxmlUrl);
			final Node ecranFxml = chargeurFxml.load();
			Parent ecranParent = (Parent)ecranFxml;

			conteneur.getChildren().setAll(ecranParent);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
