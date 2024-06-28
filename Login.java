import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame {
Boolean loginPressed;
    public JComboBox<String> membershipOptions;
    public JTextField signInPreferenceField;
    public JLabel signInPreferenceLabel;

    public Login() {
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel using BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Panel for input fields using GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(4, 1, 6, 6));
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Heading: Sign-in preferences
        JLabel preferencesTitle = new JLabel("<html><b>Sign-in preferences</b></html>");
        preferencesTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        inputPanel.add(preferencesTitle);

        // Membership Number drop-down menu
        String[] options = {"Membership number", "Email address", "Turkish ID number"};
        membershipOptions = new JComboBox<>(options);

        membershipOptions.setBorder(null);

        inputPanel.add(membershipOptions);

        // Sign-in preference input field
        signInPreferenceField = new JTextField("Membership Number");
        signInPreferenceField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                signInPreferenceField.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (signInPreferenceField.getText().isEmpty())
                    signInPreferenceField.setText((String) membershipOptions.getSelectedItem());
            }
        });
        inputPanel.add(signInPreferenceField);

        // Password field
        JTextField passwordField = new JTextField("Password");
        // passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty())
                    passwordField.setText((String) "Password");
            }
        });
        inputPanel.add(passwordField);

        // Panel for buttons using FlowLayout
        JPanel buttonPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBackground(Color.WHITE);
        // Forgot password link
        JButton forgotPasswordButton = new JButton(new ImageIcon("forgot_pasword.png"));
        forgotPasswordButton.setForeground(Color.RED);
        forgotPasswordButton.setPreferredSize(new Dimension(135, 30));
        forgotPasswordButton.setBackground(Color.WHITE);
        buttonPanel.add(forgotPasswordButton, BorderLayout.EAST);
        buttonPanel.setBackground(Color.WHITE);
        // Login button
        JButton loginButton = new JButton(new ImageIcon("sign_in.png"));
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);
            loginButton.setPreferredSize(new Dimension(100,70));
            loginButton.setBackground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(100, 70));
        loginButton.setBackground(Color.WHITE);
        buttonPanel.add(loginButton, BorderLayout.SOUTH);
        buttonPanel.setBackground(Color.WHITE);
        membershipOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update signInPreferenceField based on selected item in JComboBox
                signInPreferenceField.setText((String) membershipOptions.getSelectedItem());
            }
        });
        setVisible(true);

        // ActionListener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected option
                String selectedOption = (String) membershipOptions.getSelectedItem();
                // Get entered username and password
                String username = signInPreferenceField.getText();
                String password = passwordField.getText();

                // Execute database operations asynchronously
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Call the login method
                        login(selectedOption, username, password);
                        return null;
                    }
                };
                worker.execute();
                loginPressed=true;
            }
        });
    }
    public Login(String flightNum) {
        setTitle("Login");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel using BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        // Panel for input fields using GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(4, 1, 6, 6));
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Heading: Sign-in preferences
        JLabel preferencesTitle = new JLabel("<html><b>Sign-in preferences</b></html>");
        preferencesTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        inputPanel.add(preferencesTitle);

        // Membership Number drop-down menu
        String[] options = {"Membership number", "Email address", "Turkish ID number"};
        membershipOptions = new JComboBox<>(options);

        membershipOptions.setBorder(null);

        inputPanel.add(membershipOptions);

        // Sign-in preference input field
        signInPreferenceField = new JTextField("Membership Number");
        signInPreferenceField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                signInPreferenceField.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (signInPreferenceField.getText().isEmpty())
                    signInPreferenceField.setText((String) membershipOptions.getSelectedItem());
            }
        });
        inputPanel.add(signInPreferenceField);

        // Password field
        JTextField passwordField = new JTextField("Password");
        // passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setText("");

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty())
                    passwordField.setText((String) "Password");
            }
        });
        inputPanel.add(passwordField);

        // Panel for buttons using FlowLayout
        JPanel buttonPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBackground(Color.WHITE);
        // Forgot password link
        JButton forgotPasswordButton = new JButton(new ImageIcon("forgot_pasword.png"));
        forgotPasswordButton.setForeground(Color.RED);
        forgotPasswordButton.setPreferredSize(new Dimension(135, 30));
        forgotPasswordButton.setBackground(Color.WHITE);
        buttonPanel.add(forgotPasswordButton, BorderLayout.EAST);
        buttonPanel.setBackground(Color.WHITE);
        // Login button
        JButton loginButton = new JButton(new ImageIcon("sign_in.png"));
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);
            loginButton.setPreferredSize(new Dimension(100,70));
            loginButton.setBackground(Color.WHITE);
        loginButton.setPreferredSize(new Dimension(100, 70));
        loginButton.setBackground(Color.WHITE);
        buttonPanel.add(loginButton, BorderLayout.SOUTH);
        buttonPanel.setBackground(Color.WHITE);
        membershipOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update signInPreferenceField based on selected item in JComboBox
                signInPreferenceField.setText((String) membershipOptions.getSelectedItem());
            }
        });
        setVisible(true);

        // ActionListener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected option
                String selectedOption = (String) membershipOptions.getSelectedItem();
                // Get entered username and password
                String username = signInPreferenceField.getText();
                String password = passwordField.getText();

                // Execute database operations asynchronously
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Call the login method
                        login1(selectedOption, username, password,flightNum);
                        return null;
                    }
                };
                worker.execute();
                loginPressed=true;
            }
        });
    }

    // Method to perform login
    private void login(String selectedOption, String username, String password) {
        String url = "jdbc:mysql://localhost:3306/airlines";
        String dbUsername = "Adm";
        String dbPassword = "xxxx";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword)) {
            String sql;
            switch (selectedOption) {
                case "Membership number":
                    sql = "SELECT * FROM User WHERE MilesAndSmilesUsername=?";
                    break;
                case "Email address":
                    sql = "SELECT * FROM User WHERE email=?";
                    break;
                case "Turkish ID number":
                    sql = "SELECT * FROM User WHERE trId=?";
                    break;
                default:
                    return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String storedPassword = rs.getString("password");
                        if (storedPassword.equals(password)) {
                            JOptionPane.showMessageDialog(null, "Login Successful");
                            String credential;
                            switch (selectedOption) {
                                case "Membership number":
                                    credential = signInPreferenceField.getText();
                                    TurkishAirlinesFrame mainFrame = new TurkishAirlinesFrame(credential, "membership number");
                                    mainFrame.setVisible(true);
                                    
                                    break;
                                case "Email address":
                                credential = signInPreferenceField.getText();
                                TurkishAirlinesFrame mainFrame1 = new TurkishAirlinesFrame(credential, "Email address");
                                mainFrame1.setVisible(true);

                                    break;
                                case "Turkish ID number":
                                credential = signInPreferenceField.getText();
                                TurkishAirlinesFrame mainFrame2 = new TurkishAirlinesFrame(credential, "Turkish ID number");
                                mainFrame2.setVisible(true);

                                    break;
                                default:
                                    return;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Password");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "User not found");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
        }
    setBackground(Color.WHITE);
    }


    private void login1(String selectedOption, String username, String password, String flightNum) {
        String url = "jdbc:mysql://localhost:3306/airlines";
        String dbUsername = "Adm";
        String dbPassword = "xxxx";
    
        String sql = "";
        String credential = "";
        switch (selectedOption) {
            case "Membership number":
                sql = "SELECT * FROM User WHERE MilesAndSmilesUsername=?";
                credential = username; // Assuming username is the membership number
                break;
            case "Email address":
                sql = "SELECT * FROM User WHERE email=?";
                credential = username; // Assuming username is the email
                break;
            case "Turkish ID number":
                sql = "SELECT * FROM User WHERE trId=?";
                credential = username; // Assuming username is the Turkish ID number
                break;
            default:
                return;
        }
    
        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, credential);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (storedPassword.equals(password)) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        // Insert booking details including the flight number
                        try (PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO Bookings (credential, preference, flightNum) VALUES (?, ?, ?)")) {
                            insertStmt.setString(1, credential);
                            insertStmt.setString(2, selectedOption);
                            insertStmt.setString(3, flightNum);
                            insertStmt.executeUpdate();
                        }
                        // Update flight status
                        try (PreparedStatement updateStmt = conn.prepareStatement("UPDATE flight SET is_booked = true WHERE flightNum = ?")) {
                            updateStmt.setString(1, flightNum);
                            updateStmt.executeUpdate();
                        }
                    
                    CreditCardFrame ccf = new CreditCardFrame();
                    ccf.setVisible(true);
                    ccf.setSize(400,250);
                    ccf.setLocationRelativeTo(null);

                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User not found");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while processing your request.");
        }
        setBackground(Color.WHITE);
        loginPressed=true;
    }
   
    
    public static void main(String[] args) {
       Login log = new Login("1111111117");
       log.setVisible(true);
}
}