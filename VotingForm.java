import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VotingForm extends JFrame implements ActionListener {

    private JLabel heading;
    private JRadioButton option1, option2, option3;
    private JButton submitButton, resetButton, exitButton;
    private ButtonGroup candidatesGroup;

    public VotingForm() {
        // Window settings
        setTitle("Voting Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Layout setup
        setLayout(new GridLayout(7, 1));

        // Heading
        heading = new JLabel("Select Your Candidate", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading);

        // Radio buttons
        option1 = new JRadioButton("Candidate 1");
        option2 = new JRadioButton("Candidate 2");
        option3 = new JRadioButton("Candidate 3");

        candidatesGroup = new ButtonGroup();
        candidatesGroup.add(option1);
        candidatesGroup.add(option2);
        candidatesGroup.add(option3);

        add(option1);
        add(option2);
        add(option3);

        // Buttons
        submitButton = new JButton("Submit Vote");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);
        add(buttonPanel);

        // Action listeners
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Make visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == submitButton) {
            String selected = null;
            if (option1.isSelected()) selected = option1.getText();
            else if (option2.isSelected()) selected = option2.getText();
            else if (option3.isSelected()) selected = option3.getText();

            if (selected != null) {
                JOptionPane.showMessageDialog(this,
                    "You voted for: " + selected,
                    "Vote Submitted",
                    JOptionPane.INFORMATION_MESSAGE);
                candidatesGroup.clearSelection(); // Clear after voting
            } else {
                JOptionPane.showMessageDialog(this,
                    "Please select a candidate!",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            }
        }

        else if (source == resetButton) {
            candidatesGroup.clearSelection();
        }

        else if (source == exitButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new VotingForm();
    }
}

