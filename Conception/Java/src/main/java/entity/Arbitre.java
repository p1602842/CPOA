package entity;

public class Arbitre {

	private int id;
	private String nom;
	private String prenom;
	private String nationalite;
	private String categorie;

	public Arbitre(int id, String nom, String prenom, String nationalite, String categorie){

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.categorie = categorie;
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
}
