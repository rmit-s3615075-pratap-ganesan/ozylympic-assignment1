
import java.util.*;

public class Driver {
	Scanner sc=new Scanner(System.in);    //taking user input
	Random ran=new Random();              //generating random number
	Game game;                            //creating object of Game
	Athlete currentAthlete;               //arraylist to store list of athletes playing in games
	int USER_PREDICTION =0 ;              //storing user prediction
	boolean isGameSelected ;               
	boolean isWinnerPredicted;
	boolean isGameStarted;
	int MAX_ATHLETES=8;                   //maximum athletes who can participate
	int MIN_ATHLETES=2;                   //minimum athletes who can participate
	int selec;                            //storing user selection choice
	int numberofAthletes;
 
	Set<Athlete> athleteList = new HashSet<Athlete>();
	public static void main(String args[]){
	Driver d=new Driver();
	d.menu();
}
/*
 * getting number of athletes participating using random number
 */
public int getNumberOfAthletes(){
	numberofAthletes= ran.nextInt(MAX_ATHLETES-MIN_ATHLETES)+MIN_ATHLETES;
	return numberofAthletes;
}
 /*
  * providing menu interface to user
  * user program interaction happens here
  */
public void menu(){	
	try{
		options();
	    selec =sc.nextInt();
	switch(selec){
	case 1:
	  if(getNumberOfAthletes() > 4){
		 isGameSelected=true;
		gameSelect();     //calling game select method
		}
		else if(getNumberOfAthletes()< 4){
		System.out.println("Not Enough Athletes For This Game");	
		}  
		break;
	case 2:
		if(isGameSelected ==true){
	    isWinnerPredicted=true;
	    predictWinner();              //calling method to predict winner
		}	else 
	    System.out.println("Select Game First");
		break;
	case 3:
		if(USER_PREDICTION != 0){
		isGameStarted=true;
		startGame();                 //calling method to start Game
		gameResult();               //calling method to display result
		}else
		System.out.println("Predict Winner First");
		break;
	case 4:
		if(isGameStarted==true){
		}else
		System.out.println("First Start Game ");
		break;
	case 5:
		if(isGameStarted==true){
			 athleteDisplay();       //displaying the final result of Game
		} else
			System.out.println("First Play Game");
		break;
	case 6:
		System.exit(0) ;
		break;
	}
	if(selec > 6){
		System.out.println("Wrong Input Try Again");
		}
	}
	catch(Exception e){
		sc.next();
		System.out.println("Enter right input");
	}	
	menu();
}
/*
 * selecting game to play
 */
public void gameSelect(){
	try{
	System.out.println("========== PLEASE SELECT A GAME EVENT ==========");
	System.out.println("1) SWIMMING \n");
	System.out.println("2) RUNNING \n");
	System.out.println("3) CYCLING \n");
	 selec=sc.nextInt();
	if(selec==1){
		System.out.println("-------------- Game selected is SWIMMING --------------");
		new AthleteDataBase().loadAthlete(athleteList,numberofAthletes,'S');     
		game = new Game(new Swimming(),athleteList);                             
	}
	else if(selec==2){
		System.out.println("-------------- Game selected is RUNNING --------------");
		new AthleteDataBase().loadAthlete(athleteList,numberofAthletes,'R');
		game = new Game(new Running(),athleteList);
	}
	else if(selec==3){
		System.out.println("-------------- Game selected is CYCLING --------------");
		new AthleteDataBase().loadAthlete(athleteList,numberofAthletes,'C');
		game = new Game(new Cycling(),athleteList);	
	}
	else{
		System.out.println("Please Give Right Input");
		gameSelect();
	}
	}
	catch(Exception e){
		sc.next();
		System.out.println("Please Provide Valid Input");
		gameSelect();
		}
	menu();
}
/*
 * letting user to predict winner
 */
public void predictWinner(){
	try{
		System.out.println("TOTAL NUMBER OF ATHLETES PLAYING THE GAME ARE : "+numberofAthletes);
		int i=1;
	Iterator iterator = athleteList.iterator();
	while(iterator.hasNext()){
		currentAthlete = (Athlete)iterator.next();
		System.out.println(i +")"+currentAthlete.getAthleteId());
		 i++;
	}
	System.out.println("========== Enter your Prediction ===========");
	 USER_PREDICTION =sc.nextInt()-1;
	}
	 catch(Exception e){
		 sc.next();
		System.out.println("Please Select One Of Given Players");
		}
   System.out.println("=================================");
   try{
   List currentList = new ArrayList(this.athleteList);
   Athlete currentAthlete = (Athlete)currentList.get(USER_PREDICTION);
   System.out.println("User Choice is "+ currentAthlete.getAthleteName());
   }
   catch(Exception e){
	   sc.next();
	   System.out.println(e);
   }
}
/*
 * menu options provided to user
 */
public void options(){
	System.out.println("===========================================");
	System.out.println("            OZYMPLIC GAMES");
	System.out.println("============================================");
	System.out.println("1. Select a Game to run ");
	System.out.println("2. Predict the Winner of Game ");
	System.out.println("3. Start the Game ");
	System.out.println("4. Display the final result of all Games");
	System.out.println("5. Display the points of all Athletes");
	System.out.println("6. Exit ");
}
/*
 * initiating game
 * rewarding points to athletes
 */
public void startGame(){
	try{
	game.initiateGame();
	game.rewardWinner();
	System.out.println("====================== GAME STARTED ========================");
	}
	catch(Exception e){
		sc.next();
		System.out.println("Something went wrong while starting Game");
	}
	
}
public void athleteDisplay(){
	try{
		System.out.println("=================== RESULTS ===================");
	System.out.println("Athlete at First Position is "+game.firstAthlete.getAthleteName()+" "+game.firstAthlete.getFinishTimer());
	System.out.println("Athlete at Second Position is "+game.secondAthlete.getAthleteName()+" "+game.secondAthlete.getFinishTimer());
	System.out.println("Athlete at Third Position is "+game.thirdAthlete.getAthleteName()+" "+game.thirdAthlete.getFinishTimer());	
	System.out.println("WINNER OF GAME IS  "+game.getWinnerName());
	System.out.println("===================== END =====================");
	}
	catch(Exception e){
		sc.next();
		System.out.println("Unable to display list of Athletes");
	}
}
/*
 * displaying result of game to user
 */
public void gameResult(){
	try{
	List currentList = new ArrayList(this.athleteList);
	Athlete currentAthlete = (Athlete)currentList.get(USER_PREDICTION);
	System.out.println("Winner of this game is "+game.getWinnerName());
	System.out.println("User Prediction for the game was "+currentAthlete.getAthleteName());
	if(currentAthlete.equals(game.firstAthlete)){
		System.out.println("=-=-=-=-=-=-=-=-=-=- Congrats User Prediction was correct =-=-=-=-=-=-=-=-=-=-");
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

