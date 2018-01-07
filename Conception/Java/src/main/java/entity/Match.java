package entity;

import java.util.List;

import util.Moment;
import util.PhaseTournoi;

public abstract class Match {

	private int id;
	private PhaseTournoi phaseTournoi;
	private Moment moment;
	private Terrain terrain;
	private boolean accessibleAuPublic;
	private boolean matchJoue;
	private String score;
	private Arbitre arbitreChaise;
	private List<Arbitre> arbitresLigne;

	public Match(int id, PhaseTournoi phaseTournoi, Moment moment, Terrain terrain, boolean accessibleAuPublic, boolean matchJoue, String score, Arbitre arbitreChaise, List<Arbitre> arbitresLigne){

		this.id = id;
		this.phaseTournoi = phaseTournoi;
		this.moment = moment;
		this.terrain = terrain;
		this.accessibleAuPublic = accessibleAuPublic;
		this.matchJoue = matchJoue;
		this.score = score;
		this.arbitreChaise = arbitreChaise;
		this.arbitresLigne = arbitresLigne;
	}

	public int getId(){

		return(id);
	}

	public Moment getMoment(){

		return(moment);
	}

	public Terrain getTerrain(){

		return(terrain);
	}

	public String getScore(){

		return(score);
	}

	public Arbitre getArbitreChaise(){

		return(arbitreChaise);
	}

	public List<Arbitre> getArbitresLigne(){

		return(arbitresLigne);
	}

	public boolean getAccessibleAuPublic(){

		return(accessibleAuPublic);
	}
}
