package com.coderscratchpad.javafxtutorial.effects.sepiatone;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-sepiatone-effect/">coderscratchpad.com</a>
 */
public class CustomizingSepiaToneEffectLevel extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    // Create the parent layout manager for the application
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create the main application scene
        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the title for the application window
        stage.setTitle("Customizing SepiaTone Image Filter Level");

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

        // Create a Slider for adjusting the SepiaTone level
        Slider levelSlider = new Slider(0, 100, 100);
        levelSlider.setShowTickMarks(true);
        levelSlider.setShowTickLabels(true);

        // Create the SepiaTone Effect, and bind the level property
        // to the Slider's value property
        SepiaTone sepiaTone = new SepiaTone();
        sepiaTone.levelProperty().bind(levelSlider.valueProperty().divide(100));

        // Apply the SepiaTone effect
        imageView.setEffect(sepiaTone);

        // Add the ImageView to the center region of the BorderPane
        this.parent.setCenter(imageView);

        // Add the Slider to the bottom region of the BorderPane
        this.parent.setBottom(levelSlider);
        BorderPane.setAlignment(levelSlider, Pos.CENTER);
        BorderPane.setMargin(levelSlider, new Insets(10));

    }
}