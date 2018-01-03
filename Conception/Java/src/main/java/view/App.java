package view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import entity.TennisMan;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.AccesBD;
import util.Utile;

public class App extends Application {

	private static final List<String> ECRANS_ACCESSIBLES_SANS_CONNEXION = Arrays.asList("accueil", "affichage planning", "plan");
	private static boolean connecte = false;
	private static String rpConnecte = null;
	private static TennisMan tennisManConnecte = null;

	private static String ecran = "accueil";
	private static StackPane conteneur = new StackPane();

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
		rechargerConteneur();
	}

	public static String getEcran(){

		return(ecran);
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

		if(!ECRANS_ACCESSIBLES_SANS_CONNEXION.contains(ecran)){
			setEcran("accueil");
		}

		App.rechargerConteneur();
	}

	public static boolean getConnecte(){

		return(connecte);
	}

	public static String getRpConnecte(){

		return(rpConnecte);
	}

	public static TennisMan getTennisManConnecte(){

		return(tennisManConnecte);
	}

	public static void rechargerConteneur(){

		conteneur.getChildren().setAll();

		try {
			Parent ecranParent = (Parent)Utile.chargerFxml(ecran);

			conteneur.getChildren().setAll(ecranParent);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
