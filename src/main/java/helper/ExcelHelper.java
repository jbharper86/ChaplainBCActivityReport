package helper;

import data.Activity;
import data.ActivitySheet;
import data.ServiceCode;
import data.Summary;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.Duration;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelHelper {

	public static void export() {
		export(new LocalDate(), new LocalDate());
	}

	public static void export(LocalDate start, LocalDate end) {
		Map<ServiceCode, Summary> summaryMap = getSummaryMap(start, end);
		XSSFWorkbook workbook = getWorkbook(summaryMap);
		File excelFile = FileHelper.getSummaryFile(start, end);
		try {
			FileOutputStream out = new FileOutputStream(excelFile);
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static XSSFWorkbook getWorkbook(Map<ServiceCode, Summary> summaryMap) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();

		int rowNum = 0;
		for (ServiceCode serviceCode : summaryMap.keySet()) {
			Summary summary = summaryMap.get(serviceCode);
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(serviceCode.code());
			row.createCell(1).setCellValue(serviceCode.description());
			if (serviceCode == ServiceCode._901) {
				row.createCell(2).setCellValue(summary.getMiles() + " miles");
			} else {
				row.createCell(2).setCellValue(summary.getOccurrences() + " occurrences");
			}

			row.createCell(3).setCellValue(
					summary.getTime().toStandardHours().getHours() + " HRS " + summary.getTime().toStandardMinutes().getMinutes() % 60 + " MIN");
			rowNum++;
		}
		return workbook;
	}

	private static Map<ServiceCode, Summary> getSummaryMap(LocalDate start, LocalDate end) {
		Map<ServiceCode, Summary> summaryMap = new HashMap<ServiceCode, Summary>();
		LocalDate curr = start;
		while (curr.isEqual(end) || curr.isBefore(end)) {
			ActivitySheet activitySheet = SerializationHelper.deserializeActivitySheet(curr);
			if (activitySheet != null && activitySheet.getActivities() != null) {
				for (Activity activity : activitySheet.getActivities()) {
					Summary summary = summaryMap.get(activity.getType());
					if (summary == null) {
						summary = new Summary();
						summary.setServiceCode(activity.getType());
					}

					Duration activityTime = activity.getTotalTime();
					summary.addTime(activityTime);
					summary.incrementOccurrences();
					summaryMap.put(summary.getServiceCode(), summary);

					Duration travelTime = activity.getTotalTravelTime();
					if (travelTime.toStandardSeconds().getSeconds() > 0) {
						Summary travelSummary = summaryMap.get(ServiceCode._901);
						if (travelSummary == null) {
							travelSummary = new Summary();
							travelSummary.setServiceCode(ServiceCode._901);
						}

						travelSummary.addTime(travelTime);
						travelSummary.addMiles(activity.getTotalMiles());
						summaryMap.put(travelSummary.getServiceCode(), travelSummary);
					}
				}
			}
			curr = curr.plusDays(1);
		}
		return summaryMap;
	}

}
