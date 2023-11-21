package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
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
public class SequentialTransitionExample extends Application {

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

        // Create a SequentialTransition to combine multiple animations sequentially
        SequentialTransition sequentialTransition = new SequentialTransition();

        // Enable auto-reversal and indefinite repetition for the SequentialTransition
        sequentialTransition.setAutoReverse(true);
        sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);

        // Create a FadeTransition to animate opacity from 0.0 to 1.0 over 2 seconds
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), rectangle);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);

        // Create a TranslateTransition to move the rectangle horizontally by 100 units over 2 seconds
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), rectangle);
        translateTransition.setToX(100);

        // Add the FadeTransition and TranslateTransition to the SequentialTransition
        sequentialTransition.getChildren().addAll(fadeTransition, translateTransition);

        // Start the SequentialTransition animation
        sequentialTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}