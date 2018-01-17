package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Arbitre;
import entity.Match;
import entity.MatchSimple;
import util.CategorieArbitre;
import util.Moment;

public class ArbitreDAO extends DAO {

	public static List<Arbitre> tousLesArbitres(){

		List<Arbitre> arbitres = new ArrayList<Arbitre>();
		String sql = "SELECT * FROM ARBITRE";

		try {
			ResultSet resultat = executeQuery(sql);

			while(resultat.next()){
				arbitres.add(new Arbitre(resultat.getInt("ID_ARBITRE"),
						resultat.getString("NOM_ARBITRE"),
						resultat.getString("PRENOM_ARBITRE"),
						resultat.getString("NATIONALITE_ARBITRE"),
						new CategorieArbitre(resultat.getString("CATEGORIE"))));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(arbitres);
	}

	public static Arbitre trouver(int id){

		String sql = "SELECT * FROM ARBITRE WHERE ID_ARBITRE = ?";
		
		try{
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				Arbitre arbitre = new Arbitre(resultat.getInt("ID_ARBITRE"),
						resultat.getString("NOM_ARBITRE"),
						resultat.getString("PRENOM_ARBITRE"),
						resultat.getString("NATIONALITE_ARBITRE"),
						new CategorieArbitre(resultat.getString("CATEGORIE")));
				return(arbitre);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(null);
	}

	public static List<Arbitre> pasDisponibles(Moment moment){

		List<Arbitre> pasDispos = new ArrayList<Arbitre>();
		String sql = "SELECT ARBITRE_LIGNE_SIMPLE.ID_ARBITRE FROM ARBITRE_LIGNE_SIMPLE INNER JOIN MATCHSIMPLE WHERE ARBITRE_LIGNE_SIMPLE.ID_MATCH_SIMPLE = MATCHSIMPLE.ID_MATCH_SIMPLE AND HORAIRE_SIMPLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				pasDispos.add(trouver(resultat.getInt("ID_ARBITRE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql2 = "SELECT ARBITRE_LIGNE_DOUBLE.ID_ARBITRE FROM ARBITRE_LIGNE_DOUBLE INNER JOIN MATCHDOUBLE WHERE ARBITRE_LIGNE_DOUBLE.ID_MATCH_DOUBLE = MATCHDOUBLE.ID_MATCH_DOUBLE AND HORAIRE_DOUBLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sql2);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				pasDispos.add(trouver(resultat.getInt("ID_ARBITRE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql3 = "SELECT ID_ARBITRE FROM MATCHSIMPLE WHERE HORAIRE_SIMPLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sql3);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				pasDispos.add(trouver(resultat.getInt("ID_ARBITRE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		String sql4 = "SELECT ID_ARBITRE FROM MATCHDOUBLE WHERE HORAIRE_DOUBLE = ?";

		try {
			PreparedStatement prep = prepareStatement(sql4);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				pasDispos.add(trouver(resultat.getInt("ID_ARBITRE")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(pasDispos);
	}

	public static List<Arbitre> tropDeMatchsArbitreChaise(){

		List<Arbitre> arbitres = new ArrayList<Arbitre>();

		for(Arbitre arbitre : tousLesArbitres()){
			String sql = "SELECT (SELECT COUNT(*) FROM MATCHSIMPLE WHERE ID_ARBITRE = ?) + (SELECT COUNT(*) FROM MATCHDOUBLE WHERE ID_ARBITRE = ?)";

			try {
				PreparedStatement prep = prepareStatement(sql);

				prep.setInt(1, arbitre.getId());
				prep.setInt(2, arbitre.getId());

				ResultSet resultat = prep.executeQuery();

				while(resultat.next()){
					if(resultat.getInt(1) >= 4){
						arbitres.add(arbitre);
					}
				}
			} catch(Exception e){
				e.printStackTrace();
			}
		}

		return(arbitres);
	}

	public static boolean tropDeMatchsArbitreChaise(Arbitre arbitre){

		String sql = "SELECT (SELECT COUNT(*) FROM MATCHSIMPLE WHERE ID_ARBITRE = ?) + (SELECT COUNT(*) FROM MATCHDOUBLE WHERE ID_ARBITRE = ?)";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, arbitre.getId());
			prep.setInt(2, arbitre.getId());

			ResultSet resultat = prep.executeQuery();

			if(resultat.next()){
				return(resultat.getInt(1) >= 4);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(true);
	}

	public static boolean ajouterArbitreChaise(Match match, Arbitre arbitre){

		String sql;

		if(match instanceof MatchSimple){
			sql = "UPDATE MATCHSIMPLE SET ID_ARBITRE = ? WHERE ID_MATCH_SIMPLE = ?";
		}
		else {
			sql = "UPDATE MATCHDOUBLE SET ID_ARBITRE = ? WHERE ID_MATCH_DOUBLE = ?";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, arbitre.getId());
			prep.setInt(2, match.getId());

			return(prep.executeUpdate() >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}

	public static boolean ajouterArbitreLigne(Match match, Arbitre arbitre){

		String sql;

		if(match instanceof MatchSimple){
			sql = "INSERT INTO ARBITRE_LIGNE_SIMPLE (ID_MATCH_SIMPLE, ID_ARBITRE) VALUES (?, ?)";
		}
		else {
			sql = "INSERT INTO ARBITRE_LIGNE_DOUBLE (ID_MATCH_DOUBLE, ID_ARBITRE) VALUES (?, ?)";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, match.getId());
			prep.setInt(2, arbitre.getId());

			return(prep.executeUpdate() >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}

	public static boolean retirerArbitreChaise(Match match){

		String sql;

		if(match instanceof MatchSimple){
			sql = "UPDATE MATCHSIMPLE SET ID_ARBITRE = ? WHERE ID_MATCH_SIMPLE = ?";
		}
		else {
			sql = "UPDATE MATCHDOUBLE SET ID_ARBITRE = ? WHERE ID_MATCH_DOUBLE = ?";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setNull(1, java.sql.Types.INTEGER);
			prep.setInt(2, match.getId());

			return(prep.executeUpdate() >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}

	public static boolean retirerArbitreLigne(Match match, Arbitre arbitre){

		String sql;

		if(match instanceof MatchSimple){
			sql = "DELETE FROM ARBITRE_LIGNE_SIMPLE WHERE ID_MATCH_SIMPLE = ? AND ID_ARBITRE = ?";
		}
		else {
			sql = "DELETE FROM ARBITRE_LIGNE_DOUBLE WHERE ID_MATCH_DOUBLE = ? AND ID_ARBITRE = ?";
		}

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, match.getId());
			prep.setInt(2, arbitre.getId());

			return(prep.executeUpdate() >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}
}
