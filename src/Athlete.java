import java.util.Comparator;
import java.util.Random;

public class Athlete implements Comparable<Athlete>, Comparator<Athlete> {
	
	private int totalPoints;
	private String athleteId;
	private String athleteName;
	private int athleteAge;
	private String athleteState;
	private char athleteType;
	private int finishTimer;
	
	public int getFinishTimer() {
		return finishTimer;
	}


	public void setFinishTimer(int finishTimer) {
		this.finishTimer = finishTimer;
	}


	public int getTotalPoints() {
		return totalPoints;
	}


	public String getAthleteId() {
		return athleteId;
	}


	public void setAthleteId(String athleteId) {
		this.athleteId = athleteId;
	}


	public String getAthleteName() {
		return athleteName;
	}


	public void setAthleteName(String athleteName) {
		this.athleteName = athleteName;
	}


	public int getAthleteAge() {
		return athleteAge;
	}


	public void setAthleteAge(int athleteAge) {
		this.athleteAge = athleteAge;
	}


	public String getAthleteState() {
		return athleteState;
	}


	public void setAthleteState(String athleteState) {
		this.athleteState = athleteState;
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
		this.athleteId = athleteId;
		this.athleteName = athleteName;
		this.athleteAge = athleteAge;
		this.athleteState = athleteState;
		this.athleteType = athleteType;
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
