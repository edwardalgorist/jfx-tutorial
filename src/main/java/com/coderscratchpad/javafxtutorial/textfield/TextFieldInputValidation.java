package com.coderscratchpad.javafxtutorial.textfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-textfield/">coderscratchpad.com</a>
 */
public class TextFieldInputValidation extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        TextField textField = new TextField();

        // Set the TextField maximum width
        textField.setMaxWidth(300.0);

        // Define the text formatter with a filter
        TextFormatter<String> formatter = new TextFormatter<>(change -> {

            String newText = change.getControlNewText();

            if (newText.matches("\\d*")) {

                change.getControl().setStyle("-fx-border-color: transparent;");
                return change;

            } else {

                change.getControl().setStyle("-fx-border-color: red;");

                // Rejects the change if it's not numeric
                return null;

            }

        });

        textField.setTextFormatter(formatter);

        this.parent.setCenter(textField);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX TextField");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}