package ui;

import bad.EventHandler;
import helper.SerializationHelper;
import listener.AddActivityListener;
import listener.ExcelExportListener;
import listener.SaveListener;

import javax.swing.*;
import java.awt.Dimension;

public class Main {

	private static void createAndShowGui() {
		// Create and set up the window.
		JFrame frame = new JFrame("Chaplain BC Activity Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 200));

		// Create the menu bar.
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);

		JMenu menu = new JMenu("Options");
		JMenuItem addItem = new JMenuItem("Add Activity");
		addItem.addActionListener(new AddActivityListener());
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new SaveListener());
		JMenuItem exportItem = new JMenuItem("Export to Excel");
		exportItem.addActionListener(new ExcelExportListener());
		menu.add(addItem);
		menu.add(saveItem);
		menu.add(exportItem);
		menuBar.add(menu);

		// Set the menu bar and add the label to the content pane.
		frame.setJMenuBar(menuBar);
		EventHandler.init(frame);

		EventHandler.loadFromActivitySheet(SerializationHelper.deserializeActivitySheet());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGui();
			}
		});
	}
}