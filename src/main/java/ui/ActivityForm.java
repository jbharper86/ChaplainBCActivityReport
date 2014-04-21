package ui;

import data.ServiceCode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityForm {
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
    private JTextField odometerStart;
    private JTextField odometerStop;
    private JTextField travelTotalHour;
    private JTextField travelTotalMin;
    private JTextField activityTotalHour;
    private JTextField activityTotalMin;
    private JTextField odometerTotal;
    private JPanel activityForm;

	private void createUIComponents() {
        int maxHour = 24;
        int maxMinute = 60;
        List<Integer> minutes = new ArrayList<Integer>();
        List<Integer> hours = new ArrayList<Integer>();
        for (int i = 0; i < maxMinute; i++) {
            if (i < maxHour) {
                hours.add(i);
            }
            minutes.add(i);
        }

        Integer[] hoursArray = hours.toArray(new Integer[1]);
        Integer[] minutesArray = minutes.toArray(new Integer[1]);

        activityCodeBox = new JComboBox(ServiceCode.getSortedList());
        travelStartHour = new JComboBox(hoursArray);
        travelStartMin = new JComboBox(minutesArray);
        travelStopHour = new JComboBox(hoursArray);
        travelStopMin = new JComboBox(minutesArray);

        activityStartHour = new JComboBox(hoursArray);
        activityStartMin = new JComboBox(minutesArray);
        activityStopHour = new JComboBox(hoursArray);
        activityStopMin = new JComboBox(minutesArray);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
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
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        activityForm.add(activityCodeBox, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Patient Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        activityForm.add(label1, gbc);
        patientName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        activityForm.add(patientName, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Activity Code");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        activityForm.add(label2, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        activityForm.add(panel1, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Travel");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Activity Time");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Odometer");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label5, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("Start");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label6, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(travelStartHour, gbc);
        final JLabel label7 = new JLabel();
        label7.setRequestFocusEnabled(true);
        label7.setText("hr");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label7, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(travelStartMin, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("min");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label8, gbc);
        final JLabel label9 = new JLabel();
        label9.setText("Stop");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label9, gbc);
        final JLabel label10 = new JLabel();
        label10.setRequestFocusEnabled(true);
        label10.setText("hr");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label10, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("min");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label11, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(travelStopMin, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(travelStopHour, gbc);
        final JLabel label12 = new JLabel();
        label12.setText("Total");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label12, gbc);
        final JLabel label13 = new JLabel();
        label13.setRequestFocusEnabled(true);
        label13.setText("hr");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label13, gbc);
        final JLabel label14 = new JLabel();
        label14.setText("min");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label14, gbc);
        travelTotalHour = new JTextField();
        travelTotalHour.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(travelTotalHour, gbc);
        travelTotalMin = new JTextField();
        travelTotalMin.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(travelTotalMin, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel3, gbc);
        final JLabel label15 = new JLabel();
        label15.setText("Start");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label15, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(activityStartHour, gbc);
        final JLabel label16 = new JLabel();
        label16.setRequestFocusEnabled(true);
        label16.setText("hr");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label16, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(activityStartMin, gbc);
        final JLabel label17 = new JLabel();
        label17.setText("min");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label17, gbc);
        final JLabel label18 = new JLabel();
        label18.setText("Stop");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label18, gbc);
        final JLabel label19 = new JLabel();
        label19.setRequestFocusEnabled(true);
        label19.setText("hr");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label19, gbc);
        final JLabel label20 = new JLabel();
        label20.setText("min");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label20, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(activityStopMin, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(activityStopHour, gbc);
        final JLabel label21 = new JLabel();
        label21.setText("Total");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label21, gbc);
        final JLabel label22 = new JLabel();
        label22.setRequestFocusEnabled(true);
        label22.setText("hr");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label22, gbc);
        final JLabel label23 = new JLabel();
        label23.setText("min");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel3.add(label23, gbc);
        activityTotalHour = new JTextField();
        activityTotalHour.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(activityTotalHour, gbc);
        activityTotalMin = new JTextField();
        activityTotalMin.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel3.add(activityTotalMin, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel4, gbc);
        final JLabel label24 = new JLabel();
        label24.setText("Start");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label24, gbc);
        odometerStart = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(odometerStart, gbc);
        final JLabel label25 = new JLabel();
        label25.setText("Stop");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label25, gbc);
        odometerStop = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(odometerStop, gbc);
        final JLabel label26 = new JLabel();
        label26.setText("Total");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel4.add(label26, gbc);
        odometerTotal = new JTextField();
        odometerTotal.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel4.add(odometerTotal, gbc);
        final JLabel label27 = new JLabel();
        label27.setText("MR #");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        activityForm.add(label27, gbc);
        medicalRecordNumber = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        activityForm.add(medicalRecordNumber, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return activityForm;
    }
}