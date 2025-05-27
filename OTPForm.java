import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OTPForm extends JFrame {
    private JTextField otpField;
    private JButton verifyButton, resendButton;

    public OTPForm() {
        setTitle("OTP Verification");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Create components
        JLabel otpLabel = new JLabel("Enter OTP:");
        otpField = new JTextField(10);
        verifyButton = new JButton("Verify");
        resendButton = new JButton("Resend OTP");

        // Layout setup
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(otpLabel, gbc);
        gbc.gridx = 1;
        panel.add(otpField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(verifyButton, gbc);
        gbc.gridx = 1;
        panel.add(resendButton, gbc);

        add(panel);

        // Action listeners
        verifyButton.addActionListener(e -> handleVerify());
        resendButton.addActionListener(e -> handleResend());
    }

    private void handleVerify() {
        String enteredOTP = otpField.getText();

        // Dummy check (replace with actual OTP logic)
        if (enteredOTP.equals("123456")) {
            JOptionPane.showMessageDialog(this, "OTP Verified!");
            // Proceed to next step (e.g., open VotingForm)
        } else {
            JOptionPane.showMessageDialog(this, "Invalid OTP!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleResend() {
        // Dummy action — replace with your resend logic
        JOptionPane.showMessageDialog(this, "OTP has been resent.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OTPForm().setVisible(true));
    }
}
