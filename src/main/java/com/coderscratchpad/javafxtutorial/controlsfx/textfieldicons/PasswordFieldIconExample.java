package com.coderscratchpad.javafxtutorial.controlsfx.textfieldicons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.CustomPasswordField;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/text-field-icons-in-javafx-with-controlsfx/">coderscratchpad.com</a>
 */
public class PasswordFieldIconExample extends Application {

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

        // Create the CustomPasswordField
        CustomPasswordField customPasswordField = new CustomPasswordField();

        // Set the CustomPasswordField width to 200px
        customPasswordField.setMaxWidth(200);

        // Replace "lock.png" with your icon's path
        customPasswordField.setLeft(new ImageView("lock.png"));

        // Add the CustomPasswordField to the center of the BorderPane
        this.parent.setCenter(customPasswordField);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Text Field Icons in JavaFX with ControlsFX");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}