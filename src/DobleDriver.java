import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class DobleDriver {
	
	Scanner sc=new Scanner(System.in);    //taking user input
	Random ran=new Random();              //generating random number
	Athlete currentAthlete;               //arraylist to store list of athletes playing in games
	int USER_PREDICTION =0 ;              //storing user prediction
	Game game;
	List<Game> gameList = new ArrayList<Game>();
	boolean isGameSelected ;               
	boolean isWinnerPredicted;
	boolean isGameStarted;
	int MAX_ATHLETES=8;                   //maximum athletes who can participate
	int MIN_ATHLETES=2;                   //minimum athletes who can participate
	int selectedOption;                            //storing user selection choice
	int numberOfAthletes;
	final int numberOfMandatoryAthletes = 5;
	Set<Athlete> athleteList = new HashSet<Athlete>();
	AthleteDataBase db;
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DobleDriver dbo = new DobleDriver();
		dbo.menu();
		
	}
	
	
	
	public void menu(){
		int i =1;
		try{
		do{
		System.out.println("===========================================\n"
				+ "           OZYMPLIC GAMES\n"
				+ "============================================\n"
				+ "1. Select a Game to run \n"
				+ "2. Predict the Winner of Game \n"
				+ "3. Start the Game\n"
				+ "4. Display the final result of all Games\n"
				+ "5. Display the points of all Athletes\n"
				+ "6. Exit ");	
			
		selectedOption = sc.nextInt();
			
			switch(selectedOption){
			case 1:
				isGameSelected=true;
				numberOfAthletes = getNumberOfAthletes();
				gameSelect();
				break;
				
			case 2:
				if(isGameSelected){
					isWinnerPredicted=true;
					System.out.println("Predict user");
				}
				else{
					System.out.println("Please select the Game first");
				}
				break;
			
			case 3:
				if(isGameSelected){
					if(isWinnerPredicted){
						startGame();
						isGameStarted = true;
						isGameSelected = false;
						isWinnerPredicted = false;
					}
					else{
						System.out.println("Please predict the winner first");
					}

				}else{
					System.out.println("Please select the Game first");
				}
				break;
				
			case 4:
				if(isGameStarted){
				this.displayAllGames();
				}
				else
					System.out.println("Please Play the Game first");
				break;
				
			case 5:
				if(isGameStarted){
				System.out.println("display all the athlete result");
				}else
					System.out.println("Please select the Game first");
				break;
				
			case 6:
				System.out.println("Thank you BYE!");
				break;
				
			default: 
				System.out.println("Please select the correct input");
			
			}
			
			
		}while(selectedOption!=6);
		}catch(Exception e){
			System.out.println("Please enter a correct input");
			sc.next();
			menu();

		}

		
		
	}
	
	
	public void gameSelect(){
		try{
		System.out.println("========== PLEASE SELECT A GAME EVENT ==========");
		System.out.println("1) SWIMMING \n");
		System.out.println("2) RUNNING \n");
		System.out.println("3) CYCLING \n");
		selectedOption=sc.nextInt();
		switch(selectedOption){
		
		case 1:
			System.out.println("-------------- Game selected is SWIMMING --------------");
			
			if(checkForSufficientAthlete()){
				System.out.println(" size is " +athleteList.size());
				deleteAthleteList();
				db.getAthleteDataBase().loadAthlete(athleteList,numberOfAthletes,'S');
				System.out.println("Size of athleteList after loading "+ this.athleteList.size());
				System.out.println("Player has been loaded");
				this.game = new Game(new Swimming(),athleteList);
				System.out.println("Game object has been created");
				System.out.println("Game has been added to the list");
				
			}
			else
				System.out.println(" add the code to de- initialize the game selection");
			 
			break;

			
		default:
			System.out.println("Please select the correct input");
			
		
		
		}
		}
		catch(Exception e){
			sc.next();
			System.out.println("Please Provide Valid Input");
			gameSelect();
			}
		
	}
	
	
	
	
	
	
	/*
	 * getting number of athletes participating using random number
	 */
	public int getNumberOfAthletes(){
		numberOfAthletes= ran.nextInt(MAX_ATHLETES-MIN_ATHLETES)+MIN_ATHLETES;
		return numberOfAthletes;
	}
	
	
	public boolean checkForSufficientAthlete(){
		boolean isSufficient = false;
		System.out.println(" number of Athletes"+numberOfAthletes);
		if(numberOfAthletes >= numberOfMandatoryAthletes)
			isSufficient = true;
		else
			System.out.println("Game has been cancelled due to Insufficient Players");
		return isSufficient;
	}
	
	
	public void displayAllGames(){
		System.out.println("Total number of games played is "+gameList.size());
		for(Game game: gameList){
			System.out.println("====================");
			System.out.println("Game ID: "+game.getGameID());
			System.out.println("Referre name :"+game.referee.getName());
			game.referee.displayResult();

		}

	}
	
	public void deleteAthleteList(){
		this.athleteList.clear();
					
	}


	public void startGame(){
		try{
			this.game.initiateGame();
			this.game.rewardWinner();
			gameList.add(this.game);
			System.out.println("====================== GAME STARTED ========================");
		}
		catch(Exception e){
			//sc.next();
			System.out.println("Game has been withdrawn due to heavy rain");
		}

	}


	public void displayAllAthletePoints(){
			Athlete[] athleteList = AthleteDataBase.athlete;
			System.out.println(athleteList.length);

	}


}
