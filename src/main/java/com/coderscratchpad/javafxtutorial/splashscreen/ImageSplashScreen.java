package com.coderscratchpad.javafxtutorial.splashscreen;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-splash-screens-with-javafx/">coderscratchpad.com</a>
 */
public class ImageSplashScreen extends Preloader {

    // Create the splash screen layout
    private final StackPane parent = new StackPane();

    private Stage preloaderStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.preloaderStage = stage;

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Make the scene background transparent
        scene.setFill(Color.TRANSPARENT);

        // Set the scene for the stage
        stage.setScene(scene);

        // Remove window decorations
        stage.initStyle(StageStyle.TRANSPARENT);

        // Center the SplashScreen on the screen
        stage.centerOnScreen();

        // Display the SplashScreen
        stage.show();
    }

    @Override
    public void init() throws Exception {

        // Replace with your image path
        // Load the image to be displayed on the splash screen
        Image image = new Image("bird.png");

        // Create an ImageView to display the image
        ImageView imageView = new ImageView(image);

        // Preserve the image's aspect ratio
        imageView.setPreserveRatio(true);

        // Set the width of the ImageView
        imageView.setFitWidth(500);

        // Add the ImageView to the parent StackPane
        this.parent.getChildren().add(imageView);
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {

        if (info.getType() == StateChangeNotification.Type.BEFORE_START) {

            // Close the splash screen when the application is ready to start
            this.preloaderStage.close();
        }
    }
}
