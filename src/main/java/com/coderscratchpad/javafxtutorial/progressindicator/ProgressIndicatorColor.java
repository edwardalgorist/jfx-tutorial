package com.coderscratchpad.javafxtutorial.progressindicator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-progressindicator-control/">coderscratchpad.com</a>
 */
public class ProgressIndicatorColor extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("ProgressIndicator Color");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        // Create the ProgressIndicator
        ProgressIndicator progressIndicator = new ProgressIndicator();

        // Set the progress to 50 percent
        progressIndicator.setProgress(0.7);

        // Set the color Red
        progressIndicator.setStyle("-fx-progress-color: red;");

        // Add the ProgressIndicator to the parent StackPane
        this.parent.getChildren().add(progressIndicator);

    }

}