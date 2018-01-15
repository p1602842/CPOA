package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Horaire {

	public static final List<String> HORAIRES_POSSIBLES = Arrays.asList("Matin", "Matinée", "Midi", "Après-midi", "Soirée");

	private String horaire = null;

	public Horaire(String horaire){

		if(HORAIRES_POSSIBLES.contains(horaire)){
			this.horaire = horaire;
		}
	}

	public Horaire(int h){

		this.horaire = HORAIRES_POSSIBLES.get(h % HORAIRES_POSSIBLES.size());
	}

	public String getValeur(){

		return(horaire);
	}

	public static List<Horaire> toutesLesHoraires(){

		List<Horaire> horaires = new ArrayList<Horaire>();

		for(String horaireString : HORAIRES_POSSIBLES){
			horaires.add(new Horaire(horaireString));
		}

		return(horaires);
	}

	public boolean estAvant(Horaire h){

		return((HORAIRES_POSSIBLES.indexOf(h.getValeur()) > HORAIRES_POSSIBLES.indexOf(getValeur())));
	}

	public boolean estApres(Horaire h){

		return((HORAIRES_POSSIBLES.indexOf(h.getValeur()) < HORAIRES_POSSIBLES.indexOf(getValeur())));
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
