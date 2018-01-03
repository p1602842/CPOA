package util;

import java.util.Arrays;
import java.util.List;

public class Horaire {

	public String horaire = null;
	private static List<String> horairesPossibles = Arrays.asList("Matin", "Matinée", "Midi", "Après-midi", "Soirée");

	public Horaire(String horaire){

		if(horairesPossibles.contains(horaire)){
			this.horaire = horaire;
		}
	}

	public Horaire(int h){

		this.horaire = horairesPossibles.get(h % horairesPossibles.size());
	}

	public String getValeur(){

		return(horaire);
	}

	@Override
	public String toString() {

		if(horaire.equals("Matin")){
			return("Matin (8h - 11h)");
		}
		else if(horaire.equals("Matinée")){
			return("Matinée (11h - 14h)");
		}
		else if(horaire.equals("Midi")){
			return("Midi (15h - 18h)");
		}
		else if(horaire.equals("Après-midi")){
			return("Après-midi (18h - 21h)");
		}
		else if(horaire.equals("Soirée")){
			return("Soirée (21h - 0h)");
		}
		else {
			return(null);
		}
	}

	@Override
	public boolean equals(Object o){

		if (o == null)
			return(false);
	    if (o == this)
	    	return(true);
	    if (!(o instanceof Horaire))
	    	return(false);
	    Horaire oHoraire = (Horaire)o;
	    if(oHoraire.getValeur().equals(this.getValeur()))
	    	return(true);
	    else
	    	return(false);
	}
}
