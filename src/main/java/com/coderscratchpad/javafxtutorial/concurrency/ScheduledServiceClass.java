package com.coderscratchpad.javafxtutorial.concurrency;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/concurrency-and-multithreading-in-javafx/">coderscratchpad.com</a>
 */
public class ScheduledServiceClass extends Application {

    // Main UI container
    private final BorderPane parent = new BorderPane();

    // Label for displaying the clock time
    private final Label clockLabel = new Label();

    // Format for displaying time with AM/PM
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm:ss a");

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

        // Apply CSS style to the clock label
        clockLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 36px;");

        // Initialize the clock label with the current time
        updateClockLabel();

        // Create a custom ScheduledService for updating the clock
        ClockService service = new ClockService();

        // Set the execution interval (every second)
        service.setPeriod(Duration.seconds(1));

        // Start the service
        service.start();

        // Set the clock label at the center of the parent layout
        parent.setCenter(clockLabel);
    }

    // Update the clock label text with the current time
    private void updateClockLabel() {
        String currentTime = timeFormat.format(new Date());
        clockLabel.setText(currentTime);
    }

    // Custom ScheduledService for updating the clock
    private class ClockService extends ScheduledService<Void> {

        @Override
        protected Task<Void> createTask() {

            return new Task<>() {

                @Override
                protected Void call() {

                    // Update the clock label text with the current time
                    Platform.runLater(ScheduledServiceClass.this::updateClockLabel);
                    return null;
                }
            };
        }
    }

}