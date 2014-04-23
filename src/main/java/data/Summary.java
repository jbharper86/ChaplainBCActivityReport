package data;

import org.joda.time.Duration;

import java.io.Serializable;

public class Summary implements Serializable {

	public static final long serialVersionUID = 3290478329874284L;

	private ServiceCode serviceCode;
	private int miles;
	private int occurrences;
	private Duration time;

	public ServiceCode getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(ServiceCode serviceCode) {
		this.serviceCode = serviceCode;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	public void addMiles(int miles) {
		this.miles += miles;
	}

	public int getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(int occurrences) {
		this.occurrences = occurrences;
	}

	public void incrementOccurrences() {
		occurrences++;
	}

	public Duration getTime() {
		return time;
	}

	public void setTime(Duration time) {
		this.time = time;
	}

	public void addTime(Duration time) {
		if (this.time == null) {
			this.time = new Duration(0L);
		}
		this.time = this.time.plus(time);
	}
}
