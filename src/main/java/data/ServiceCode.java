package data;

import java.io.Serializable;
import java.util.*;

public enum ServiceCode implements Serializable {

	NONE("", false),
	_BC72H("Hospice Bereavement Visit", true),
	_BC72HA("Hospice Bereavement Assessment", true),
	_BC72HP("Hospice Bereavement Phone Visit", true),
	_BC72HR("Hospice Remote Bereavement Visit", true),
	_BC725("IDG Meeting", false),
	_BC800("Meetings/Conference Calls/Education/Etc.", false),
	_BC900("Office/Documentation", false),
	_BC901("Mileage", false);

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