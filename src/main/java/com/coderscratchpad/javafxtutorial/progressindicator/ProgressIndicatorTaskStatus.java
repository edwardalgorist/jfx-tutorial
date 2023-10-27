package com.coderscratchpad.javafxtutorial.progressindicator;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-progressindicator-control/">coderscratchpad.com</a>
 */
public class ProgressIndicatorTaskStatus extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("ProgressIndicator Task Binder");

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

        // Create Counter Task, and add a state listener
        Counter counter = new Counter();
        counter.stateProperty().addListener(this::counterState);

        // Create the ProgressIndicator
        ProgressIndicator progressIndicator = new ProgressIndicator();

        // Bind the progress indicator progress to the counter task progress
        progressIndicator.progressProperty().bind(counter.progressProperty());

        // Add the ProgressIndicator to the parent StackPane
        this.parent.getChildren().add(progressIndicator);

        // Start the task
        Thread thread = new Thread(counter);
        thread.start();

    }

    private void counterState(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {

        if (newState == Worker.State.SUCCEEDED) {

            System.out.println("Task completed successfully.");

        } else if (newState == Worker.State.FAILED) {

            System.out.println("Task encountered an error.");

        }
    }
}