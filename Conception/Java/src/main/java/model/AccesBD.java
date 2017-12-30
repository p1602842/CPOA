package model;

import java.sql.Connection;
import java.sql.ResultSet;

public class AccesBD {

	private Connection connexion = null;
	private static AccesBD instance = null;

	public AccesBD(){
		
		connexion = ConnexionFactory.creerConnexion();
	}

	public static AccesBD getInstance(){

		if(instance == null){
			instance = new AccesBD();
		}
		return(instance);
	}

	public Connection getConnexion(){

		return(connexion);
	}

	public static boolean estValide(Connection connexion){

		if(connexion == null){
			return false;
		}

		ResultSet ping = null;

		try{
			if(connexion.isClosed()){
				return false;
			}
			ping = connexion.createStatement().executeQuery("SELECT 1");
			return ping.next();
		} catch(Exception e) {
			return false;
		} finally {
			if(ping != null){
				try{
					ping.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void fermerConnexion(){

		if(connexion != null){
			try{
				connexion.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
