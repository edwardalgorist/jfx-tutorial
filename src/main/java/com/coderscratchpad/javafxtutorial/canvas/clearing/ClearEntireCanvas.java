package com.coderscratchpad.javafxtutorial.canvas.clearing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/clearing-the-javafx-canvas/">coderscratchpad.com</a>
 */
public class ClearEntireCanvas extends Application {

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

        // Create the Canvas
        Canvas canvas = new Canvas(600, 400);

        // Get the GraphicsContext
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Clear the entire Canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Clearing the JavaFX Canvas");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}