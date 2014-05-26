package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import bad.EventHandler;
import data.Activity;
import data.ServiceCode;
import listener.ActivityFormListener;

public class ActivityForm implements ItemListener {

	public static final String PATIENT_CARD = "patientCard";
	public static final String DESCRIPTION_CARD = "descriptionCard";

	private JComboBox activityCodeBox;
	private JTextField patientName;
	private JTextField medicalRecordNumber;
	private JComboBox travelStartHour;
	private JComboBox travelStartMin;
	private JComboBox travelStopHour;
	private JComboBox travelStopMin;
	private JComboBox activityStartHour;
	private JComboBox activityStartMin;
	private JComboBox activityStopHour;
	private JComboBox activityStopMin;
	private JFormattedTextField odometerStart;
	private JFormattedTextField odometerStop;
	private JTextField travelTotalHour;
	private JTextField travelTotalMin;
	private JTextField activityTotalHour;
	private JTextField activityTotalMin;
	private JTextField odometerTotal;
	private JPanel activityForm;
	private JButton xButton;
	private JButton upButton;
	private JButton downButton;
	private JTextField activityDescripiton;
	private JPanel cardPanel;
	private Activity activity;
	private int position;

	public ActivityForm() {
		$$$setupUI$$$();
		xButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				EventHandler.deleteActivity(position);
			}
		});
		upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				EventHandler.moveActivity(position, -1);
			}
		});
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				EventHandler.moveActivity(position, 1);
			}
		});
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		createUIComponents();
		activityForm = new JPanel();
		activityForm.setLayout(new GridBagLayout());
		activityForm.setAlignmentX(1.0f);
		activityForm.setAlignmentY(1.0f);
		activityForm.setAutoscrolls(false);
		activityForm.setInheritsPopupMenu(true);
		activityForm.setMaximumSize(new Dimension(40000, 200));
		activityForm.setMinimumSize(new Dimension(700, 200));
		activityForm.setOpaque(true);
		activityForm.setPreferredSize(new Dimension(700, 200));
		final JLabel label1 = new JLabel();
		label1.setText("Activity Code");
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		activityForm.add(label1, gbc);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		activityForm.add(panel1, gbc);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		panel1.add(panel2, gbc);
		panel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Activity Time", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
		final JLabel label2 = new JLabel();
		label2.setText("Start");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label2, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(activityStartHour, gbc);
		final JLabel label3 = new JLabel();
		label3.setRequestFocusEnabled(true);
		label3.setText(" hr");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label3, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(activityStartMin, gbc);
		final JLabel label4 = new JLabel();
		label4.setText(" min");
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label4, gbc);
		final JLabel label5 = new JLabel();
		label5.setText("Stop");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label5, gbc);
		final JLabel label6 = new JLabel();
		label6.setRequestFocusEnabled(true);
		label6.setText(" hr");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label6, gbc);
		final JLabel label7 = new JLabel();
		label7.setText(" min");
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label7, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(activityStopMin, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(activityStopHour, gbc);
		final JLabel label8 = new JLabel();
		label8.setText("Total");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label8, gbc);
		final JLabel label9 = new JLabel();
		label9.setRequestFocusEnabled(true);
		label9.setText(" hr");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label9, gbc);
		final JLabel label10 = new JLabel();
		label10.setText(" min");
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel2.add(label10, gbc);
		activityTotalHour = new JTextField();
		activityTotalHour.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(activityTotalHour, gbc);
		activityTotalMin = new JTextField();
		activityTotalMin.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(activityTotalMin, gbc);
		final JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(spacer1, gbc);
		final JPanel spacer2 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(spacer2, gbc);
		final JPanel spacer3 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(spacer3, gbc);
		final JPanel spacer4 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 8;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(spacer4, gbc);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		panel1.add(panel3, gbc);
		panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Travel", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
		final JLabel label11 = new JLabel();
		label11.setText("Start");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label11, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(travelStartHour, gbc);
		final JLabel label12 = new JLabel();
		label12.setRequestFocusEnabled(true);
		label12.setText(" hr");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label12, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(travelStartMin, gbc);
		final JLabel label13 = new JLabel();
		label13.setText(" min");
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label13, gbc);
		final JLabel label14 = new JLabel();
		label14.setText("Stop");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label14, gbc);
		final JLabel label15 = new JLabel();
		label15.setRequestFocusEnabled(true);
		label15.setText(" hr");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label15, gbc);
		final JLabel label16 = new JLabel();
		label16.setText(" min");
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label16, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(travelStopMin, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(travelStopHour, gbc);
		final JLabel label17 = new JLabel();
		label17.setText("Total");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label17, gbc);
		final JLabel label18 = new JLabel();
		label18.setRequestFocusEnabled(true);
		label18.setText(" hr");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label18, gbc);
		final JLabel label19 = new JLabel();
		label19.setText(" min");
		gbc = new GridBagConstraints();
		gbc.gridx = 7;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel3.add(label19, gbc);
		travelTotalHour = new JTextField();
		travelTotalHour.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(travelTotalHour, gbc);
		travelTotalMin = new JTextField();
		travelTotalMin.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(travelTotalMin, gbc);
		final JPanel spacer5 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(spacer5, gbc);
		final JPanel spacer6 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(spacer6, gbc);
		final JPanel spacer7 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(spacer7, gbc);
		final JPanel spacer8 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 8;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(spacer8, gbc);
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		panel1.add(panel4, gbc);
		panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Odometer", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.TOP));
		final JLabel label20 = new JLabel();
		label20.setText("Start");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(label20, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(odometerStart, gbc);
		final JLabel label21 = new JLabel();
		label21.setText("Stop");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(label21, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(odometerStop, gbc);
		final JLabel label22 = new JLabel();
		label22.setText("Total");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(label22, gbc);
		odometerTotal = new JTextField();
		odometerTotal.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(odometerTotal, gbc);
		final JPanel spacer9 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(spacer9, gbc);
		final JPanel spacer10 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(spacer10, gbc);
		final JPanel spacer11 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(spacer11, gbc);
		activityCodeBox.setName("activityCodeBox");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		activityForm.add(activityCodeBox, gbc);
		final JPanel spacer12 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		activityForm.add(spacer12, gbc);
		final JPanel spacer13 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		activityForm.add(spacer13, gbc);
		final JPanel spacer14 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		activityForm.add(spacer14, gbc);
		final JPanel spacer15 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.VERTICAL;
		activityForm.add(spacer15, gbc);
		final JPanel spacer16 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		activityForm.add(spacer16, gbc);
		final JPanel spacer17 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.VERTICAL;
		activityForm.add(spacer17, gbc);
		final JPanel panel5 = new JPanel();
		panel5.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridheight = 7;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		activityForm.add(panel5, gbc);
		xButton = new JButton();
		xButton.setIcon(new ImageIcon(getClass().getResource("/delete.png")));
		xButton.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel5.add(xButton, gbc);
		upButton = new JButton();
		upButton.setIcon(new ImageIcon(getClass().getResource("/up_arrow.png")));
		upButton.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel5.add(upButton, gbc);
		downButton = new JButton();
		downButton.setIcon(new ImageIcon(getClass().getResource("/down_arrow.png")));
		downButton.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel5.add(downButton, gbc);
		final JPanel spacer18 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel5.add(spacer18, gbc);
		final JPanel spacer19 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel5.add(spacer19, gbc);
		cardPanel = new JPanel();
		cardPanel.setLayout(new CardLayout(0, 0));
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		activityForm.add(cardPanel, gbc);
		final JPanel panel6 = new JPanel();
		panel6.setLayout(new GridBagLayout());
		cardPanel.add(panel6, "patientCard");
		final JLabel label23 = new JLabel();
		label23.setText("Patient Name");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel6.add(label23, gbc);
		patientName = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel6.add(patientName, gbc);
		final JLabel label24 = new JLabel();
		label24.setText("MR #");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel6.add(label24, gbc);
		medicalRecordNumber = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel6.add(medicalRecordNumber, gbc);
		final JPanel spacer20 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel6.add(spacer20, gbc);
		final JPanel panel7 = new JPanel();
		panel7.setLayout(new GridBagLayout());
		cardPanel.add(panel7, "descriptionCard");
		final JLabel label25 = new JLabel();
		label25.setText("Description");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel7.add(label25, gbc);
		activityDescripiton = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel7.add(activityDescripiton, gbc);
		final JPanel spacer21 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel7.add(spacer21, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return activityForm;
	}

	private void createUIComponents() {
		int maxHour = 24;
		int maxMinute = 60;
		List<Integer> minutes = new ArrayList<Integer>();
		List<Integer> hours = new ArrayList<Integer>();
		for (int i = 0; i < maxHour; i++) {
			if ((i * 5) < maxMinute) {
				minutes.add(i * 5);
			}
			hours.add(i);
		}

		Integer[] hoursArray = hours.toArray(new Integer[1]);
		Integer[] minutesArray = minutes.toArray(new Integer[1]);

		activityCodeBox = new JComboBox(ServiceCode.getSortedLabelArray());
		travelStartHour = new JComboBox(hoursArray);
		travelStartMin = new JComboBox(minutesArray);
		travelStopHour = new JComboBox(hoursArray);
		travelStopMin = new JComboBox(minutesArray);

		activityStartHour = new JComboBox(hoursArray);
		activityStartMin = new JComboBox(minutesArray);
		activityStopHour = new JComboBox(hoursArray);
		activityStopMin = new JComboBox(minutesArray);

		odometerStart = new JFormattedTextField(NumberFormat.getIntegerInstance());
		odometerStop = new JFormattedTextField(NumberFormat.getIntegerInstance());
	}

	public void addChangeListeners() {
		ActivityFormListener listener = new ActivityFormListener(this);

		travelStartHour.addActionListener(listener);
		travelStopHour.addActionListener(listener);
		travelStartMin.addActionListener(listener);
		travelStopMin.addActionListener(listener);

		activityStartHour.addActionListener(listener);
		activityStopHour.addActionListener(listener);
		activityStartMin.addActionListener(listener);
		activityStopMin.addActionListener(listener);

		odometerStart.addPropertyChangeListener("value", listener);
		odometerStop.addPropertyChangeListener("value", listener);

		activityCodeBox.addItemListener(this);
	}


	private DateTime getDateTime(JComboBox hours, JComboBox minutes) {
		Integer hourVal = (Integer) hours.getSelectedItem();
		Integer minuteVal = (Integer) minutes.getSelectedItem();
		return new DateTime().withHourOfDay(hourVal).withMinuteOfHour(minuteVal).withSecondOfMinute(0).withMillisOfSecond(0);
	}

	public void getData(Activity data) {
		// Activity Code
		String activityLabel = (String) activityCodeBox.getSelectedItem();
		data.setType(ServiceCode.getCodeForLabel(activityLabel));

		if (data.getType().showPatientInfo()) {
			// Patient info
			data.setPatientName(patientName.getText());
			data.setMedicalRecordNumber(medicalRecordNumber.getText());
		} else {
			data.setPatientName(activityDescripiton.getText());
		}

		// Travel Time
		data.setTravelStart(getDateTime(travelStartHour, travelStartMin));
		data.setTravelStop(getDateTime(travelStopHour, travelStopMin));

		// Activity Time
		data.setActivityStartTime(getDateTime(activityStartHour, activityStartMin));
		data.setActivityStopTime(getDateTime(activityStopHour, activityStopMin));

		// Odometer
		if (odometerStart.getValue() != null) {
			data.setStartMileage(Integer.valueOf(String.valueOf(odometerStart.getValue())));
		} else {
			data.setStartMileage(0);
		}
		if (odometerStop.getValue() != null) {
			data.setStopMileage(Integer.valueOf(String.valueOf(odometerStop.getValue())));
		} else {
			data.setStopMileage(0);
		}
	}

	@Override
	public void itemStateChanged(final ItemEvent e) {
		ServiceCode serviceCode = ServiceCode.getCodeForLabel((String) e.getItem());
		showCardPanel(serviceCode);
	}

	private void showCardPanel(final ServiceCode serviceCode) {
		CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
		if (serviceCode != null && serviceCode.showPatientInfo()) {
			cardLayout.show(cardPanel, PATIENT_CARD);
		} else {
			cardLayout.show(cardPanel, DESCRIPTION_CARD);
		}
	}

	public void setData(Activity data) {
		if (activityCodeBox != null) {
			// Activity code
			if (data.getType() != null) {
				activityCodeBox.setSelectedItem(data.getType().labelForDropdown());
			}

			// Patient info
			patientName.setText(data.getPatientName());
			medicalRecordNumber.setText(data.getMedicalRecordNumber());

			// Activity description (reuse patient name field for now)
			activityDescripiton.setText(data.getPatientName());

			// Travel Time
			if (data.getTravelStart() != null) {
				travelStartHour.setSelectedIndex(data.getTravelStart().hourOfDay().get());
				travelStartMin.setSelectedIndex(data.getTravelStart().minuteOfHour().get() / 5);
			}
			if (data.getTravelStop() != null) {
				travelStopHour.setSelectedIndex(data.getTravelStop().hourOfDay().get());
				travelStopMin.setSelectedIndex(data.getTravelStop().minuteOfHour().get() / 5);
			}

			// Activity Time
			if (data.getActivityStartTime() != null) {
				activityStartHour.setSelectedIndex(data.getActivityStartTime().hourOfDay().get());
				activityStartMin.setSelectedIndex(data.getActivityStartTime().minuteOfHour().get() / 5);
			}
			if (data.getActivityStopTime() != null) {
				activityStopHour.setSelectedIndex(data.getActivityStopTime().hourOfDay().get());
				activityStopMin.setSelectedIndex(data.getActivityStopTime().minuteOfHour().get() / 5);
			}

			// Odometer
			odometerStart.setValue(Integer.valueOf(data.getStartMileage()));
			odometerStop.setValue(Integer.valueOf(data.getStopMileage()));

			setTotalFields(data);

			showCardPanel(data.getType());
		}
	}

	private void setTotalFields(Activity data) {
		Duration travelTotal = data.getTotalTravelTime();
		Duration activityTotal = data.getTotalTime();
		int mileageTotal = data.getTotalMiles();

		travelTotalHour.setText(String.valueOf(travelTotal.getStandardHours()));
		travelTotalMin.setText(String.valueOf(travelTotal.getStandardMinutes() % 60));

		activityTotalHour.setText(String.valueOf(activityTotal.getStandardHours()));
		activityTotalMin.setText(String.valueOf(activityTotal.getStandardMinutes() % 60));

		odometerTotal.setText(String.valueOf(mileageTotal));
	}

	public void setTotalFields() {
		setTotalFields(getActivity());
	}

	public Activity getActivity() {
		getData(this.activity);
		return this.activity;
	}

	public void setActivity(final Activity activity) {
		this.activity = activity;
		setData(this.activity);
	}

	public void setPosition(final int position) {
		this.position = position;
	}

	public void enableUp() {
		upButton.setEnabled(true);
	}

	public void enableDown() {
		downButton.setEnabled(true);
	}

	public void disableUp() {
		upButton.setEnabled(false);
	}

	public void disableDown() {
		downButton.setEnabled(false);
	}
}
