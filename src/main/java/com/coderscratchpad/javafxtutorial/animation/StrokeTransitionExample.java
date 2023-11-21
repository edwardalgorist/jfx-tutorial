package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.StrokeTransition;
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
public class StrokeTransitionExample extends Application {

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

        // Create a stroke color transition animation for the Rectangle
        StrokeTransition strokeTransition = new StrokeTransition(Duration.seconds(1), rectangle);

        // Starting stroke color (Red)
        strokeTransition.setFromValue(Color.RED);

        // Ending stroke color (Blue)
        strokeTransition.setToValue(Color.BLUE);

        // Reverse the animation when it completes
        strokeTransition.setAutoReverse(true);

        // Repeat the animation indefinitely
        strokeTransition.setCycleCount(StrokeTransition.INDEFINITE);

        // Start the animation
        strokeTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}