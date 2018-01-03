package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Reservation;
import entity.TennisMan;
import util.Moment;

public class ReservationDAO extends DAO {

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

	public static boolean annulerReservation(int id){

		String sql = "DELETE FROM RESERVATION WHERE ID_RESERVATION = ?";

		try {
			PreparedStatement prep = prepareStatement(sql);

			prep.setInt(1, id);

			int nb = prep.executeUpdate();

			return(nb >= 1);
		} catch(Exception e){
			e.printStackTrace();
		}

		return(false);
	}
}
