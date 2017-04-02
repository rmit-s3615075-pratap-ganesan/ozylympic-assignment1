import java.text.DecimalFormat;

public class Cycling extends AbstractEvent {
static int minTime=500;                  //maximum time for event cycling
static int maxTime=800;                  //minimum time for event cycling
static int count =0;                     //counting number of times event played

 /*
  * method to pass minimum and maximum time of event to parent class
  */
public Cycling() {
	super(minTime, maxTime);
	// TODO Auto-generated constructor stub
}

public String getCount(){
	DecimalFormat formatter = new DecimalFormat("00");
	String formatted = formatter.format(++count);
	return formatted;
}
/*
 * overriding parent method to fetch name of event
 */
@Override
public char getEventName() {
	// TODO Auto-generated method stub
	return 'C';
}






}
