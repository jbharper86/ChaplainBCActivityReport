package data;

import java.io.Serializable;
import java.util.*;

public enum ServiceCode implements Serializable {

	NONE("", false),
	_900CH("Chaplain Charting", false),
	_900BRV("Bereavement Charting", false),
	_901("Travel", false),
	_825IDT("IDT Meeting", false),
	_825SU("Standup Meeting", false),
	_825CN("Community Networking", false),
	_825IS("In-Service", false),
	_700PER("Personal Time", false),
	_700A("Initial Spiritual Assessment", true),
	_700A1("After Hours - Initial Spiritual Assessment (<2 hours)", true),
	_700A2("After Hours - Initial Spiritual Assessment (>2 hours)", true),
	_700ACH("Attempted Chaplain visit", true),
	_700CH("Chaplain Follow-up visit", true),
	_700CH1("Chaplain After-hours visit (<2 hours)", true),
	_700CH2("Chaplain After-hours visit (>2 hours)", true),
	_700REC("Chaplain Recert visit", true),
	_700PRN("Chaplain PRN visit", true),
	_700MS("Chaplain Funeral/Memorial Service", true),
	_700IBRV("Initial Bereavement Assessment", true),
	_700BRV("Bereavement Follow-up visit", true),
	_700BRV1("After Hours Bereavement Follow-up visit (<2 hours)", true),
	_700BRV2("After Hours Bereavement Follow-up visit (>2 hours)", true),
	_700ABRV("Attempted Bereavement Follow-up visit/Phone Call", true),
	_700BRPH("Bereavement Phone Call", false),
	_700BRVL("Bereavement Letters and Cards to Families", false),
	_700BRVSG("Bereavement Support Group", false);

	public static final long serialVersionUID = 3294873857389593L;

	private final String description;
	private final boolean showPatientInfo;

	private static Map<String, ServiceCode> codes;
	static {
		codes = new HashMap<String, ServiceCode>();
		for (ServiceCode sc : values()) {
			codes.put(sc.labelForDropdown(), sc);
		}
	}

	public static List<ServiceCode> getSortedCodeList() {
		List<ServiceCode> serviceCodes = Arrays.asList(values());
		Collections.sort(serviceCodes);
		return serviceCodes;
	}

	public static String[] getSortedLabelArray() {
		List<ServiceCode> serviceCodes = getSortedCodeList();
		String[] serviceCodeArray = new String[serviceCodes.size()];
		int i=0;
		for (ServiceCode sc : serviceCodes) {
			serviceCodeArray[i] = sc.labelForDropdown();
			i++;
		}
		return serviceCodeArray;
	}

	public static ServiceCode getCodeForLabel(String label) {
		ServiceCode sc = codes.get(label);
		return (sc == null) ? NONE : sc;
	}

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

	public String labelForDropdown() {
		if (this == NONE) {
			return "";
		}
		return code() + " - " + description();
	}

	public boolean showPatientInfo() {
		return showPatientInfo;
	}
}