package com.coderscratchpad.javafxtutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/styling-javafx-buttons-with-css/">coderscratchpad.com</a>
 */
public class ButtonCSSFonts extends Application {

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

        // Sets the button text font family to 'Comic Sans MS'
        // The size to 18px
        // And the font style to 'italic'
        button.setStyle(
                "-fx-font-family: 'Comic Sans MS'; " +
                "-fx-font-size: 18px;" +
                "-fx-font-style: italic;"
        );

        this.parent.setCenter(button);

    }

}