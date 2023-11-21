package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-animation-bringing-your-user-interfaces-to-life/">coderscratchpad.com</a>
 */
public class ParallelTransitionExample extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX Animation: Bringing Your User Interfaces to Life");

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
        buildUI();
    }

    private void buildUI() {

        // Create a Rectangle
        Rectangle rectangle = new Rectangle(100, 100, Color.BLUE);

        // Create a ParallelTransition to combine multiple animations
        ParallelTransition parallelTransition = new ParallelTransition();

        // Set the ParallelTransition to auto-reverse and repeat indefinitely
        parallelTransition.setAutoReverse(true);
        parallelTransition.setCycleCount(ParallelTransition.INDEFINITE);

        // Create a FadeTransition for the rectangle
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), rectangle);

        // Start with full transparency
        fadeTransition.setFromValue(0.0);

        // End with full opacity
        fadeTransition.setToValue(1.0);

        // Create a ScaleTransition for the rectangle
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), rectangle);

        // Scale horizontally by a factor of 3
        scaleTransition.setToX(3.0);

        // Scale vertically by a factor of 3
        scaleTransition.setToY(3.0);

        // Add the FadeTransition and ScaleTransition to the ParallelTransition
        parallelTransition.getChildren().addAll(fadeTransition, scaleTransition);

        // Start the ParallelTransition animation
        parallelTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}