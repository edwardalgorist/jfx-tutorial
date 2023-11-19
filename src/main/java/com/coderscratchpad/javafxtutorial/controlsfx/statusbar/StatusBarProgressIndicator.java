package com.coderscratchpad.javafxtutorial.controlsfx.statusbar;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.control.StatusBar;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-controlsfx-statusbar/">coderscratchpad.com</a>
 */
public class StatusBarProgressIndicator extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        StatusBar statusBar = new StatusBar();

        // Set initial status message
        statusBar.setText("Ready");

        Task<Void> task = new Task<>() {

            @Override
            protected Void call() throws Exception {

                for (int i = 0; i <= 100; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(100);
                }

                return null;

            }

        };

        ProgressBar progressBar = new ProgressBar();
        progressBar.progressProperty().bind(task.progressProperty());
        statusBar.getRightItems().addAll(progressBar);

        Thread thread = new Thread(task);
        thread.start();

        // Add the StatusBar to the BorderPane layout manager
        this.parent.setBottom(statusBar);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX ControlsFX StatusBar");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}