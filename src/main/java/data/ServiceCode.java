package data;

import java.io.Serializable;

public enum ServiceCode implements Serializable {

	_900CH("Chaplain Charting"),
	_900BRV("Bereavement Charting"),
	_901("Travel"),
	_825IDT("IDT Meeting"),
	_825SU("Standup Meeting"),
	_825CN("Community Networking"),
	_825IS("In-Service"),
	_700CH("Chaplain Follow-up visit"),
	_700CH1("Chaplain After-hours visit (<2 hours)"),
	_700CH2("Chaplain After-hours visit (>2 hours)"),
	_700ACH("Attempted Chaplain visit"),
	_700A("Initial Spiritual Assessment"),
	_700A1("After Hours - Initial Spiritual Assessment (<2 hours)"),
	_700A2("After Hours - Initial Spiritual Assessment (>2 hours)"),
	_700IBRV("Initial Bereavement Assessment"),
	_700BRV("Bereavement Follow-up visit"),
	_700BRV1("After Hours Bereavement Follow-up visit (<2 hours)"),
	_700BRV2("After Hours Bereavement Follow-up visit (>2 hours)"),
	_700BRPH("Bereavement Phone Call"),
	_700ABRV("Attempted Bereavement Follow-up visit"),
	_700REC("Chaplain Recert visit"),
	_700PRN("Chaplain PRN visit"),
	_700MS("Chaplain Funeral/Memorial Service");

	public static final long serialVersionUID = 3294873857389593L;

	private final String description;

	private ServiceCode(final String description) {
		this.description = description;
	}

	public String code() {
		return name().replaceAll("_", "");
	}

	public String description() {
		return description;
	}
}