package com.coderscratchpad.javafxtutorial.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-text-wrapping-and-overflow/">coderscratchpad.com</a>
 */
public class TextNodeTextWrapping extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Text Node Text Wrapping");

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

        // Create a Text node and enable text wrapping
        Text text = new Text("This is a long text that needs wrapping.");

        // width for wrapping
        // text.setWrappingWidth(200);

        // Bind the wrapping width to the BorderPane's width property
        text.wrappingWidthProperty().bind(this.parent.widthProperty());

        /* Add the Text node to the BorderPane center region */
        this.parent.setCenter(text);

    }

}