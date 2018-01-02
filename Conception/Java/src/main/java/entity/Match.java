package entity;

import java.util.List;

import util.Moment;

public abstract class Match {

	public String phaseTournoi;
	public Moment moment;
	public boolean accessibleAuPublic;
	public boolean matchJoue;
	public String score;
	public Arbitre arbitreChaise;
	public List<Arbitre> arbitresLigne;

	public Match(String phaseTournoi, Moment moment, boolean accessibleAuPublic, boolean matchJoue, String score, Arbitre arbitreChaise, List<Arbitre> arbitresLigne){

		this.phaseTournoi = phaseTournoi;
		this.moment = moment;
		this.accessibleAuPublic = accessibleAuPublic;
		this.matchJoue = matchJoue;
		this.score = score;
		this.arbitreChaise = arbitreChaise;
		this.arbitresLigne = arbitresLigne;
	}

}
