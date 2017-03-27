import java.text.DecimalFormat;

public class Swimming extends AbstractEvent{
	 static int minTime=100;
	 static int maxTime=200;
	 static int count=0;
	
	 public Swimming() {
		super(minTime,maxTime);
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
		return 'S';
	}
	 
	 
}
