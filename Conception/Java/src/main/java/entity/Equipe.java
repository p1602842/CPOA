package entity;

public class Equipe {

	private TennisMan tennisMan1;
	private TennisMan tennisMan2;

	public Equipe(TennisMan tennisMan1, TennisMan tennisMan2){

		this.tennisMan1 = tennisMan1;
		this.tennisMan2 = tennisMan2;
	}

	public TennisMan getTennisMan(int num){

		if(num == 1){
			return(tennisMan1);
		}
		else {
			return(tennisMan2);
		}
	}

	public String getNomsMembres(){

		return(tennisMan1.getPrenomNom() + " & " + tennisMan2.getPrenomNom());
	}

	@Override
	public String toString(){

		return(getNomsMembres());
	}
}
