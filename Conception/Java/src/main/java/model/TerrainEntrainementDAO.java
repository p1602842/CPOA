package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.TerrainEntrainement;

public class TerrainEntrainementDAO extends DAO {

	public static TerrainEntrainement trouver(int id){

		String sql = "SELECT * FROM TERRAIN WHERE ID_TERRAIN = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				if(resultat.getBoolean("ENTRAINEMENT")){
					TerrainEntrainement terrain = new TerrainEntrainement(resultat.getInt("ID_TERRAIN"),
							resultat.getString("NOM_TERRAIN"),
							resultat.getString("LOCALISATION"));
					return(terrain);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}
}
