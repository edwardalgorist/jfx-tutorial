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
public class StackedBubbleChart extends Application {

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

        // Sample data series
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Series 1");

        series1.getData().add(new XYChart.Data<>("Category 1", 10));
        series1.getData().add(new XYChart.Data<>("Category 2", 15));
        series1.getData().add(new XYChart.Data<>("Category 3", 8));
        series1.getData().add(new XYChart.Data<>("Category 4", 20));

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Series 2");

        series2.getData().add(new XYChart.Data<>("Category 1", 5));
        series2.getData().add(new XYChart.Data<>("Category 2", 12));
        series2.getData().add(new XYChart.Data<>("Category 3", 18));
        series2.getData().add(new XYChart.Data<>("Category 4", 7));

        // Define the axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the stacked bar chart
        StackedBarChart<String, Number> stackedBarChart = new StackedBarChart<>(xAxis, yAxis);

        stackedBarChart.getData().addAll(series1, series2);

        // Set the chart title and axis labels
        stackedBarChart.setTitle("Stacked Bar Chart Example");
        xAxis.setLabel("Categories");
        yAxis.setLabel("Values");

        this.parent.getChildren().addAll(stackedBarChart);

    }

}