package entity;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

	public List<TennisMan> tennisMen = new ArrayList<TennisMan>();

	public Equipe(List<TennisMan> tennisMen){

		this.tennisMen = tennisMen;
	}
}
