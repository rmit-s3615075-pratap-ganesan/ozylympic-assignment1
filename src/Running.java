import java.text.DecimalFormat;

public class Running extends AbstractEvent{
	static int minTime=10;             //minimum time for the event running
	static int maxTime=20;             // maximum time for the event running
	static int count=0;                //counting number of times event played
	/*
	 * method to pass minimum and maximum time of event to parent class
	 */
	 public Running() {
		super(minTime, maxTime);
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
		return 'R';
	}
}
