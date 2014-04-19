package ui;

import javax.swing.*;
import java.awt.*;

public class Main {

    private static void createAndShowGui() {
        // Create and set up the window.
        JFrame frame = new JFrame("Chaplain BC Activity Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the menu bar.
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setPreferredSize(new Dimension(200, 20));

        // Set the menu bar and add the label to the content pane.
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(new ActivityForm().$$$getRootComponent$$$());

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