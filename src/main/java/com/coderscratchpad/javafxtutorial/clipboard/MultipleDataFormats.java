package com.coderscratchpad.javafxtutorial.clipboard;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-clipboard/">coderscratchpad.com</a>
 */
public class MultipleDataFormats extends Application {

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

        // Create an observable list to hold files
        ObservableList<File> fileList = FXCollections.observableArrayList();

        // Create a ListView to display the files
        ListView<File> listView = new ListView<>(fileList);

        // Create a button to clear/paste files
        Button pasteFilesButton = new Button("Clear/Paste Files");

        // Define action for the "Clear/Paste Files" button
        pasteFilesButton.setOnAction(e -> {

            if(this.clipboard.hasFiles()) {
                fileList.clear();
                fileList.addAll(this.clipboard.getFiles());
            }

        });

        // Create a VBox to hold the ListView and button
        VBox container = new VBox(30, listView, pasteFilesButton);

        // Center-align the container contents
        container.setAlignment(Pos.CENTER);

        // Add the VBox container to the parent layout (StackPane)
        this.parent.getChildren().add(container);

    }

}