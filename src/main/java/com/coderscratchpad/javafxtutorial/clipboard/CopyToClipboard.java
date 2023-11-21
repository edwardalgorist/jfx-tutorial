package com.coderscratchpad.javafxtutorial.clipboard;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-clipboard/">coderscratchpad.com</a>
 */
public class CopyToClipboard extends Application {

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

        // Create a label with text
        Label copyLabel = new Label("Hello, Clipboard!");

        // Create a "Copy" menu item
        MenuItem copyMenuItem = new MenuItem("Copy");

        copyMenuItem.setOnAction(e -> {

            // Create ClipboardContent to hold data
            ClipboardContent content = new ClipboardContent();

            // Set the label's text as a string in ClipboardContent
            content.putString(copyLabel.getText());

            // Set the ClipboardContent to the clipboard
            clipboard.setContent(content);

        });

        // Create a context menu with the "Copy" menu item
        ContextMenu cxtMenu = new ContextMenu(copyMenuItem);

        // Attach the context menu to the label
        copyLabel.setContextMenu(cxtMenu);

        // Create an HBox container to hold the label
        HBox container = new HBox(20, copyLabel);

        // Center-align the container contents
        container.setAlignment(Pos.CENTER);

        // Add the container to the StackPane
        this.parent.getChildren().add(container);

    }

}