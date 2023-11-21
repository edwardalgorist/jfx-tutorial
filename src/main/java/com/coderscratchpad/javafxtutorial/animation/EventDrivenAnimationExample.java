package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-animation-bringing-your-user-interfaces-to-life/">coderscratchpad.com</a>
 */
public class EventDrivenAnimationExample extends Application {

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

        // Create a button
        Button button = new Button("Animate");

        // Define an action for the button click event
        button.setOnAction(event -> {

            // Create a fade animation for the circle
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), circle);

            // Starting opacity (fully visible)
            fadeTransition.setFromValue(1.0);

            // Ending opacity (completely transparent)
            fadeTransition.setToValue(0.0);

            // Reverse the animation once
            fadeTransition.setAutoReverse(true);

            // Play the animation 2 times
            fadeTransition.setCycleCount(2);

            // Start the animation
            fadeTransition.play();

        });

        // Create a container for the circle and button
        VBox container = new VBox(20, circle, button);
        container.setAlignment(Pos.CENTER);

        // Add the container to the parent layout
        this.parent.getChildren().add(container);

    }

}