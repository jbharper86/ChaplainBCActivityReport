package bad;

import data.Activity;
import data.ActivitySheet;
import data.Agent;
import data.Office;
import helper.ActivitySheetHelper;
import helper.FileHelper;
import helper.ProductivityReportHelper;
import helper.SerializationHelper;
import org.joda.time.LocalDate;
import ui.*;
import util.DimensionUtil;

import javax.swing.*;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {

	private static JFrame frame;
	private static JPanel contentPanel;
	private static JPanel headerPanel;
	private static List<ActivityForm> activityForms;
	private static LocalDate loadedDate;

	public static boolean isFrameVisible() {
		return frame.isVisible();
	}

	public static void reloadActivitySheet() {
		save();
		loadFromActivitySheetDate(loadedDate);
	}

	public static void loadFromActivitySheetDate(LocalDate activitySheetDate) {
		loadFromActivitySheet(SerializationHelper.deserializeActivitySheet(activitySheetDate));
	}

	public static void loadFromActivitySheet(ActivitySheet activitySheet) {
		headerPanel.removeAll();
		ActivitySheetHeader header = new ActivitySheetHeader();
		header.setData(activitySheet);
		headerPanel.add(header.$$$getRootComponent$$$());
		if (activitySheet != null) {
			reloadActivities(activitySheet.getActivities());
		}
		SwingUtilities.updateComponentTreeUI(frame);
		EventHandler.loadedDate = activitySheet.getDate();
	}

	private static void setButtonsEnabled() {
		for (ActivityForm form : activityForms) {
			form.enableUp();
			form.enableDown();
		}
		if (!activityForms.isEmpty()) {
			activityForms.get(0).disableUp();
			activityForms.get(activityForms.size() - 1).disableDown();
		}
	}

	public static void reloadActivities(List<Activity> activities) {
		contentPanel.removeAll();
		activityForms.clear();
		if (activities != null) {
			for (Activity activity : activities) {
				addActivity(activity);
			}
		}
		setButtonsEnabled();
		SwingUtilities.updateComponentTreeUI(frame);
	}

	public static void addActivity() {
		addActivity(new Activity());
		setButtonsEnabled();
	}

	public static void addActivity(Activity activity) {
		if (!activityForms.isEmpty()) {
			JSeparator separator = new JSeparator();
			separator.setMaximumSize(new Dimension(40000, 2));
			contentPanel.add(separator);
		}
		ActivityForm form = new ActivityForm();
		form.setActivity(activity);
		form.addChangeListeners();
		form.setPosition(activityForms.size());
		activityForms.add(form);
		contentPanel.add(form.$$$getRootComponent$$$());
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
		String file = ActivitySheetHelper.export(SerializationHelper.deserializeActivitySheet(EventHandler.loadedDate));
		JOptionPane.showConfirmDialog(EventHandler.frame, "Activity Sheet saved to " + file, "Activity Sheet Export",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	public static void productivityReportExport(LocalDate start, LocalDate end) {
		save();
		Agent agent = SerializationHelper.deserializeAgent();
		Office office = SerializationHelper.deserializeOffice();
		String file = ProductivityReportHelper.export(agent, office, start, end);
		JOptionPane.showConfirmDialog(EventHandler.frame, "Productivity Report saved to " + file, "Productivity Report Export",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	public static void init(JFrame frame) {
		EventHandler.frame = frame;
		EventHandler.activityForms = new ArrayList<ActivityForm>();

		EventHandler.headerPanel = new JPanel();
		EventHandler.headerPanel.setLayout(new BoxLayout(EventHandler.headerPanel, BoxLayout.PAGE_AXIS));
		EventHandler.contentPanel = new JPanel();
		EventHandler.contentPanel.setAutoscrolls(true);
		EventHandler.contentPanel.setLayout(new BoxLayout(EventHandler.contentPanel, BoxLayout.PAGE_AXIS));
		JScrollPane scrollPane = new JScrollPane(EventHandler.contentPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		frame.getContentPane().add(headerPanel);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.setPreferredSize(new Dimension(800, 500));
		frame.setMinimumSize(new Dimension(800, 500));
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
		if (EventHandler.frame.isShowing()) {
			DimensionUtil.setCenterLocation(dialog, EventHandler.frame);
		} else {
			DimensionUtil.setCenterLocation(dialog);
		}
		dialog.setVisible(true);
	}

	public static void displayProductivityReportDialog() {
		GenerateProductivityReportDialog dialog = new GenerateProductivityReportDialog(EventHandler.frame);
		dialog.pack();
		DimensionUtil.setCenterLocation(dialog, EventHandler.frame);
		dialog.setVisible(true);
	}

	public static void displayOpenActivitySheetDialog() {
		OpenActivitySheetDialog dialog = new OpenActivitySheetDialog(EventHandler.frame);
		dialog.pack();
		DimensionUtil.setCenterLocation(dialog, EventHandler.frame);
		dialog.setVisible(true);
	}

	public static void displayOpenProfileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			FileHelper.setProfilePath(file.getAbsolutePath());
			checkAgentAndOfficeInfo();
			loadFromActivitySheet(SerializationHelper.deserializeActivitySheet());
		}
	}

	public static void deleteActivity(int index) {
		List<Activity> activities = getActivities();
		if (index >= 0 && index < activities.size()) {
			activities.remove(index);
		}
		reloadActivities(activities);
	}

	public static void moveActivity(int index, int amount) {
		List<Activity> activities = getActivities();
		if (index >= 0 && index < activities.size() && (index+amount) >= 0 && (index+amount) < activities.size()) {
			Activity activity = activities.remove(index);
			activities.add(index+amount, activity);
		}
		reloadActivities(activities);
	}

	public static void saveAgent(Agent agent) {
		SerializationHelper.serializeAgent(agent);
	}

	public static void saveOffice(Office office) {
		SerializationHelper.serializeOffice(office);
	}
}
