package com.coderscratchpad.javafxtutorial.tooltip;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tooltip-enhancing-user-interface-with-informative-hints/">coderscratchpad.com</a>
 */
public class GraphicalTooltip extends Application {

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

        // Create a Button
        Button button = new Button("Hover Me!");

        // Replace with your image path
        ImageView imageView = new ImageView(new Image("cpp.png"));

        // Create a tooltip with text and a graphic (an image)
        Tooltip tooltip = new Tooltip("This tooltip displays an image.");
        tooltip.setGraphic(imageView);

        button.setTooltip(tooltip);

        // Add the Button to the BorderPane layout manager
        this.parent.setCenter(button);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Tooltip: Enhancing User Interface with Informative Hints");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}