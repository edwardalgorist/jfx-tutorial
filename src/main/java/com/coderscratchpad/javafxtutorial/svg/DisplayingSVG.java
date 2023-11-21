package com.coderscratchpad.javafxtutorial.svg;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.Objects;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/displaying-svg-images-in-javafx/">coderscratchpad.com</a>
 */
public class DisplayingSVG extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("Displaying SVG Images in JavaFX");

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

        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("house.svg")).toExternalForm();

        // Create an SVGViewer and add it to the parent StackPane
        SVGViewer svgViewer = new SVGViewer(path);
        this.parent.getChildren().add(svgViewer);
    }

}

