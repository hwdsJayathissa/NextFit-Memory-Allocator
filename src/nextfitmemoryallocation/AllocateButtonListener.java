package nextfitmemoryallocation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllocateButtonListener implements ActionListener {
    private JTextField memoryField;
    private JTextField processField;
    private JTextArea resultArea;

    public AllocateButtonListener(JTextField memoryField, JTextField processField, JTextArea resultArea) {
        this.memoryField = memoryField;
        this.processField = processField;
        this.resultArea = resultArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Parse memory block sizes
            String[] memoryInput = memoryField.getText().split(",");
            int[] memoryBlocks = new int[memoryInput.length];
            for (int i = 0; i < memoryInput.length; i++) {
                memoryBlocks[i] = Integer.parseInt(memoryInput[i].trim());
            }

            // Parse process sizes
            String[] processInput = processField.getText().split(",");
            int[] processSizes = new int[processInput.length];
            for (int i = 0; i < processInput.length; i++) {
                processSizes[i] = Integer.parseInt(processInput[i].trim());
            }

            // Perform allocation
            NextFitAllocator allocator = new NextFitAllocator();
            String allocationResult = allocator.allocate(memoryBlocks, processSizes);

            // Display the results
            resultArea.setText(allocationResult);
        } catch (Exception ex) {
            resultArea.setText("Error: " + ex.getMessage());
        }
    }
}
