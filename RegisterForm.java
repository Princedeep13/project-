import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterForm extends JFrame {
    private JTextField nameField, emailField, usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, clearButton;

    public RegisterForm() {
        setTitle("User Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen

        // Components
        JLabel nameLabel = new JLabel("Full Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");

        nameField = new JTextField(15);
        emailField = new JTextField(15);
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        confirmPasswordField = new JPasswordField(15);

        registerButton = new JButton("Register");
        clearButton = new JButton("Clear");

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(usernameLabel, gbc);
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        panel.add(confirmPasswordField, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(registerButton, gbc);
        gbc.gridx = 1;
        panel.add(clearButton, gbc);

        add(panel);

        // Actions
        registerButton.addActionListener(e -> handleRegister());
        clearButton.addActionListener(e -> clearFields());
    }

    private void handleRegister() {
        String name = nameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

        if (name.isEmpty() || email.isEmpty() || username.isEmpty() ||
            password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // TODO: Save user data to file/database
        JOptionPane.showMessageDialog(this, "Registration Successful!");
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegisterForm().setVisible(true));
    }
}
