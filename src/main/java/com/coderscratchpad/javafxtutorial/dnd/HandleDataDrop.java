package com.coderscratchpad.javafxtutorial.dnd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drag-and-drop-in-javafx-simplifying-user-interactions/">coderscratchpad.com</a>
 */
public class HandleDataDrop extends Application {

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

        // 1. Create the Drag Source
        Label dragSource = new Label("Drag me!");

        // Set an action when the label is detected for dragging
        dragSource.setOnDragDetected(event -> {

            // Start a drag-and-drop operation with COPY transfer mode
            Dragboard db = dragSource.startDragAndDrop(TransferMode.COPY);

            // Define the content to be transferred
            ClipboardContent content = new ClipboardContent();
            content.putString("Data to be transferred");

            // Set the content for the dragboard
            db.setContent(content);

            // Consume the event to indicate that it's being handled
            event.consume();

        });

        // 2. Define the Drop Target
        Label dropTarget = new Label("Drop here!");

        // Set an action when a drag enters the drop target area
        dropTarget.setOnDragOver(event -> {

            // Check if the dragged item is not the drop target itself and if it contains string data
            if (event.getGestureSource() != dropTarget && event.getDragboard().hasString()) {

                // Accept the transfer modes (COPY or MOVE in this case)
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

            }

            // Consume the event to indicate that it's being handled
            event.consume();

        });

        // 3. Handle Data Drop
        dropTarget.setOnDragDropped(event -> {

            // Get the Dragboard containing the data
            Dragboard db = event.getDragboard();

            // Initialize a flag for the drop success
            boolean success = false;

            // Check if the Dragboard contains string data
            if (db.hasString()) {

                // Process the dropped data here
                String data = db.getString();

                // Perform necessary actions with the data
                // For example, you can update the drop target text with the dropped data
                dropTarget.setText(data);

                // Set the success flag to true, indicating a successful drop
                success = true;

            }

            // Indicate whether the drop was completed successfully
            event.setDropCompleted(success);

            // Consume the event to indicate that it's being handled
            event.consume();

        });

        // Add the drag source Label to the center of the BorderPane
        this.parent.setCenter(dragSource);

        // Add the drag target Label to the bottom of the BorderPane
        this.parent.setBottom(dropTarget);

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