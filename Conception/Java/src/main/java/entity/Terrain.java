package entity;

public abstract class Terrain {

	private int id;
	private String nom;
	@SuppressWarnings("unused")
	private String localisation;

	public Terrain(int id, String nom, String localisation){

		this.id = id;
		this.nom = nom;
		this.localisation = localisation;
	}

	public int getId(){

		return(id);
	}

	public String getNom(){

		return(nom);
	}

	@Override
	public String toString(){

		return(getNom());
	}

	@Override
	public boolean equals(Object o){

		if (o == null)
			return(false);
	    if (o == this)
	    	return(true);
	    if (!(o instanceof Terrain))
	    	return(false);
	    Terrain oTerrain = (Terrain)o;
	    if(oTerrain.getId() == this.getId())
	    	return(true);
	    else
	    	return(false);
	}
}
