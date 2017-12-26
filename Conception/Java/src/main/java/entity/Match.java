package entity;

import util.Horaire;

public abstract class Match {

	public String phaseTournoi;
	public Horaire horaire;
	public boolean accessibleAuPublic;
	public boolean matchJoue;
	public String score;

	public Match(String phaseTournoi, Horaire horaire, boolean accessibleAuPublic, boolean matchJoue, String score){

		this.phaseTournoi = phaseTournoi;
		this.horaire = horaire;
		this.accessibleAuPublic = accessibleAuPublic;
		this.matchJoue = matchJoue;
		this.score = score;
	}

}
