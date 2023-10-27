package com.coderscratchpad.javafxtutorial.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-text-wrapping-and-overflow/">coderscratchpad.com</a>
 */
public class TextAreaTextWrapping extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("TextArea Text Wrapping");

        // Set the stage scene
        stage.setScene(scene);

        // Center stage on screen
        stage.centerOnScreen();

        // Show stage on screen
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        // Create the TextArea, and enable wrapping
        TextArea textArea = new TextArea("This is a long text that needs wrapping.");
        textArea.setWrapText(true);

        /* Add the TextArea to the BorderPane center region */
        this.parent.setCenter(textArea);

    }

}