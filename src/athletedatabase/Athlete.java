package athletedatabase;

public class Athlete {
	
	private int totalPoints;
	private String athleteId;
	private String athleteName;
	private int athleteAge;
	private String athleteState;
	private char athleteType;
	
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


	public void compete(){
		System.out.println("Inside the compete: generating the random numbers");
	}

}
