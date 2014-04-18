package data

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class Activity {

	private DateTime startTime;
	private DateTime finishTime;
	private int arriveMileage;
	private int leaveMileage;
	private ServiceCode type;

	public DateTime getStartTime() {
		return startTime;
	}

	public DateTime getFinishTime() {
		return finishTime;
	}

	public int getArriveMileage() {
		return arriveMileage;
	}

	public int getLeaveMileage() {
		return leaveMileage;
	}

	public ServiceCode getType() {
		return type;
	}

	public int getTotalMiles() {
		return getArriveMileage() - getLeaveMileage();
	}

	public Duration getTotalTime() {
		return new Duration(getStartTime(), getFinishTime());
	}
}