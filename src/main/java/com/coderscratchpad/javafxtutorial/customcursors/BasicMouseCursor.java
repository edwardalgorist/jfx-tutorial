package com.coderscratchpad.javafxtutorial.customcursors;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-custom-mouse-cursors/">coderscratchpad.com</a>
 */
public class BasicMouseCursor extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX Custom Mouse Cursors");

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

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        // Create the Button
        Button button = new Button("Click Me");

        // Set the custom cursor image
        button.setCursor(Cursor.MOVE);

        // Add the Button to the center of the BorderPane
        this.parent.setCenter(button);

    }

}