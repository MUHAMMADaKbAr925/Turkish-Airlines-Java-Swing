import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCardFrame extends JFrame {

    private JTextField cardNumberField;
    private JTextField expiryField;
    private JTextField cvvField;

    public CreditCardFrame() {
        setTitle("Payment Information");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2));

        JLabel cardNumberLabel = new JLabel("Credit Card Number:");
        cardNumberField = new JTextField(20);

        JLabel expiryLabel = new JLabel("Expiry Date (MM/YY):");
        expiryField = new JTextField(5);

        JLabel cvvLabel = new JLabel("CVV:");
        cvvField = new JTextField(3);

        inputPanel.add(cardNumberLabel);
        inputPanel.add(cardNumberField);
        inputPanel.add(expiryLabel);
        inputPanel.add(expiryField);
        inputPanel.add(cvvLabel);
        inputPanel.add(cvvField);

        JPanel buttonPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your confirmation logic here
            }
        });
        buttonPanel.add(confirmButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Payment successfull, Your flight is booked");
                dispose();
            }
        });

        getContentPane().add(mainPanel);
        setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CreditCardFrame();
            }
        });
    }
}
