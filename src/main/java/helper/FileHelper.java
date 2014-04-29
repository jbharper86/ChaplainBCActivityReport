package helper;

import data.ActivitySheet;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.IOException;

import static util.DateTimeFormats.YEAR_MONTH_DAY_FORMAT;

public class FileHelper {

	public static String getApplicationDirectory() {
		return System.getProperty("user.home") + File.separator + ".activitySheet" + File.separator;
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

	public static File getSummaryFile(LocalDate startDate, LocalDate endDate) {
		return getFile(getSummaryDirectory() + "Summary_" + YEAR_MONTH_DAY_FORMAT.print(startDate) + "_-_" + YEAR_MONTH_DAY_FORMAT.print(endDate) + ".xlsx");
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
}
