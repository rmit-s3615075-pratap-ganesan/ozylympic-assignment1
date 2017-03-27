import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	int i=01;
	String gameID;
	AbstractEvent abstractEvent;
	String gameType;
	public ArrayList<Athlete> listOfPlayers = new ArrayList<Athlete>();
	int numberOfAthletes;
	
	public Game(AbstractEvent abstractEvent, int numberofAthletes){
		
		if(abstractEvent instanceof Swimming){
			 this.gameID="S"+i;
			i++;
			System.out.println(gameID);
		}
		else if(abstractEvent instanceof Cycling){
			this.gameID="C"+i;
			i++;
			System.out.println(gameID);
		}
		else{
			this.gameID="R"+i;
			i++;
			System.out.println(gameID);
		}
		
		
	}
	
	
	public void loadPlayers(ArrayList<Athlete> listOfPlayers,int numberOfAthletes,String gameType ){
		
		new AthleteDataBase().loadPlayers(listOfPlayers, numberOfAthletes, gameType);
		
	}
	
	
	
}