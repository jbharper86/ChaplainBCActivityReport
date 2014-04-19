package data;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import java.io.Serializable;

public class Activity implements Serializable {

	public static final long serialVersionUID = 84579384573489L;

	private DateTime startTime;
	private DateTime stopTime;
	private String patientName;
	private String medicalRecordNumber;
	private ServiceCode type;

	private DateTime travelStart;
	private DateTime travelStop;
	private int startMileage;
	private int stopMileage;

	public DateTime getStartTime() {
		return startTime;
	}

	public DateTime getStopTime() {
		return stopTime;
	}

	public DateTime getTravelStart() {
		return travelStart;
	}

	public DateTime getTravelStop() {
		return travelStop;
	}

	public int getStartMileage() {
		return startMileage;
	}

	public int getStopMileage() {
		return stopMileage;
	}

	public ServiceCode getType() {
		return type;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getMedicalRecordNumber() {
		return medicalRecordNumber;
	}

	public int getTotalMiles() {
		return getStopMileage() - getStartMileage();
	}

	public Duration getTotalTime() {
		return new Duration(getStartTime(), getStopTime());
	}

	public Duration getTotalTravelTime() {
		return new Duration(getTravelStart(), getTravelStop());
	}

	public void setStartTime(final DateTime startTime) {
		this.startTime = startTime;
	}

	public void setFinishTime(final DateTime stopTime) {
		this.stopTime = stopTime;
	}

	public void setTravelStart(final DateTime travelStart) {
		this.travelStart = travelStart;
	}

	public void setTravelStop(final DateTime travelStop) {
		this.travelStop = travelStop;
	}

	public void setStartMileage(final int startMileage) {
		this.startMileage = startMileage;
	}

	public void setStopMileage(final int stopMileage) {
		this.stopMileage = stopMileage;
	}

	public void setType(final ServiceCode type) {
		this.type = type;
	}

	public void setPatientName(final String patientName) {
		this.patientName = patientName;
	}

	public void setMedicalRecordNumber(final String medicalRecordNumber) {
		this.medicalRecordNumber = medicalRecordNumber;
	}
}