package ui;

import bad.EventHandler;
import helper.SerializationHelper;
import listener.*;
import util.DimensionUtil;

import javax.swing.*;
import java.awt.Dimension;

public class Main {

	private static void createAndShowGui() {
		setLookAndFeel();

		// Create and set up the window.
		JFrame frame = new JFrame("Counselor Activity Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenuBar(frame);

		EventHandler.init(frame);

		EventHandler.checkAgentAndOfficeInfo();
		EventHandler.loadFromActivitySheet(SerializationHelper.deserializeActivitySheet());

		// Display the window.
		frame.pack();
		DimensionUtil.setCenterLocation(frame);
		frame.setVisible(true);
		frame.createBufferStrategy(2);
	}

	private static void createMenuBar(JFrame frame) {
		// Create the menu bar.
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);

		JMenu menu = new JMenu("Options");
		JMenuItem addItem = new JMenuItem("Add Activity");
		addItem.addActionListener(new AddActivityListener());
		JMenuItem openItem = new JMenuItem("Open Activity Sheet");
		openItem.addActionListener(new OpenActivitySheetListener());
		JMenuItem agentItem = new JMenuItem("Edit Agent/Office Info");
		agentItem.addActionListener(new AgentOfficeInfoListener());
		JMenuItem profileItem = new JMenuItem("Open Profile");
		profileItem.addActionListener(new ProfileListener());
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new SaveListener());
		menu.add(addItem);
		menu.add(openItem);
		menu.add(agentItem);
		menu.add(profileItem);
		menu.add(saveItem);
		menuBar.add(menu);

		JMenu exportMenu = new JMenu("Export");
		JMenuItem exportActivitySheetItem = new JMenuItem("Export Activity Sheet");
		exportActivitySheetItem.addActionListener(new ActivitySheetExportListener());
		JMenuItem exportItem = new JMenuItem("Export Productivity Report");
		exportItem.addActionListener(new ProductivityReportExportListener());
		exportMenu.add(exportActivitySheetItem);
		exportMenu.add(exportItem);
		menuBar.add(exportMenu);


		// Set the menu bar and add the label to the content pane.
		frame.setJMenuBar(menuBar);
	}

	private static void setLookAndFeel() {
		try {
			// Enable the Nimbus Look-and-Feel
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					return;
				}
			}

			// Nimbus is not available, use the system look-and-feel instead.
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// Do nothing...default to the "Metal" Look & Feel
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}