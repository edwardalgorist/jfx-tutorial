package com.coderscratchpad.javafxtutorial.canvas.oval;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drawing-ovals-in-javafx-canvas/">coderscratchpad.com</a>
 */
public class FilledOval extends Application {

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

        // Set the fill color
        gc.setFill(Color.CORNFLOWERBLUE);

        // Draw a filled oval
        gc.fillOval(100, 100, 300, 150);

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Drawing Ovals in JavaFX Canvas");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}