package entity;

public abstract class Terrain {

	@SuppressWarnings("unused")
	private int id;
	private String nom;
	@SuppressWarnings("unused")
	private String localisation;

	public Terrain(int id, String nom, String localisation){

		this.id = id;
		this.nom = nom;
		this.localisation = localisation;
	}

	public String getNom(){

		return(nom);
	}

	@Override
	public String toString(){

		return(getNom());
	}
}
