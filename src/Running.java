import java.text.DecimalFormat;

public class Running extends AbstractEvent{
	static int minTime=10;
	static int maxTime=20;
	static int count=0;
	
	 public Running() {
		super(minTime, maxTime);
	 }

	@Override
	public String getCount(){
		DecimalFormat formatter = new DecimalFormat("00");
		String formatted = formatter.format(++count);

		return formatted;
	}

	@Override
	public char getEventName() {
		// TODO Auto-generated method stub
		return 'R';
	}
}
