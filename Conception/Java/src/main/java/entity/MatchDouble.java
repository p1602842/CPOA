package entity;

import java.util.List;

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
}
