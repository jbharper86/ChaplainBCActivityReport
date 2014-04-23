package bad;

import data.Activity;
import data.ActivitySheet;
import helper.ExcelHelper;
import helper.SerializationHelper;
import ui.ActivityForm;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {

	private static JFrame frame;
	private static List<ActivityForm> activityForms;

	public static void loadFromActivitySheet(ActivitySheet activitySheet) {
		if (activitySheet != null && activitySheet.getActivities() != null) {
			for (Activity activity : activitySheet.getActivities()) {
				addActivity(activity);
			}
		}
	}

	public static void addActivity() {
		addActivity(new Activity());
	}

	public static void addActivity(Activity activity) {
		if (!activityForms.isEmpty()) {
			frame.getContentPane().add(Box.createRigidArea(new Dimension(0, 5)));
		}
		ActivityForm form = new ActivityForm();
		form.setActivity(activity);
		activityForms.add(form);
		frame.getContentPane().add(form.$$$getRootComponent$$$());
		frame.pack();
	}

	private static List<Activity> getActivities() {
		List<Activity> activities = new ArrayList<Activity>();
		for (ActivityForm form : activityForms) {
			activities.add(form.getActivity());
		}
		return activities;
	}

	public static void save() {
		ActivitySheet activitySheet = new ActivitySheet();
		activitySheet.setActivities(getActivities());
		SerializationHelper.serializeActivitySheet(activitySheet);
	}

	public static void excelExport() {
		save();
		ExcelHelper.export();
	}

	public static void init(JFrame frame) {
		EventHandler.frame = frame;
		EventHandler.activityForms = new ArrayList<ActivityForm>();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setMinimumSize(new Dimension(400, 200));
	}
}
