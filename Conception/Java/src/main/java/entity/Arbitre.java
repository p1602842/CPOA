package entity;

import model.ArbitreDAO;
import util.CategorieArbitre;

public class Arbitre {

	private int id;
	private String nom;
	private String prenom;
	private String nationalite;
	private CategorieArbitre categorie;
	private boolean reel;

	public Arbitre(int id, String nom, String prenom, String nationalite, CategorieArbitre categorie){

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.categorie = categorie;
		this.reel = true;
	}

	public Arbitre(String nom){

		this.nom = nom;
		this.reel = false;
	}

	public int getId(){

		return(id);
	}

	public String getPrenom(){

		return(prenom);
	}

	public String getNom(){

		return(nom);
	}

	public String getPrenomNom(){

		return(getPrenom() + " " + getNom());
	}

	public String getNationalite(){

		return(nationalite);
	}

	public CategorieArbitre getCategorie(){

		return(categorie);
	}

	public boolean getReel(){

		return(reel);
	}

	public boolean peutArbitrerChaise(Match match){

		if(!ArbitreDAO.tropDeMatchsArbitreChaise(this)){
			if(categorie.meilleurOuEgalA(new CategorieArbitre("ITT1"))){
				if(match instanceof MatchSimple){
					MatchSimple matchS = (MatchSimple)match;
					if(matchS.getTennisMan(1) != null){
						if(!nationalite.equals(matchS.getTennisMan(1).getNationalite())){
							if(matchS.getTennisMan(2) != null){
								if(!nationalite.equals(matchS.getTennisMan(2).getNationalite())){
									return(true);
								}
							}
							else {
								return(true);
							}
						}
					}
					else {
						return(true);
					}
				}
				else {
					MatchDouble matchD = (MatchDouble)match;
					if((matchD.getEquipe(1) != null) && (matchD.getEquipe(1).getTennisMan(1) != null)){
						if(!nationalite.equals(matchD.getEquipe(1).getTennisMan(1).getNationalite())){
							if(matchD.getEquipe(1).getTennisMan(2) != null){
								if(!nationalite.equals(matchD.getEquipe(1).getTennisMan(2).getNationalite())){
									if((matchD.getEquipe(2) != null) && (matchD.getEquipe(2).getTennisMan(1) != null)){
										if(!nationalite.equals(matchD.getEquipe(2).getTennisMan(1).getNationalite())){
											if(matchD.getEquipe(2).getTennisMan(2) != null){
												if(!nationalite.equals(matchD.getEquipe(2).getTennisMan(2).getNationalite())){
													return(true);
												}
											}
											else {
												return(true);
											}
										}
									}
									else {
										return(true);
									}
								}
							}
							else {
								return(true);
							}
						}
					}
					else {
						return(true);
					}
				}
			}
		}
		return(false);
	}

	@Override
	public boolean equals(Object o){

		if (o == null)
			return(false);
	    if (o == this)
	    	return(true);
	    if (!(o instanceof Arbitre))
	    	return(false);
	    Arbitre oArbitre = (Arbitre)o;
	    if(id == oArbitre.getId())
	    	return(true);
	    else
	    	return(false);
	}
}
