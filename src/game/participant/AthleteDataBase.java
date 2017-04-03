package game.participant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
/**
 * 
 * @author ASHISH
 *
 */
public class AthleteDataBase {
	
	public static  Athlete athlete[];
	public static Referee referee[];
	Random randomGenerator = new Random();    //generating random number
	int totalParticipatingAthletes = 26;
	int totalParticipatingReferee = 5;
	static AthleteDataBase db;
	/**
	 * @description getting the instance of AthleteDatabase 
	 * @return database object
	 */ 
	public static AthleteDataBase getAthleteDataBase(){
		if(db!=null)
			return db;
		else
			db = new AthleteDataBase();
		return db;
		
	}
	
	private AthleteDataBase(){
		
		athlete = new Athlete[totalParticipatingAthletes];
		referee = new Referee[totalParticipatingReferee];
		athlete[0] = new Athlete("A01_Cycle", "AJohn",22, "AState",'C');
		athlete[1] = new Athlete("B01_Swim", "BJohn",22, "BState",'S');
		athlete[2] = new Athlete("C01_Run", "CJohn",22, "CState",'R');
		athlete[3] = new Athlete("D01_Super", "DJohn",22, "DState",'A');
		athlete[4] = new Athlete("E01_Cycle", "EJohn",22, "EState",'C');
		athlete[5] = new Athlete("F01_Cycle", "FJohn",22, "FState",'C');
		athlete[6] = new Athlete("G01_Cycle", "GJohn",22, "GState",'C');
		athlete[7] = new Athlete("H01_Cycle", "HJohn",22, "HState",'C');
		athlete[8] = new Athlete("I01_Super", "IJohn",22, "IState",'A');
		athlete[9] = new Athlete("J01_Super", "JJohn",22, "JState",'A');
		athlete[10] = new Athlete("K01_Super", "KJohn",22, "KState",'A');
		athlete[11] = new Athlete("L01_Super", "LJohn",22, "LState",'A');
		athlete[12] = new Athlete("M01_Super", "MJohn",22, "MState",'A');
		athlete[13] = new Athlete("N01_Swim", "NJohn",22, "NState",'S');
		athlete[14] = new Athlete("O01_Run", "OJohn",22, "OState",'R');
		athlete[15] = new Athlete("P01_Run", "PJohn",22, "PState",'R');
		athlete[16] = new Athlete("Q01_Run", "QJohn",22, "QState",'R');
		athlete[17] = new Athlete("R01_Run", "RJohn",22, "RState",'R');
		athlete[18] = new Athlete("S01_Swim", "SJohn",22, "SState",'S');
		athlete[19] = new Athlete("T01_Swim", "TJohn",22, "TState",'S');
		athlete[20] = new Athlete("U01_Swim", "UJohn",22, "UState",'S');
		athlete[21] = new Athlete("V01_Swim", "VJohn",22, "VState",'S');
		athlete[22] = new Athlete("W01_Super", "WJohn",22, "WState",'A');
		athlete[23] = new Athlete("X01_Super", "XJohn",22, "XState",'A');
		athlete[24] = new Athlete("Y01_Run", "YJohn",22, "YState",'R');
		athlete[25] = new Athlete("Z01_Run", "ZJohn",22, "ZState",'R');
		
		
		referee[0] = new Referee("Ref_A01","RefereeA",28,"RefAState");
		referee[1] = new Referee("Ref_B01","RefereeB",28,"RefBState");
		referee[2] = new Referee("Ref_C01","RefereeC",28,"RefCState");
		referee[3] = new Referee("Ref_D01", "RefereeD", 28, "RefDState");
		referee[4] = new Referee("Ref_E01","RefereeE",30,"RefeEState");
		
	}
	/**
	 * @description loading the list of Athletes
	 * @param athleteList list of athlete objects
	 * @param numberOfAthletes number of Athletes participating
	 * @param gameType type of event
	 */
public void loadAthlete(Set<Athlete> athleteList,int numberOfAthletes,char gameType){
		
		int randomNumber;
		boolean assignedPlayer;
		char assignedPlayerType;
		while(athleteList.size()!=numberOfAthletes){
			assignedPlayer = false;
			while(!assignedPlayer){
			randomNumber = randomGenerator.nextInt(26);
			assignedPlayerType = this.athlete[randomNumber].getAthleteType();
			if(assignedPlayerType == gameType || assignedPlayerType== 'A'){
				try{
				athleteList.add(this.athlete[randomNumber]);
				assignedPlayer = true;
				}catch(Exception e){System.out.println("Cannot assign duplicate values");}		
				
				}
			}
		}
	}

/**
 * @description assigning Referee to Game
 * @return assignedReferee object
 */
 public Referee assginReferee(){
	 Referee assignedReferee;
	 assignedReferee =  referee[randomGenerator.nextInt(totalParticipatingReferee)];
	 return assignedReferee;
	 
 }


	
	
	
	
	
	

}
