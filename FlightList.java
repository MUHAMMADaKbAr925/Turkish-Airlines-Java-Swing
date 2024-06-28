import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class FlightList extends JFrame {
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private ArrayList<JRadioButton> allRadioButtons = new ArrayList<>();
    JPanel confirmPanel;
   
//constructor for round trip
    public FlightList(String departure, String destination, String date, String credentials, String preference, int n,String formattedDate) throws Exception {
        // Load the MySQL driver
      confirmPanel = new JPanel();
      confirmPanel.setBackground(Color.WHITE);
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/airlines";
        String username = "Adm";
        String password = "xxxx";

        // SQL query using PreparedStatement
        String sql = "SELECT * FROM flight WHERE Departure = ? AND Destination = ? AND Date_of_departure = ? AND is_booked = false";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters for the query
            pstmt.setString(1, departure);
            pstmt.setString(2, destination);
            pstmt.setString(3, date);

            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                setLayout(new GridLayout(0, 1, 10, 10)); // Grid layout with appropriate gaps

                while (rs.next()) {
                    String flightNum = rs.getString("flightNum");
                    String departureCity = rs.getString("Departure");
                    String destinationCity = rs.getString("Destination");
                    String timeOfDeparture = rs.getString("Time_of_departure");
                    String timeOfArrival = rs.getString("Time_of_Arrival");
                    boolean isDirect = rs.getBoolean("is_direct");
                    int businessPrice = rs.getInt("business_price");
                    int economyPrice = rs.getInt("economy_price");

                    Ticket ticket = new Ticket(flightNum, departureCity, destinationCity, timeOfDeparture, timeOfArrival, isDirect, businessPrice, economyPrice);
                    ticketList.add(ticket); // Add ticket to the list
                    add(ticket);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setBackground(Color.WHITE);

        JButton confirmButton = new JButton(new ImageIcon("select_flight.png"));
        confirmButton.setPreferredSize(new Dimension(140,30));

        confirmPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Ticket ticket : ticketList) {
                    if (ticket.isBusinessSelected() || ticket.isEconomySelected()) {
                        // Gather credit card information
                        JTextField cardNumberField = new JTextField();
                        JTextField expiryField = new JTextField();
                        JTextField cvvField = new JTextField();

                        JPanel panel = new JPanel(new GridLayout(0, 1));
                        panel.add(new JLabel("Enter Credit Card Number:"));
                        panel.add(cardNumberField);
                        panel.add(new JLabel("Enter Expiry Date (MM/YY):"));
                        panel.add(expiryField);
                        panel.add(new JLabel("Enter CVV:"));
                        panel.add(cvvField);

                        int result = JOptionPane.showConfirmDialog(null, panel, "Payment Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            String cardNumber = cardNumberField.getText();
                            String expiry = expiryField.getText();
                            String cvv = cvvField.getText();

                            // Simulate payment processing
                            boolean paymentSuccessful = processPayment(cardNumber, expiry, cvv);

                            if (paymentSuccessful) {
                                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                                    String insertSql = "INSERT INTO Bookings (credential, preference, flightNum) VALUES (?, ?, ?)";
                                    String updateSql = "UPDATE flight SET is_booked = true WHERE flightNum = ?";

                                    // Insert booking details
                                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                                        insertStmt.setString(1, credentials);
                                        insertStmt.setString(2, preference);
                                        insertStmt.setString(3, ticket.getFlightNum());
                                        insertStmt.executeUpdate();
                                    }

                                    // Update flight to mark as booked
                                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                                        updateStmt.setString(1, ticket.getFlightNum());
                                        updateStmt.executeUpdate();
                                    }

                                    JOptionPane.showMessageDialog(null, "Payment successful, your flight is booked.");
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
                            }
                        }
                    }
                }
            }
        });
        add(confirmPanel); // Add the confirm button to the frame

        setSize(800, 600); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setVisible(true); // Set frame visibility
    }
    public FlightList(String departure, String destination, String date, String date1, String credentials, String preference, int n) throws Exception {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");
    
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/airlines";
        String username = "Adm";
        String password = "xxxx";
    
        // SQL query using PreparedStatement
        String sql = "SELECT * FROM flight WHERE Departure = ? AND Destination = ? AND Date_of_departure = ? AND is_booked = false " +
                     "UNION " +
                     "SELECT * FROM flight WHERE Departure = ? AND Destination = ? AND Date_of_departure = ? AND is_booked = false";
    
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            // Set the parameters for the first query (departure to destination)
            pstmt.setString(1, departure);
            pstmt.setString(2, destination);
            pstmt.setString(3, date);
    
            // Set the parameters for the second query (destination to departure)
            pstmt.setString(4, destination); // Swap departure and destination
            pstmt.setString(5, departure);   // Swap departure and destination
            pstmt.setString(6, date1);       // Use date1 instead of date
    
            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                setLayout(new GridLayout(0, 1, 10, 10)); // Grid layout with appropriate gaps
    
                while (rs.next()) {
                    String flightNum = rs.getString("flightNum");
                    String departureCity = rs.getString("Departure");
                    String destinationCity = rs.getString("Destination");
                    String timeOfDeparture = rs.getString("Time_of_departure");
                    String timeOfArrival = rs.getString("Time_of_Arrival");
                    boolean isDirect = rs.getBoolean("is_direct");
                    int businessPrice = rs.getInt("business_price");
                    int economyPrice = rs.getInt("economy_price");
    
                    Ticket ticket = new Ticket(flightNum, departureCity, destinationCity, timeOfDeparture, timeOfArrival, isDirect, businessPrice, economyPrice);
                    ticketList.add(ticket); // Add ticket to the list
                    add(ticket);
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        setBackground(Color.WHITE);
    confirmPanel = new JPanel();
        JButton confirmButton = new JButton(new ImageIcon("select_flight.png"));
        confirmButton.setPreferredSize(new Dimension(140,30));

        confirmPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Ticket ticket : ticketList) {
                    if (ticket.isBusinessSelected() || ticket.isEconomySelected()) {
                        // Gather credit card information
                        JTextField cardNumberField = new JTextField();
                        JTextField expiryField = new JTextField();
                        JTextField cvvField = new JTextField();
    
                        JPanel panel = new JPanel(new GridLayout(0, 1));
                        panel.add(new JLabel("Enter Credit Card Number:"));
                        panel.add(cardNumberField);
                        panel.add(new JLabel("Enter Expiry Date (MM/YY):"));
                        panel.add(expiryField);
                        panel.add(new JLabel("Enter CVV:"));
                        panel.add(cvvField);
    
                        int result = JOptionPane.showConfirmDialog(null, panel, "Payment Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
                        if (result == JOptionPane.OK_OPTION) {
                            String cardNumber = cardNumberField.getText();
                            String expiry = expiryField.getText();
                            String cvv = cvvField.getText();
    
                            // Simulate payment processing
                            boolean paymentSuccessful = processPayment(cardNumber, expiry, cvv);
    
                            if (paymentSuccessful) {
                                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                                    String insertSql = "INSERT INTO Bookings (credential, preference, flightNum) VALUES (?, ?, ?)";
                                    String updateSql = "UPDATE flight SET is_booked = true WHERE flightNum = ?";
    
                                    // Insert booking details
                                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                                        insertStmt.setString(1, credentials);
                                        insertStmt.setString(2, preference);
                                        insertStmt.setString(3, ticket.getFlightNum());
                                        insertStmt.executeUpdate();
                                    }
    
                                    // Update flight to mark as booked
                                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                                        updateStmt.setString(1, ticket.getFlightNum());
                                        updateStmt.executeUpdate();
                                    }
    
                                    JOptionPane.showMessageDialog(null, "Payment successful, your flight is booked.");
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
                            }
                        }
                    }
                }
            }
        });
        add(confirmPanel); // Add the confirm button to the frame
        confirmPanel.setBackground(Color.WHITE);

        setSize(800, 600); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setVisible(true); // Set frame visibility
    }
 public FlightList(String departure, String destination, String date, String credentials, String preference, int n) throws Exception {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/airlines";
        String username = "Adm";
        String password = "xxxx";

        // SQL query using PreparedStatement
        String sql = "SELECT * FROM flight WHERE Departure = ? AND Destination = ? AND Date_of_departure = ? AND is_booked = false";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters for the query
            pstmt.setString(1, departure);
            pstmt.setString(2, destination);
            pstmt.setString(3, date);

            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                setLayout(new GridLayout(0, 1, 10, 10)); // Grid layout with appropriate gaps

                while (rs.next()) {
                    String flightNum = rs.getString("flightNum");
                    String departureCity = rs.getString("Departure");
                    String destinationCity = rs.getString("Destination");
                    String timeOfDeparture = rs.getString("Time_of_departure");
                    String timeOfArrival = rs.getString("Time_of_Arrival");
                    boolean isDirect = rs.getBoolean("is_direct");
                    int businessPrice = rs.getInt("business_price");
                    int economyPrice = rs.getInt("economy_price");

                    Ticket ticket = new Ticket(flightNum, departureCity, destinationCity, timeOfDeparture, timeOfArrival, isDirect, businessPrice, economyPrice);
                    ticketList.add(ticket); // Add ticket to the list
                    add(ticket);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setBackground(Color.WHITE);

        JButton confirmButton = new JButton(new ImageIcon("select_flight.png"));
        confirmButton.setPreferredSize(new Dimension(140,30));

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Ticket ticket : ticketList) {
                    if (ticket.isBusinessSelected() || ticket.isEconomySelected()) {
                        // Gather credit card information
                        JTextField cardNumberField = new JTextField();
                        JTextField expiryField = new JTextField();
                        JTextField cvvField = new JTextField();

                        JPanel panel = new JPanel(new GridLayout(0, 1));
                        panel.add(new JLabel("Enter Credit Card Number:"));
                        panel.add(cardNumberField);
                        panel.add(new JLabel("Enter Expiry Date (MM/YY):"));
                        panel.add(expiryField);
                        panel.add(new JLabel("Enter CVV:"));
                        panel.add(cvvField);

                        int result = JOptionPane.showConfirmDialog(null, panel, "Payment Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            String cardNumber = cardNumberField.getText();
                            String expiry = expiryField.getText();
                            String cvv = cvvField.getText();

                            // Simulate payment processing
                            boolean paymentSuccessful = processPayment(cardNumber, expiry, cvv);

                            if (paymentSuccessful) {
                                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                                    String insertSql = "INSERT INTO Bookings (credential, preference, flightNum) VALUES (?, ?, ?)";
                                    String updateSql = "UPDATE flight SET is_booked = true WHERE flightNum = ?";

                                    // Insert booking details
                                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                                        insertStmt.setString(1, credentials);
                                        insertStmt.setString(2, preference);
                                        insertStmt.setString(3, ticket.getFlightNum());
                                        insertStmt.executeUpdate();
                                    }

                                    // Update flight to mark as booked
                                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                                        updateStmt.setString(1, ticket.getFlightNum());
                                        updateStmt.executeUpdate();
                                    }

                                    JOptionPane.showMessageDialog(null, "Payment successful, your flight is booked.");
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
                            }
                        }
                    }
                }
            }
        });
        add(confirmButton); // Add the confirm button to the frame

        setSize(800, 600); // Set frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setVisible(true); // Set frame visibility
    }

    private boolean processPayment(String cardNumber, String expiry, String cvv) {
        // Simulate payment processing logic
        // This is where you would integrate with a real payment gateway
        return true; // Assume payment is always successful for this example
    }


