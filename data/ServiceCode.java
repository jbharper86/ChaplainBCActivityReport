package data

public enum ServiceCode {
	900CH("Chaplain Charting"),
	900BRV("Bereavement Charting"),
	901("Travel"),
	825IDT("IDT Meeting"),
	825SU("Standup Meeting"),
	825CN("Community Networking"),
	825IS("In-Service"),
	700CH("Chaplain Follow-up visit"),
	700CH1("Chaplain After-hours visit (<2 hours)"),
	700CH2("Chaplain After-hours visit (>2 hours)"),
	700ACH("Attempted Chaplain visit"),
	700A("Initial Spiritual Assessment"),
	700A1("After Hours - Initial Spiritual Assessment (<2 hours)"),
	700A2("After Hours - Initial Spiritual Assessment (>2 hours)"),
	700IBRV("Initial Bereavement Assessment"),
	700BRV("Bereavement Follow-up visit"),
	700BRV1("After Hours Bereavement Follow-up visit (<2 hours)"),
	700BRV2("After Hours Bereavement Follow-up visit (>2 hours)"),
	700BRPH("Bereavement Phone Call"),
	700ABRV("Attempted Bereavement Follow-up visit"),
	700REC("Chaplain Recert visit"),
	700PRN("Chaplain PRN visit"),
	700MS("Chaplain Funeral/Memorial Service");

	private String description;

	private ServiceCode(final String description) {
		this.description = description;
	}

	public String description() {
		return description;
	}
}