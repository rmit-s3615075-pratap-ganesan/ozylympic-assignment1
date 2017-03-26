import java.util.Random;
import java.util.Scanner;

public class Driver {
	Scanner sc=new Scanner(System.in);
	Random ran=new Random();
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
	System.out.println("===========================================");
	System.out.println("            OZYMPLIC GAMES");
	System.out.println("===========================================\n");
	System.out.println("1. Select a Game to run ");
	System.out.println("2. Predict the Winner of Game ");
	System.out.println("3. Start the Game ");
	System.out.println("4. Display the final result of all Games");
	System.out.println("5. Display the points of all Athletes");
	System.out.println("6. Exit ");
	int selec =sc.nextInt();
	switch(selec){
	case 1:
		if(totalAthletes > 4){
		gameSelect();
		}
		else if(totalAthletes < 4){
			System.out.println("Not Enough Athletes For This Game");
		}
		break;
	case 2:
		//will display all players
		break;
	case 3:
		//start the game and generate values
		break;
	case 4:
		//display the output to user
		break;
	case 5:
		//display athletes with final result
		break;
	case 6:
		System.exit(0) ;
		break;
	}
}
public void gameSelect(){
	System.out.println("========== PLEASE SELECT A GAME EVENT ==========\n");
	System.out.println("1) SWIMMING \n");
	System.out.println("2) CYCLING \n");
	System.out.println("3) RUNNING \n");
	int choice=sc.nextInt();
	if(choice==1){
		new Game(new Swimming(),totalAthletes);
	}
	else if(choice==2){
	    new Game(new Cycling(),totalAthletes);
	}
	else if(choice==3){
		new Game(new Running(),totalAthletes);
	}
	else{
		System.out.println("Please Give Right Input");
	}
}
public void listAthletes(){
	int randomSelect=ran.nextInt(16);
	for(int i= randomSelect;i<randomSelect+4;i++){
		// array to store random players from list
	}
}
}
