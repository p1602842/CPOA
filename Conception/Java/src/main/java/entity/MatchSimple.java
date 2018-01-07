package entity;

import java.util.List;

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
}
