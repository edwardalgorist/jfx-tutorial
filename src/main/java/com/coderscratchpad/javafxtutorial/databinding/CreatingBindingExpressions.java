package com.coderscratchpad.javafxtutorial.databinding;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/data-binding-in-javafx-simplifying-ui-data-synchronization/">coderscratchpad.com</a>
 */
public class CreatingBindingExpressions extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Data Binding in JavaFX: Simplifying UI-Data Synchronization");

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

        // Create text fields for width and height
        DoublePropertyTextField txtWidth = new DoublePropertyTextField("Width");
        DoublePropertyTextField txtHeight = new DoublePropertyTextField("Height");

        // Bind the area label to the product of width and height
        DoubleBinding area = txtWidth.doubleProperty().multiply(txtHeight.doubleProperty());

        Label results = new Label();

        // Bind the label to the calculated area
        results.textProperty().bind(area.asString());

        // Create a container for the UI components
        VBox container = new VBox(
                15, // Spacing between components
                txtWidth, txtHeight,
                new VBox(results)
        );

        container.setAlignment(Pos.CENTER);
        container.setMaxWidth(300.0);

        // Add the container to the parent StackPane
        this.parent.getChildren().add(container);
    }

    // Custom VBox with a DoubleProperty for numeric input
    static class DoublePropertyTextField extends VBox {

        private final DoubleProperty value = new SimpleDoubleProperty();

        public DoublePropertyTextField(String label) {
            super(5); // Spacing between label and text field

            // Create a text field with a NumericFormatter to allow only numeric input
            TextField textField = new TextField();
            textField.setTextFormatter(new NumericFormatter());

            // Listen for changes in the text field and update the DoubleProperty accordingly
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    double newValueAsDouble = Double.parseDouble(newValue);
                    value.set(newValueAsDouble);
                } catch (NumberFormatException nfe) {
                    value.set(0.0);
                }
            });

            // Add the label and text field to the VBox
            getChildren().addAll(new Label(label), textField);
        }

        public DoubleProperty doubleProperty() {
            return value;
        }

        // Custom TextFormatter to enforce numeric input
        static class NumericFormatter extends TextFormatter<Double> {

            public NumericFormatter() {
                // Initialize the NumericFormatter with appropriate settings
                this(change -> {

                    String newText = change.getControlNewText();
                    if (newText.matches("[0-9]*\\.?[0-9]*")) {
                        // Accept the change if it's a valid numeric input
                        return change;
                    }

                    // Reject the change if it's not a valid numeric input
                    return null;
                });
            }

            private NumericFormatter(UnaryOperator<Change> unaryOperator) {
                super(unaryOperator);
            }
        }
    }
}