package com.coderscratchpad.javafxtutorial.splashscreen;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-splash-screens-with-javafx/">coderscratchpad.com</a>
 */
public class ProgressIndicatorSplashScreen extends Preloader {

    // Create the splash screen layout
    private final StackPane parent = new StackPane();

    private Stage preloaderStage;

    private ProgressIndicator progressIndicator;

    @Override
    public void start(Stage stage) throws Exception {
        this.preloaderStage = stage;

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the scene for the stage
        stage.setScene(scene);

        // Remove window decorations to create an undecorated window
        stage.initStyle(StageStyle.UNDECORATED);

        // Center the SplashScreen on the screen
        stage.centerOnScreen();

        // Display the SplashScreen
        stage.show();
    }

    @Override
    public void init() throws Exception {

        // Load and set the background image for the splash screen
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image("background.jpg"), // Replace with your background image path
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        this.parent.setBackground(new Background(backgroundImage));

        // Create and configure a ProgressIndicator for showing loading progress
        this.progressIndicator = new ProgressIndicator(0.0);
        this.progressIndicator.setMinSize(85, 85);

        // Add the ProgressIndicator to the parent StackPane
        this.parent.getChildren().add(this.progressIndicator);
    }

    @Override
    public void handleApplicationNotification(PreloaderNotification info) {

        if (info instanceof ProgressNotification) {

            // Handle progress updates from the main application
            double progress = ((ProgressNotification) info).getProgress();
            this.progressIndicator.setProgress(progress);
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {

        if (info.getType() == StateChangeNotification.Type.BEFORE_START) {

            // Close the splash screen when the application is ready to start
            this.preloaderStage.close();
        }
    }
}
