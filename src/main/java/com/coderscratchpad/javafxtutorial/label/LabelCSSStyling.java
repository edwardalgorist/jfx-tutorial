package com.coderscratchpad.javafxtutorial.label;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-labels-customization-and-text-effects/">coderscratchpad.com</a>
 */
public class LabelCSSStyling extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    private final StackPane parent = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("JavaFX Labels: Customization and Text Effects");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        Label label = new Label("Customization and Text Effects");

        label.setStyle("-fx-font-family: 'Arial'; " +
                "-fx-font-size: 18px; " +
                "-fx-text-fill: #333333; " +
                "-fx-background-color: #FFFFFF; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 10, 0, 0, 0);");

        this.parent.getChildren().addAll(label);

    }

}