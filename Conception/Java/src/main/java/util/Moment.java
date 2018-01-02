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

	public Moment(int j, Horaire horaire){

		this.horaire = horaire;
		this.jour = joursPossibles.get(j % joursPossibles.size());
	}

	@Override
	public String toString(){

		return(jour + " " + horaire);
	}
}
