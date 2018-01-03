package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResponsablePlanningDAO extends DAO {

	public static String connecte(String id, String mdp){

		PreparedStatement prepQuelRespo = null;

		try {
			String sql = "SELECT IDENTIFIANT_RP_PLANNING, MDP_RP_PLANNING FROM RESPOPLANNING WHERE IDENTIFIANT_RP_PLANNING = ?";

			prepQuelRespo = prepareStatement(sql);

			prepQuelRespo.setString(1, id);

			ResultSet resultat = prepQuelRespo.executeQuery();

			if(resultat.next()){

				String idTable = resultat.getString("IDENTIFIANT_RP_PLANNING");
				String mdpTable = resultat.getString("MDP_RP_PLANNING");

				if(id.equals(idTable) && mdp.equals(mdpTable)){
					return(id);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}
}
