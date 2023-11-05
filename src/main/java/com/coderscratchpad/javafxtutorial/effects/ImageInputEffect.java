package com.coderscratchpad.javafxtutorial.effects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-imageinput-effect/">coderscratchpad.com</a>
 */
public class ImageInputEffect extends Application {

    // Application properties
    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create the main application scene
        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Set the title for the application window
        stage.setTitle("ImageInput Effect");

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

        // Create a Rectangle Node
        Rectangle rectangle = new Rectangle(300, 300);
        rectangle.setFill(Color.CORNFLOWERBLUE); // Set the Rectangle Fill color

        // Create the ImageInput Effect
        Image image = new Image("rose.jpg"); // Load an image
        ImageInput imageInput = new ImageInput(image);

        // Adjust the position of the displayed image
        imageInput.setX(0);
        imageInput.setY(0);

        // Create the SepiaTone Effect
        SepiaTone sepiaTone = new SepiaTone();

        // Set the ImageInput as the input effect to the SepiaTone Effect
        sepiaTone.setInput(imageInput);

        // Apply the SepiaTone Effect to the Rectangle
        rectangle.setEffect(sepiaTone);

        // Add the Rectangle to the center region of the BorderPane
        this.parent.setCenter(rectangle);

    }
}