//second constructor incase user didnt login already
//..............................................WITHOUT LOGIN CONSTRUCTOR STARTS.................................//
String flightNum;

public FlightList(String departure, String destination, String date) throws Exception {
    confirmPanel = new JPanel();
    // Load the MySQL driver
confirmPanel.setBackground(Color.WHITE);
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Database connection details
    String url = "jdbc:mysql://localhost:3306/airlines";
    String username = "Adm";
    String password = "xxxx";

    // SQL query using PreparedStatement
    String sql = "SELECT * FROM flight WHERE Departure = ? AND Destination = ? AND Date_of_departure  = ? AND is_booked = false";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Set the parameters for the query
        pstmt.setString(1, departure);
        pstmt.setString(2, destination);
        pstmt.setString(3, date);

        // Execute the query
        try (ResultSet rs = pstmt.executeQuery()) {
            setLayout(new GridLayout(0, 1, 10, 10)); // Grid layout with appropriate gaps
            while (rs.next()) {
               flightNum = rs.getString("flightNum");
                String departureCity = rs.getString("Departure");
                String destinationCity = rs.getString("Destination");
                String timeOfDeparture = rs.getString("Time_of_departure");
                String timeOfArrival = rs.getString("Time_of_Arrival");
                boolean isDirect = rs.getBoolean("is_direct");
                int businessPrice = rs.getInt("business_price");
                int economyPrice = rs.getInt("economy_price");

                Ticket ticket = new Ticket(flightNum, departureCity, destinationCity, timeOfDeparture, timeOfArrival, isDirect, businessPrice, economyPrice);
                ticketList.add(ticket); // Add ticket to the list
                add(ticket);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }



    
    getContentPane().setBackground(Color.WHITE);
confirmPanel.setBackground(Color.WHITE);
    JButton confirmButton = new JButton(new ImageIcon("select_flight.png"));
    confirmButton.setPreferredSize(new Dimension(140,30));
    confirmPanel.add(confirmButton,BorderLayout.CENTER);
    confirmButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {   
            // Display login window
            Login login = new Login(flightNum);
            login.setVisible(true);

            // Check if login is successful
            if (login.loginPressed) {
           

                for (Ticket ticket : ticketList) {
                    if (ticket.isBusinessSelected() || ticket.isEconomySelected()) {
                        // Gather credit card information
                        JTextField cardNumberField = new JTextField();
                        JTextField expiryField = new JTextField();
                        JTextField cvvField = new JTextField();

                        JPanel panel = new JPanel(new GridLayout(0, 1));
                        panel.setBackground(Color.WHITE);
                        panel.add(new JLabel("Enter Credit Card Number:"));
                        panel.add(cardNumberField);
                        panel.add(new JLabel("Enter Expiry Date (MM/YY):"));
                        panel.add(expiryField);
                        panel.add(new JLabel("Enter CVV:"));
                        panel.add(cvvField);

                        int result = JOptionPane.showConfirmDialog(null, panel, "Payment Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            String cardNumber = cardNumberField.getText();
                            String expiry = expiryField.getText();
                            String cvv = cvvField.getText();

                            // Simulate payment processing
                            boolean paymentSuccessful = processPayment(cardNumber, expiry, cvv);

                            if (paymentSuccessful) {        
                                  

                                    // Insert booking details
                                 

                                    // Update flight to mark as booked
                                   

                                    JOptionPane.showMessageDialog(null, "Payment successful, your flight is booked.");
                                }
                                
                            else {
                                JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
            }
        }
    });
  
  
 //ActionListener ends

    add(confirmPanel); // Add the confirm button to the frame

    setSize(950, 400); // Set frame size
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
    setVisible(true); // Set frame visibility
}


    //...............................WITHOUT LOGIN CONSTRUCTOR ENDS...............................//

    // Method to get the list of tickets
    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    // Method to add a radio button to the list
    public void addRadioButton(JRadioButton radioButton) {
        allRadioButtons.add(radioButton);
    }

    // Method to deselect all radio buttons except the given one
    public void deselectOtherRadioButtons(JRadioButton selectedRadioButton) {
        for (JRadioButton radioButton : allRadioButtons) {
            if (radioButton != selectedRadioButton) {
                radioButton.setSelected(false);
            }
        }
    }

    public static void main(String[] args) {
        try {
            new FlightList("Ankara", "Istanbul", "24-05-14");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
