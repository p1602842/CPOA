package entity;

public class TennisMan {

	private int id;
	private String nom;
	private String prenom;
	@SuppressWarnings("unused")
	private int rang;
	@SuppressWarnings("unused")
	private int age;
	private String nationalite;

	public TennisMan(int id, String nom, String prenom, int rang, int age, String nationalite){

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.rang = rang;
		this.age = age;
		this.nationalite = nationalite;
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

	public String getNationalite(){

		return(nationalite);
	}

	public String getPrenomNom(){

		return(getPrenom() + " " + getNom());
	}

	@Override
	public String toString(){

		return(getPrenomNom());
	}
}
