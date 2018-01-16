package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Match;
import entity.MatchSimple;
import util.Moment;

public class RamasseursDAO extends DAO {

	public static List<Integer> toutesLesEquipesDeRamasseurs(){

		List<Integer> equipesRamasseurs = new ArrayList<Integer>();
		String sql = "SELECT ID_EQUIPE_RAMASSEURS FROM EQUIPERAMASSEURS";

		try {
			ResultSet resultat = executeQuery(sql);

			while(resultat.next()){
				equipesRamasseurs.add(new Integer(resultat.getInt("ID_EQUIPE_RAMASSEURS")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(equipesRamasseurs);
	}

	public static List<Integer> ramasseursMatch(Match match){

		List<Integer> ramasseurs = new ArrayList<Integer>();
		String sql;

		if(match instanceof MatchSimple){
			sql = "SELECT ID_EQUIPE_RAMASSEURS FROM RAMASSE_SIMPLE WHERE ID_MATCH_SIMPLE = ?";
		}
		else {
			sql = "SELECT ID_EQUIPE_RAMASSEURS FROM RAMASSE_DOUBLE WHERE ID_MATCH_DOUBLE = ?";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, match.getId());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				ramasseurs.add(new Integer(resultat.getInt("ID_EQUIPE_RAMASSEURS")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(ramasseurs);
	}

	public static List<Integer> ramasseursPasDispos(Moment moment){

		List<Integer> pasDispos = new ArrayList<Integer>();
		String sql = "SELECT ID_EQUIPE_RAMASSEURS FROM RAMASSE_SIMPLE INNER JOIN MATCHSIMPLE WHERE RAMASSE_SIMPLE.ID_MATCH_SIMPLE = MATCHSIMPLE.ID_MATCH_SIMPLE AND HORAIRE_SIMPLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				pasDispos.add(new Integer(resultat.getInt("ID_EQUIPE_RAMASSEURS")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql2 = "SELECT ID_EQUIPE_RAMASSEURS FROM RAMASSE_DOUBLE INNER JOIN MATCHDOUBLE WHERE RAMASSE_DOUBLE.ID_MATCH_DOUBLE = MATCHDOUBLE.ID_MATCH_DOUBLE AND HORAIRE_DOUBLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sql2);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				pasDispos.add(new Integer(resultat.getInt("ID_EQUIPE_RAMASSEURS")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(pasDispos);
	}

	public static boolean ajouterRamassage(int ramasseurs, Match match){

		String sql;

		if(match instanceof MatchSimple){
			sql = "INSERT INTO RAMASSE_SIMPLE (ID_MATCH_SIMPLE, ID_EQUIPE_RAMASSEURS) VALUES (?, ?)";
		}
		else {
			sql = "INSERT INTO RAMASSE_DOUBLE (ID_MATCH_DOUBLE, ID_EQUIPE_RAMASSEURS) VALUES (?, ?)";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, match.getId());
			prep.setInt(2, ramasseurs);

			return(prep.executeUpdate() >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}

	public static boolean retirerRamassage(int ramasseurs, Match match){

		String sql;

		if(match instanceof MatchSimple){
			sql = "DELETE FROM RAMASSE_SIMPLE WHERE ID_MATCH_SIMPLE = ? AND ID_EQUIPE_RAMASSEURS = ?";
		}
		else {
			sql = "DELETE FROME RAMASSE_DOUBLE WHERE ID_MATCH_DOUBLE = ? AND ID_EQUIPE_RAMASSEURS = ?";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, match.getId());
			prep.setInt(2, ramasseurs);

			return(prep.executeUpdate() >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}
}
