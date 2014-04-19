package data;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import java.io.Serializable;

public class Activity implements Serializable {

	public static final long serialVersionUID = 84579384573489L;

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

	public void setStartTime(final DateTime startTime) {
		this.startTime = startTime;
	}

	public void setFinishTime(final DateTime finishTime) {
		this.finishTime = finishTime;
	}

	public void setArriveMileage(final int arriveMileage) {
		this.arriveMileage = arriveMileage;
	}

	public void setLeaveMileage(final int leaveMileage) {
		this.leaveMileage = leaveMileage;
	}

	public void setType(final ServiceCode type) {
		this.type = type;
	}
}