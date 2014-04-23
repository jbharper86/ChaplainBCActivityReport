package data;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;

import java.io.Serializable;

public class Activity implements Serializable {

	public static final long serialVersionUID = 84579384573489L;

	private DateTime activityStartTime;
	private DateTime activityStopTime;
	private String patientName;
	private String medicalRecordNumber;
	private ServiceCode type;

	private DateTime travelStart;
	private DateTime travelStop;
	private int startMileage;
	private int stopMileage;

	public DateTime getActivityStartTime() {
		return activityStartTime;
	}

	public DateTime getActivityStopTime() {
		return activityStopTime;
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
		return new Duration(getActivityStartTime(), getActivityStopTime());
	}

	public Duration getTotalTravelTime() {
		return new Duration(getTravelStart(), getTravelStop());
	}

	public void setActivityStartTime(final DateTime activityStartTime) {
		this.activityStartTime = activityStartTime;
	}

	public void setActivityStopTime(final DateTime activityStopTime) {
		this.activityStopTime = activityStopTime;
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