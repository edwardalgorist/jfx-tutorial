package com.coderscratchpad.javafxtutorial.canvas.arc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drawing-arcs-in-javafx-canvas/">coderscratchpad.com</a>
 */
public class FilledArc extends Application {

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
        Canvas canvas = new Canvas(640, 480);

        // Get the GraphicsContext
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Define arc parameters
        double centerX = 200;
        double centerY = 200;
        double radiusX = 100;
        double radiusY = 100;
        double startAngle = 45; // in degrees
        double arcExtent = 90; // in degrees

        // Set the fill color for the arc
        gc.setFill(Color.BLUE);

        // Draw a filled arc on the Canvas
        gc.fillArc(
                centerX - radiusX,
                centerY - radiusY,
                2 * radiusX,
                2 * radiusY,
                startAngle,
                arcExtent,
                ArcType.ROUND
        );

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Drawing Arcs in JavaFX Canvas");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}