package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Reservation;
import entity.TennisMan;
import entity.TerrainEntrainement;
import util.Horaire;
import util.Moment;

public class ReservationDAO extends DAO {

	public static boolean ajouterReservation(Reservation reservation){

		String sql = "INSERT INTO RESERVATION (ID_RESERVATION, ID_TENNISMAN, ID_TERRAIN, HORAIRE_RESERVATION) VALUES (NULL, ?, ?, ?)";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, reservation.getReservant().getId());
			prep.setInt(2, reservation.getTerrain().getId());
			prep.setString(3, reservation.getMomentReservation().getEnregistrement());

			int nb = prep.executeUpdate();

			return(nb >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}

	public static List<Reservation> reservationsJoueur(int id){

		List<Reservation> reservations = new ArrayList<Reservation>();
		String sql = "SELECT * FROM RESERVATION WHERE ID_TENNISMAN = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				Reservation reservation = new Reservation(resultat.getInt("ID_RESERVATION"),
						TennisManDAO.trouver(resultat.getInt("ID_TENNISMAN")),
						TerrainEntrainementDAO.trouver(resultat.getInt("ID_TERRAIN")),
						new Moment(resultat.getString("HORAIRE_RESERVATION")));
				reservations.add(reservation);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(reservations);
	}

	public static List<Reservation> reservationsJoueur(TennisMan tennisMan){

		return(reservationsJoueur(tennisMan.getId()));
	}

	public static List<Horaire> horairesImpossible(int idTennisMan, String jour){

		List<Horaire> horairesImpossibles = new ArrayList<Horaire>();
		List<Reservation> reservationsJoueur = reservationsJoueur(idTennisMan);

		for(Reservation reservation : reservationsJoueur){
			if(reservation.getMomentReservation().getJour().equals(jour)){
				horairesImpossibles.add(reservation.getMomentReservation().getHoraire());
			}
		}

		return(horairesImpossibles);
	}

	public static List<Horaire> horairesImpossible(TennisMan tennisMan, String jour){

		return(horairesImpossible(tennisMan.getId(), jour));
	}

	public static List<TerrainEntrainement> terrainsImpossible(Moment moment){

		List<TerrainEntrainement> terrainsImpossibles = new ArrayList<TerrainEntrainement>();

		String sql = "SELECT ID_TERRAIN FROM RESERVATION WHERE HORAIRE_RESERVATION = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setString(1, moment.getEnregistrement());

			ResultSet resultat = prep.executeQuery();

			while(resultat.next()){
				TerrainEntrainement terrain = TerrainEntrainementDAO.trouver(resultat.getInt("ID_TERRAIN"));
				terrainsImpossibles.add(terrain);
			}
		} catch(Exception e){
			e.printStackTrace();
		}

		return(terrainsImpossibles);
	}

	public static boolean annulerReservation(Reservation reservation){

		String sql = "DELETE FROM RESERVATION WHERE ID_RESERVATION = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, reservation.getId());

			int nb = prep.executeUpdate();

			return(nb >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}
}
