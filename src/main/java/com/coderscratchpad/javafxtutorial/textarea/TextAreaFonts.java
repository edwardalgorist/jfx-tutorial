package com.coderscratchpad.javafxtutorial.textarea;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-textarea-multi-line-text-input/">coderscratchpad.com</a>
 */
public class TextAreaFonts extends Application {

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

        // Create the TextArea
        TextArea textArea = new TextArea();

        // Set initial text
        textArea.setText("Hello, JavaFX!");

        // Set the Font
        textArea.setFont(new Font("Open Sans", 18.0));

        // Add the TextArea to the BorderPane
        this.parent.setCenter(textArea);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX TextArea: Multi-Line Text Input");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}