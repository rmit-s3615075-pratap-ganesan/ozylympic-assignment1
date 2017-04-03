import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Athlete extends Participant implements Comparable<Athlete>, Comparator<Athlete> {
	
	private int totalPoints;
	
	private char athleteType;
	private int finishTimer;
	Set<Athlete> athleteList;
	
	public int getFinishTimer() {
		return finishTimer;
	} 


	public void setFinishTimer(int finishTimer) {
		this.finishTimer = finishTimer;
	}


	public int getTotalPoints() {
		return totalPoints;
	}


	
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}


	public char getAthleteType() {
		return athleteType;
	}


	public void setAthleteType(char athleteType) {
		this.athleteType = athleteType;
	}

	
	
	public Athlete(String athleteId, String athleteName, int athleteAge, String athleteState, char athleteType) {
		super(athleteId,athleteName,athleteAge,athleteState);
		this.athleteType = athleteType;
	}

	public void athleteDisplay(){
		Athlete currentAthlete;
		Iterator iterator = this.athleteList.iterator();
		while(iterator.hasNext()){
			currentAthlete = (Athlete)iterator.next();
			System.out.println(currentAthlete);
	}
	}
	public void compete(int minTimer, int maxTimer){
		Random random = new Random();
		int finishTimer = random.nextInt(maxTimer-minTimer)+minTimer;
		this.setFinishTimer(finishTimer);
		
	}


	@Override
	public int compare(Athlete firstAthlete, Athlete secondAthlete) {
		// TODO Auto-generated method stub
		return firstAthlete.getFinishTimer() - secondAthlete.getFinishTimer();
	}


	@Override
	public int compareTo(Athlete athlete) {
		// TODO Auto-generated method stub
		return this.compare(this, athlete);
	}

}
