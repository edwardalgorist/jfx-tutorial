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
public class PasteFromClipboard extends Application {

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

        // Create a label with text for copying
        Label copyLabel = new Label("Hello, Clipboard!");

        // Create a "Copy" menu item
        MenuItem copyMenuItem = new MenuItem("Copy");

        // Define action for the "Copy" menu item
        copyMenuItem.setOnAction(e -> {

            ClipboardContent content = new ClipboardContent();

            // Copy the label's text to the clipboard
            content.putString(copyLabel.getText());
            this.clipboard.setContent(content);

        });

        // Create a context menu with the "Copy" menu item for the copying label
        ContextMenu copyContextMenu = new ContextMenu(copyMenuItem);

        // Attach the context menu to the copying label
        copyLabel.setContextMenu(copyContextMenu);

        // Create a label for pasting
        Label pasteLabel = new Label("Paste Here!");

        // Create a "Paste" menu item
        MenuItem pasteMenuItem = new MenuItem("Paste");

        // Define action for the "Paste" menu item
        pasteMenuItem.setOnAction(e -> {

            if (this.clipboard.hasString()) {
                String text = this.clipboard.getString();
                pasteLabel.setText(text);
            }

        });

        // Create a context menu with the "Paste" menu item for the pasting label
        ContextMenu pasteContextMenu = new ContextMenu(pasteMenuItem);

        // Attach the context menu to the pasting label
        pasteLabel.setContextMenu(pasteContextMenu);

        // Create an HBox container to hold both labels
        HBox container = new HBox(20, copyLabel, pasteLabel);

        // Center-align the container contents
        container.setAlignment(Pos.CENTER);

        // Add the Container to the parent layout (StackPane)
        this.parent.getChildren().add(container);

    }

}