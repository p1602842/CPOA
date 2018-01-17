package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Moment {

	public static final List<String> JOURS_POSSIBLES = Arrays.asList("Samedi Qualif", "Dimanche Qualif", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche");
	public static final List<String> JOURS_POSSIBLES_TOURNOI = Arrays.asList("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche");
	public static final List<String> JOURS_POSSIBLES_QUALIFS = Arrays.asList("Samedi Qualif", "Dimanche Qualif");

	private String jour = null;
	private Horaire horaire = null; 

	public Moment(String jour, Horaire horaire){

		this.horaire = horaire;
		if(JOURS_POSSIBLES.contains(jour)){
			this.jour = jour;
		}
	}

	public Moment(String enregistrement){

		if(enregistrement != null){
			String[] morceaux = enregistrement.split("_");
			if(morceaux.length >= 2){
				String jourEnregistrement = morceaux[0];
				String horaireEnregistrement = morceaux[1];

				horaire = new Horaire(horaireEnregistrement);
				if(JOURS_POSSIBLES.contains(jourEnregistrement)){
					jour = jourEnregistrement;
				}
			}
		}
	}

	public Moment(int j, Horaire horaire){

		this.horaire = horaire;
		this.jour = JOURS_POSSIBLES.get(j % JOURS_POSSIBLES.size());
	}

	public String getJour(){

		return(jour);
	}

	public Horaire getHoraire(){

		return(horaire);
	}

	public String getEnregistrement(){

		if((jour != null) && (horaire != null)){
			return(jour + "_" + horaire.getValeur());
		}
		else {
			return(null);
		}
	}

	public static List<Moment> tousLesMoments(){

		List<Moment> moments = new ArrayList<Moment>();

		for(String jour : JOURS_POSSIBLES){
			for(Horaire horaire : Horaire.toutesLesHoraires()){
				moments.add(new Moment(jour, horaire));
			}
		}

		return(moments);
	}

	public boolean estAvant(Moment m){

		if((m == null) || (m.getJour() == null) || (m.getHoraire() == null) || (getJour() == null) || (getHoraire() == null)){
			return(true);
		}
		if(JOURS_POSSIBLES.indexOf(m.getJour()) == JOURS_POSSIBLES.indexOf(getJour())){
			return(getHoraire().estAvant(m.getHoraire()));
		}
		else {
			return(JOURS_POSSIBLES.indexOf(m.getJour()) > JOURS_POSSIBLES.indexOf(getJour()));
		}
	}

	public boolean estApres(Moment m){

		if((m == null) || (m.getJour() == null) || (m.getHoraire() == null) || (getJour() == null) || (getHoraire() == null)){
			return(true);
		}

		if(JOURS_POSSIBLES.indexOf(m.getJour()) == JOURS_POSSIBLES.indexOf(getJour())){
			return(getHoraire().estApres(m.getHoraire()));
		}
		else {
			return(JOURS_POSSIBLES.indexOf(m.getJour()) < JOURS_POSSIBLES.indexOf(getJour()));
		}
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
	    if((oMoment.getJour() == null) || (oMoment.getHoraire() == null))
	    	return(false);
	    if(oMoment.getJour().equals(this.getJour()) && oMoment.getHoraire().equals(this.getHoraire()))
	    	return(true);
	    else
	    	return(false);
	}
}
