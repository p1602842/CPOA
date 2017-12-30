package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import util.Utile;

public class ConnexionFactory {

	private ConnexionFactory(){
		
	}

	public static Connection creerConnexion(){

		Properties proprietes = new Properties();

		String driver = null;
		String url = null;
		String login = null;
		String motDePasse = null;

		try{
			proprietes.load(Utile.recupererStream("/Base de Données/bdd.properties"));
			driver = proprietes.getProperty("jdbc.driver");
			url = proprietes.getProperty("jdbc.url");
			login = proprietes.getProperty("jdbc.login");
			motDePasse = proprietes.getProperty("jdbc.motDePasse");
		} catch(Exception e){
			e.printStackTrace();
		}

		Connection connexion = null;

		try{
			Class.forName(driver);
			connexion = DriverManager.getConnection(url, login, motDePasse);
		} 
		catch(ClassNotFoundException cnfe){ 
			System.out.println("Driver introuvable : "); 
			cnfe.printStackTrace(); 
		}
		catch(SQLException sqle){
			System.out.println("Erreur SQL : ");
			sqle.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Autre erreur : ");
			e.printStackTrace();
		}

		return(connexion);
	}

}
