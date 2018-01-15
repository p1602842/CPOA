package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Arbitre;
import entity.Equipe;
import entity.MatchDouble;
import util.Moment;
import util.PhaseTournoi;

public class MatchDoubleDAO extends MatchDAO {

	public static MatchDouble trouver(int id){

		String sql = "SELECT ID_ARBITRE FROM ARBITRE_LIGNE_DOUBLE WHERE ID_MATCH_DOUBLE = ?";
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

		String sql2 = "SELECT ID_EQUIPE FROM JOUE_DOUBLE WHERE ID_MATCH_DOUBLE = ?";
		List<Equipe> equipes = new ArrayList<Equipe>();

		try{
			PreparedStatement prep = prepareStatement(sql2);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				equipes.add(EquipeDAO.trouver(resultat.getInt("ID_EQUIPE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql3 = "SELECT * FROM MATCHDOUBLE WHERE ID_MATCH_DOUBLE = ?";
		Equipe equipe1 = null;
		Equipe equipe2 = null;

		if(equipes.size() >= 2){
			equipe1 = equipes.get(0);
			equipe2 = equipes.get(1);
		}
			
		try{
			PreparedStatement prep = prepareStatement(sql3);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				MatchDouble match = new MatchDouble(resultat.getInt("ID_MATCH_DOUBLE"),
						new PhaseTournoi(resultat.getInt("PHASE_TOURNOI_DOUBLE"), false),
						new Moment(resultat.getString("HORAIRE_DOUBLE")),
						TerrainDAO.trouver(resultat.getInt("ID_TERRAIN")),
						resultat.getBoolean("ACCESSIBLE_DOUBLE"),
						resultat.getBoolean("JOUE_DOUBLE"),
						resultat.getString("SCORE_DOUBLE"),
						ArbitreDAO.trouver(resultat.getInt("ID_ARBITRE")),
						arbitresLigne,
						equipe1,
						equipe2);
				return(match);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}

	public static List<MatchDouble> trouver(int idDebut, int idFin){

		List<MatchDouble> matchs = new ArrayList<MatchDouble>();

		for(int i = idDebut; i <= idFin; i++){
			matchs.add(trouver(i));
		}

		return(matchs);
	}
}
