package util;

import java.util.Arrays;
import java.util.List;

public class CategorieArbitre {

	public static final List<String> CATEGORIES_POSSIBLES = Arrays.asList("JAT2", "JAT3", "ITT1", "ITT2");

	private String categorie;

	public CategorieArbitre(String categorie){

		if(CATEGORIES_POSSIBLES.contains(categorie)){
			this.categorie = categorie;
		}
	}

	public String getValeur(){

		return(categorie);
	}

	public boolean meilleurOuEgalA(CategorieArbitre cat){

		if(cat != null){
			return((CATEGORIES_POSSIBLES.indexOf(cat.getValeur()) <= CATEGORIES_POSSIBLES.indexOf(getValeur())));
		}
		else {
			return(true);
		}
	}

	@Override
	public String toString(){

		return(getValeur());
	}

	@Override
	public boolean equals(Object o){

		if (o == null)
			return(false);
	    if (o == this)
	    	return(true);
	    if (!(o instanceof Horaire))
	    	return(false);
	    CategorieArbitre oCategorieArbitre = (CategorieArbitre)o;
	    if(oCategorieArbitre.getValeur().equals(this.getValeur()))
	    	return(true);
	    else
	    	return(false);
	}
}
