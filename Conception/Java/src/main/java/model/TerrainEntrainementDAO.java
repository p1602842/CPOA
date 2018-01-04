package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public static List<TerrainEntrainement> tousLesTerrainsEntrainement(){

		List<TerrainEntrainement> terrains = new ArrayList<TerrainEntrainement>();

		String sql = "SELECT * FROM TERRAIN";

		try {
			ResultSet resultat = executeQuery(sql);

			while(resultat.next()){
				if(resultat.getBoolean("ENTRAINEMENT")){
					TerrainEntrainement terrain = new TerrainEntrainement(resultat.getInt("ID_TERRAIN"),
							resultat.getString("NOM_TERRAIN"),
							resultat.getString("LOCALISATION"));
					terrains.add(terrain);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(terrains);
	}
}
