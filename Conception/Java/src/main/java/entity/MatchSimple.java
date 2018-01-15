package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.MatchSimpleDAO;
import util.Moment;
import util.PhaseTournoi;

public class MatchSimple extends Match {

	private TennisMan tennisMan1;
	private TennisMan tennisMan2;

	public MatchSimple(int id, PhaseTournoi phaseTournoi, Moment moment, Terrain terrain, boolean accessibleAuPublic, boolean matchJoue, String score, Arbitre arbitreChaise, List<Arbitre> arbitresLigne, TennisMan tennisMan1, TennisMan tennisMan2) {

		super(id, phaseTournoi, moment, terrain, accessibleAuPublic, matchJoue, score, arbitreChaise, arbitresLigne);

		this.tennisMan1 = tennisMan1;
		this.tennisMan2 = tennisMan2;
	}

	public TennisMan getTennisMan(int num){

		if(num == 1){
			return(tennisMan1);
		}
		else {
			return(tennisMan2);
		}
	}

	public static List<MatchSimple> getMatchsPrecedents(int id){

		switch(id){
		case 1 : return(new ArrayList<MatchSimple>());
		case 2 : return(new ArrayList<MatchSimple>());
		case 3 : return(new ArrayList<MatchSimple>());
		case 4 : return(new ArrayList<MatchSimple>());
		case 5 : return(new ArrayList<MatchSimple>());
		case 6 : return(new ArrayList<MatchSimple>());
		case 7 : return(new ArrayList<MatchSimple>());
		case 8 : return(new ArrayList<MatchSimple>());
		case 9 : return(new ArrayList<MatchSimple>());
		case 10 : return(new ArrayList<MatchSimple>());
		case 11 : return(new ArrayList<MatchSimple>());
		case 12 : return(new ArrayList<MatchSimple>());
		case 13 : return(new ArrayList<MatchSimple>());
		case 14 : return(new ArrayList<MatchSimple>());
		case 15 : return(new ArrayList<MatchSimple>());
		case 16 : return(new ArrayList<MatchSimple>());
		case 17 : return(MatchSimpleDAO.trouver(1, 2));
		case 18 : return(MatchSimpleDAO.trouver(3, 4));
		case 19 : return(MatchSimpleDAO.trouver(5, 6));
		case 20 : return(MatchSimpleDAO.trouver(7, 8));
		case 21 : return(MatchSimpleDAO.trouver(9, 10));
		case 22 : return(MatchSimpleDAO.trouver(11, 12));
		case 23 : return(MatchSimpleDAO.trouver(13, 14));
		case 24 : return(MatchSimpleDAO.trouver(15, 16));
		case 25 : return(MatchSimpleDAO.trouver(17, 18));
		case 26 : return(MatchSimpleDAO.trouver(19, 20));
		case 27 : return(MatchSimpleDAO.trouver(21, 22));
		case 28 : return(MatchSimpleDAO.trouver(23, 24));
		case 29 : return(Arrays.asList(MatchSimpleDAO.trouver(25)));
		case 30 : return(new ArrayList<MatchSimple>());
		case 31 : return(new ArrayList<MatchSimple>());
		case 32 : return(new ArrayList<MatchSimple>());
		case 33 : return(Arrays.asList(MatchSimpleDAO.trouver(26)));
		case 34 : return(new ArrayList<MatchSimple>());
		case 35 : return(new ArrayList<MatchSimple>());
		case 36 : return(new ArrayList<MatchSimple>());
		case 37 : return(Arrays.asList(MatchSimpleDAO.trouver(27)));
		case 38 : return(new ArrayList<MatchSimple>());
		case 39 : return(new ArrayList<MatchSimple>());
		case 40 : return(new ArrayList<MatchSimple>());
		case 41 : return(Arrays.asList(MatchSimpleDAO.trouver(28)));
		case 42 : return(new ArrayList<MatchSimple>());
		case 43 : return(new ArrayList<MatchSimple>());
		case 44 : return(new ArrayList<MatchSimple>());
		case 45 : return(MatchSimpleDAO.trouver(29, 30));
		case 46 : return(MatchSimpleDAO.trouver(31, 32));
		case 47 : return(MatchSimpleDAO.trouver(33, 34));
		case 48 : return(MatchSimpleDAO.trouver(35, 36));
		case 49 : return(MatchSimpleDAO.trouver(37, 38));
		case 50 : return(MatchSimpleDAO.trouver(39, 40));
		case 51 : return(MatchSimpleDAO.trouver(41, 42));
		case 52 : return(MatchSimpleDAO.trouver(43, 44));
		case 53 : return(MatchSimpleDAO.trouver(45, 46));
		case 54 : return(MatchSimpleDAO.trouver(47, 48));
		case 55 : return(MatchSimpleDAO.trouver(49, 50));
		case 56 : return(MatchSimpleDAO.trouver(51, 52));
		case 57 : return(MatchSimpleDAO.trouver(53, 54));
		case 58 : return(MatchSimpleDAO.trouver(55, 56));
		case 59 : return(MatchSimpleDAO.trouver(57, 58));
		}

		return(new ArrayList<MatchSimple>());
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
		case 26 : return(MatchSimpleDAO.trouver(33));
		case 27 : return(MatchSimpleDAO.trouver(37));
		case 28 : return(MatchSimpleDAO.trouver(41));
		case 29 : return(MatchSimpleDAO.trouver(45));
		case 30 : return(MatchSimpleDAO.trouver(45));
		case 31 : return(MatchSimpleDAO.trouver(46));
		case 32 : return(MatchSimpleDAO.trouver(46));
		case 33 : return(MatchSimpleDAO.trouver(47));
		case 34 : return(MatchSimpleDAO.trouver(47));
		case 35 : return(MatchSimpleDAO.trouver(48));
		case 36 : return(MatchSimpleDAO.trouver(48));
		case 37 : return(MatchSimpleDAO.trouver(49));
		case 38 : return(MatchSimpleDAO.trouver(49));
		case 39 : return(MatchSimpleDAO.trouver(50));
		case 40 : return(MatchSimpleDAO.trouver(50));
		case 41 : return(MatchSimpleDAO.trouver(51));
		case 42 : return(MatchSimpleDAO.trouver(51));
		case 43 : return(MatchSimpleDAO.trouver(52));
		case 44 : return(MatchSimpleDAO.trouver(52));
		case 45 : return(MatchSimpleDAO.trouver(53));
		case 46 : return(MatchSimpleDAO.trouver(53));
		case 47 : return(MatchSimpleDAO.trouver(54));
		case 48 : return(MatchSimpleDAO.trouver(54));
		case 49 : return(MatchSimpleDAO.trouver(55));
		case 50 : return(MatchSimpleDAO.trouver(55));
		case 51 : return(MatchSimpleDAO.trouver(56));
		case 52 : return(MatchSimpleDAO.trouver(56));
		case 53 : return(MatchSimpleDAO.trouver(57));
		case 54 : return(MatchSimpleDAO.trouver(57));
		case 55 : return(MatchSimpleDAO.trouver(58));
		case 56 : return(MatchSimpleDAO.trouver(58));
		case 57 : return(MatchSimpleDAO.trouver(59));
		case 58 : return(MatchSimpleDAO.trouver(59));
		case 59 : return(null);
		}

		return(null);
	}
}
