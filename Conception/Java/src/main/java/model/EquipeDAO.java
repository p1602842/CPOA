package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Equipe;
import entity.TennisMan;

public class EquipeDAO extends DAO {

	public static Equipe trouver(int id){

		String sql = "SELECT ID_TENNISMAN FROM TENNISMAN WHERE ID_EQUIPE = ?";
		List<TennisMan> membres = new ArrayList<TennisMan>();

		try{
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				membres.add(TennisManDAO.trouver(resultat.getInt("ID_TENNISMAN")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql2 = "SELECT * FROM EQUIPE WHERE ID_EQUIPE = ?";
		
		try{
			PreparedStatement prep = prepareStatement(sql2);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				return(new Equipe(membres.get(0), membres.get(1)));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}
}
