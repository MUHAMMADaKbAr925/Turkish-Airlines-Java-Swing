import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.stream.Collectors;
public class SIgnUp extends JFrame {
private JPanel firstPanel;
private JPanel secondPanel;
private JPanel thirdPanel;
// private JPanel maiPanel;

    private JTextField firstNameField;
    private JTextField surnameField;
    private JTextField languageField;
    private JTextField nationalityField;
    private JTextField dobField;
    private JTextField titleField;
    private JTextField countryField;
    private JTextField trId;
    private JTextField cityField;
    private JTextField zipField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField areaCodeField;
    private JTextField mobileField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JTextField securityQuestionField;
    private JTextField securityAnswerField;
    JTextField[] fields = {
        firstNameField,
        surnameField,
        languageField,
        nationalityField,
        dobField,
        titleField,
        countryField,
        trId,
        cityField,
        zipField,
        addressField,
        emailField,
        areaCodeField,
        mobileField,
        passwordField,
        confirmPasswordField,
        securityQuestionField,
        securityAnswerField
};
String[] fieldTexts = {
    "First / Middle name (as shown on ID):",
    "Surname (as shown on ID):",
    "Language:",
    "Nationality:",
    "Date of birth (DD/MM/YYYY):",
    "Gender:M/F",
    "Country / Region:",
    "Turkish ID",
    "City:",
    "Zip/Postal code:",
    "Address:",
    "Email address:",
    "Area code:",
    "Mobile number:",
    "Create password:",
    "Confirm password:",
    "Choose a security question:",
    "Answer to security question:"
};public String[] userData= new String[fieldTexts.length];

private JPanel firstNamePanel;
private JPanel surnamePanel;
private JPanel languagePanel;
private JPanel nationalityPanel;
private JPanel dobPanel;
private JPanel titlePanel;
private JPanel countryPanel;
private JPanel trIdPanel;
private JPanel cityPanel;
private JPanel zipPanel;
private JPanel addressPanel;
private JPanel emailPanel;
private JPanel areaCodePanel;
private JPanel mobilePanel;
private JPanel passwordPanel;
private JPanel confirmPasswordPanel;
private JPanel securityQuestionPanel;
private JPanel securityAnswerPanel;
JPanel[] panels = {
    firstNamePanel,
    surnamePanel,
    languagePanel,
    nationalityPanel,
    dobPanel,
    titlePanel,
    countryPanel,
    trIdPanel,
    cityPanel,
    zipPanel,
    addressPanel,
    emailPanel,
    areaCodePanel,
    mobilePanel,
    passwordPanel,
    confirmPasswordPanel,
    securityQuestionPanel,
    securityAnswerPanel
};
private JLabel firstNameLabel;
    private JLabel surnameLabel;
    private JLabel languageLabel;
    private JLabel nationalityLabel;
    private JLabel dobLabel;
    private JLabel titleLabel;
    private JLabel countryLabel;
    private JLabel trIdLabel;
    private JLabel cityLabel;
    private JLabel zipLabel;
    private JLabel addressLabel;
    private JLabel emailLabel;
    private JLabel areaCodeLabel;
    private JLabel mobileLabel;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JLabel securityQuestionLabel;
    private JLabel securityAnswerLabel;
    JLabel[] labels = {
        firstNameLabel,
        surnameLabel,
        languageLabel,
        nationalityLabel,
        dobLabel,
        titleLabel,
        countryLabel,
        trIdLabel,
        cityLabel,
        zipLabel,
        addressLabel,
        emailLabel,
        areaCodeLabel,
        mobileLabel,
        passwordLabel,
        confirmPasswordLabel,
        securityQuestionLabel,
        securityAnswerLabel
};



public SIgnUp() {
    setLayout(new GridLayout(4,0));

    // Initialize panels
    firstPanel = new JPanel(new GridLayout(3, 2, 3, 3));
    secondPanel = new JPanel(new GridLayout(3, 2, 3, 3));
    thirdPanel = new JPanel(new GridLayout(3, 2, 3, 3));

    // Add components to the first panel
    for (int i = 0; i < 6; i++) { // We need only 6 components for the first panel
        fields[i] = new JTextField();
        fields[i].setText("cc");

        panels[i] = new JPanel(new GridLayout(2, 1,5,5));
        labels[i] = new JLabel(fieldTexts[i] + "");
        focusBorder(fields[i],labels[i]);
        panels[i].add(labels[i]);
        panels[i].add(fields[i]);
        firstPanel.add(panels[i]);
    }

    // Add components to the second panel
    for (int i = 6; i < 12; i++) {
        fields[i] = new JTextField(); 
        fields[i].setText("cc");
  
             labels[i] = new JLabel(fieldTexts[i] + "");

        focusBorder(fields[i],labels[i]);
        panels[i] = new JPanel(new GridLayout(2, 1,5,5));
        panels[i].add(labels[i]);
        panels[i].add(fields[i]);
        secondPanel.add(panels[i]);
    }

    // Add components to the third panel
    for (int i = 12; i < 18; i++) {
        fields[i] = new JTextField();     
        fields[i].setText("cc");

           labels[i] = new JLabel(fieldTexts[i] + "");

        focusBorder(fields[i],labels[i]);
        panels[i] = new JPanel(new GridLayout(2, 1,5,5));
        panels[i].add(labels[i]);
        panels[i].add(fields[i]);
        thirdPanel.add(panels[i]);
    }
    JPanel submitPanel= new JPanel(new FlowLayout());

    JButton submitButton = new JButton(new ImageIcon("create_msacc.png"));
    submitButton.setPreferredSize(new Dimension(350,50));
    submitPanel.add(submitButton);
    
// maiPanel= new JPanel();
    // maiPanel.setLayout(new GridLayout(3,1,3,0));
setBackground(Color.WHITE);
    // Add panels to the frame
   add(firstPanel);
   add(secondPanel);
   add(thirdPanel);
   add(submitPanel);
//    add(maiPanel);

submitButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
for(int i=0;i<fieldTexts.length;i++){
   userData[i]= fields[i].getText();

}
int length = 10;
RandomStringGenerator rsg = new RandomStringGenerator();
        String randomString = rsg.generateRandomString(length);
        try {
            insertUserData(userData,randomString);
            JOptionPane.showMessageDialog(SIgnUp.this, "Signup successful.\nYour MilesAndSmiles code is: " + randomString);


        } catch (Exception ex) {
            // TODO: handle exception
ex.printStackTrace();
JOptionPane.showMessageDialog(SIgnUp.this, "Error occurred while signing up.");

        }

        
    }
});
}
public void focusBorder(JTextField field,JLabel label) {
    label.setForeground(Color.BLUE);
    field.addFocusListener(new FocusListener() {
        public void focusGained(FocusEvent e) {
            field.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        }

        public void focusLost(FocusEvent e) {
            if (field.getText().isEmpty()) {
                field.setBorder(BorderFactory.createLineBorder(Color.RED));
            } else {
                field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
    });
 
}


private void insertUserData(String[] values, String milesAndSmiles) throws SQLException {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines", "Adm", "xxxx");
        String sql = "INSERT INTO User () VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setString(i + 1, values[i]);
        }
        preparedStatement.setString(values.length + 1, milesAndSmiles); // Set milesAndSmiles separately
        preparedStatement.executeUpdate();
    } finally {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}


public static void main(String[] args) {
    
SIgnUp frame= new SIgnUp();
frame.setVisible(true);
frame.setLocationRelativeTo(null);
frame.pack();
frame.setSize(800,800);





}
}
 class RandomStringGenerator {

    public static String generateRandomString(int length) {
        return new Random().ints(length, 0, 62)
                .mapToObj(i -> Character.toString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(i)))
                .collect(Collectors.joining());
    }}