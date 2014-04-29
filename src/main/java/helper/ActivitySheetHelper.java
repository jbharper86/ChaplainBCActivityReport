package helper;

import data.Activity;
import data.ActivitySheet;
import data.ServiceCode;
import data.Summary;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.Duration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import static util.DateTimeFormats.*;

public class ActivitySheetHelper {

	private static final int ACTIVITY_START = 6;

	public static void export(ActivitySheet activitySheet) {
		XSSFWorkbook workbook = getWorkbook(activitySheet);
		File excelFile = FileHelper.getActivitySheetReportFile(activitySheet);
		try {
			FileOutputStream out = new FileOutputStream(excelFile);
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static XSSFWorkbook getWorkbook(ActivitySheet activitySheet) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();

		// Set the default font to Arial size 10. The auto-size column method uses this font to resize the columns.
		Font defaultFont = workbook.getFontAt((short) 0);
		defaultFont.setFontHeightInPoints((short) 10);
		defaultFont.setFontName("Arial");
		CellStyle defaultStyle = workbook.createCellStyle();
		defaultStyle.setFont(defaultFont);

		Font boldFont = workbook.createFont();
		boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		boldFont.setFontHeightInPoints((short) 10);

		CellStyle borderStyle = workbook.createCellStyle();
		borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
		borderStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());

		CellStyle centerBold = workbook.createCellStyle();
		centerBold.setAlignment(CellStyle.ALIGN_CENTER);
		centerBold.setFont(boldFont);

		CellStyle right = workbook.createCellStyle();
		right.setAlignment(CellStyle.ALIGN_RIGHT);

		CellStyle center = workbook.createCellStyle();
		center.setAlignment(CellStyle.ALIGN_CENTER);

		CellStyle borderRightAlign = workbook.createCellStyle();
		borderRightAlign.setAlignment(CellStyle.ALIGN_RIGHT);
		borderRightAlign.setBorderBottom(CellStyle.BORDER_THIN);
		borderRightAlign.setBottomBorderColor(IndexedColors.BLACK.getIndex());

		sheet.createRow(0).createCell(0).setCellValue("Activity Sheet");
		sheet.createRow(1).createCell(0).setCellValue("Adventa Hospice - " +
				activitySheet.getOffice().getCity() + ", " + activitySheet.getOffice().getState() + " - Care Center #" + activitySheet.getOffice().getCareCenterNumber());
		Row row2 = sheet.createRow(3);
		Row row3 = sheet.createRow(4);

		row2.createCell(0).setCellValue("Date: " + MONTH_DAY_YEAR_FORMAT.print(activitySheet.getDate()));
		row3.createCell(0).setCellValue("Agent: " + activitySheet.getAgent().getNameAndId());

		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 6));
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 4));
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 4));

		sheet.getRow(0).getCell(0).setCellStyle(centerBold);
		sheet.getRow(1).getCell(0).setCellStyle(centerBold);

		Row activityStartRow = sheet.createRow(ACTIVITY_START - 1);
		activityStartRow.createCell(0).setCellStyle(borderStyle);
		activityStartRow.createCell(1).setCellStyle(borderStyle);
		activityStartRow.createCell(2).setCellStyle(borderStyle);
		activityStartRow.createCell(3).setCellStyle(borderStyle);
		activityStartRow.createCell(4).setCellStyle(borderStyle);
		activityStartRow.createCell(5).setCellStyle(borderStyle);
		activityStartRow.createCell(6).setCellStyle(borderStyle);

		Duration totalTime = new Duration(0L);
		int totalMiles = 0;

		int row = ACTIVITY_START;
		if (activitySheet != null) {
			for (Activity activity : activitySheet.getActivities()) {
				Row activityCodeRow = sheet.createRow(row++);
				activityCodeRow.createCell(0).setCellValue(activity.getType().labelForDropdown());
				sheet.addMergedRegion(new CellRangeAddress(row - 1, row - 1, 0, 6));

				if (activity.getType().showPatientInfo()) {
					Row patientRow = sheet.createRow(row++);
					patientRow.createCell(0).setCellValue("Patient Name: " + activity.getPatientName());
					patientRow.createCell(5).setCellValue("MR#:");
					patientRow.createCell(6).setCellValue(activity.getMedicalRecordNumber());
					sheet.addMergedRegion(new CellRangeAddress(row - 1, row - 1, 0, 4));
					patientRow.getCell(5).setCellStyle(right);
				}

				Row activityRow = sheet.createRow(row++);
				activityRow.createCell(0).setCellValue("Activity Time:");
				activityRow.createCell(1).setCellValue("Start:");
				activityRow.createCell(2).setCellValue(HOUR_MIN_TIME_FORMAT.print(activity.getActivityStartTime()));
				activityRow.createCell(3).setCellValue("Stop:");
				activityRow.createCell(4).setCellValue(HOUR_MIN_TIME_FORMAT.print(activity.getActivityStopTime()));
				activityRow.createCell(5).setCellValue("Total:");
				activityRow.createCell(6).setCellValue(HOUR_MIN_PERIOD_FORMAT.print(activity.getTotalTime().toPeriod()));
				activityRow.getCell(1).setCellStyle(right);
				activityRow.getCell(3).setCellStyle(right);
				activityRow.getCell(5).setCellStyle(right);

				if (activity.getTotalTravelTime().getMillis() > 0L) {
					Row travelRow = sheet.createRow(row++);
					travelRow.createCell(0).setCellValue("Travel Time:");
					travelRow.createCell(1).setCellValue("Start:");
					travelRow.createCell(2).setCellValue(HOUR_MIN_TIME_FORMAT.print(activity.getTravelStart()));
					travelRow.createCell(3).setCellValue("Stop:");
					travelRow.createCell(4).setCellValue(HOUR_MIN_TIME_FORMAT.print(activity.getTravelStop()));
					travelRow.createCell(5).setCellValue("Total:");
					travelRow.createCell(6).setCellValue(HOUR_MIN_PERIOD_FORMAT.print(activity.getTotalTravelTime().toPeriod()));
					travelRow.getCell(1).setCellStyle(right);
					travelRow.getCell(3).setCellStyle(right);
					travelRow.getCell(5).setCellStyle(right);
				}

				if (activity.getTotalMiles() > 0) {
					Row odometerRow = sheet.createRow(row++);
					odometerRow.createCell(0).setCellValue("Odometer: ");
					odometerRow.createCell(1).setCellValue("Start:");
					odometerRow.createCell(2).setCellValue(String.valueOf(activity.getStartMileage()));
					odometerRow.createCell(3).setCellValue("Stop:");
					odometerRow.createCell(4).setCellValue(String.valueOf(activity.getStopMileage()));
					odometerRow.createCell(5).setCellValue("Total:");
					odometerRow.createCell(6).setCellValue(String.valueOf(activity.getTotalMiles()));
					odometerRow.getCell(1).setCellStyle(right);
					odometerRow.getCell(3).setCellStyle(right);
					odometerRow.getCell(5).setCellStyle(right);
				}

				Row lastRow = sheet.getRow(row - 1);
				lastRow.getCell(0).setCellStyle(borderStyle);
				lastRow.getCell(1).setCellStyle(borderRightAlign);
				lastRow.getCell(2).setCellStyle(borderStyle);
				lastRow.getCell(3).setCellStyle(borderRightAlign);
				lastRow.getCell(4).setCellStyle(borderStyle);
				lastRow.getCell(5).setCellStyle(borderRightAlign);
				lastRow.getCell(6).setCellStyle(borderStyle);

				if (activity.getType() != ServiceCode._600PER) {
					totalTime = totalTime.plus(activity.getTotalTime());
					totalTime = totalTime.plus(activity.getTotalTravelTime());
					totalMiles += activity.getTotalMiles();
				}
			}

		}

		row2.createCell(5).setCellValue("Total Time:");
		row2.createCell(6).setCellValue(HOUR_MIN_PERIOD_FORMAT.print(totalTime.toPeriod()));
		row3.createCell(5).setCellValue("Total Mileage:");
		row3.createCell(6).setCellValue(String.valueOf(totalMiles));
		row2.getCell(5).setCellStyle(right);
		row2.getCell(6).setCellStyle(right);
		row3.getCell(5).setCellStyle(right);
		row3.getCell(6).setCellStyle(right);

		Map<ServiceCode, Summary> summaryMap = SummaryHelper.getSummaryMap(activitySheet.getDate(), activitySheet.getDate());
		int column = 0;
		Row summaryRow = null;
		for (ServiceCode serviceCode : ServiceCode.getSortedCodeList()) {
			Summary summary = summaryMap.get(serviceCode);
			if (summary != null) {
				if (column % 7 == 0) {
					column = 0;
					summaryRow = sheet.createRow(row++);
					summaryRow.createCell(column++);
				}
				summaryRow.createCell(column++).setCellValue(serviceCode.code() + " - ");
				summaryRow.createCell(column++).setCellValue(HOUR_MIN_PERIOD_FORMAT.print(summary.getTime().toPeriod()));
				summaryRow.getCell(column - 2).setCellStyle(right);
			}
		}
		while (column % 7 != 0) {
			summaryRow.createCell(column++);
		}

		Row lastRow = sheet.getRow(row - 1);
		lastRow.getCell(0).setCellStyle(borderStyle);
		lastRow.getCell(1).setCellStyle(borderRightAlign);
		lastRow.getCell(2).setCellStyle(borderStyle);
		lastRow.getCell(3).setCellStyle(borderRightAlign);
		lastRow.getCell(4).setCellStyle(borderStyle);
		lastRow.getCell(5).setCellStyle(borderRightAlign);
		lastRow.getCell(6).setCellStyle(borderStyle);

		row += 2;
		Row agentSignatureRow = sheet.createRow(row);
		agentSignatureRow.createCell(0).setCellValue(
				"Agent Signature: _____________________________________________________________");
		sheet.addMergedRegion(new CellRangeAddress(row, row, 0, 6));
		agentSignatureRow.getCell(0).setCellStyle(center);

		sheet.autoSizeColumn(0, true);
		sheet.autoSizeColumn(1, true);
		sheet.autoSizeColumn(2, true);
		sheet.autoSizeColumn(3, true);
		sheet.autoSizeColumn(4, true);
		sheet.autoSizeColumn(5, true);
		sheet.autoSizeColumn(6, true);

		return workbook;
	}
}
