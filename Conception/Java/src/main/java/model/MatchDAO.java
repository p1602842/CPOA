package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Arbitre;
import entity.Match;
import entity.MatchDouble;
import entity.MatchSimple;
import entity.Terrain;
import entity.TerrainEntrainement;
import util.Moment;

public abstract class MatchDAO extends DAO {

	public static List<Integer> ramasseursMatch(boolean enDouble, int idMatch){

		List<Integer> ramasseurs = new ArrayList<Integer>();

		String sql = "";

		if(!enDouble){
			sql = "SELECT ID_EQUIPE_RAMASSEURS FROM RAMASSE_SIMPLE WHERE ID_MATCH_SIMPLE = ?";
		}
		else {
			sql = "SELECT ID_EQUIPE_RAMASSEURS FROM RAMASSE_DOUBLE WHERE ID_MATCH_DOUBLE = ?";
		}

		try{
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, idMatch);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				ramasseurs.add(resultat.getInt("ID_EQUIPE_RAMASSEURS"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(ramasseurs);
	}

	public static List<Integer> ramasseursMatch(Match match){

		if(match instanceof MatchDouble){
			return(ramasseursMatch(true, match.getId()));
		}
		else {
			return(ramasseursMatch(false, match.getId()));
		}
	}

	public static List<Match> matchsArbitre(int idArbitre){

		List<Match> matchs = new ArrayList<Match>();
		String sqlLigneSimple = "SELECT ID_MATCH_SIMPLE FROM ARBITRE_LIGNE_SIMPLE WHERE ID_ARBITRE = ?";
		String sqlChaiseSimple = "SELECT ID_MATCH_SIMPLE FROM MATCHSIMPLE WHERE ID_ARBITRE = ?";
		String sqlLigneDouble = "SELECT ID_MATCH_DOUBLE FROM ARBITRE_LIGNE_DOUBLE WHERE ID_ARBITRE = ?";
		String sqlChaiseDouble = "SELECT ID_MATCH_DOUBLE FROM MATCHDOUBLE WHERE ID_ARBITRE = ?";

		try{
			PreparedStatement prep = prepareStatement(sqlLigneSimple);

			prep.setInt(1, idArbitre);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				matchs.add(MatchSimpleDAO.trouver(resultat.getInt("ID_MATCH_SIMPLE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		try{
			PreparedStatement prep = prepareStatement(sqlChaiseSimple);

			prep.setInt(1, idArbitre);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				matchs.add(MatchSimpleDAO.trouver(resultat.getInt("ID_MATCH_SIMPLE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		try{
			PreparedStatement prep = prepareStatement(sqlLigneDouble);

			prep.setInt(1, idArbitre);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				matchs.add(MatchDoubleDAO.trouver(resultat.getInt("ID_MATCH_DOUBLE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		try{
			PreparedStatement prep = prepareStatement(sqlChaiseDouble);

			prep.setInt(1, idArbitre);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				matchs.add(MatchDoubleDAO.trouver(resultat.getInt("ID_MATCH_DOUBLE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(matchs);
	}

	public static List<Match> matchsArbitre(Arbitre arbitre){

		return(matchsArbitre(arbitre.getId()));
	}

	public static List<Match> matchsEquipeRamassage(int idEquipeRamassage){

		List<Match> matchs = new ArrayList<Match>();
		String sqlSimple = "SELECT ID_MATCH_SIMPLE FROM RAMASSE_SIMPLE WHERE ID_EQUIPE_RAMASSEURS = ?";
		String sqlDouble = "SELECT ID_MATCH_DOUBLE FROM RAMASSE_DOUBLE WHERE ID_EQUIPE_RAMASSEURS = ?";

		try{
			PreparedStatement prep = prepareStatement(sqlSimple);

			prep.setInt(1, idEquipeRamassage);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				matchs.add(MatchSimpleDAO.trouver(resultat.getInt("ID_MATCH_SIMPLE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		try{
			PreparedStatement prep = prepareStatement(sqlDouble);

			prep.setInt(1, idEquipeRamassage);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				matchs.add(MatchDoubleDAO.trouver(resultat.getInt("ID_MATCH_DOUBLE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(matchs);
	}

	public static List<Moment> momentsImpossibles(Match match){

		List<Moment> momentsImpossibles = new ArrayList<Moment>();

		for(Match matchArbitreChaise : MatchDAO.matchsArbitre(match.getArbitreChaise())){
			momentsImpossibles.add(matchArbitreChaise.getMoment());
		}

		for(Arbitre arbitre : match.getArbitresLigne()){
			for(Match matchArbitreLigne : MatchDAO.matchsArbitre(arbitre)){
				momentsImpossibles.add(matchArbitreLigne.getMoment());
			}
		}

		for(Integer equipeRamasseurs : ramasseursMatch(match)){
			for(Match matchEquipeRamasseurs : MatchDAO.matchsEquipeRamassage(equipeRamasseurs.intValue())){
				momentsImpossibles.add(matchEquipeRamasseurs.getMoment());
			}
		}

		while(momentsImpossibles.contains(match.getMoment())){
			momentsImpossibles.remove(match.getMoment());
		}

		return(momentsImpossibles);
	}

	public static List<Terrain> terrainsImpossibles(Moment moment){

		List<Terrain> terrainsImpossibles = new ArrayList<Terrain>();

		String sqlSimple = "SELECT ID_TERRAIN FROM MATCHSIMPLE WHERE HORAIRE_SIMPLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sqlSimple);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				Terrain terrain = TerrainDAO.trouver(resultat.getInt("ID_TERRAIN"));
				terrainsImpossibles.add(terrain);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sqlDouble = "SELECT ID_TERRAIN FROM MATCHDOUBLE WHERE HORAIRE_DOUBLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sqlDouble);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				Terrain terrain = TerrainDAO.trouver(resultat.getInt("ID_TERRAIN"));
				terrainsImpossibles.add(terrain);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(terrainsImpossibles);
	}

	public static boolean modifierHoraireEmplacementMatch(Match match, Moment moment, Terrain terrain){

		String table;
		String champ;

		if(match instanceof MatchSimple){
			table = "MATCHSIMPLE";
			champ = "SIMPLE";
		}
		else {
			table = "MATCHDOUBLE";
			champ = "DOUBLE";
		}

		String sql = "UPDATE " + table + " SET HORAIRE_" + champ + " = ?, ID_TERRAIN = ? WHERE ID_MATCH_" + champ + " = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setString(1, moment.getEnregistrement());
			prep.setInt(2, terrain.getId());
			prep.setInt(3, match.getId());

			int nb = prep.executeUpdate();

			return(nb >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}
}
