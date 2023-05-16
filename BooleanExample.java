// Oracle Java code conventions: https://www.oracle.com/java/technologies/javase/codeconventions-contents.html
// Google Java code conventions: https://google.github.io/styleguide/javaguide.html

// Wild card imports use *. This is frowned upon
// but we will use less typing since we are constrained by time.

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

public class BooleanExample {    
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton leftButton, rightButton;
    private JLabel resultLabel;
    private JComboBox<String> operationChoice;
    private GridLayout mainGridLayout;
    private GridLayout topGridLayout;
    private GridLayout bottomGridLayout;

    private Color bgColor = Color.black;
    private Color offColor = Color.gray;
    private Color onColor = Color.cyan;

    public BooleanExample() {
        frame = new JFrame();
        mainPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        
        frame.setTitle("Visual Bools");
        frame.setSize(360, 170);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);

        mainGridLayout = new GridLayout(0, 1, 5, 5);
        mainPanel.setLayout(mainGridLayout);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(topPanel);
        mainPanel.add(bottomPanel);
        mainPanel.setBackground(bgColor);

        topGridLayout = new GridLayout(0, 3, 5, 5);
        topPanel.setLayout(topGridLayout);
        topPanel.setBackground(bgColor);

        leftButton = new JButton("false");
        leftButton.setBackground(offColor);
        leftButton.setActionCommand("leftButton");
        leftButton.addActionListener(new CalculateAction());
        topPanel.add(leftButton);

        String[] choices = {"and", "or", "xor"};
        operationChoice = new JComboBox<String>(choices);
        operationChoice.setBackground(offColor);
        operationChoice.setActionCommand("operactionChoice");
        operationChoice.addActionListener(new CalculateAction());
        topPanel.add(operationChoice);

        rightButton = new JButton("false");
        rightButton.setBackground(offColor);
        rightButton.setActionCommand("rightButton");
        rightButton.addActionListener(new CalculateAction());
        topPanel.add(rightButton);

        bottomGridLayout = new GridLayout(0, 1, 5, 5);
        bottomPanel.setLayout(bottomGridLayout);
        bottomPanel.setBackground(bgColor);

        resultLabel = new JLabel("false", SwingConstants.CENTER);
        resultLabel.setBackground(offColor);
        resultLabel.setOpaque(true);
        bottomPanel.add(resultLabel);
        
        frame.setVisible(true);      
    }

    private class CalculateAction implements ActionListener {        
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action == "leftButton" || action == "rightButton") {
                JButton button = (JButton)e.getSource();
    
                if (Boolean.parseBoolean(button.getText()) && button != null) {
                    button.setText("false");
                    button.setBackground(offColor);
                } else {                
                    button.setText("true");
                    button.setBackground(onColor);
                }
            }
            processResults();
        }        
    }

    private void processResults() {
        boolean leftButtonValue = Boolean.parseBoolean(leftButton.getText());
        boolean rightButtonValue = Boolean.parseBoolean(rightButton.getText());

        String operation = operationChoice.getSelectedItem().toString();
        boolean resultValue = false;
        
        // switch (operation) {
        //     case "and":
        //         resultValue = leftButtonValue && rightButtonValue;
        //         break;
        //     case "or":
        //         resultValue = leftButtonValue || rightButtonValue;
        //         break;
        //     case "xor":
        //         resultValue = leftButtonValue ^ rightButtonValue;
        //         break;
        // }

        if (operation == "and") {
            resultValue = leftButtonValue && rightButtonValue;
        } else if (operation == "or") {
            resultValue = leftButtonValue || rightButtonValue;
        } else {
            resultValue = leftButtonValue ^ rightButtonValue;
        }

        if (resultValue) {
            resultLabel.setText("true");
            resultLabel.setBackground(Color.CYAN);
        } else {
            resultLabel.setText("false");
            resultLabel.setBackground(Color.GRAY);
        }
    }

    public static void main(String[] args) {
        new BooleanExample();
    }
}
