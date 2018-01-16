package util;

import java.util.Arrays;
import java.util.List;

public class PhaseTournoi {

	public static final List<String> PHASES_POSSIBLES = Arrays.asList("Seizièmes - Qualifications", "Huitièmes - Qualifications", "Quarts - Qualifications", "Seizièmes", "Huitièmes", "Quarts", "Demis", "Big Match");
	public static final List<String> PHASES_QUALIFS = Arrays.asList("Seizièmes - Qualifications", "Huitièmes - Qualifications", "Quarts - Qualifications");
	public static final List<String> PHASES_FINAL = Arrays.asList("Seizièmes", "Huitièmes", "Quarts", "Demis", "Big Match");

	private String phase = null;
	private boolean matchDouble;

	public PhaseTournoi(String phase, boolean matchDouble){

		if(PHASES_POSSIBLES.contains(phase)){
			this.phase = phase;
			this.matchDouble = matchDouble;
		}
	}

	public PhaseTournoi(int p, boolean matchDouble){

		if(!matchDouble){
			if((p >= 1)&&(p <= 8)){
				phase = PHASES_POSSIBLES.get(p - 1);
			}
		}
		else {
			if((p >= 1)&&(p <= 5)){
				phase = PHASES_POSSIBLES.get(p + 2);
			}
		}

		this.matchDouble = matchDouble;
	}

	public String getValeur(){

		return(phase);
	}

	public int getEnregistrement(){

		if(!matchDouble){
			return(PHASES_POSSIBLES.indexOf(phase) + 1);
		}
		else {
			return(PHASES_POSSIBLES.indexOf(phase) - 2);
		}
	}

	@Override
	public String toString(){

		return(getValeur());
	}

	@Override
	public boolean equals(Object o){

		if(o == null)
			return(false);
		if(o == this)
			return(true);
		if(!(o instanceof PhaseTournoi))
			return(false);
		PhaseTournoi oPhase = (PhaseTournoi)o;
		if(oPhase.getValeur().equals(this.getValeur()))
			return(true);
		else
			return(false);
	}
}
