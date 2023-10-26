package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-image-cropping-and-scaling/">coderscratchpad.com</a>
 */
public class ProportionalImageScaling extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Proportional Image Scaling");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        Image image = new Image("scorpion.jpg");
        ImageView imageView = new ImageView(image);

        // Scaling the image proportionally
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(350);

        /* Add the ImageView to the StackPane */
        this.parent.getChildren().addAll(imageView);

    }

}