import java.util.Scanner;

public class Driver {
	Scanner sc=new Scanner(System.in);
	
public static void main(String args[]){
Driver d=new Driver();
d.menu();
}

public void menu(){
	System.out.println("===========================================");
	System.out.println("            OZYMPLIC GAMES");
	System.out.println("===========================================");
	System.out.println("1. Select a Game to run ");
	System.out.println("2. Predict the Winner of Game ");
	System.out.println("3. Start the Game ");
	System.out.println("4. Display the final result of all Games");
	System.out.println("5. Display the points of all Athletes");
	System.out.println("6. Exit ");
	int selec =sc.nextInt();
	switch(selec){
	case 1:
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	case 5:
		break;
	case 6:
		break;
	}
}
}
