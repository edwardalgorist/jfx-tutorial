package com.coderscratchpad.javafxtutorial.button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/styling-javafx-buttons-with-css/">coderscratchpad.com</a>
 */
public class ButtonCSSHover extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

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

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Styling JavaFX Buttons with CSS");

        // Sets the stage scene
        stage.setScene(scene);

        // Centers stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    private void buildUI() {

        Button button = new Button("Close Project");

        // Changes the button background color to lightblue on mouseover
        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: lightblue;"));

        // Removes the style on mouse exit
        button.setOnMouseExited(event -> button.setStyle(""));

        this.parent.setCenter(button);

    }

}