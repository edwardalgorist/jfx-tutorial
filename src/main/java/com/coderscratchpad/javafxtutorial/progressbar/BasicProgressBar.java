package com.coderscratchpad.javafxtutorial.progressbar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-progressbar/">coderscratchpad.com</a>
 */
public class BasicProgressBar extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX ProgressBar");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        ProgressBar progressBar = new ProgressBar(0);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {

            if (progressBar.getProgress() < 1.0) {
                progressBar.setProgress(progressBar.getProgress() + 0.1);
            }

        }));

        timeline.setCycleCount(10);

        timeline.play();

        this.parent.getChildren().addAll(progressBar);

    }

}