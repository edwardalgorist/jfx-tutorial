package com.coderscratchpad.javafxtutorial.effects.lighting.point;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-lighting-effect-light-point/">coderscratchpad.com</a>
 */
public class PointLightApp extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    // The parent layout manager for the application's UI
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the stage title
        stage.setTitle("Lighting Effect: Light.Point");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();

        // Load an image from a file
        Image image = new Image("scorpion.jpg");

        // Create an ImageView for the loaded image
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(250);

        // Create a Point Light source
        Light.Point pointLight = new Light.Point();

        // Create a Lighting effect and set the light source
        Lighting lighting = new Lighting();
        lighting.setLight(pointLight);

        // Apply the Lighting effect to the ImageView
        imageView.setEffect(lighting);

        // Add the ImageView to the BorderPane's center region
        this.parent.setCenter(imageView);

        // Create a control panel for configuring the Lighting and Point Light properties
        LightingControlPanel lightingControlPanel = new LightingControlPanel(lighting, pointLight);
        this.parent.setLeft(lightingControlPanel);
    }

}
