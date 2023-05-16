// Purpose: Simulate rolling two dice numerouse times and display the sum of the results in a bar chart.

// These are the imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;
import java.text.*;
import java.util.Date;
import java.util.Scanner;
 
 
public class Main extends Application {
    // These are the variables that we can change to change the simulation
    // We put them outside of the start method so we can easily change them
    int numberOfRolls = 100000;
    Die die1 = new Die(20);
    Die die2 = new Die(20);
    
    // We discussed the @Override annotation in earlier
    @Override
    public void start(Stage stage) {
        // Set the title and axes labels
        stage.setTitle("Dice Roll Simulation");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Sum (Die1 + Die2) Frequencies");

        // Create the bar chart
        final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis, yAxis);
        // Create the series that will be displayed on the bar chart
        // We will only use one series, but we could use more
        XYChart.Series rolls = new XYChart.Series();
        rolls.setName("Rolls");

        // Simulate the rolls and add them to the series
        HashMap<Integer, Integer> rollingSimResults = new HashMap<Integer, Integer>();
        rollingSimResults = SimulateRolling(die1, die2, numberOfRolls);

        for (Integer key : rollingSimResults.keySet()){
            String x = key.toString();
            Integer y = rollingSimResults.get(key);
            rolls.getData().add(new XYChart.Data(x, y));       
        }
        
        Scene scene  = new Scene(barChart,800,600);
        barChart.getData().addAll(rolls);


        barChart.setCategoryGap(1);
        stage.setScene(scene);
        stage.show();
    }

    // This method simulates rolling two dice a number of times
    // It returns a HashMap with the sum of the rolls as the key and the number of times it occurred as the value
    // We use a HashMap because it makes it easier to store the sum and the number of times it occurred
    // We could use a 2D array, but it would be more complicated
    // We could also use two ArrayLists, but that would add more complexity
    public static HashMap<Integer, Integer> SimulateRolling(Die die1, Die die2, int numberOfRolls){
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        
        for (int i = 0; i < numberOfRolls; i++){
            Integer rolledSum = die1.Roll() + die2.Roll();
            rolls.add(rolledSum);
        }

        HashMap<Integer, Integer> frequencies = new HashMap();
        int rollSum = die1.GetNumberOfSides() + die2.GetNumberOfSides();
            
        for (int i = 2; i <= rollSum; i++){
            Integer occurrences = Collections.frequency(rolls, i);
            frequencies.put(i, occurrences);
        }
        return frequencies;
    }
 
    public static void main(String[] args){
        launch(args);
    }        
}