package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-animation-bringing-your-user-interfaces-to-life/">coderscratchpad.com</a>
 */
public class KeyFrameAnimationExample extends Application {

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

        // Create a Circle with a radius of 50 and red fill color
        Circle circle = new Circle(50, Color.RED);

        // Create a KeyValue for changing the circle's radius from 50 to 100
        KeyValue keyValue = new KeyValue(circle.radiusProperty(), 100);

        // Create a KeyFrame with the KeyValue at 2 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);

        // Create a Timeline to manage the animation
        Timeline timeline = new Timeline(keyFrame);

        // Run the animation indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Start the animation
        timeline.play();

        // Add the Circle to the parent layout
        this.parent.getChildren().add(circle);

    }

}