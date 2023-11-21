package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/screen-pixel-color-retrieval-in-javafx/">coderscratchpad.com</a>
 */
public class ScreenPixelColorRetriever extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Screen Pixel Color Retrieval in JavaFX");

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
        buildUI();
    }

    private void buildUI() {

        // Load an image (Replace with your image path)
        Image image = new Image("rose.jpg");

        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);

        // Attach click event handler
        imageView.setOnMouseClicked(this::onImageViewClicked);

        // Maintain aspect ratio
        imageView.setPreserveRatio(true);

        // Set the image width
        imageView.setFitWidth(300.0);

        // Add the ImageView to the parent layout (StackPane)
        this.parent.getChildren().add(imageView);
    }

    private void onImageViewClicked(MouseEvent mouseEvent) {

        // Initialize the Robot for screen pixel color retrieval
        Robot robot = new Robot();

        // Get the ImageView that triggered the click event
        ImageView imageView = (ImageView) mouseEvent.getSource();

        // Get the color of the pixel at the clicked coordinates
        Color pixelColor = robot.getPixelColor(robot.getMouseX(), robot.getMouseY());

        // Set the background color of the parent StackPane to the selected color
        imageView.getParent().setStyle(String.format(
                "-fx-background-color: rgba(%d, %d, %d, %.2f);",
                (int) (pixelColor.getRed() * 255),
                (int) (pixelColor.getGreen() * 255),
                (int) (pixelColor.getBlue() * 255),
                pixelColor.getOpacity()
        ));

    }

}