import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {

    private JLabel userLabel, passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton, resetButton;

    public LoginForm() {
        // Frame settings
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Components
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");

        // Add action listeners
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add to frame
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
        add(resetButton);

        // Show window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (e.getSource() == loginButton) {
            // Dummy authentication (you can replace this with DB check)
            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Proceed to next screen, e.g., VotingForm
                new VotingForm(); // optional: if you have that class
                dispose(); // close login window
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        }

        if (e.getSource() == resetButton) {
            userField.setText("");
            passField.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
