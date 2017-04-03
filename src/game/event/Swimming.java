package game.event;
import java.text.DecimalFormat;
/**
 * 
 * @author PRATAP
 *
 */
public class Swimming extends AbstractEvent{
	 static int minTime=100;          //minimum time for event Swimming
	 static int maxTime=200;          //maximum time for event Swimming
	 static int count=0;               //counting number of times event played
		/*
		 * method to pass minimum and maximum time of event to parent class
	    */
	 public Swimming() {
		super(minTime,maxTime);
	 }

	@Override
	public String getCount(){
		DecimalFormat formatter = new DecimalFormat("00");
		String formatted = formatter.format(++count);

		return formatted;
	}
	/*
	 *overriding parent method to fetch name of event
	 */
	@Override
	public char getEventName() {
		// TODO Auto-generated method stub
		return 'S';
	}
	 
	 
}
