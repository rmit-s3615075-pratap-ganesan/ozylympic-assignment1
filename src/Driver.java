
import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Driver {
	Scanner sc=new Scanner(System.in);
	Random ran=new Random();
	Game game;
	int i=1;
   int userPrediction;
	Athlete currentAthlete;
	Set<Athlete> athleteList = new HashSet<Athlete>();
public static void main(String args[]){
Driver d=new Driver();
d.menu();
}
public int getNumberOfAthletes(){
	int numberofAthletes = ran.nextInt(8);
	return numberofAthletes;
}
 int totalAthletes= getNumberOfAthletes();
public void menu(){
	try{
	System.out.println("===========================================");
	System.out.println("            OZYMPLIC GAMES");
	System.out.println("============================================");
	System.out.println("1. Select a Game to run ");
	System.out.println("2. Predict the Winner of Game ");
	System.out.println("3. Start the Game ");
	System.out.println("4. Display the final result of all Games");
	System.out.println("5. Display the points of all Athletes");
	System.out.println("6. Exit ");
	int selec =sc.nextInt();
	switch(selec){
	case 1:
	//	if(totalAthletes > 4){
		gameSelect();
		//}
	/*	else if(totalAthletes < 4){
			System.out.println("Not Enough Athletes For This Game");
		}  */
		break;
	case 2:
	predictWinner();
		break;
	case 3:
	     startGame();
		break;
	case 4:
		gameResult();
		menu();
		break;
	case 5:
		athleteDisplay();
		break;
	case 6:
		System.exit(0) ;
		break;
	}
	if(selec > 6){
		System.out.println("Wrong Input Try Again");
		menu();
	}
	}
	catch(Exception e){
		System.out.println("ERROR");	
	}

	
}
public void gameSelect(){
	try{
	System.out.println("========== PLEASE SELECT A GAME EVENT ==========");
	System.out.println("1) SWIMMING \n");
	System.out.println("2) RUNNING \n");
	System.out.println("3) CYCLING \n");
	int choice=sc.nextInt();
	if(choice==1){
		System.out.println("********** Game selected is SWIMMING **********");
		new AthleteDataBase().loadAthlete(athleteList,2,'S');
		game = new Game(new Swimming(),athleteList);
		menu();
	
	}
	else if(choice==2){
		System.out.println("********** Game selected is RUNNING **********");
		new AthleteDataBase().loadAthlete(athleteList,8,'R');
		game = new Game(new Running(),athleteList);
		menu();
		
	}
	else if(choice==3){
		System.out.println("********** Game selected is CYCLING **********");
		new AthleteDataBase().loadAthlete(athleteList,8,'C');
		game = new Game(new Cycling(),athleteList);
		menu();
	
	}
	else{
		System.out.println("Please Give Right Input");
	}
	}
	catch(Exception e){
		System.out.println("ERROR");
	}
}

public void predictWinner(){
	try{
	Iterator iterator = athleteList.iterator();
	while(iterator.hasNext()){
		currentAthlete = (Athlete)iterator.next();
		System.out.println(i +")"+currentAthlete.getAthleteId());
		 i++;
	}
	System.out.println("===== Enter your Prediction =====");
	 userPrediction =sc.nextInt()-1;
	 
   System.out.println("=================================");
   List currentList = new ArrayList(this.athleteList);
   Athlete currentAthlete = (Athlete)currentList.get(userPrediction);
   System.out.println("User Choice is "+ currentAthlete.getAthleteName());
   menu();
	}
	catch(Exception e){
		System.out.println("ERROR");
		menu();
	}
}
public void startGame(){
	game.initiateGame();
	game.rewardWinner();
	System.out.println("================ Game Started ==================");
	menu();
}
public void athleteDisplay(){
	System.out.println("Athlete at First Position is "+game.firstAthlete.getAthleteName()+" "+game.firstAthlete.getFinishTimer());
	System.out.println("Athlete at Second Position is "+game.secondAthlete.getAthleteName()+" "+game.secondAthlete.getFinishTimer());
	System.out.println("Athlete at Third Position is "+game.thirdAthlete.getAthleteName()+" "+game.thirdAthlete.getFinishTimer());	
	System.out.println("Winner of game is "+game.getWinnerName());
}
public void gameResult(){
	List currentList = new ArrayList(this.athleteList);
	   Athlete currentAthlete = (Athlete)currentList.get(userPrediction);
	System.out.println("Winner of this game is "+game.getWinnerName());
	System.out.println("User Prediction for the game was "+currentAthlete.getAthleteName());
	if(currentAthlete.equals(game.firstAthlete)){
		System.out.println("***** Congrats User Prediction was correct *****");
	}
		else{
			System.out.println("===== User selected Athlete was not in First place =====");
		}
	}
}

