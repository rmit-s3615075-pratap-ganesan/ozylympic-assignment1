package game.event;



/**
 * 
 * @author PRATAP
 *
 */
public interface Event {
	
	public String getCount();         //counting number of games
	public char getEventName();       //fetching the name of Event
	public int getminTimer();         //fetching minimum time for event
	public int getmaxTimer();         //fetching maximum time for event

}
