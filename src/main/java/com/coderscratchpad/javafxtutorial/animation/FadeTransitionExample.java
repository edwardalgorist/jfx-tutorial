package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.FadeTransition;
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
public class FadeTransitionExample extends Application {

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

        // Create a fade animation for the Rectangle
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), rectangle);

        // Starting opacity (fully visible)
        fadeTransition.setFromValue(1.0);

        // Ending opacity (completely transparent)
        fadeTransition.setToValue(0.0);

        // Reverse the animation when it reaches the end
        fadeTransition.setAutoReverse(true);

        // Repeat the animation indefinitely
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);

        // Start the animation
        fadeTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}