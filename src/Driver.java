
import java.util.*;

public class Driver {
	Scanner sc=new Scanner(System.in);
	Random ran=new Random();
	Game game;
	Athlete currentAthlete;
	int userPrediction =0 ;
	boolean isGameSelected ;
	boolean isWinnerPredicted;
	boolean isGameStarted;
	int MAX_ATHLETES=8;
	int MIN_ATHLETES=2;
	int numberofAthletes;
 
	Set<Athlete> athleteList = new HashSet<Athlete>();
	public static void main(String args[]){
	Driver d=new Driver();
	d.menu();
}
public int getNumberOfAthletes(){
	numberofAthletes= ran.nextInt(MAX_ATHLETES-MIN_ATHLETES)+MIN_ATHLETES;
	return numberofAthletes;
}
 int totalAthletes= getNumberOfAthletes();

public void menu(){	
	try{
		int i=0;
		options();
		   int selection =sc.nextInt();
	switch(selection){
	case 1:
	//	if(totalAthletes > 4){
		gameSelect();
		isGameSelected=true;
	    menu();
		//}
	/*	else if(totalAthletes < 4){
			System.out.println("Not Enough Athletes For This Game");	
		}  */
		break;
	case 2:
		//if(isGameSelected ==true){
	    predictWinner();
	 //   isWinnerPredicted=true;
		menu();
	/*	}
		else{
			System.out.println("Select Game First");
			menu(); 
		} */
		break;
	case 3:
		if(userPrediction != 0){
		startGame();
		gameResult();
		menu();
		isGameStarted=true;
		}
		else{
			System.out.println("Predict Winner First");
			menu();
		}
	
		break;
	case 4:
		if(isGameStarted==true){
		menu();
		}else{
			System.out.println("First Start Game ");
			menu();
		}
		break;
	case 5:
	athleteDisplay();
		break;
	case 6:
		System.exit(0) ;
		break;
	}

	if(selection > 6){
		System.out.println("Wrong Input Try Again");
		menu();
		}
	}
	catch(Exception e){
		System.out.println("Enter right input");
		menu();
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
		new AthleteDataBase().loadAthlete(athleteList,numberofAthletes,'S');
		game = new Game(new Swimming(),athleteList);
	
	}
	else if(choice==2){
		System.out.println("********** Game selected is RUNNING **********");
		new AthleteDataBase().loadAthlete(athleteList,numberofAthletes,'R');
		game = new Game(new Running(),athleteList);
	
	}
	else if(choice==3){
		System.out.println("********** Game selected is CYCLING **********");
		new AthleteDataBase().loadAthlete(athleteList,numberofAthletes,'C');
		game = new Game(new Cycling(),athleteList);
		
	}
	else{
		System.out.println("Please Give Right Input");
	}
	}
	catch(Exception e){
		System.out.println("Please Provide Valid Input");
		}
}

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
	System.out.println("===== Enter your Prediction =====");
	 userPrediction =sc.nextInt()-1;
	}
	 catch(Exception e){
			System.out.println("Please Select One Of Given Players");
		}
   System.out.println("=================================");
   try{
   List currentList = new ArrayList(this.athleteList);
   Athlete currentAthlete = (Athlete)currentList.get(userPrediction);
   System.out.println("User Choice is "+ currentAthlete.getAthleteName());
   }
   catch(Exception e){
	   System.out.println(e);
   }
 
}

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

public void startGame(){
	try{
	game.initiateGame();
	game.rewardWinner();
	System.out.println("=================== GAME STARTED =====================");
	}
	catch(Exception e){
		System.out.println("Something went wrong while starting Game");
	}
	
}
public void athleteDisplay(){
	try{
	System.out.println("Athlete at First Position is "+game.firstAthlete.getAthleteName()+" "+game.firstAthlete.getFinishTimer());
	System.out.println("Athlete at Second Position is "+game.secondAthlete.getAthleteName()+" "+game.secondAthlete.getFinishTimer());
	System.out.println("Athlete at Third Position is "+game.thirdAthlete.getAthleteName()+" "+game.thirdAthlete.getFinishTimer());	
	System.out.println("Winner of game is "+game.getWinnerName());
	}
	catch(Exception e){
		System.out.println("Unable to display list of Athletes");
	}
}
public void gameResult(){
	try{
		int i=1;
	 List currentList = new ArrayList(this.athleteList);
	   Athlete currentAthlete = (Athlete)currentList.get(userPrediction);
	System.out.println("Winner of this game is "+game.getWinnerName());
	System.out.println("User Prediction for the game was "+currentAthlete.getAthleteName());
	if(currentAthlete.equals(game.firstAthlete)){
		System.out.println("******* Congrats User Prediction was correct *******");
	}
		else{
			System.out.println("===== User selected Athlete was not in First place =====");
		}
	}
	catch(Exception e){
		System.out.println("ERROR");
	}

}
}

