package entity;

import java.util.List;

import util.Moment;

public class MatchDouble extends Match {

	public MatchDouble(String phaseTournoi, Moment moment, boolean accessibleAuPublic, boolean matchJoue, String score, Arbitre arbitreChaise, List<Arbitre> arbitresLigne) {

		super(phaseTournoi, moment, accessibleAuPublic, matchJoue, score, arbitreChaise, arbitresLigne);
	}
}
