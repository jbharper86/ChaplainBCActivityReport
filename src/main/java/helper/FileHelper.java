package helper;

import data.ActivitySheet;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;

public class FileHelper {

	private static final DateTimeFormatter FILENAME_FORMAT = DateTimeFormat.forPattern("yyyy_MM_dd");

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
		return getFile(getDataDirectory() + FILENAME_FORMAT.print(date) + ".dat");
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
		return getFile(getSummaryDirectory() + FILENAME_FORMAT.print(startDate) + "_-_" + FILENAME_FORMAT.print(endDate) + ".xlsx");
	}
}
