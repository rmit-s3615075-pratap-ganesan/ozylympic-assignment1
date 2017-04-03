
package game.participant;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ASHISH
 *Referee is inheriting Participant
 */
public class Referee extends Participant{

	ArrayList<Athlete> athleteList;
	final int firstPlace = 0;
	final int secondPlace = 1;
	final int thirdPlace = 3;
	
	
	public Referee(String id, String name, int age, String state) {
		super(id, name, age, state);
	}
/**
 * @description displaying the Game results to user
 */
	public void displayResult(){
		System.out.println("Winner: "+athleteList.get(firstPlace).getId()+" "+athleteList.get(firstPlace).getName());
		System.out.println("First Runner up: "+athleteList.get(secondPlace).getId()+" "+athleteList.get(secondPlace).getName());
		System.out.println("Second Runner up: "+athleteList.get(thirdPlace).getId()+" "+athleteList.get(thirdPlace).getName());
		
		
	}
	/**
	 * @description loading the list of Athletes
	 * @param athleteList list of athlete objects
	 */
	public void loadAthletes(List athleteList){
		this.athleteList =  (ArrayList<Athlete>) athleteList;
		
	}

	
}
