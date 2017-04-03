

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import game.controller.*;
import game.participant.*;
import game.event.*;

/**
 * @author ASHISH
 * Driver is where all the user interaction is happening
 */
public class Driver {
	
	Scanner sc=new Scanner(System.in);     //taking user input
	Random randomNumber =new Random();     //generating random number
	Athlete currentAthlete;              
	int USER_PREDICTION =0 ;              //storing user prediction
	Game game;
	List<Game> gameList = new ArrayList<Game>();
	boolean isGameSelected ;               
	boolean isWinnerPredicted;
	boolean isGameStarted;
	int MAX_ATHLETES=8;                   //maximum athletes who can participate
	int MIN_ATHLETES=2;                   //minimum athletes who can participate
	int selectedOption;                   //storing user selection choice
	int numberOfAthletes;
	final int numberOfMandatoryAthletes = 5;    //least number of Athletes for game
	Set<Athlete> athleteList = new HashSet<Athlete>();
	AthleteDataBase db;
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		driver.menu();
		
	}
	
	/**
	 * @description menu to give user choices to run games and predict winners
	 * @exception IOException On input error
	 */
	public void menu(){
		int i =1;
		try{
		do{
		options();
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
					predictWinner();
				}
				else
					System.out.println("Please select the Game first");
				break;
			case 3:
				if(isGameSelected){
					if(isWinnerPredicted){
						playGame();
					}
					else
						System.out.println("Please predict the winner first");
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
					displayAllAthletePoints();
				}else
					System.out.println("Please Play the Game first");
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
	
/**
 * @description contains methods for game initialization	
 */
	private void playGame() {
		startGame();
		reset();
		gameResult();
	}
/**
 * @description Resets the value of boolean to false after one run of game
 */
	private void reset() {
		isGameStarted = true;
		isGameSelected = false;
		isWinnerPredicted = false;
	}

	private void options() {
		System.out.println("===========================================\n"
				+ "           OZYLYMPLIC GAMES\n"
				+ "============================================\n"
				+ "1. Select a Game to run \n"
				+ "2. Predict the Winner of Game \n"
				+ "3. Start the Game\n"
				+ "4. Display the final result of all Games\n"
				+ "5. Display the points of all Athletes\n"
				+ "6. Exit ");	

		System.out.print("Please enter your option: ");
		
	}
/**
 * @description Selecting the game to play
 * @exception IOException On input error
 */
	public void gameSelect(){
		try{
		System.out.println("========== PLEASE SELECT A GAME EVENT ==========");
		System.out.println("1) SWIMMING \n");
		System.out.println("2) RUNNING \n");
		System.out.println("3) CYCLING \n");
		System.out.print("Please enter your option: ");
		selectedOption=sc.nextInt();
		switch(selectedOption){
		case 1:
			System.out.println("-------------- Game selected is SWIMMING --------------");
			if(checkForSufficientAthlete()){
				deleteAthleteList();
				db.getAthleteDataBase().loadAthlete(athleteList,numberOfAthletes,'S');
				this.game = new Game(new Swimming(),athleteList);
			}
			else
				isGameSelected = false;
			break;
			case 2:
				System.out.println("-------------- Game selected is RUNNING --------------");
				if(checkForSufficientAthlete()){
					deleteAthleteList();
					db.getAthleteDataBase().loadAthlete(athleteList,numberOfAthletes,'R');
					this.game = new Game(new Running(),athleteList);
				}
				else
					isGameSelected = false;
				break;
			case 3:
				System.out.println("-------------- Game selected is CYCLING --------------");
				if(checkForSufficientAthlete()){
					deleteAthleteList();
					db.getAthleteDataBase().loadAthlete(athleteList,numberOfAthletes,'C');
					this.game = new Game(new Cycling(),athleteList);
				}
				else
					isGameSelected = false;
				break;
		default:
			System.out.println("Please select the correct input");
			gameSelect();
		}
		}
		catch(Exception e){
			sc.next();
			System.out.println("Please Provide Valid Input");
			gameSelect();
			}
	}


	public int getNumberOfAthletes(){
		numberOfAthletes= randomNumber.nextInt(MAX_ATHLETES-MIN_ATHLETES)+MIN_ATHLETES;
		return numberOfAthletes;
	}
	
	/**
	 * @description check if minimum number of athletes are participating or not
	 * @return boolean isSufficient sufficient players are available or not
	 */
	public boolean checkForSufficientAthlete(){
		boolean isSufficient = false;
		if(numberOfAthletes >= numberOfMandatoryAthletes)
			isSufficient = true;
		else
			System.out.println("Game has been cancelled due to Insufficient Players: "+numberOfAthletes);
		return isSufficient;
	}
	
	
	public void displayAllGames(){
		System.out.println("Total number of games played is "+gameList.size());
		for(Game game: gameList){
			System.out.println("=============================");
			System.out.println("Game ID: "+game.getGameID());
			System.out.println("Referre name :"+game.getReferee().getName());
			game.getReferee().displayResult();

		}

	}
	
	public void deleteAthleteList(){
		this.athleteList.clear();
					
	}
/**
 * @description starting the game to play
 * @exception IOException On input error
 */

	public void startGame(){
		try{
			this.game.initiateGame();
			this.game.rewardWinner();
			gameList.add(this.game);
			System.out.println("====================== GAME STARTED ========================");
		}
		catch(Exception e){
			sc.next();
			System.out.println("Game has been withdrawn due to heavy rain");
		}

	}
/**
 * @description displaying points of all athletes
 */

	public void displayAllAthletePoints(){
			Athlete[] athleteList = AthleteDataBase.athlete;
			for(int i=0; i< athleteList.length ; i++){
				System.out.println("Name:  "+athleteList[i].getName()+"Total points: "+athleteList[i].getTotalPoints());
			}
	}
/**
 * @description Predicting the winner of game
 * @exception IOException On input error
 */

	public void predictWinner(){
		try{
			System.out.println("TOTAL NUMBER OF ATHLETES PLAYING THE GAME ARE : "+numberOfAthletes);
			int i=1;
			Iterator iterator = athleteList.iterator();
			while(iterator.hasNext()){
				currentAthlete = (Athlete)iterator.next();
				System.out.println(i +")"+currentAthlete.getId());
				i++;
			}
			System.out.println("Please select your player: ");
			USER_PREDICTION =sc.nextInt()-1;
			System.out.println("====================================");
			List currentList = new ArrayList(this.athleteList);
			int size=currentList.size()-1;
			if((USER_PREDICTION <= size) && !(USER_PREDICTION <0)){
				Athlete currentAthlete = (Athlete)currentList.get(USER_PREDICTION);
				System.out.println("User Choice is "+ currentAthlete.getName());
			} else{
				System.out.println("Please select player from menu Only");
				predictWinner();
			}
		}
		catch(Exception e){
			sc.next();
			System.out.println("Please try the correct option");
			predictWinner();
		}
	}

/**
 * @description Showing the result of game to user
 * @exception IOException On input error
 */
	public void gameResult(){
		try{
			List currentList = new ArrayList(this.athleteList);
			Athlete currentAthlete = (Athlete)currentList.get(USER_PREDICTION);
			System.out.println("Winner of this game is "+game.getWinnerName());
			System.out.println("User Prediction for the game was "+currentAthlete.getName());
			if(currentAthlete.equals(game.getFirstAthlete())){
				System.out.println("=-=-=-=-=-=-=-==- Congrats User Prediction was correct =-=-=-=-=-=-==-=-");
			}
			else
				System.out.println("========== User predicted Athlete was not in First place ==========");
		}
		catch(Exception e){
			sc.next();
			System.out.println("Please try again with valid entry");
		}

	}



}
