package com.coderscratchpad.javafxtutorial.effects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-gaussianblur-effect/">coderscratchpad.com</a>
 */
public class CustomizingGaussianBlurEffectRadius extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    // Create the parent layout manager for the application
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create the main application scene
        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the title for the application window
        stage.setTitle("Customizing GaussianBlur Image Filter Radius");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();

        Image image = new Image("scorpion.jpg");

        // Create an ImageView to display the loaded image
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);

        // Create a Slider for adjusting the blur radius
        Slider radiusSlider = new Slider(0, 63, 10);
        radiusSlider.setShowTickMarks(true);
        radiusSlider.setShowTickLabels(true);

        // Create a GaussianBlur
        GaussianBlur blur = new GaussianBlur();

        // Bind the blur radius to the Slider's value
        blur.radiusProperty().bind(radiusSlider.valueProperty());

        // Apply the GaussianBlur effect to the ImageView
        imageView.setEffect(blur);

        // Add the ImageView to the center region of the BorderPane
        this.parent.setCenter(imageView);

        // Add the Slider to the bottom region of the BorderPane
        this.parent.setBottom(radiusSlider);
        BorderPane.setAlignment(radiusSlider, Pos.CENTER);
        BorderPane.setMargin(radiusSlider, new Insets(10));
    }
}