import java.util.ArrayList;

public class Game {
	
	String gameID;
	AbstractEvent abstractEvent;
	String gameType;
	public ArrayList<Athlete> listOfPlayers = new ArrayList<Athlete>();
	int numberOfAthletes;
	
	public Game(AbstractEvent abstractEvent, int numberofAthletes){
		
	System.out.println();
		
		
	}
	
	
	public void loadPlayers(ArrayList<Athlete> listOfPlayers,int numberOfAthletes,String gameType ){
		
		new AthleteDataBase().loadPlayers(listOfPlayers, numberOfAthletes, gameType);
		
	}
	
	
	
}