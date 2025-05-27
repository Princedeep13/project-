import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterForm extends JFrame implements ActionListener {

    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, resetButton, cancelButton;

    public RegisterForm() {
        setTitle("User Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Create UI components
        JLabel usernameLabel = new JLabel("Username:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");

        usernameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        registerButton = new JButton("Register");
        resetButton = new JButton("Reset");
        cancelButton = new JButton("Cancel");

        // Add listeners
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // Add components to frame
        add(usernameLabel); add(usernameField);
        add(emailLabel); add(emailField);
        add(passwordLabel); add(passwordField);
        add(confirmPasswordLabel); add(confirmPasswordField);
        add(registerButton); add(resetButton);
        add(new JLabel()); add(cancelButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // In real app: save to DB
                JOptionPane.showMessageDialog(this, "Registered Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // close registration form
                new LoginForm(); // proceed to login form
            }
        }

        if (e.getSource() == resetButton) {
            usernameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
        }

        if (e.getSource() == cancelButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new RegisterForm();
    }
}
