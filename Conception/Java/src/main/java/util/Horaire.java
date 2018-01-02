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

	@Override
	public String toString() {

		return horaire;
	}
}
