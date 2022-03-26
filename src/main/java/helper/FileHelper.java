package helper;

import data.ActivitySheet;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.IOException;

import static util.DateTimeFormats.YEAR_MONTH_DAY_FORMAT;

public class FileHelper {

	private static String profilePath;

	public static String getDefaultDirectory() {
		return System.getProperty("user.home") + File.seaparator + "Documents" + File.separator + "activitySheet" + File.separator;
	}

	public static String getApplicationDirectory() {
		if (profilePath != null) {
			return profilePath;
		}
		return getDefaultDirectory();
	}

	public static String getDataDirectory() {
		String dir = getApplicationDirectory() + "data" + File.separator;
		new File(dir).mkdirs();
		return dir;
	}

	public static String getSummaryDirectory() {
		String dir = getApplicationDirectory() + "summary" + File.separator;
		new File(dir).mkdirs();
		return dir;
	}

	public static File getActivityFile(ActivitySheet activitySheet) {
		if (activitySheet == null) {
			return null;
		}

		if (activitySheet.getDate() == null) {
			activitySheet.setDate(new DateTime().toLocalDate());
		}
		return getActivityFile(activitySheet.getDate());
	}

	public static File getActivityFile(LocalDate date) {
		return getFile(getDataDirectory() + YEAR_MONTH_DAY_FORMAT.print(date) + ".dat");
	}

	private static File getFile(String filename) {
		File file = new File(filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static File getProductivityReportFile(LocalDate startDate, LocalDate endDate) {
		return getFile(getSummaryDirectory() + "ProductivityReport_" + YEAR_MONTH_DAY_FORMAT.print(startDate) + "_-_" + YEAR_MONTH_DAY_FORMAT.print(endDate) + ".xlsx");
	}

	public static File getAgentFile() {
		return getFile(getDataDirectory() + "agent.dat");
	}

	public static File getOfficeFile() {
		return getFile(getDataDirectory() + "office.dat");
	}

	public static File getActivitySheetReportFile(ActivitySheet activitySheet) {
		return getFile(getSummaryDirectory() + "ActivitySheet_" + YEAR_MONTH_DAY_FORMAT.print(activitySheet.getDate()) + ".xlsx");
	}

	public static void setProfilePath(String profilePath) {
		if (profilePath != null && !profilePath.endsWith(File.separator)) {
			profilePath += File.separator;
		}
		FileHelper.profilePath = profilePath;
	}
}
