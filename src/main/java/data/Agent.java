package data;

import java.io.Serializable;

public class Agent implements Serializable {

	public static final long serialVersionUID = 4587957209348879384L;

	private String firstName;
	private String middleName;
	private String lastName;
	private String agentId;
	private String jobTitle;

	public String getNameAndId() {
		return lastName + ", " + firstName + " " + middleName + " (" + agentId + ")";
	}

	public String getAgentId() {
		return agentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setAgentId(final String agentId) {
		this.agentId = agentId;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}