package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-charts/">coderscratchpad.com</a>
 */
public class StackedAreaChartExample extends Application {

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
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Series 1");

        series1.getData().add(new XYChart.Data<>(1, 10));
        series1.getData().add(new XYChart.Data<>(2, 15));
        series1.getData().add(new XYChart.Data<>(3, 8));
        series1.getData().add(new XYChart.Data<>(4, 20));

        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        series2.setName("Series 2");

        series2.getData().add(new XYChart.Data<>(1, 5));
        series2.getData().add(new XYChart.Data<>(2, 12));
        series2.getData().add(new XYChart.Data<>(3, 18));
        series2.getData().add(new XYChart.Data<>(4, 7));

        // Define the axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the stacked area chart
        javafx.scene.chart.StackedAreaChart<Number, Number> stackedAreaChart = new javafx.scene.chart.StackedAreaChart<>(xAxis, yAxis);

        stackedAreaChart.getData().addAll(series1, series2);

        // Set the chart title and axis labels
        stackedAreaChart.setTitle("Stacked Area Chart Example");
        xAxis.setLabel("X-Axis Label");
        yAxis.setLabel("Y-Axis Label");

        this.parent.getChildren().addAll(stackedAreaChart);

    }

}