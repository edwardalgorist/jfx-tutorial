package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.ScaleTransition;
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
public class ScaleTransitionExample extends Application {

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

        // Create a blue Rectangle
        Rectangle rectangle = new Rectangle(100, 100, Color.BLUE);

        // Create a scaling animation with a duration of 2 seconds for the rectangle
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), rectangle);

        // Set the target scale factors for X and Y to make it 3 times larger
        scaleTransition.setToX(3.0);
        scaleTransition.setToY(3.0);

        // Enable auto-reverse to make the animation reverse after reaching the target scale
        scaleTransition.setAutoReverse(true);

        // Set the cycle count to make the animation repeat indefinitely
        scaleTransition.setCycleCount(ScaleTransition.INDEFINITE);

        // Start the scaling animation
        scaleTransition.play();

        // Add the scaled rectangle to our layout
        this.parent.getChildren().add(rectangle);

    }

}