package com.coderscratchpad.javafxtutorial.scrollpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/creating-scrollable-content-with-javafx-scrollpane/">coderscratchpad.com</a>
 */
public class ScrollPaneDifferentContent extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        // Load an image
        Image image = new Image("https://via.placeholder.com/640");

        // Use an ImageView to display the image
        ImageView imageView = new ImageView(image);

        ScrollPane scrollPane = new ScrollPane(imageView);

        // Add the scroll pane to the BorderPane layout manager
        this.parent.setCenter(scrollPane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX ScrollPane");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}