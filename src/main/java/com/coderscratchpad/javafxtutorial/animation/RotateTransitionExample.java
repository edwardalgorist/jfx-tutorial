package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.RotateTransition;
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
public class RotateTransitionExample extends Application {

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

        // Create a rotation animation for the rectangle
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(2), rectangle);

        // Rotate the rectangle by 360 degrees
        rotateTransition.setByAngle(360);

        // Repeat the rotation animation indefinitely
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);

        // Start the rotation animation
        rotateTransition.play();

        // Add the rotating rectangle to the parent StackPane
        this.parent.getChildren().add(rectangle);
    }

}