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
public class BounceInterpolators extends Application {

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
        Rectangle rectangle = new Rectangle(50, 50, Color.BLUE);

        // Create a TranslateTransition animation for the Rectangle
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), rectangle);

        // Apply a custom bounce effect using the SPLINE interpolator
        translateTransition.setInterpolator(Interpolator.SPLINE(0.1, 0.7, 0.7, 1.0));

        // Move the rectangle vertically by 100 units
        translateTransition.setByY(100);

        // Reverse the animation when it completes
        translateTransition.setAutoReverse(true);

        // Repeat the animation indefinitely
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);

        // Start the animation
        translateTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}