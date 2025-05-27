import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class ResultForm extends JFrame {

    public ResultForm(Map<String, Integer> voteResults) {
        setTitle("Voting Results");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Convert Map to table data
        String[] columnNames = { "Candidate", "Votes" };
        Object[][] data = new Object[voteResults.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : voteResults.entrySet()) {
            data[i][0] = entry.getKey();
            data[i][1] = entry.getValue();
            i++;
        }

        // Create table model and JTable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add to frame
        add(scrollPane, BorderLayout.CENTER);
    }

    // Sample usage with static data
    public static void main(String[] args) {
        Map<String, Integer> sampleResults = Map.of(
            "Alice", 120,
            "Bob", 85,
            "Charlie", 65
        );

        SwingUtilities.invokeLater(() -> new ResultForm(sampleResults).setVisible(true));
    }
}
