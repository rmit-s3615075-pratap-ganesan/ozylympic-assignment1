import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Game {
	int firstPrize = 5;
	int secondPrize = 2;
	int thirdPrize = 1;
	String gameID;
	Event event;
	Referee referee;
	Set<Athlete> athleteList;
	Athlete firstAthlete;
	Athlete secondAthlete;
	Athlete thirdAthlete;
	static AthleteDataBase db;
		
	
		
		public Set<Athlete> getAthleteList() {
			return athleteList;
		}

		
		public Game(Event event, Set<Athlete> athleteList){
			this.setEvent(event);
			this.setGameID(event.getEventName()+event.getCount());
			this.setAthleteList(athleteList);
			//this.referee = db.assginReferee();
		}
	
	
	
		public Event getEvent() {
			return event;
		}
	
	
		public void setAthleteList(Set<Athlete> athleteList) {
			this.athleteList = athleteList;
		}


		public void setEvent(Event event) {
			this.event = event;
		}


		public String getGameID() {
			return gameID;
		}


		public void setGameID(String gameID) {
			this.gameID = gameID;
		}
		
		
		public void initiateGame(){
			Athlete currentAthlete;
			Iterator iterator = this.athleteList.iterator();
			while(iterator.hasNext()){
				currentAthlete = (Athlete)iterator.next();
				currentAthlete.compete(this.event.getminTimer(),this.event.getmaxTimer());
			}
						
		}
		
		
		public void rewardWinner(){
			 List toSort = new ArrayList(this.athleteList);
			 Collections.sort(toSort);
			 Collections.reverse(toSort);
			 this.firstAthlete = (Athlete)toSort.get(0);
			 this.firstAthlete.setTotalPoints(this.firstAthlete.getTotalPoints()+firstPrize);
			 this.secondAthlete = (Athlete)toSort.get(1);
			 this.secondAthlete.setTotalPoints(this.secondAthlete.getTotalPoints()+secondPrize);
			 this.thirdAthlete = (Athlete)toSort.get(2);
			 this.thirdAthlete.setTotalPoints(this.thirdAthlete.getTotalPoints()+thirdPrize);
			 this.referee.loadAthletes(toSort);
			
		 }

		
		public String getWinnerName(){
			return this.firstAthlete.getAthleteName();
			
		}
	    
	
	
	
}