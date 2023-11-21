package com.coderscratchpad.javafxtutorial.canvas.translation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/element-translation-in-javafx-canvas/">coderscratchpad.com</a>
 */
public class TranslatingElements extends Application {

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

        // Draw a rectangle at the initial position
        double rectX = 50;
        double rectY = 50;
        double rectWidth = 200;
        double rectHeight = 200;
        gc.fillRect(rectX, rectY, rectWidth, rectHeight);

        // Translate the rectangle to a new position
        double newX = 150;
        double newY = 150;

        // Clear the old position
        gc.clearRect(rectX, rectY, rectWidth, rectHeight);

        // Draw the rectangle at the new position
        gc.fillRect(newX, newY, rectWidth, rectHeight);

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Element Translation in JavaFX Canvas");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}