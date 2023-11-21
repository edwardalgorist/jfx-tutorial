package com.coderscratchpad.javafxtutorial.graphiccalculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/math-visualization-with-javafx-creating-a-graphical-calculator/">coderscratchpad.com</a>
 */
public class PlottingGraphs extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    LineChart<Number, Number> lineChart;

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Graphical Calculator");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // Create chart for graph plotting
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();

        this.lineChart = new LineChart<>(xAxis, yAxis);
        this.lineChart.setTitle("Function Plot");

        // Add the chart to the center of the parent layout
        this.parent.setCenter(this.lineChart);

        Label prompt = new Label("Enter Mathematical Expression: ");
        TextField expression = new TextField();

        Button calculate = new Button("Calculate");

        // Define an action event handler for the "Calculate" button
        calculate.setOnAction(actionEvent -> this.plotGraph(expression.getText()));

        // Create a horizontal container for input elements
        HBox container = new HBox(5, prompt, expression, calculate);

        container.setPadding(new Insets(7.0));
        container.setAlignment(Pos.CENTER);

        // Add the container with input elements to the bottom of the parent layout
        this.parent.setBottom(container);

    }

    private void plotGraph(String expressionText) {

        Argument xargument = new Argument("x");
        Expression expression = new Expression(expressionText, xargument);

        // Clear previous data on the chart
        lineChart.getData().clear();

        // Create a new series for the graph
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(expressionText);

        // Populate the series with data points
        for (double x = -10; x <= 10; x += 0.1) {

            xargument.setArgumentValue(x);

            double y = expression.calculate();

            series.getData().add(new XYChart.Data<>(x, y));
        }

        // Add the series to the chart
        lineChart.getData().add(series);
    }

}