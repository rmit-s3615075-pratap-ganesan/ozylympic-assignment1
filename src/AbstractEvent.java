
public abstract class AbstractEvent {
protected int minTime;
protected int maxTime;
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
}
