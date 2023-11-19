package com.coderscratchpad.javafxtutorial.imageview;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-imageview-displaying-images-in-java-applications/">coderscratchpad.com</a>
 */
public class ImageViewCroppingImage extends Application {

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

        // Load an image from a file
        Image image = new Image("scorpion.jpg");

        // Create an ImageView and set the image
        ImageView imageView = new ImageView(image);

        // Define a rectangular viewport (x, y, width, height) to crop the image
        imageView.setViewport(new Rectangle2D(200, 100, 300, 300));

        // Add the ImageView to the BorderPane layout manager
        this.parent.setCenter(imageView);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX ImageView: Displaying Images in Java Applications");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}