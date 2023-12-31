package com.coderscratchpad.javafxtutorial.images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-grayscale-image-filter/">coderscratchpad.com</a>
 */
public class ColorAdjustGrayscaleImageFilter extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("ColorAdjust Grayscale Image Filter");

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

        // Load the image
        Image image = new Image("scorpion.jpg");

        ImageView imageView = new ImageView(image);

        // Scaling the image proportionally
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);

        ColorAdjust grayscale = new ColorAdjust();
        grayscale.setSaturation(-1.0);

        // Apply the ColorAdjust Effect to the ImageView
        imageView.setEffect(grayscale);

        /* Add the ImageView to the StackPane */
        this.parent.getChildren().addAll(imageView);

    }

}
