import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
		Game game;
		Athlete currentAthlete;
		Set<Athlete> athleteList = new HashSet<Athlete>();
		new AthleteDataBase().loadAthlete(athleteList,8,'C');
		Iterator iterator = athleteList.iterator();
		while(iterator.hasNext()){
			currentAthlete = (Athlete)iterator.next();
			System.out.println(currentAthlete.getAthleteId());
		
		}
		
		System.out.println("No of athletes "+athleteList.size());
		
		game = new Game(new Cycling(),athleteList);
		game.initiateGame();
		game.rewardWinner();
		System.out.println(game.firstAthlete.getAthleteName()+" "+game.firstAthlete.getFinishTimer());
		System.out.println(game.secondAthlete.getAthleteName()+" "+game.secondAthlete.getFinishTimer());
		System.out.println(game.thirdAthlete.getAthleteName()+" "+game.thirdAthlete.getFinishTimer());	
		System.out.println(game.getWinnerName());
			
		new AthleteDataBase().loadAthlete(athleteList,8,'R');
		game = new Game(new Running(),athleteList);
		game.initiateGame();
		game.rewardWinner();
		System.out.println(game.firstAthlete.getAthleteName()+" "+game.firstAthlete.getFinishTimer());
		System.out.println(game.secondAthlete.getAthleteName()+" "+game.secondAthlete.getFinishTimer());
		System.out.println(game.thirdAthlete.getAthleteName()+" "+game.thirdAthlete.getFinishTimer());	
		System.out.println(game.getWinnerName());
		
		new AthleteDataBase().loadAthlete(athleteList,8,'S');
		game = new Game(new Swimming(),athleteList);
		game.initiateGame();
		game.rewardWinner();
		System.out.println(game.firstAthlete.getAthleteName()+" "+game.firstAthlete.getFinishTimer());
		System.out.println(game.secondAthlete.getAthleteName()+" "+game.secondAthlete.getFinishTimer());
		System.out.println(game.thirdAthlete.getAthleteName()+" "+game.thirdAthlete.getFinishTimer());	
		System.out.println(game.getWinnerName());
		
	}

}
