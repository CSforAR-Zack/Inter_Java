
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private JFrame frame;

    private JPanel stackPanel;
    private JPanel queuePanel;
    private JPanel structuresPanel;
    private JPanel startButtonPanel;
    private JPanel stackButtonPanel;
    private JPanel queueButtonPanel;

    private Stack stack;
    private Queue queue;

    private JButton createStackButton;
    private JButton createQueueButton;
    private JButton pushButton;
    private JButton popButton;
    private JButton enqueueButton;
    private JButton dequeueButton;

    public Main() {
        frame = new JFrame();

        stackPanel = new JPanel();
        stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));

        queuePanel = new JPanel();
        queuePanel.setLayout(new BoxLayout(queuePanel, BoxLayout.X_AXIS));

        structuresPanel = new JPanel();
        structuresPanel.setLayout(new BoxLayout(structuresPanel, BoxLayout.X_AXIS));
        structuresPanel.add(stackPanel);
        structuresPanel.add(queuePanel);
        
        pushButton = new JButton("Push");
        pushButton.addActionListener(new Push());
        pushButton.setVisible(false);

        popButton = new JButton("Pop");
        popButton.addActionListener(new Pop());
                

        enqueueButton = new JButton("Enqueue");
        enqueueButton.addActionListener(new Enqueue());

        dequeueButton = new JButton("Dequeue");
        dequeueButton.addActionListener(new Dequeue());

        stackButtonPanel = new JPanel();
        stackButtonPanel.setLayout(new BoxLayout(stackButtonPanel, BoxLayout.X_AXIS));
        stackButtonPanel.add(pushButton);
        stackButtonPanel.add(popButton);

        queueButtonPanel = new JPanel();
        queueButtonPanel.setLayout(new BoxLayout(queueButtonPanel, BoxLayout.X_AXIS));
        queueButtonPanel.add(enqueueButton);
        queueButtonPanel.add(dequeueButton);        

        createStackButton = new JButton("Create Stack");
        createStackButton.addActionListener(new CreateStack());
        
        createQueueButton = new JButton("Create Queue");
        createQueueButton.addActionListener(new CreateQueue());

        startButtonPanel = new JPanel();
        startButtonPanel.setLayout(new BoxLayout(startButtonPanel, BoxLayout.X_AXIS));
        startButtonPanel.add(createStackButton);
        startButtonPanel.add(createQueueButton);
        
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(structuresPanel);
        frame.add(stackButtonPanel);
        frame.add(queueButtonPanel);
        frame.add(startButtonPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stacks and Queues");
        frame.pack();
        frame.setVisible(true);
    }
    
    private class CreateStack implements ActionListener {     
        public void actionPerformed(ActionEvent event) {
            stack = new Stack();
        }
    }

    private class CreateQueue implements ActionListener {     
        public void actionPerformed(ActionEvent event) {
        }
    }

    private class Push implements ActionListener {     
        public void actionPerformed(ActionEvent event) {
        }
    }

    private class Pop implements ActionListener {     
        public void actionPerformed(ActionEvent event) {
        }
    }

    private class Enqueue implements ActionListener {     
        public void actionPerformed(ActionEvent event) {
        }
    }

    private class Dequeue implements ActionListener {     
        public void actionPerformed(ActionEvent event) {
        }
    }

    public static void main(String[] args){
        new Main();
    }
}

// CSPG.Y2.3.1 - Create programs to store, access, and manipulate level-appropriate data (e.g., structured data, objects)
// We use this program to demonstrate the use of stacks and queues.
// A stack meets this standard because it stores data and allows us to access and manipulate that data.
// An example in this program is the push() method, which stores data in the stack.

