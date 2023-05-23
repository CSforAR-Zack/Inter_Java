// Importing libraries
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
// Third party libraries
import org.jfree.chart.*; 
import org.jfree.data.time.*;
import com.opencsv.*;

// Main extends JFrame to create a window
// Main creates a chart and adds it to the window
public class Main extends JFrame {
    // Main constructor
    public Main(){
        // Create dataset as a TimeSeriesCollection
        // TimeSeriesCollection comes from JFreeChart
        TimeSeriesCollection dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Weather Data", // Title
                "Date", // X-Axis Label
                "Temperature (F)", // Y-Axis Label
                dataset // Data to plot
        );
        // Add chart to panel to display
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    // Create dataset from CSV file
    private TimeSeriesCollection createDataset(){
        // Create two series to store min and max temperatures
        TimeSeries series1 = new TimeSeries("Min. Temperatures");
        TimeSeries series2 = new TimeSeries("Max Temperatures");

        // Load data from CSV file
        List<String[]> data = new ArrayList<>();
        data = LoadDataFromFile();

        // Create date formatter to parse dates from CSV file
        // so they can be added to the series
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Loop through data and add to appropriate series
        for (int i = 1; i < data.size(); i++) {
            String stringDate = data.get(i)[2];
            Date date = new Date();

            // Parse needs to be in try/catch block
            try {
                date = formatter.parse(stringDate);
            } catch(ParseException e){
                System.out.println(e);
            }
            int minTemp = Integer.parseInt(data.get(i)[7]);
            int maxTemp = Integer.parseInt(data.get(i)[6]);
            // Day is a class from JFreeChart
            series1.add(new Day(date), minTemp);
            series2.add(new Day(date), maxTemp);
        }

        // Create the collection and add the series
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }
    
    // Load data from CSV file
    public static List<String[]> LoadDataFromFile() {
        List<String[]> data = new ArrayList<>();

        // Working with files needs to be in try/catch block
        try {
            CSVReader reader = new CSVReader(new FileReader("weather_lr.csv"));
            data = reader.readAll();
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
        
        return data;
    }

    public static void main(String[] args){
        // Create chart
        Main chartWindow = new Main();
        chartWindow.pack();
        chartWindow.setSize(600, 400);
        chartWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chartWindow.setVisible(true);
    }
}