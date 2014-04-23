package data;

import org.joda.time.LocalDate;

import java.io.Serializable;
import java.util.List;

public class ActivitySheet implements Serializable {

	public static final long serialVersionUID = 3478957834598374L;

	private Agent agent;
	private Office office;
	private LocalDate date;
	private List<Activity> activities;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public Agent getAgent() {

		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
