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
public class PauseTransitionExample extends Application {

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

        // Create a SequentialTransition to sequence the animations
        SequentialTransition sequentialTransition = new SequentialTransition();

        sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);

        // Create a FadeTransition to fade the rectangle in
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), rectangle);
        fadeTransition.setFromValue(0); // Start with full transparency
        fadeTransition.setToValue(1);   // End with full opacity

        // Create a PauseTransition to pause for 2 seconds
        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));

        // Create a RotateTransition to rotate the rectangle by 360 degrees
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), rectangle);
        rotateTransition.setByAngle(360);

        // Add the animations to the sequential transition
        sequentialTransition.getChildren().addAll(
                fadeTransition,
                pauseTransition, // Pause for 2 seconds
                rotateTransition
        );

        // Play the sequential transition
        sequentialTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}