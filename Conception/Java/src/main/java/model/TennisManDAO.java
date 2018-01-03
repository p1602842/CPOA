package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.TennisMan;

public class TennisManDAO extends DAO {

	public static TennisMan trouver(int id){

		String sql = "SELECT * FROM TENNISMAN WHERE ID_TENNISMAN = ?";
		
		try{
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				TennisMan tennisMan = new TennisMan(resultat.getString("NOM_TENNISMAN"),
						resultat.getString("PRENOM_TENNISMAN"),
						resultat.getInt("RANG"),
						resultat.getInt("AGE"),
						resultat.getString("NATIONALITE_TENNISMAN"));
				return(tennisMan);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}

	public static Integer connecte(String identifiantConnexion, String mdp){

		if(identifiantConnexion.contains("_")){

			String[] morceaux = identifiantConnexion.split("_");
			String prenom = morceaux[0];
			String nom = morceaux[1];

			PreparedStatement prepQuelTennisMan = null;

			String sql = "SELECT ID_TENNISMAN, PRENOM_TENNISMAN, NOM_TENNISMAN, MDP_TENNISMAN FROM TENNISMAN WHERE UPPER(PRENOM_TENNISMAN) = ? AND UPPER(NOM_TENNISMAN) = ?";

			try {
				prepQuelTennisMan = prepareStatement(sql);

				prepQuelTennisMan.setString(1, prenom.toUpperCase());
				prepQuelTennisMan.setString(2, nom.toUpperCase());

				ResultSet resultat = prepQuelTennisMan.executeQuery();

				if(resultat.next()){

					int idTable = resultat.getInt("ID_TENNISMAN");
					String prenomTable = resultat.getString("PRENOM_TENNISMAN");
					String nomTable = resultat.getString("NOM_TENNISMAN");
					String mdpTable = resultat.getString("MDP_TENNISMAN");

					if(identifiantConnexion.equals(prenomTable.toLowerCase() + "_" + nomTable.toLowerCase()) && mdp.equals(mdpTable)){
						return(idTable);
					}
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}

		return(null);
	}
}
