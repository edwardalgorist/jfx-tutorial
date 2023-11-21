package com.coderscratchpad.javafxtutorial.concurrency;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/concurrency-and-multithreading-in-javafx/">coderscratchpad.com</a>
 */
public class ServiceClass extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

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
        this.buildUI();
    }

    private void buildUI() {

        Label statusLabel = new Label("Status: IDLE");
        Button startButton = new Button("Start Task");

        startButton.setOnAction(event -> {
            statusLabel.setText("Status: Running...");
            startBackgroundService(statusLabel);
        });

        VBox vbox = new VBox(10, statusLabel, startButton);
        vbox.setAlignment(Pos.CENTER);

        this.parent.setCenter(vbox);
    }

    private void startBackgroundService(Label statusLabel) {

        Service<Void> backgroundService = new Service<>() {
            @Override
            protected Task<Void> createTask() {

                return new Task<>() {
                    @Override
                    protected Void call() throws Exception {
                        // Simulate a time-consuming task
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }
                };
            }
        };

        backgroundService.setOnSucceeded(event -> {
            statusLabel.setText("Status: Task Completed");
        });

        backgroundService.start();
    }

}