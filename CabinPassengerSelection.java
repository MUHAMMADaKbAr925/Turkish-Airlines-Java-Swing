import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CabinPassengerSelection extends JFrame {
    private SecondPanelMainFrame parentFrame;
    private SecondPanelRoundtrip parentFrame1;
    private int n;

    public CabinPassengerSelection(SecondPanelMainFrame parentFrame) {
        this.parentFrame = parentFrame;
        setTitle("Passengers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 800));

        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel labelPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JLabel cabinLabel = new JLabel("Cabin Selection:");
        JLabel passengerLabel = new JLabel("Passenger Selection:");
        labelPanel.add(cabinLabel);
        labelPanel.add(passengerLabel);
        labelPanel.setBorder(BorderFactory.createTitledBorder("Selection"));
        mainPanel.add(labelPanel);

        JPanel cabinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton economyRadioButton = new JRadioButton("Economy Class");
        JRadioButton businessRadioButton = new JRadioButton("Business Class");
        ButtonGroup cabinGroup = new ButtonGroup();
        cabinGroup.add(economyRadioButton);
        cabinGroup.add(businessRadioButton);
        cabinPanel.add(economyRadioButton);
        cabinPanel.add(businessRadioButton);
        cabinPanel.setBorder(BorderFactory.createTitledBorder("Cabin"));
        mainPanel.add(cabinPanel);

        JPanel passengerPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        JLabel studentLabel = new JLabel("Student 12-34:");
        JSpinner studentSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JLabel infantLabel = new JLabel("Infant Under 2 years old:");
        JSpinner infantSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JLabel adultLabel = new JLabel("Adult 12+:");
        JSpinner adultSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JLabel childLabel = new JLabel("Child 2-11:");
        JSpinner childSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        passengerPanel.add(studentLabel);
        passengerPanel.add(studentSpinner);
        passengerPanel.add(infantLabel);
        passengerPanel.add(infantSpinner);
        passengerPanel.add(adultLabel);
        passengerPanel.add(adultSpinner);
        passengerPanel.add(childLabel);
        passengerPanel.add(childSpinner);
        passengerPanel.setBorder(BorderFactory.createTitledBorder("Passenger Details"));
        mainPanel.add(passengerPanel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(100, 30));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get passenger counts
                int studentCount = (int) studentSpinner.getValue();
                int infantCount = (int) infantSpinner.getValue();
                int adultCount = (int) adultSpinner.getValue();
                int childCount = (int) childSpinner.getValue();

                // Update total passenger count
                n = studentCount + infantCount + adultCount + childCount;

                // Show total passengers
                JOptionPane.showMessageDialog(null, "Total Passengers: " + n);

                // Update the passengers button label in the parent frame
                parentFrame.setPassengersButton(n);

                // Close the current frame
                dispose();
            }
        });
        mainPanel.add(confirmButton);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }
  
    public CabinPassengerSelection(SecondPanelRoundtrip parentFrame1) {
        this.parentFrame1 = parentFrame1;
        setTitle("Passengers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 800));

        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel labelPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JLabel cabinLabel = new JLabel("Cabin Selection:");
        JLabel passengerLabel = new JLabel("Passenger Selection:");
        labelPanel.add(cabinLabel);
        labelPanel.add(passengerLabel);
        labelPanel.setBorder(BorderFactory.createTitledBorder("Selection"));
        mainPanel.add(labelPanel);

        JPanel cabinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton economyRadioButton = new JRadioButton("Economy Class");
        JRadioButton businessRadioButton = new JRadioButton("Business Class");
        ButtonGroup cabinGroup = new ButtonGroup();
        cabinGroup.add(economyRadioButton);
        cabinGroup.add(businessRadioButton);
        cabinPanel.add(economyRadioButton);
        cabinPanel.add(businessRadioButton);
        cabinPanel.setBorder(BorderFactory.createTitledBorder("Cabin"));
        mainPanel.add(cabinPanel);

        JPanel passengerPanel = new JPanel(new GridLayout(0, 2, 10, 5));
        JLabel studentLabel = new JLabel("Student 12-34:");
        JSpinner studentSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JLabel infantLabel = new JLabel("Infant Under 2 years old:");
        JSpinner infantSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JLabel adultLabel = new JLabel("Adult 12+:");
        JSpinner adultSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        JLabel childLabel = new JLabel("Child 2-11:");
        JSpinner childSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        passengerPanel.add(studentLabel);
        passengerPanel.add(studentSpinner);
        passengerPanel.add(infantLabel);
        passengerPanel.add(infantSpinner);
        passengerPanel.add(adultLabel);
        passengerPanel.add(adultSpinner);
        passengerPanel.add(childLabel);
        passengerPanel.add(childSpinner);
        passengerPanel.setBorder(BorderFactory.createTitledBorder("Passenger Details"));
        mainPanel.add(passengerPanel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(100, 30));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get passenger counts
                int studentCount = (int) studentSpinner.getValue();
                int infantCount = (int) infantSpinner.getValue();
                int adultCount = (int) adultSpinner.getValue();
                int childCount = (int) childSpinner.getValue();

                // Update total passenger count
                n = studentCount + infantCount + adultCount + childCount;

                // Show total passengers
                JOptionPane.showMessageDialog(null, "Total Passengers: " + n);

                // Update the passengers button label in the parent frame
                parentFrame1.setPassengersButton(n);

                // Close the current frame
                dispose();
            }
        });
        mainPanel.add(confirmButton);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }
  
}
