import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OTPForm extends JFrame implements ActionListener {

    private JLabel otpLabel;
    private JTextField otpField;
    private JButton verifyButton, resendButton, cancelButton;
    
    // Simulated OTP for demo purposes
    private final String generatedOTP = "123456";

    public OTPForm() {
        setTitle("OTP Verification");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new GridLayout(4, 1, 10, 10));

        // Components
        otpLabel = new JLabel("Enter OTP sent to your number:");
        otpField = new JTextField();
        verifyButton = new JButton("Verify");
        resendButton = new JButton("Resend OTP");
        cancelButton = new JButton("Cancel");

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(verifyButton);
        buttonPanel.add(resendButton);
        buttonPanel.add(cancelButton);

        // Add components
        add(otpLabel);
        add(otpField);
        add(buttonPanel);

        // Event listeners
        verifyButton.addActionListener(this);
        resendButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String enteredOTP = otpField.getText();

        if (e.getSource() == verifyButton) {
            if (enteredOTP.equals(generatedOTP)) {
                JOptionPane.showMessageDialog(this, "OTP Verified Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close OTP window
                new VotingForm(); // Proceed to voting form
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == resendButton) {
            // In a real app, resend OTP here
            JOptionPane.showMessageDialog(this, "OTP resent successfully (Demo: 123456)", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == cancelButton) {
            dispose(); // Close the form
        }
    }

    public static void main(String[] args) {
        new OTPForm();
    }
}
