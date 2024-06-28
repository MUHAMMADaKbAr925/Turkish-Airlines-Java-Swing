import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MilesAndSmilesEnrollmentForm extends JFrame {

    public MilesAndSmilesEnrollmentForm() {
        setTitle("Miles&Smiles Membership Enrollment");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
panel.setBackground(Color.WHITE);
        // Set padding between components
        c.insets = new Insets(5, 5, 5, 5);

        // Heading: Miles&Smiles Membership Enrollment
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        panel.add(new JLabel("Miles&Smiles Membership Enrollment"), c);
        c.gridwidth = 1;

        JTextField firstNameField = new JTextField("First / Middle name (as shown on ID):");
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        panel.add(firstNameField, c);
        addFocusListenerToTextField(firstNameField, "First / Middle name (as shown on ID):");

        JTextField surnameField = new JTextField("Surname (as shown on ID):");
        c.gridx = 1;
        c.gridy = 1;
        panel.add(surnameField, c);
        addFocusListenerToTextField(surnameField, "Surname (as shown on ID):");

        JTextField languageField = new JTextField("Language:");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(languageField, c);
        addFocusListenerToTextField(languageField, "Language:");

        JTextField nationalityField = new JTextField("Nationality:");
        c.gridx = 1;
        c.gridy = 2;
        panel.add(nationalityField, c);
        addFocusListenerToTextField(nationalityField, "Nationality:");

        JTextField dobField = new JTextField("Date of birth (DD/MM/YYYY):");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(dobField, c);
        addFocusListenerToTextField(dobField, "Date of birth (DD/MM/YYYY):");

        JTextField titleField = new JTextField("Gender:M/F");
        c.gridx = 1;
        c.gridy = 3;
        panel.add(titleField, c);
        addFocusListenerToTextField(titleField, "Gender:M/F");

        // Heading: Contact Details
        c.gridx = 0;
        c.gridy = 4;
        panel.add(new JLabel("---------------------------------"), c);
        c.gridy = 5;
        panel.add(new JLabel("Contact Details"), c);

        JTextField countryField = new JTextField("Country / Region:");
        c.gridx = 0;
        c.gridy = 6;
        panel.add(countryField, c);
        addFocusListenerToTextField(countryField, "Country / Region:");

        JTextField cityField = new JTextField("City:");
        c.gridx = 1;
        c.gridy = 6;
        panel.add(cityField, c);
        addFocusListenerToTextField(cityField, "City:");

        JTextField zipField = new JTextField("Zip/Postal code:");
        c.gridx = 0;
        c.gridy = 7;
        panel.add(zipField, c);
        addFocusListenerToTextField(zipField, "Zip/Postal code:");

        JTextField addressField = new JTextField("Address:");
        c.gridx = 1;
        c.gridy = 7;
        panel.add(addressField, c);
        addFocusListenerToTextField(addressField, "Address:");

        JTextField emailField = new JTextField("Email address:");
        c.gridx = 0;
        c.gridy = 8;
        panel.add(emailField, c);
        addFocusListenerToTextField(emailField, "Email address:");

        JTextField areaCodeField = new JTextField("Area code:");
        c.gridx = 1;
        c.gridy = 8;
        panel.add(areaCodeField, c);
        addFocusListenerToTextField(areaCodeField, "Area code:");

        JTextField mobileField = new JTextField("Mobile number:");
        c.gridx = 0;
        c.gridy = 9;
        panel.add(mobileField, c);
        addFocusListenerToTextField(mobileField, "Mobile number:");

        // Heading: Security Details
        c.gridx = 0;
        c.gridy = 10;
        panel.add(new JLabel("---------------------------------"), c);
        c.gridy = 11;
        panel.add(new JLabel("Security Details"), c);

        JTextField passwordField = new JTextField("Create password:");
        c.gridx = 0;
        c.gridy = 12;
        panel.add(passwordField, c);
        addFocusListenerToTextField(passwordField, "Create password:");

        c.gridx = 1;
        c.gridy = 12;
        panel.add(new JLabel("Confirm password:"), c);

        JTextField confirmPasswordField = new JTextField("Confirm password:");
        c.gridx = 2;
        c.gridy = 12;
        panel.add(confirmPasswordField, c);
        addFocusListenerToTextField(confirmPasswordField, "Confirm password:");

        JTextField securityQuestionField = new JTextField("Choose a security question:");
        c.gridx = 0;
        c.gridy = 13;
        c.gridwidth = 3;
        panel.add(securityQuestionField, c);
        addFocusListenerToTextField(securityQuestionField, "Choose a security question:");

        JTextField securityAnswerField = new JTextField("Answer to security question:");
        c.gridx = 0;
        c.gridy = 14;
        c.gridwidth = 3;
        panel.add(securityAnswerField, c);
        addFocusListenerToTextField(securityAnswerField, "Answer to security question:");

        // Add a button
        JButton submitButton = new JButton(new ImageIcon("create_msacc.png"));
        c.gridx = 1;
        c.gridy = 15;
        submitButton.setPreferredSize(new Dimension(350,50));
        panel.add(submitButton, c);

        getContentPane().add(panel);
        setVisible(true);
    }

    private void addFocusListenerToTextField(JTextField textField, String defaultText) {
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(defaultText)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(defaultText);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MilesAndSmilesEnrollmentForm::new);
    }
}

