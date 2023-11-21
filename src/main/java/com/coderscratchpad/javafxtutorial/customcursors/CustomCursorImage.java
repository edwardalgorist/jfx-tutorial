package com.coderscratchpad.javafxtutorial.customcursors;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-custom-mouse-cursors/">coderscratchpad.com</a>
 */
public class CustomCursorImage extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Load the custom cursor image
        Image cursor = new Image("default.png");

        // Set default cursor for the scene
        scene.setCursor(new ImageCursor(cursor, 0, 0));

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

        // Load the custom cursor image
        Image image = new Image("cursor.png");

        // Set custom cursor for the button
        button.setCursor(new ImageCursor(image, 0, 0));

        // Add the Button to the center of the BorderPane
        this.parent.setCenter(button);

    }

}