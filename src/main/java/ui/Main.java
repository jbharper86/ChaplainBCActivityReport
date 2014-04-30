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
		JFrame frame = new JFrame("Chaplain BC Activity Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 200));
		createMenuBar(frame);

		EventHandler.init(frame);

		EventHandler.loadFromActivitySheet(SerializationHelper.deserializeActivitySheet());
		EventHandler.checkAgentAndOfficeInfo();

		// Display the window.
		frame.pack();
		DimensionUtil.setCenterLocation(frame);
		frame.setVisible(true);
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
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new SaveListener());
		JMenuItem exportActivitySheetItem = new JMenuItem("Export Activity Sheet");
		exportActivitySheetItem.addActionListener(new ActivitySheetExportListener());
		JMenuItem exportItem = new JMenuItem("Export Productivity Report");
		exportItem.addActionListener(new ProductivityReportExportListener());
		menu.add(addItem);
		menu.add(openItem);
		menu.add(agentItem);
		menu.add(saveItem);
		menu.add(exportActivitySheetItem);
		menu.add(exportItem);
		menuBar.add(menu);

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