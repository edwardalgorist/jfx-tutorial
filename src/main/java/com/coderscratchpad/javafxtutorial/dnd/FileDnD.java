package com.coderscratchpad.javafxtutorial.dnd;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drag-and-drop-in-javafx-simplifying-user-interactions/">coderscratchpad.com</a>
 */
public class FileDnD extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {

        // Setup and display the stage
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();

        // Build the user interface
        this.buildUI();
    }

    private void buildUI() {

        // Create an ObservableList to hold file paths
        ObservableList<String> fileList = FXCollections.observableArrayList();
        ListView<String> fileListView = new ListView<>(fileList);

        // Define behavior for the ListView when a drag enters
        fileListView.setOnDragOver(event -> {

            // Check if the dragged item is not the ListView itself and if it contains files
            if (event.getGestureSource() != fileListView && event.getDragboard().hasFiles()) {
                // Allow the drop
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        // Define behavior for the ListView when a drop occurs
        fileListView.setOnDragDropped(event -> {

            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasFiles()) {
                // Add the absolute paths of dropped files to the ObservableList
                fileList.addAll(db.getFiles().stream().map(File::getAbsolutePath).toList());
                success = true;
            }

            // Set the drop completed status
            event.setDropCompleted(success);
            event.consume();
        });

        // Add the ListView to the center of the BorderPane
        this.parent.setCenter(fileListView);
    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Drag and Drop in JavaFX: Simplifying User Interactions");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();
    }

}