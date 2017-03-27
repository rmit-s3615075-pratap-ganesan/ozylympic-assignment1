
public abstract class AbstractEvent implements Event {
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

@Override
public int getminTimer() {
	// TODO Auto-generated method stub
	return minTime;
}

@Override
public int getmaxTimer() {
	// TODO Auto-generated method stub
	return maxTime;
}



}
