package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Terrain;
import entity.TerrainEntrainement;
import entity.TerrainMatch;

public class TerrainDAO extends DAO {

	public static Terrain trouver(int id){

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
				else {
					TerrainMatch terrain = new TerrainMatch(resultat.getInt("ID_TERRAIN"),
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
