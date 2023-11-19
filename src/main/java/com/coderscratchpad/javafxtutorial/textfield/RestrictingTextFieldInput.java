package com.coderscratchpad.javafxtutorial.textfield;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-textfield/">coderscratchpad.com</a>
 */
public class RestrictingTextFieldInput extends Application {

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
        Label label = new Label();

        // Set the TextField maximum width
        textField.setMaxWidth(300.0);

        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue.matches("\\d*")) {

                textField.setText(newValue.replaceAll("\\D", ""));
                label.setText("Error: Invalid Input...");
                label.setStyle("-fx-text-fill: red");

            } else {

                label.setText("Success: Valid Input...");
                label.setStyle("-fx-text-fill: green");

            }

        });

        VBox vBox = new VBox(10, textField, label);
        vBox.setAlignment(Pos.CENTER);

        this.parent.setCenter(vBox);

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