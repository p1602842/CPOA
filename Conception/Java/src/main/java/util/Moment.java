package util;

import java.util.Arrays;
import java.util.List;

public class Moment {

	public String jour = null;
	public Horaire horaire = null;
	private static List<String> joursPossibles = Arrays.asList("Samedi Qualif", "Dimanche Qualif", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"); 

	public Moment(String jour, Horaire horaire){

		this.horaire = horaire;
		if(joursPossibles.contains(jour)){
			this.jour = jour;
		}
	}

	public Moment(String enregistrement){

		String[] morceaux = enregistrement.split("_");
		String jourEnregistrement = morceaux[0];
		String horaireEnregistrement = morceaux[1];

		horaire = new Horaire(horaireEnregistrement);
		if(joursPossibles.contains(jourEnregistrement)){
			jour = jourEnregistrement;
		}
	}

	public Moment(int j, Horaire horaire){

		this.horaire = horaire;
		this.jour = joursPossibles.get(j % joursPossibles.size());
	}

	public String getJour(){

		return(jour);
	}

	public Horaire getHoraire(){

		return(horaire);
	}

	public String getEnregistrement(){

		return(jour + "_" + horaire.getValeur());
	}

	@Override
	public String toString(){

		return(jour + ", " + horaire);
	}

	@Override
	public boolean equals(Object o){

		if (o == null)
			return(false);
	    if (o == this)
	    	return(true);
	    if (!(o instanceof Moment))
	    	return(false);
	    Moment oMoment = (Moment)o;
	    if(oMoment.getJour().equals(this.getJour()) && oMoment.getHoraire().equals(this.getHoraire()))
	    	return(true);
	    else
	    	return(false);
	}
}
