package entity;

import util.Moment;

public class Reservation {

	private int id;
	@SuppressWarnings("unused")
	private TennisMan reservant;
	private TerrainEntrainement terrain;
	private Moment momentReservation;

	public Reservation(int id, TennisMan reservant, TerrainEntrainement terrain, Moment momentReservation){

		this.id = id;
		this.reservant = reservant;
		this.terrain = terrain;
		this.momentReservation = momentReservation;
	}

	public int getId(){

		return(id);
	}

	public TerrainEntrainement getTerrain(){

		return(terrain);
	}

	public Moment getMomentReservation(){

		return(momentReservation);
	}
}
