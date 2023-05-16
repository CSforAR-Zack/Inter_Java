
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private int count = 0;
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton button;

    public Main() {
        frame = new JFrame();

        button = new JButton("Add");
        button.setActionCommand("add");
        button.addActionListener(new Add());

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My GUI");
        frame.pack();
        frame.setVisible(true);
    }
    
    class Add implements ActionListener {     
        public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("Number of clicks: " + count);
        }
    }

    public static void main(String[] args){
        new Main();
    }
}
