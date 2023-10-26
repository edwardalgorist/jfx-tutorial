package com.coderscratchpad.javafxtutorial.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-charts/">coderscratchpad.com</a>
 */
public class BarChartExample extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX Charts");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        // Sample data
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Category 1", 10));
        series.getData().add(new XYChart.Data<>("Category 2", 5));
        series.getData().add(new XYChart.Data<>("Category 3", 12));
        series.getData().add(new XYChart.Data<>("Category 4", 8));
        series.getData().add(new XYChart.Data<>("Category 5", 15));

        // Define the axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the bar chart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.getData().add(series);

        // Set the chart title and axis labels
        barChart.setTitle("Bar Chart Example");
        xAxis.setLabel("Categories");
        yAxis.setLabel("Values");

        this.parent.getChildren().addAll(barChart);

    }

}