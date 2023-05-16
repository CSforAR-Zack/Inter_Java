// Program: Weather Data

// We use the JavaFX library to create a line chart
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

// General Java libraries
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.Scanner;

// This is the class declaration
// it inherits from Application (year 3) but we need it to make the line chart
public class Main extends Application {
    // start comes from the Application class through inheritance and is called when the program starts
    // We add the @Override annotation to tell the compiler that we are overriding the method
    // from the parent class. Override is a year 3 topic.
    @Override
    public void start(Stage stage) {        
        stage.setTitle("Weather Data");
        
        // Create the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        // For simiplicity, we use days from 1-1-21 as the x axis
        // There are ways to use Date objects, but they are more complicated
        xAxis.setLabel("Day from 1-1-21");

        // Create the line chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);                
        lineChart.setTitle("Little Rock Temperatures");
        
        // Create the different series that will be displayed on the line chart
        XYChart.Series seriesMinTemp = new XYChart.Series();
        seriesMinTemp.setName("Min. Temp");

        XYChart.Series seriesMaxTemp = new XYChart.Series();
        seriesMaxTemp.setName("Max Temp");
        
        // Create an ArrayList to store the data and load the data from the file
        List<String[]> data = new ArrayList<>();        
        data = LoadDataFromFile();
        // Loop through the data and add it to the correct series
        // Since some columns had commas in them, we need to take that into account
        // We could consider using a CSV library to make this easier or
        // We could use a regular expression to split the line on commas
        for (int i = 1; i < data.size(); i++){
            int minTemp = Integer.parseInt(data.get(i)[8]);
            int maxTemp = Integer.parseInt(data.get(i)[7]);
            seriesMinTemp.getData().add(new XYChart.Data(i, minTemp));
            seriesMaxTemp.getData().add(new XYChart.Data(i, maxTemp));
        }
        
        // Create the scene and add the line chart to it
        Scene scene  = new Scene(lineChart,800,600);
        // We use a css file to style the line chart for simplicity
        // This could be done in code as well, but documentation is sparse
        scene.getStylesheets().add("style.css");
        // Add the series to the line chart
        lineChart.getData().addAll(seriesMinTemp, seriesMaxTemp);

        // Change the look of the lines
        lineChart.setCreateSymbols(false);

        // This is an alternative way to change the look of the lines
        // seriesMinTemp.getNode().setStyle("-fx-stroke: blue;");
        // seriesMaxTemp.getNode().setStyle("-fx-stroke: red;");
        
        // Set the scene and show the stage
        stage.setScene(scene);
        stage.show();
    }

    // This method loads the data from the file
    // It returns a list of String arrays
    // Each String array is a line from the file
    // Each element in the String array is a column from the file
    // However, the first line is the column headers
    public static List<String[]> LoadDataFromFile(){
        List<String[]> data = new ArrayList<>();
        
        // This is a try catch block and is required when using File IO
        try{
            // We will use a Scanner to read the file, however, there are other ways to do this
            Scanner sc = new Scanner(new File("weather_lr.csv"));
            while (sc.hasNextLine()){
                // We read the line and split it into an array of Strings
                // We remove the quotes from the line for easier processing later
                // We split the line on the comma. Keep in mind that some of the columns have commas in them
                // We will deal with this later
                String[] line = new String[9];
                String rawLine = sc.nextLine().replace("\"", "");
                line = rawLine.split(",");
                data.add(line);
            }
            // Close the scanner so we don't have a resource leak
            sc.close();              
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }        
        return data;
    }
 
    public static void main(String[] args){
        // This is how we launch the JavaFX application
        launch(args);
    }        
}