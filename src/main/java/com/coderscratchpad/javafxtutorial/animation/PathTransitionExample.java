package com.coderscratchpad.javafxtutorial.animation;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-animation-bringing-your-user-interfaces-to-life/">coderscratchpad.com</a>
 */
public class PathTransitionExample extends Application {

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
        Rectangle rectangle = new Rectangle(20, 20, Color.BLUE);

        // Create a path for the animation
        Path path = new Path();
        path.getElements().add(new MoveTo(0, 0));
        path.getElements().add(new LineTo(200, 0));
        path.getElements().add(new LineTo(200, 200));
        path.getElements().add(new LineTo(0, 200));
        path.getElements().add(new LineTo(100, 100));
        path.getElements().add(new LineTo(0, 0));

        // Create a path transition animation
        PathTransition pathTransition = new PathTransition(Duration.seconds(10), path, rectangle);

        // Reverse the animation when it completes
        pathTransition.setAutoReverse(true);

        // Repeat the animation indefinitely
        pathTransition.setCycleCount(PathTransition.INDEFINITE);

        // Start the animation
        pathTransition.play();

        // Add the Rectangle to the parent layout
        this.parent.getChildren().add(rectangle);

    }

}