import java.util.ArrayList;
import java.util.List;

public class Referee extends Participant{

	ArrayList<Athlete> athleteList;
	final int firstPlace = 0;
	final int secondPlace = 1;
	final int thirdPlace = 3;
	
	
	public Referee(String id, String name, int age, String state) {
		super(id, name, age, state);
	}

	public void displayResult(){
		System.out.println("Winner: "+athleteList.get(firstPlace));
		System.out.println("First Runner up: "+athleteList.get(secondPlace));
		System.out.println("Second Runner up: "+athleteList.get(thirdPlace));
		
		
	}
	
	public void loadAthletes(List athleteList){
		this.athleteList =  (ArrayList<Athlete>) athleteList;
		
	}

	
}
