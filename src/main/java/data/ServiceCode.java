package data;

import java.io.Serializable;

public enum ServiceCode implements Serializable {

	_900CH("Chaplain Charting", false),
	_900BRV("Bereavement Charting", false),
	_901("Travel", false),
	_825IDT("IDT Meeting", false),
	_825SU("Standup Meeting", false),
	_825CN("Community Networking", false),
	_825IS("In-Service", false),
	_700CH("Chaplain Follow-up visit", true),
	_700CH1("Chaplain After-hours visit (<2 hours)", true),
	_700CH2("Chaplain After-hours visit (>2 hours)", true),
	_700ACH("Attempted Chaplain visit", true),
	_700A("Initial Spiritual Assessment", true),
	_700A1("After Hours - Initial Spiritual Assessment (<2 hours)", true),
	_700A2("After Hours - Initial Spiritual Assessment (>2 hours)", true),
	_700IBRV("Initial Bereavement Assessment", true),
	_700BRV("Bereavement Follow-up visit", true),
	_700BRV1("After Hours Bereavement Follow-up visit (<2 hours)", true),
	_700BRV2("After Hours Bereavement Follow-up visit (>2 hours)", true),
	_700BRPH("Bereavement Phone Call", false),
	_700ABRV("Attempted Bereavement Follow-up visit", true),
	_700REC("Chaplain Recert visit", true),
	_700PRN("Chaplain PRN visit", true),
	_700MS("Chaplain Funeral/Memorial Service", true);

	public static final long serialVersionUID = 3294873857389593L;

	private final String description;
	private final boolean showPatientInfo;

	private ServiceCode(final String description, final boolean showPatientInfo) {
		this.description = description;
		this.showPatientInfo = showPatientInfo;
	}

	public String code() {
		return name().replaceAll("_", "");
	}

	public String description() {
		return description;
	}

	public boolean showPatientInfo() {
		return showPatientInfo;
	}
}