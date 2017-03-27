import java.text.DecimalFormat;

public class Cycling extends AbstractEvent {
static int minTime=500;
static int maxTime=800;
static int count =0;

 
public Cycling() {
	super(minTime, maxTime);
	// TODO Auto-generated constructor stub
}

public String getCount(){
	DecimalFormat formatter = new DecimalFormat("00");
	String formatted = formatter.format(++count);

	return formatted;
}

@Override
public char getEventName() {
	// TODO Auto-generated method stub
	return 'C';
}






}
