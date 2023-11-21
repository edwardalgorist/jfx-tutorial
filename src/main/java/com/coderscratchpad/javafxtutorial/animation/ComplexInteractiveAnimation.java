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
public class ComplexInteractiveAnimation extends Application {

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

        // Create a Circle
        Circle circle = new Circle(50, Color.RED);

        // Create a timeline with keyframes for horizontal movement
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(6), e -> circle.setTranslateX(-150)), // Move left
                new KeyFrame(Duration.seconds(4), e -> circle.setTranslateX(0)),    // Return to the center
                new KeyFrame(Duration.seconds(2), e -> circle.setTranslateX(150))   // Move right
        );

        // Repeat the animation indefinitely
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Reverse the animation when completed
        timeline.setAutoReverse(true);

        // Add an event listener to pause/resume animation on circle click
        circle.setOnMouseClicked(e -> {
            if (timeline.getStatus() == Timeline.Status.RUNNING) {
                timeline.pause();
            } else {
                timeline.play();
            }
        });

        // Add the circle to the parent layout
        this.parent.getChildren().add(circle);

    }

}