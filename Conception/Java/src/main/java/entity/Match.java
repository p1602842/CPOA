package entity;

import java.util.List;

import util.Moment;
import util.PhaseTournoi;

public abstract class Match {

	protected int id;
	protected PhaseTournoi phaseTournoi;
	protected Moment moment;
	protected Terrain terrain;
	protected boolean accessibleAuPublic;
	protected boolean matchJoue;
	protected String score;
	protected Arbitre arbitreChaise;
	protected List<Arbitre> arbitresLigne;

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

	public PhaseTournoi getPhaseTournoi(){

		return(phaseTournoi);
	}

	public Moment getMoment(){

		return(moment);
	}

	public Terrain getTerrain(){

		return(terrain);
	}

	public boolean estJoue(){

		return(matchJoue);
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

	public List<?> getMatchsPrecedents(){

		if(this instanceof MatchSimple){
			return(MatchSimple.getMatchsPrecedents(id));
		}
		else {
			return(MatchDouble.getMatchsPrecedents(id));
		}
	}

	public Match getMatchSuivant(){

		if(this instanceof MatchSimple){
			return(MatchSimple.getMatchSuivant(id));
		}
		else {
			return(MatchDouble.getMatchSuivant(id));
		}
	}

	public abstract String getOpposants();

	@Override
	public String toString(){

		return(((Integer)id).toString());
	}

	@Override
	public boolean equals(Object o){

		if (o == null)
			return(false);
	    if (o == this)
	    	return(true);
	    if (!(o instanceof Match))
	    	return(false);
	    Match oMatch = (Match)o;
	    if(oMatch instanceof MatchSimple){
	    	if(this instanceof MatchSimple){
	    		if (this.id == oMatch.id)
	    			return(true);
	    		else
	    			return(false);
	    	}
	    	else
	    		return(false);
	    }
	    else if(this instanceof MatchDouble){
	    	if (this.id == oMatch.id)
	    		return(true);
	    	else
	    		return(false);
	    }
	    else
	    	return(false);
	}
}
