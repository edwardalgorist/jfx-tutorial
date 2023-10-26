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
public class PieChartExample extends Application {

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
        PieChart.Data slice1 = new PieChart.Data("Category 1", 30);
        PieChart.Data slice2 = new PieChart.Data("Category 2", 20);
        PieChart.Data slice3 = new PieChart.Data("Category 3", 50);

        // Create the pie chart
        PieChart pieChart = new PieChart();
        pieChart.getData().addAll(slice1, slice2, slice3);

        // Set the chart title
        pieChart.setTitle("Pie Chart Example");

        this.parent.getChildren().addAll(pieChart);

    }

}