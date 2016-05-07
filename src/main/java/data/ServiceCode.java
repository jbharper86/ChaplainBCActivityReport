package data;

import java.io.Serializable;
import java.util.*;

public enum ServiceCode implements Serializable {

	NONE("", false),
	_900("Charting/Documentation/IDT Forms", false),
	_901("Travel", false),
	_825("IDT Meeting/Standup Meeting/Care Plan Meeting/In-Service/Community Networking", false),
	_825IDT("Interdisciplinary Team Meeting", false),
	_825SU("Stand-Up Meeting", false),
	_825FM("Family Meeting", false),
	_825CN("Community Networking", false),
	_825CPM("Care Plan Meeting/Facility", false),
	_825IS("In-Service/Continuing Education", false),
	_600PER("Personal Time (Break for Lunch)", false),
	_800LIA("Chaplain/Bereavement/Social Work/Volunteer Liaison Program", false),
	_700A("Initial Spiritual Assessment", true),
	_700A1("After Hours Initial Spiritual Assessment (<2 hours)", true),
	_700A2("After Hours Initial Spiritual Assessment (>2 hours)", true),
	_700ACH("Attempted Chaplain visit", true),
	_700CH("Chaplain Follow-up visit", true),
	_700CH1("After Hours Chaplain Follow-up visit (<2 hours)", true),
	_700CH2("After Hours Chaplain Follow-up visit (>2 hours)", true),
	_700PRN("Chaplain PRN visit", true),
	_700REC("Chaplain Recert visit", true),
	_700IBA("Initial Bereavement Assessment", true),
	_700ABRV("Attempted Bereavement Visit", true),
	_700MS("Funeral/Memorial Service", true),
	_700BRV("Bereavement Visit", true),
	_700BRV1("After Hours Bereavement Visit (<2 hours)", true),
	_700BRV2("After Hours Bereavement Visit (>2 hours)", true),
	_700CAL("Bereavement Phone Call", false),
	_700ACAL("Attempted Bereavement Phone Call", false),
	_700BRVL("Bereavement Letters", false),
	_700SG("Bereavement Support Group", false),
	_CH11H("Chaplain Visit", true),
	_CH01H("Chaplain Assessment/Evaluation", true),
	_CH72H("Chaplain Bereavement Visit", true),
	_CHPRNH("Chaplain PRN Visit", true),
	_CHPRNH1("Chaplain PRN Visit (<2 hours)", true),
	_CHPRNH2("Chaplain PRN Visit (>2 hours)", true),
	_CH40H("Chaplain HCHB Transition Visit", true),
	_CH11H1("Chaplain Visit (<2 hours)", true),
	_CH11H2("Chaplain Visit (>2 hours)", true),
	_CH01H1("Chaplain Assessment (<2 hours)", true),
	_CH01H2("Chaplain Assessment (>2 hours)", true),
	_CH72H1("Chaplain Bereavement Visit (<2 hours)", true),
	_CH72H2("Chaplain Bereavement Visit (>2 hours)", true),
	_CH11HP("Chaplain Phone Call", true),
	_CH72HP("Chaplain Bereavement Phone Call", true),
	_BC72H("Bereavement Coordinator Visit", true),
	_BC72HP("Bereavement Coordinator Phone Call", true);

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