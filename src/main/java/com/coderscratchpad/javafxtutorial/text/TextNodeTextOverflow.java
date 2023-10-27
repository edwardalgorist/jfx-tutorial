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
public class TextNodeTextOverflow extends Application {

    private static final double WIDTH = 640;
    private static final double HEIGHT = 480;

    /* The parent layout manager */
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(this.parent, WIDTH, HEIGHT);

        // Sets the stage title
        stage.setTitle("Text Node Text Overflow");

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

        // Create a Text Node with long text content
        Text text = new Text("This is a very long text with ellipsis for overflow.");

        addEllipsis(text, 200);

        /* Add the Label to the StackPane */
        this.parent.setCenter(text);

    }

    public void addEllipsis(Text text, double width) {
        this.ellipsis(text, width, "...");
    }

    public void addEllipsis(Text text, double width, String ellipsisString) {
        this.ellipsis(text, width, ellipsisString);
    }

    private void ellipsis(Text text, double width, String ellipsisString) {

        String originalText = text.getText();

        // Apply custom logic for text ellipsis
        while (text.getLayoutBounds().getWidth() > (width - ellipsisString.length())) {
            originalText = originalText.substring(0, originalText.length() - 1);
            text.setText(originalText + ellipsisString);
        }

    }

}
