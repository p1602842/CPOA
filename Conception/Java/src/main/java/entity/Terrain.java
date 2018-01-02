package entity;

public abstract class Terrain {

	public String nom;
	public String localisation;

	public Terrain(String nom, String localisation){

		this.nom = nom;
		this.localisation = localisation;
	}
}
