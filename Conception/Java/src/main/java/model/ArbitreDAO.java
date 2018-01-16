package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Arbitre;

public class ArbitreDAO extends DAO {

	public static Arbitre trouver(int id){

		String sql = "SELECT * FROM ARBITRE WHERE ID_ARBITRE = ?";
		
		try{
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				Arbitre arbitre = new Arbitre(resultat.getInt("ID_ARBITRE"),
						resultat.getString("NOM_ARBITRE"),
						resultat.getString("PRENOM_ARBITRE"),
						resultat.getString("NATIONALITE_ARBITRE"),
						resultat.getString("CATEGORIE"));
				return(arbitre);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}
}
