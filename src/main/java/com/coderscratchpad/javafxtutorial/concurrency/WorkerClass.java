package com.coderscratchpad.javafxtutorial.concurrency;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/concurrency-and-multithreading-in-javafx/">coderscratchpad.com</a>
 */
public class WorkerClass extends Application {

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

        // Set the initial progress of the ProgressIndicator to 0
        progressIndicator.setProgress(0);

        startButton.setOnAction(event -> {
            startBackgroundService();
        });

        // Create a VBox to hold the ProgressIndicator and Start button, with spacing and center alignment
        VBox vbox = new VBox(20, progressIndicator, startButton);
        vbox.setAlignment(Pos.CENTER);

        // Set the VBox as the center content of the parent BorderPane
        this.parent.setCenter(vbox);
    }

    private void startBackgroundService() {

        // Create a background service
        Service<Void> backgroundService = new Service<>() {
            @Override
            protected Task<Void> createTask() {

                return new Task<>() {

                    @Override
                    protected Void call() throws Exception {

                        final int maxProgress = 100;

                        for (int i = 0; i <= maxProgress; i++) {

                            // Simulate some work
                            Thread.sleep(100);

                            // Update progress
                            updateProgress(i, maxProgress);
                        }

                        return null;
                    }
                };
            }
        };

        // Bind the ProgressIndicator's progress property to the service's progress property
        progressIndicator.progressProperty().bind(backgroundService.progressProperty());

        // Start the background service
        backgroundService.start();
    }

}