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
	static AthleteDataBase db;
	
	
	
	
	
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
				 if(getNumberOfAthletes() > 4){
					 isGameSelected=true;
						numberOfAthletes = getNumberOfAthletes();
					gameSelect();     //calling game select method
					}
					else if(getNumberOfAthletes()< 4){
					System.out.println("Not Enough Athletes For This Game");	
					}  
			
				break;
				
			case 2:
				System.out.println("Predict user");
				if(isGameSelected ==true){
				    isWinnerPredicted=true;
				    predictWinner();              //calling method to predict winner
					}	else 
				    System.out.println("Select Game First");
				break;
			
			case 3:
				System.out.println("start the game");
				if(USER_PREDICTION > 0){
					isGameStarted=true;
					startGame();                 //calling method to start Game
					gameResult();               //calling method to display result
					}else
					System.out.println("Predict Winner First");
					break;
				break;
				
			case 4:
				if(isGameStarted==true){
					displayAllGames();
					System.out.println("display all the game result");
				}else
				System.out.println("First Start Game ");
				
				break;
				
			case 5:
				System.out.println("display all the athlete result");
				if(isGameStarted==true){
					 athleteDisplay();       //displaying the final result of Game
				} else
					System.out.println("First Play Game");
				break;
				
			case 6:
				System.exit(0) ;
				break;
				
			default: 
				System.out.println("Please select the correct input");
			}
		}while(i!=6);
		}catch(Exception e){
			System.out.println("Please enter a correct input");
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
				db.getAthleteDataBase().loadAthlete(athleteList,numberOfAthletes,'S');
				System.out.println("Player has been loaded");
				game = new Game(new Swimming(),athleteList);
				System.out.println("Game object has been created");
				gameList.add(game);
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
		System.out.println(gameList.size());
	}
	
	public void deleteAthleteList(){
		Iterator<E> iterator = athleteList.iterator()
				while(iterator.hasNext())
					
	}

}
