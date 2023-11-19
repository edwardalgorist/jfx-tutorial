package com.coderscratchpad.javafxtutorial.controlsfx.clearabletextfield;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/clearable-textfield-in-javafx-using-controlsfx/">coderscratchpad.com</a>
 */
public class ClearableTextField extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        // Setup and display the stage
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create a ClearableTextField
        TextField clearableTextField = TextFields.createClearableTextField();

        // Set the TextField width to 200px
        clearableTextField.setMaxWidth(200);

        // Add the ClearableTextField to the center of the BorderPane
        this.parent.setCenter(clearableTextField);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Clearable TextField in JavaFX using ControlsFX");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}