import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.DateComponentFormatter;

public class SecondPanelMainFrame extends JPanel {

    private JButton passengersButton;
    private JButton searchButton;
    private JTextField istField;
    private JTextField toField;
    private JDatePickerImpl datePicker;
    private int n;
//isme bhi wohi functionality dalni hai jo isse niche wale mein hai 9:19
    public SecondPanelMainFrame(int n) {
        this.n = n;

        setLayout(new BorderLayout());

        // Create panel for "Flight Ticket" label
        JPanel ticketPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ticketLabel = new JLabel(new ImageIcon("flight_ticket.png"));
        ticketLabel.setForeground(Color.RED);
        ticketLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        ticketPanel.add(ticketLabel);
        ticketPanel.setBackground(Color.WHITE);

        //  panel for radio buttons
        JPanel radiosPanel = new JPanel();
        radiosPanel.setLayout(new FlowLayout());
        JRadioButton roundTripRadio = new JRadioButton("Round Trip");
        
        JRadioButton oneWayRadio = new JRadioButton("One Way");
        JRadioButton stepOverInIst = new JRadioButton("Step Over in Istanbul");
        JRadioButton multiCity = new JRadioButton("Multi City");
        ButtonGroup radioGroup = new ButtonGroup();
        roundTripRadio.setBackground(Color.WHITE);
        oneWayRadio.setBackground(Color.WHITE);
        radioGroup.add(roundTripRadio);
        radioGroup.add(oneWayRadio);
        radioGroup.add(stepOverInIst);
        radioGroup.add(multiCity);
        radiosPanel.add(roundTripRadio);
        radiosPanel.add(oneWayRadio);
        radiosPanel.setBackground(Color.WHITE);

        // Create panel for booking information
        JPanel bookingInfoPanel = new JPanel();
        bookingInfoPanel.setLayout(new FlowLayout());
        istField = new JTextField("Istanbul", 10);
        istField.setPreferredSize(new Dimension(120, 45));

        toField = new JTextField("To", 10);
        toField.setPreferredSize(new Dimension(120, 45));

        passengersButton = new JButton("Passengers " + n);
        passengersButton.setPreferredSize(new Dimension(120, 45));

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        datePicker = new JDatePickerImpl(new JDatePanelImpl(model, p), new DateComponentFormatter());
        datePicker.setPreferredSize(new Dimension(120, 45));

        searchButton = new JButton(new ImageIcon("search_flights.png"));
        searchButton.setHorizontalTextPosition(JButton.LEFT);
        searchButton.setPreferredSize(new Dimension(120, 45));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String departure = istField.getText();
                    String destination = toField.getText();
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);

                    FlightList flightList = new FlightList(departure, destination, formattedDate);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        bookingInfoPanel.add(istField);
        bookingInfoPanel.add(toField);
        bookingInfoPanel.add(datePicker);
        bookingInfoPanel.add(passengersButton);
        bookingInfoPanel.add(searchButton);
        bookingInfoPanel.setBackground(Color.WHITE);

        add(ticketPanel, BorderLayout.NORTH);
        add(radiosPanel, BorderLayout.CENTER);
        add(bookingInfoPanel, BorderLayout.SOUTH);
        roundTripRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
              TurkishAirlinesFrame frame = new TurkishAirlinesFrame("");
            }
        });
        //  action listener  passengersButton
        setupPassengersButtonListener();
    }

    public SecondPanelMainFrame(int n,String credentials,String preference) {
        this.n = n;

        setLayout(new BorderLayout());

        // Create panel for "Flight Ticket" label
        JPanel ticketPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ticketLabel = new JLabel(new ImageIcon("flight_ticket.png"));
        ticketLabel.setForeground(Color.RED);
        ticketLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        ticketPanel.add(ticketLabel);
        ticketPanel.setBackground(Color.WHITE);

        // Create panel for radio buttons
        JPanel radiosPanel = new JPanel();
        radiosPanel.setLayout(new FlowLayout());
        JRadioButton roundTripRadio = new JRadioButton("Round Trip");
        roundTripRadio.setSelected(false);
        JRadioButton oneWayRadio = new JRadioButton("One Way");
        
        ButtonGroup radioGroup = new ButtonGroup();
        roundTripRadio.setBackground(Color.WHITE);
        oneWayRadio.setBackground(Color.WHITE);
            radioGroup.add(oneWayRadio);
    radioGroup.add(roundTripRadio);    
        radiosPanel.add(oneWayRadio);

        radiosPanel.add(roundTripRadio);
        radiosPanel.setBackground(Color.WHITE);

        // Create panel for booking information
        JPanel bookingInfoPanel = new JPanel();
        bookingInfoPanel.setLayout(new FlowLayout());
        istField = new JTextField("Istanbul", 10);
        istField.setPreferredSize(new Dimension(120, 45));

        toField = new JTextField("To", 10);
        toField.setPreferredSize(new Dimension(120, 45));

        passengersButton = new JButton("Passengers " + n);
        passengersButton.setPreferredSize(new Dimension(120, 45));

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        datePicker = new JDatePickerImpl(new JDatePanelImpl(model, p), new DateComponentFormatter());
        datePicker.setPreferredSize(new Dimension(120, 45));

        searchButton = new JButton(new ImageIcon("search_flights.png"));
        searchButton.setHorizontalTextPosition(JButton.LEFT);
        searchButton.setPreferredSize(new Dimension(120, 45));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String departure = istField.getText();
                    String destination = toField.getText();
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);

                    FlightList flightList = new FlightList(departure, destination, formattedDate,credentials,preference,n);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        bookingInfoPanel.add(istField);
        bookingInfoPanel.add(toField);
        bookingInfoPanel.add(datePicker);
        bookingInfoPanel.add(passengersButton);
        bookingInfoPanel.add(searchButton);
        bookingInfoPanel.setBackground(Color.WHITE);

        add(ticketPanel, BorderLayout.NORTH);
        add(radiosPanel, BorderLayout.CENTER);
        add(bookingInfoPanel, BorderLayout.SOUTH);

        // Set up action listener for passengersButton
        setupPassengersButtonListener();
        roundTripRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
              TurkishAirlinesFrame frame = new TurkishAirlinesFrame(credentials, preference,"");
            }
        });
    }

    public void setPassengersButton(int n) {
        passengersButton.setText("Passengers " + n);
    }

    public JButton getPassengersButton() {
        return passengersButton;
    }

    public void setupPassengersButtonListener() {
        passengersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CabinPassengerSelection passengerSelection = new CabinPassengerSelection(SecondPanelMainFrame.this);
                passengerSelection.setVisible(true);
            }
        });
        setBackground(Color.WHITE);

        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SecondPanelMainFrame frame = new SecondPanelMainFrame(1);
            frame.setVisible(true);
        });
    }
}
