package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/displaying-images-with-javafx/">coderscratchpad.com</a>
 */
public class ImageDisplay extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    @Override
    public void start(Stage stage) {

        // Create a BorderPane layout manager to arrange elements
        BorderPane layoutManager = new BorderPane();

        // Create a scene using the layout manager and set its dimensions
        Scene scene = new Scene(layoutManager, WIDTH, HEIGHT);

        // Create an ImageView to display an image
        ImageView imageView = new ImageView();

        // Load and set the image to the ImageView
        imageView.setImage(new Image("duck.png"));

        // Add the ImageView to the center of the BorderPane
        layoutManager.setCenter(imageView);

        // Set the title of the application window
        stage.setTitle("Displaying Images with JavaFX");

        // Set the scene for the stage (window)
        stage.setScene(scene);

        // Center the window on the screen
        stage.centerOnScreen();

        // Show the application window
        stage.show();
    }
}