package helper;

import data.Activity;
import data.ActivitySheet;
import data.ServiceCode;
import data.Summary;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelHelper {

	public static final int SUMMARY_START = 5;
	public static final PeriodFormatter HOUR_MIN_FORMAT = new PeriodFormatterBuilder().printZeroAlways().appendHours().appendLiteral(
			" HR ").appendMinutes().appendLiteral(" MIN").toFormatter();

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

	private static Duration getTotalTime(Map<ServiceCode, Summary> summaryMap) {
		Duration totalTime = new Duration(0L);
		for (ServiceCode serviceCode : summaryMap.keySet()) {
			if (serviceCode != ServiceCode._700PER) {
				Summary summary = summaryMap.get(serviceCode);
				totalTime = totalTime.plus(summary.getTime());
			}
		}
		return totalTime;
	}

	private static XSSFWorkbook getWorkbook(Map<ServiceCode, Summary> summaryMap) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();

		DataFormat format = workbook.createDataFormat();
		CellStyle number2D = workbook.createCellStyle();
		number2D.setDataFormat(format.getFormat("##0.00"));

		// Set the default font to Arial size 10. The auto-size column method uses this font to resize the columns.
		Font defaultFont = workbook.getFontAt((short) 0);
		defaultFont.setFontHeightInPoints((short) 10);
		defaultFont.setFontName("Arial");
		CellStyle defaultStyle = workbook.createCellStyle();
		defaultStyle.setFont(defaultFont);

		CellStyle bold = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		boldFont.setFontHeightInPoints((short) 10);
		bold.setFont(boldFont);

		CellStyle centerBold = workbook.createCellStyle();
		centerBold.setAlignment(CellStyle.ALIGN_CENTER);
		centerBold.setFont(boldFont);

		CellStyle rightBold = workbook.createCellStyle();
		rightBold.setAlignment(CellStyle.ALIGN_RIGHT);
		rightBold.setFont(boldFont);

		Row titleRow = sheet.createRow(0);
		titleRow.createCell(0).setCellValue("MONTHLY PRODUCTIVITY REPORT");
		titleRow.setRowStyle(centerBold);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

		Row locationRow = sheet.createRow(1);
		locationRow.createCell(0).setCellValue("Location: Loudon, TN");
		locationRow.createCell(2).setCellValue("Month: April 2014");
		locationRow.getCell(0).setCellStyle(bold);
		locationRow.getCell(2).setCellStyle(rightBold);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 2, 4));

		Row agentRow = sheet.createRow(2);
		agentRow.createCell(0).setCellValue("Agent Name: Greg Harper");
		agentRow.createCell(2).setCellValue("Job Title: Chaplain");
		agentRow.getCell(0).setCellStyle(bold);
		agentRow.getCell(2).setCellStyle(rightBold);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 1));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 2, 4));

		Row keyRow = sheet.createRow(SUMMARY_START - 1);
		keyRow.createCell(0).setCellValue("Activity Code");
		keyRow.createCell(1).setCellValue("Description");
		keyRow.createCell(2).setCellValue("Visits/Activities");
		keyRow.createCell(3).setCellValue("Time");
		keyRow.createCell(4).setCellValue("Percentage");
		keyRow.setRowStyle(bold);

		sheet.setDefaultColumnStyle(0, defaultStyle);
		sheet.setDefaultColumnStyle(1, defaultStyle);
		sheet.setDefaultColumnStyle(2, defaultStyle);
		sheet.setDefaultColumnStyle(3, defaultStyle);
		sheet.setDefaultColumnStyle(4, defaultStyle);

		int rowNum = SUMMARY_START;
		Duration totalTime = getTotalTime(summaryMap);
		for (ServiceCode serviceCode : ServiceCode.getSortedCodeList()) {
			Summary summary = summaryMap.get(serviceCode);
			if (summary != null) {
				Row row = sheet.createRow(rowNum);
				row.createCell(0).setCellValue(serviceCode.code());
				row.createCell(1).setCellValue(serviceCode.description());
				if (serviceCode == ServiceCode._901) {
					row.createCell(2).setCellValue(summary.getMiles() + " miles");
				} else {
					row.createCell(2).setCellValue(summary.getOccurrences() + " occurrences");
				}
				row.createCell(3).setCellValue(HOUR_MIN_FORMAT.print(summary.getTime().toPeriod()));

				if (serviceCode == ServiceCode._700PER) {
					row.createCell(4).setCellValue(0d);
					row.getCell(4).setCellStyle(number2D);
				} else {
					Double percentTime = (Long.valueOf(summary.getTime().getMillis()).doubleValue() / Long.valueOf(
							totalTime.getMillis()).doubleValue()) * 100d;
					row.createCell(4).setCellValue(percentTime);
					row.getCell(4).setCellStyle(number2D);
				}
				rowNum++;
			}
		}

		Row summaryRow = sheet.createRow(rowNum);
		summaryRow.createCell(2).setCellValue("TOTALS:");
		summaryRow.createCell(3).setCellValue(HOUR_MIN_FORMAT.print(totalTime.toPeriod()));
		summaryRow.createCell(4).setCellFormula("SUM(E" + (SUMMARY_START + 1) + ":E" + rowNum + ")");
		summaryRow.getCell(4).setCellStyle(number2D);
		summaryRow.setRowStyle(bold);

		sheet.autoSizeColumn(0, true);
		sheet.autoSizeColumn(1, true);
		sheet.autoSizeColumn(2, true);
		sheet.autoSizeColumn(3, true);
		sheet.autoSizeColumn(4, true);

		//		workbook.setPrintArea(0,0,4,0,rowNum);
		//		PrintSetup ps = sheet.getPrintSetup();
		//		sheet.setAutobreaks(true);
		//		ps.setFitHeight((short) 1);
		//		ps.setFitWidth((short) 1);

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
					} else if (activity.getType() == ServiceCode._901) {
						summary.addMiles(activity.getTotalMiles());
					}
					summaryMap.put(summary.getServiceCode(), summary);
				}
			}
			curr = curr.plusDays(1);
		}
		return summaryMap;
	}

}
