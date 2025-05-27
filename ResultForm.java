import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultForm extends JFrame implements ActionListener {

    private JLabel resultLabel;
    private JTextArea resultArea;
    private JButton refreshButton, closeButton;

    // Dummy vote counts for demonstration
    private int candidate1Votes = 10;
    private int candidate2Votes = 7;
    private int candidate3Votes = 5;

    public ResultForm() {
        setTitle("Voting Results");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        resultLabel = new JLabel("Election Result Summary", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        refreshButton = new JButton("Refresh");
        closeButton = new JButton("Close");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        buttonPanel.add(closeButton);

        add(resultLabel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        refreshButton.addActionListener(this);
        closeButton.addActionListener(this);

        updateResults(); // Initial load

        setVisible(true);
    }

    private void updateResults() {
        StringBuilder sb = new StringBuilder();
        sb.append("Candidate 1: ").append(candidate1Votes).append(" votes\n");
        sb.append("Candidate 2: ").append(candidate2Votes).append(" votes\n");
        sb.append("Candidate 3: ").append(candidate3Votes).append(" votes\n");

        // Optional: Show winner
        int maxVotes = Math.max(candidate1Votes, Math.max(candidate2Votes, candidate3Votes));
        String winner = "";
        if (candidate1Votes == maxVotes) winner = "Candidate 1";
        if (candidate2Votes == maxVotes) winner = "Candidate 2";
        if (candidate3Votes == maxVotes) winner = "Candidate 3";

        sb.append("\nWinner: ").append(winner);
        resultArea.setText(sb.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == refreshButton) {
            updateResults(); // In real app, re-fetch from DB
        }
        if (e.getSource() == closeButton) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new ResultForm();
    }
}
