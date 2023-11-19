package com.coderscratchpad.javafxtutorial.imageview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-imageview-displaying-images-in-java-applications/">coderscratchpad.com</a>
 */
public class ImageViewRotatingImage extends Application {

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

        // Resize the image to fit within specified dimensions
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);

        // Rotate the image by 45 degrees clockwise
        imageView.setRotate(45);

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