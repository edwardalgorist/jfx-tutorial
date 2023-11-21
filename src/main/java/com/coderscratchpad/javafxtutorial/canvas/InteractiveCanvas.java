package com.coderscratchpad.javafxtutorial.canvas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/getting-started-with-javafx-canvas/">coderscratchpad.com</a>
 */
public class InteractiveCanvas extends Application {

    private final BorderPane parent = new BorderPane();

    private double lastX, lastY;

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

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {

            if (e.getButton() == MouseButton.PRIMARY) {
                lastX = e.getX();
                lastY = e.getY();
            }

        });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {

            if (e.getButton() == MouseButton.PRIMARY) {
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(2);
                gc.strokeLine(lastX, lastY, e.getX(), e.getY());
                lastX = e.getX();
                lastY = e.getY();
            }

        });

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

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