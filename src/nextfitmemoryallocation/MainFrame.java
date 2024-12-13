package nextfitmemoryallocation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextField memoryField;
    private JTextField processField;
    private JTextArea resultArea;

    public MainFrame() {
        setTitle("Next Fit Memory Allocator");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create UI Components
        createResultPanel(); // Initialize resultArea first
        createInputPanel(); // Then pass resultArea to AllocateButtonListener

        setVisible(true);
    }

    private void createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel memoryLabel = new JLabel("Enter Memory Block Sizes (comma-separated):");
        memoryField = new JTextField();

        JLabel processLabel = new JLabel("Enter Process Sizes (comma-separated):");
        processField = new JTextField();

        JButton allocateButton = new JButton("Allocate Memory");
        allocateButton.addActionListener(new AllocateButtonListener(memoryField, processField, resultArea));

        inputPanel.add(memoryLabel);
        inputPanel.add(memoryField);
        inputPanel.add(processLabel);
        inputPanel.add(processField);
        inputPanel.add(new JLabel()); // Spacer
        inputPanel.add(allocateButton);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void createResultPanel() {
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        JLabel resultLabel = new JLabel("Memory Allocation Results:");
        resultArea = new JTextArea(15, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        add(resultPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
