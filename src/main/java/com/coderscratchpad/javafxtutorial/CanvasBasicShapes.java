package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/getting-started-with-javafx-canvas/">coderscratchpad.com</a>
 */
public class CanvasBasicShapes extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

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

        // Create a Canvas
        Canvas canvas = new Canvas(400, 400);

        // Get the GraphicsContext for drawing
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Set the fill color to blue
        gc.setFill(Color.BLUE);

        // Draw a rectangle
        gc.fillRect(50, 50, 100, 100);

        // Set the fill color to red
        gc.setFill(Color.RED);

        // Draw a circle
        gc.fillOval(200, 200, 100, 100);

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("Getting Started with JavaFX Canvas");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }
}
