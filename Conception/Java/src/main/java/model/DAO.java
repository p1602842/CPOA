package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DAO {

	public static boolean execute(String commandeSql){

		try {
			Statement statement = AccesBD.getInstance().getConnexion().createStatement();
			return(statement.execute(commandeSql));
		} catch(Exception e){
			e.printStackTrace();
			return(false);
		}
	}

	public static ResultSet executeQuery(String commandeSql){

		try {
			Statement statement = AccesBD.getInstance().getConnexion().createStatement();
			return(statement.executeQuery(commandeSql));
		} catch(Exception e){
			e.printStackTrace();
			return(null);
		}
	}

	public static int executeUpdate(String commandeSql){

		try {
			Statement statement = AccesBD.getInstance().getConnexion().createStatement();
			return(statement.executeUpdate(commandeSql));
		} catch(Exception e){
			e.printStackTrace();
			return(0);
		}
	}

	public static PreparedStatement prepareStatement(String sql){

		try {
			return(AccesBD.getInstance().getConnexion().prepareStatement(sql));
		} catch(Exception e){
			e.printStackTrace();
			return(null);
		}
	}
}
