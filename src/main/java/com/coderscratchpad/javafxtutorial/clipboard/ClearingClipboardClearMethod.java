package com.coderscratchpad.javafxtutorial.clipboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-clipboard/">coderscratchpad.com</a>
 */
public class ClearingClipboardClearMethod extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    // Get the system clipboard
    private final Clipboard clipboard = Clipboard.getSystemClipboard();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX Clipboard");

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

        // Create a button to clear the clipboard
        Button clearClipboardButton = new Button("Clear Clipboard");

        // Define action for the "Clear Clipboard" button
        clearClipboardButton.setOnAction(e -> {

            // Clear the system clipboard
            this.clipboard.clear();

        });

        // Add the "Clear Clipboard" Button to the parent layout
        this.parent.getChildren().add(clearClipboardButton);

    }

}