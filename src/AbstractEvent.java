
public abstract class AbstractEvent implements Event {
protected int minTime;         //minimum time of event
protected int maxTime;         //maximum time of event

/*
 * constructor
 */
public AbstractEvent(int minTime, int maxTime) {
	
	this.minTime = minTime;
	this.maxTime = maxTime;
}
public int getMinTime(){
	 return minTime;
}
public int getMaxTime(){
	 return maxTime;
}
/*
 * overridden method to get minimum time
 */
@Override
public int getminTimer() {
	// TODO Auto-generated method stub
	return minTime;
}
/*
 * overridden method to get maximum time
 */
@Override
public int getmaxTimer() {
	// TODO Auto-generated method stub
	return maxTime;
}



}
