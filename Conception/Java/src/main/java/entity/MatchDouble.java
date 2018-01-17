package entity;

import java.util.ArrayList;
import java.util.List;

import model.MatchDoubleDAO;
import model.MatchSimpleDAO;
import util.Moment;
import util.PhaseTournoi;

public class MatchDouble extends Match {

	private Equipe equipe1;
	private Equipe equipe2;

	public MatchDouble(int id, PhaseTournoi phaseTournoi, Moment moment, Terrain terrain, boolean accessibleAuPublic, boolean matchJoue, String score, Arbitre arbitreChaise, List<Arbitre> arbitresLigne, Equipe equipe1, Equipe equipe2) {

		super(id, phaseTournoi, moment, terrain, accessibleAuPublic, matchJoue, score, arbitreChaise, arbitresLigne);

		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}

	public Equipe getEquipe(int num){

		if(num == 1){
			return(equipe1);
		}
		else {
			return(equipe2);
		}
	}

	public static List<MatchDouble> getMatchsPrecedents(int id){

		switch(id){
		case 1 : return(new ArrayList<MatchDouble>());
		case 2 : return(new ArrayList<MatchDouble>());
		case 3 : return(new ArrayList<MatchDouble>());
		case 4 : return(new ArrayList<MatchDouble>());
		case 5 : return(new ArrayList<MatchDouble>());
		case 6 : return(new ArrayList<MatchDouble>());
		case 7 : return(new ArrayList<MatchDouble>());
		case 8 : return(new ArrayList<MatchDouble>());
		case 9 : return(new ArrayList<MatchDouble>());
		case 10 : return(new ArrayList<MatchDouble>());
		case 11 : return(new ArrayList<MatchDouble>());
		case 12 : return(new ArrayList<MatchDouble>());
		case 13 : return(new ArrayList<MatchDouble>());
		case 14 : return(new ArrayList<MatchDouble>());
		case 15 : return(new ArrayList<MatchDouble>());
		case 16 : return(new ArrayList<MatchDouble>());
		case 17 : return(MatchDoubleDAO.trouver(1, 2));
		case 18 : return(MatchDoubleDAO.trouver(3, 4));
		case 19 : return(MatchDoubleDAO.trouver(5, 6));
		case 20 : return(MatchDoubleDAO.trouver(7, 8));
		case 21 : return(MatchDoubleDAO.trouver(9, 10));
		case 22 : return(MatchDoubleDAO.trouver(11, 12));
		case 23 : return(MatchDoubleDAO.trouver(13, 14));
		case 24 : return(MatchDoubleDAO.trouver(15, 16));
		case 25 : return(MatchDoubleDAO.trouver(17, 18));
		case 26 : return(MatchDoubleDAO.trouver(19, 20));
		case 27 : return(MatchDoubleDAO.trouver(21, 22));
		case 28 : return(MatchDoubleDAO.trouver(23, 24));
		case 29 : return(MatchDoubleDAO.trouver(25, 26));
		case 30 : return(MatchDoubleDAO.trouver(27, 28));
		case 31 : return(MatchDoubleDAO.trouver(29, 30));
		}

		return(new ArrayList<MatchDouble>());
	}

	public static Match getMatchSuivant(int id) {

		switch(id){
		case 1 : return(MatchSimpleDAO.trouver(17));
		case 2 : return(MatchSimpleDAO.trouver(17));
		case 3 : return(MatchSimpleDAO.trouver(18));
		case 4 : return(MatchSimpleDAO.trouver(18));
		case 5 : return(MatchSimpleDAO.trouver(19));
		case 6 : return(MatchSimpleDAO.trouver(19));
		case 7 : return(MatchSimpleDAO.trouver(20));
		case 8 : return(MatchSimpleDAO.trouver(20));
		case 9 : return(MatchSimpleDAO.trouver(21));
		case 10 : return(MatchSimpleDAO.trouver(21));
		case 11 : return(MatchSimpleDAO.trouver(22));
		case 12 : return(MatchSimpleDAO.trouver(22));
		case 13 : return(MatchSimpleDAO.trouver(23));
		case 14 : return(MatchSimpleDAO.trouver(23));
		case 15 : return(MatchSimpleDAO.trouver(24));
		case 16 : return(MatchSimpleDAO.trouver(24));
		case 17 : return(MatchSimpleDAO.trouver(25));
		case 18 : return(MatchSimpleDAO.trouver(25));
		case 19 : return(MatchSimpleDAO.trouver(26));
		case 20 : return(MatchSimpleDAO.trouver(26));
		case 21 : return(MatchSimpleDAO.trouver(27));
		case 22 : return(MatchSimpleDAO.trouver(27));
		case 23 : return(MatchSimpleDAO.trouver(28));
		case 24 : return(MatchSimpleDAO.trouver(28));
		case 25 : return(MatchSimpleDAO.trouver(29));
		case 26 : return(MatchSimpleDAO.trouver(29));
		case 27 : return(MatchSimpleDAO.trouver(30));
		case 28 : return(MatchSimpleDAO.trouver(30));
		case 29 : return(MatchSimpleDAO.trouver(31));
		case 30 : return(MatchSimpleDAO.trouver(31));
		case 31 : return(null);
		}

		return(null);
	}

	public String getOpposants(){

		return(equipe1 + " VS " + equipe2);
	}
}
