package com.coderscratchpad.javafxtutorial.canvas.text;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/text-in-javafx-canvas-adding-typography-to-your-graphics/">coderscratchpad.com</a>
 */
public class TextPosition extends Application {

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

        // Set font, stroke color, and stroke width
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gc.setStroke(Color.RED);
        gc.setLineWidth(2.0);

        // Draw lines as visual cues
        gc.strokeLine(220, 0, 220, 100);

        // Set text alignment to right and text baseline to top
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.setTextBaseline(VPos.TOP);

        // Draw stroked text with the specified alignment
        gc.strokeText("Hello, TOP RIGHT!", 220, 100);

        // Add the Canvas to the center of the BorderPane
        this.parent.setCenter(canvas);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Text in JavaFX Canvas: Adding Typography to Your Graphics");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}
