package bad;

import data.Activity;
import data.ActivitySheet;
import data.Agent;
import data.Office;
import helper.ActivitySheetHelper;
import helper.ProductivityReportHelper;
import helper.SerializationHelper;
import org.joda.time.LocalDate;
import ui.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {

	private static JFrame frame;
	private static List<ActivityForm> activityForms;
	private static LocalDate loadedDate;

	public static void loadFromActivitySheetDate(LocalDate activitySheetDate) {
		loadFromActivitySheet(SerializationHelper.deserializeActivitySheet(activitySheetDate));
	}

	public static void loadFromActivitySheet(ActivitySheet activitySheet) {
		frame.getContentPane().removeAll();
		ActivitySheetHeader header = new ActivitySheetHeader();
		header.setData(activitySheet);
		frame.getContentPane().add(header.$$$getRootComponent$$$());
		frame.getContentPane().add(new JSeparator());
		if (activitySheet != null && activitySheet.getActivities() != null) {
			for (Activity activity : activitySheet.getActivities()) {
				addActivity(activity);
			}
		}
		SwingUtilities.updateComponentTreeUI(frame);
		EventHandler.loadedDate = activitySheet.getDate();
	}

	public static void addActivity() {
		addActivity(new Activity());
	}

	public static void addActivity(Activity activity) {
		if (!activityForms.isEmpty()) {
			frame.getContentPane().add(new JSeparator());
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
		activitySheet.setDate(EventHandler.loadedDate);
		activitySheet.setActivities(getActivities());
		SerializationHelper.serializeActivitySheet(activitySheet);
	}

	public static void activitySheetExport() {
		save();
		ActivitySheetHelper.export(SerializationHelper.deserializeActivitySheet(EventHandler.loadedDate));
	}

	public static void productivityReportExport(LocalDate start, LocalDate end) {
		save();
		Agent agent = SerializationHelper.deserializeAgent();
		Office office = SerializationHelper.deserializeOffice();
		ProductivityReportHelper.export(agent, office, start, end);
	}

	public static void init(JFrame frame) {
		EventHandler.frame = frame;
		EventHandler.activityForms = new ArrayList<ActivityForm>();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setMinimumSize(new Dimension(400, 200));
	}

	public static void checkAgentAndOfficeInfo() {
		Agent agent = SerializationHelper.deserializeAgent();
		Office office = SerializationHelper.deserializeOffice();

		if (agent == null || office == null) {
			displayAgentOfficeDialog(agent, office);
		}
	}

	public static void displayAgentOfficeDialog() {
		Agent agent = SerializationHelper.deserializeAgent();
		Office office = SerializationHelper.deserializeOffice();
		displayAgentOfficeDialog(agent, office);
	}

	private static void displayAgentOfficeDialog(Agent agent, Office office) {
		AgentDialog dialog = new AgentDialog(EventHandler.frame);
		dialog.setData(agent, office);
		dialog.pack();
		dialog.setVisible(true);
	}

	public static void displayProductivityReportDialog() {
		GenerateProductivityReportDialog dialog = new GenerateProductivityReportDialog(EventHandler.frame);
		dialog.pack();
		dialog.setVisible(true);
	}

	public static void displayOpenActivitySheetDialog() {
		OpenActivitySheetDialog dialog = new OpenActivitySheetDialog(EventHandler.frame);
		dialog.pack();
		dialog.setVisible(true);
	}

	public static void saveAgent(Agent agent) {
		SerializationHelper.serializeAgent(agent);
	}

	public static void saveOffice(Office office) {
		SerializationHelper.serializeOffice(office);
	}
}
