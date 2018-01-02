package entity;

import java.util.List;

import util.Moment;

public class TerrainEntrainement extends Terrain {

	public List<Moment> reservations;
	public List<TennisMan> reservants;

	public TerrainEntrainement(String nom, String localisation, List<Moment> reservations, List<TennisMan> reservants){

		super(nom, localisation);
		this.reservations = reservations;
		this.reservants = reservants;
	}
}
