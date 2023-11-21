package com.coderscratchpad.javafxtutorial.animation;

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
public class TranslateTransitionExample extends Application {

    // This is our layout manager
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

        // Show the stage
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        buildUI();
    }

    private void buildUI() {

        // Create a blue Rectangle
        Rectangle rectangle = new Rectangle(50, 50, Color.BLUE);

        // Create a translation animation with a duration of 2 seconds for the rectangle
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), rectangle);

        // Set the target X-coordinate to move the rectangle 200 pixels to the right
        translateTransition.setToX(200);

        // Enable auto-reverse to make the animation go back and forth
        translateTransition.setAutoReverse(true);

        // Set the cycle count to make the animation repeat indefinitely
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);

        // Start the translation animation
        translateTransition.play();

        // Add the rectangle to our layout
        this.parent.getChildren().add(rectangle);
    }

}