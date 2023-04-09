package helper;

import data.Activity;
import data.ActivitySheet;
import data.ServiceCode;
import data.Summary;
import org.joda.time.Duration;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class SummaryHelper {

	public static Map<ServiceCode, Summary> getSummaryMap(LocalDate start, LocalDate end) {
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
						Summary travelSummary = summaryMap.get(ServiceCode._BC901);
						if (travelSummary == null) {
							travelSummary = new Summary();
							travelSummary.setServiceCode(ServiceCode._BC901);
						}

						travelSummary.addTime(travelTime);
						travelSummary.addMiles(activity.getTotalMiles());
						summaryMap.put(travelSummary.getServiceCode(), travelSummary);
					} else if (activity.getType() == ServiceCode._BC901) {
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
