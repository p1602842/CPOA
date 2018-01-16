package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Arbitre;
import entity.Match;
import entity.MatchSimple;
import entity.TennisMan;
import entity.Terrain;
import util.Horaire;
import util.Moment;
import util.PhaseTournoi;

public class MatchSimpleDAO extends MatchDAO {

	public static MatchSimple trouver(int id){

		String sql = "SELECT ID_ARBITRE FROM ARBITRE_LIGNE_SIMPLE WHERE ID_MATCH_SIMPLE = ?";
		List<Arbitre> arbitresLigne = new ArrayList<Arbitre>();

		try{
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				arbitresLigne.add(ArbitreDAO.trouver(resultat.getInt("ID_ARBITRE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql2 = "SELECT ID_TENNISMAN FROM JOUE_SIMPLE WHERE ID_MATCH_SIMPLE = ?";
		List<TennisMan> tennisMen = new ArrayList<TennisMan>();

		try{
			PreparedStatement prep = prepareStatement(sql2);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				tennisMen.add(TennisManDAO.trouver(resultat.getInt("ID_TENNISMAN")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql3 = "SELECT * FROM MATCHSIMPLE WHERE ID_MATCH_SIMPLE = ?";
		TennisMan tennisMan1 = null;
		TennisMan tennisMan2 = null;

		if(tennisMen.size() >= 2){
			tennisMan1 = tennisMen.get(0);
			tennisMan2 = tennisMen.get(1);
		}
			
		try{
			PreparedStatement prep = prepareStatement(sql3);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				MatchSimple match = new MatchSimple(resultat.getInt("ID_MATCH_SIMPLE"),
						new PhaseTournoi(resultat.getInt("PHASE_TOURNOI_SIMPLE"), false),
						new Moment(resultat.getString("HORAIRE_SIMPLE")),
						TerrainDAO.trouver(resultat.getInt("ID_TERRAIN")),
						resultat.getBoolean("ACCESSIBLE_SIMPLE"),
						resultat.getBoolean("JOUE_SIMPLE"),
						resultat.getString("SCORE_SIMPLE"),
						ArbitreDAO.trouver(resultat.getInt("ID_ARBITRE")),
						arbitresLigne,
						tennisMan1,
						tennisMan2);
				return(match);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}

	public static List<MatchSimple> trouver(int idDebut, int idFin){

		List<MatchSimple> matchs = new ArrayList<MatchSimple>();

		for(int i = idDebut; i <= idFin; i++){
			matchs.add(trouver(i));
		}

		return(matchs);
	}
}
