package controller;

import entity.TennisMan;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.ResponsablePlanningDAO;
import model.TennisManDAO;
import view.App;

public class Connexion {

	@FXML
	private TextField loginField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Text target;
	
	@FXML
	private void onButtonActivated(){

		String connexionRP = ResponsablePlanningDAO.connecte(loginField.getText(), passwordField.getText());

		if(connexionRP != null){
			App.setRpConnecte(connexionRP);
			target.setText("Bienvenue " + connexionRP + ". Vous êtes désormais connecté.");
		}
		else {
			Integer connexionTennisMan = TennisManDAO.connecte(loginField.getText(), passwordField.getText());
			if(connexionTennisMan != null){
				TennisMan tennisMan = TennisManDAO.trouver(connexionTennisMan.intValue());
				App.setTennisManConnecte(tennisMan);
				target.setText("Bienvenue " + tennisMan.getPrenom() + " " + tennisMan.getNom() + ". Vous êtes désormais connecté.");
			} else {
				target.setText("La connexion a échoué. Veuillez réessayer.");
			}
		}
	}
}
