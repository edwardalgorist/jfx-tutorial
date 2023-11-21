package com.coderscratchpad.javafxtutorial.graphiccalculator;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.mariuszgromada.math.mxparser.Expression;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/math-visualization-with-javafx-creating-a-graphical-calculator/">coderscratchpad.com</a>
 */
public class BasicCalculator extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
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

        // Create labels, text field, and button
        Label prompt = new Label("Enter Mathematical Expression:");
        TextField expression = new TextField();
        Button calculate = new Button("Calculate");

        Label result = new Label("0");
        result.setFont(Font.font(20.0));

        // Define an action event handler for the "Calculate" button
        calculate.setOnAction(event -> this.onCalculate(expression, result));

        // Create a vertical layout container
        VBox container = new VBox(
                10,
                new VBox(5, prompt, expression),  // Input label and text field
                new VBox(5, calculate, result)   // Calculate button and result label
        );

        container.setMaxWidth(400.0);
        container.setAlignment(Pos.CENTER);

        // Add the container to the parent StackPane
        this.parent.getChildren().add(container);
    }

    private void onCalculate(TextField expressionTextField, Label resultLabel) {

        String expressionText = expressionTextField.getText();

        // Use the mxparser library to evaluate the mathematical expression
        Expression expression = new Expression(expressionText);
        double result = expression.calculate();

        // Display the result in the resultLabel
        resultLabel.setText(String.valueOf(result));

    }

}