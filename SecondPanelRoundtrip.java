import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.*;
import org.jdatepicker.impl.*;

public class SecondPanelRoundtrip extends JPanel {
    private JButton passengersButton;
    private JButton searchButton;
    private JTextField istField;
    private JTextField toField;
    private JDatePickerImpl datePicker;
    private JDatePickerImpl datePicker1;
    private int n;
    private String credentials;
    private String preference;

    // Constructor 1
    public SecondPanelRoundtrip(int n) {
        this(n, null, null);  // refer to the other constructor
    }

    // Constructor 2
    public SecondPanelRoundtrip(int n, String credentials, String preference) {
        this.n = n;
        this.credentials = credentials;
        this.preference = preference;

        setLayout(new BorderLayout());

        // Create panel for "Flight Ticket" label
        JPanel ticketPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel ticketLabel = new JLabel(new ImageIcon("flight_ticket.png"));
        ticketLabel.setForeground(Color.RED);
        ticketLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        ticketPanel.add(ticketLabel);
        ticketPanel.setBackground(Color.WHITE);

        // Create panel for radio buttons
        JPanel radiosPanel = new JPanel(new FlowLayout());
        JRadioButton roundTripRadio = new JRadioButton("Round Trip");
        roundTripRadio.setSelected(true);
        ButtonGroup radioGroup = new ButtonGroup();
        roundTripRadio.setBackground(Color.WHITE);
        radioGroup.add(roundTripRadio);
        radiosPanel.add(roundTripRadio);
       
        radiosPanel.setBackground(Color.WHITE);

        // Create panel for booking information
        JPanel bookingInfoPanel = new JPanel(new FlowLayout());
        istField = new JTextField("Istanbul", 10);
        istField.setPreferredSize(new Dimension(120, 45));
        toField = new JTextField("To", 10);
        toField.setPreferredSize(new Dimension(120, 45));

        passengersButton = new JButton("Passengers " + n);
        passengersButton.setPreferredSize(new Dimension(120, 45));

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        datePicker.setPreferredSize(new Dimension(120, 45));

        UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateComponentFormatter());
        datePicker1.setPreferredSize(new Dimension(120, 45));

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
                    Date selectedDate1 = (Date) datePicker1.getModel().getValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
                    String formattedDate = dateFormat.format(selectedDate);
                    String formattedDate1 = dateFormat.format(selectedDate1);

                    if (credentials == null || preference == null) {
                        FlightList flightList = new FlightList(departure, destination, formattedDate);
                    } else {
                    FlightList flightList = new FlightList(departure, destination, formattedDate,formattedDate1 , credentials, preference, n);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        bookingInfoPanel.add(istField);
        bookingInfoPanel.add(toField);
        bookingInfoPanel.add(datePicker);
        if (credentials != null && preference != null) {
            bookingInfoPanel.add(datePicker1);
        }
        bookingInfoPanel.add(passengersButton);
        bookingInfoPanel.add(searchButton);
        bookingInfoPanel.setBackground(Color.WHITE);

        add(ticketPanel, BorderLayout.NORTH);
        add(radiosPanel, BorderLayout.CENTER);
        add(bookingInfoPanel, BorderLayout.SOUTH);

        // Set up action listener for passengersButton
        setupPassengersButtonListener();
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
                CabinPassengerSelection passengerSelection = new CabinPassengerSelection(SecondPanelRoundtrip.this);
                passengerSelection.setVisible(true);
            }
        });
        setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Second Panel Roundtrip");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new SecondPanelRoundtrip(1));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
