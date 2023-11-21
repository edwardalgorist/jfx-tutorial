package com.coderscratchpad.javafxtutorial.splashscreen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-splash-screens-with-javafx/">coderscratchpad.com</a>
 */
public class ImageSplashScreenMain extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    public static void main(String[] args) {

        // Specify the custom preloader class
        System.setProperty("javafx.preloader", ImageSplashScreen.class.getName());
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Creating Splash Screens with JavaFX");

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

        // Simulate application loading tasks
        simulateLoadingTasks();

        buildUI();
    }

    private void simulateLoadingTasks() throws InterruptedException {

        // Simulate a loading task by sleeping for a short time
        Thread.sleep(5000);
    }

    private void buildUI() {

        // Create a label to indicate application loading
        Label label = new Label("Application Loaded");

        // Set a larger font size
        label.setFont(Font.font(24));

        // Add the label to the parent StackPane
        this.parent.getChildren().add(label);
    }


}