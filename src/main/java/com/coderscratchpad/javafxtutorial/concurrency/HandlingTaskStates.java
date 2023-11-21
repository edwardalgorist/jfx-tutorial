package com.coderscratchpad.javafxtutorial.concurrency;

import javafx.application.Application;
import javafx.concurrent.Service;
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
public class HandlingTaskStates extends Application {

    // Main UI container
    private final BorderPane parent = new BorderPane();

    private final ProgressIndicator progressIndicator = new ProgressIndicator();
    private final Button startButton = new Button("Start Service");

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

        startButton.setOnAction(event -> {

            // Create a new instance of MyService
            MyService myService = new MyService();

            // Start the service
            myService.start();

            // Handle service state changes
            myService.stateProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == Service.State.SUCCEEDED) {

                    stateLabel.setText("Service completed successfully.");
                } else if (newValue == Service.State.FAILED) {

                    stateLabel.setText("Service failed with exception: " + myService.getException());
                }
            });
        });

        // Create a VBox to hold the stateLabel and startButton with spacing and center alignment
        VBox vbox = new VBox(20, stateLabel, startButton);
        vbox.setAlignment(Pos.CENTER);

        // Set the VBox as the center content of the parent BorderPane
        this.parent.setCenter(vbox);
    }

    static class MyService extends Service<Void> {

        @Override
        protected Task<Void> createTask() {
            return new Task<>() {
                @Override
                protected Void call() throws Exception {

                    // Simulate a time-consuming task
                    Thread.sleep(3000);

                    // Uncomment the following line to simulate a task failure
                    // throw new Exception("Task failed intentionally.");
                    return null;
                }
            };
        }
    }
}