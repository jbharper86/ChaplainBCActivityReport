package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import data.ServiceCode;

public class ChaplainBCActivityReport {

	private static void createAndShowGui() {
		//Create and set up the window.
        JFrame frame = new JFrame("Chaplain BC Activity Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create the menu bar.  Make it have a green background.
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200, 20));
 
        //Create a yellow label to put in the content pane.
        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setPreferredSize(new Dimension(200, 180));

        JComboBox comboBox = new JComboBox(ServiceCode.getSortedList());
 
        //Set the menu bar and add the label to the content pane.
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(comboBox, BorderLayout.CENTER);
 
        //Display the window.
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