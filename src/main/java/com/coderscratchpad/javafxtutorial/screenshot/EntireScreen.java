package com.coderscratchpad.javafxtutorial.screenshot;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/capturing-screenshots-with-javafx/">coderscratchpad.com</a>
 */
public class EntireScreen extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Capturing Screenshots with JavaFX");

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

        // Create an ImageView to display the captured screenshot
        ImageView imageView = new ImageView();
        imageView.setFitWidth(600.0);
        imageView.setFitHeight(400.0);

        // Create a Button to trigger the screenshot capture
        Button buttonScreenshot = new Button("Capture Screenshot");

        // Define the action to take when the button is clicked
        buttonScreenshot.setOnAction(event -> {

            // Capture a screenshot
            WritableImage image = captureScreenshot();

            // Display the captured screenshot in the ImageView
            if (image != null) imageView.setImage(image);

        });

        // Create a container (VBox) to hold the ImageView and Button
        VBox container = new VBox(20, imageView, buttonScreenshot);

        // Center-align the container contents
        container.setAlignment(Pos.CENTER);

        // Add the Container to the parent layout (StackPane)
        this.parent.getChildren().add(container);
    }

    private WritableImage captureScreenshot() {

        try {

            // Get the default graphics device
            GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

            // Get the bounds of the default configuration
            Rectangle screenBounds = graphicsDevice.getDefaultConfiguration().getBounds();

            // Extract screen width and height
            int screenWidth = screenBounds.width;
            int screenHeight = screenBounds.height;

            // Create a JavaFX Robot instance for capturing the screenshot
            Robot robot = new Robot();

            // Capture the screenshot and return it as a WritableImage
            return robot.getScreenCapture(null, 0, 0, screenWidth, screenHeight);

        } catch (HeadlessException exception) {
            /* No screen device present, return null */
            return null;
        }
    }

}