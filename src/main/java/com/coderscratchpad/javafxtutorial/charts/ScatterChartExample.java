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
public class ScatterChartExample extends Application {

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
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 5));
        series.getData().add(new XYChart.Data<>(2, 10));
        series.getData().add(new XYChart.Data<>(3, 8));
        series.getData().add(new XYChart.Data<>(4, 15));
        series.getData().add(new XYChart.Data<>(5, 12));

        // Define the axes
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create the scatter chart
        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.getData().add(series);

        // Set the chart title and axis labels
        scatterChart.setTitle("Scatter Chart Example");

        xAxis.setLabel("X-Axis Label");
        yAxis.setLabel("Y-Axis Label");

        this.parent.getChildren().addAll(scatterChart);

    }

}