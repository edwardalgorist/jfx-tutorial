package com.coderscratchpad.javafxtutorial.concurrency;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/concurrency-and-multithreading-in-javafx/">coderscratchpad.com</a>
 */
public class RestartingCancelledTask extends Application {

    // Main UI container
    private final BorderPane parent = new BorderPane();

    private MyTask myTask = null;

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Concurrency and Multithreading in JavaFX");

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

        // Build the user interface
        buildUI();
    }

    private void buildUI() {

        // Create a label to display the service state
        Label stateLabel = new Label("Service not started yet.");

        ProgressIndicator progressIndicator = new ProgressIndicator(0);

        Button startButton = new Button("Start Serrvice");

        Button cancelButton = new Button("Cancel Task");

        startButton.setOnAction(event -> {
            if (myTask == null || myTask.isDone()) {

                // Create a new task instance
                myTask = createNewTask();

                // Bind the progress indicator to the task's progress
                progressIndicator.progressProperty().bind(myTask.progressProperty());

                myTask.setOnSucceeded(taskEvent -> {
                    stateLabel.setText("Task completed with result: " + myTask.getValue());
                });

                // Start the task on a new thread
                new Thread(myTask).start();
            }
        });

        cancelButton.setOnAction(event -> {
            if (myTask != null && !myTask.isDone()) {
                // Cancel the task if it's running
                myTask.cancel();
                stateLabel.setText("Task canceled.");
            }
        });

        // Create a VBox to hold the stateLabel, progressIndicator, startButton, and cancelButton
        // with spacing and center alignment
        VBox vbox = new VBox(20, progressIndicator, stateLabel, startButton, cancelButton);
        vbox.setAlignment(Pos.CENTER);

        // Set the VBox as the center content of the parent BorderPane
        this.parent.setCenter(vbox);
    }

    private MyTask createNewTask() {
        // Create a new instance of the custom Task
        return new MyTask();
    }

    // Custom Task class that calculates the sum of numbers from 1 to 100
    static class MyTask extends Task<Integer> {

        @Override
        protected Integer call() throws Exception {

            int sum = 0;

            for (int i = 1; i <= 100; i++) {
                if (isCancelled()) {
                    break;
                }
                sum += i;

                // Simulate work
                Thread.sleep(100);

                // Update the progress
                updateProgress(i, 100);
            }
            return sum;
        }
    }
}