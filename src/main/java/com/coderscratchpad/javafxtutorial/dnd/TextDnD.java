package com.coderscratchpad.javafxtutorial.dnd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drag-and-drop-in-javafx-simplifying-user-interactions/">coderscratchpad.com</a>
 */
public class TextDnD extends Application {

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

        // Create source and target TextAreas
        TextArea sourceTextArea = new TextArea();
        sourceTextArea.setWrapText(true);

        TextArea targetTextArea = new TextArea();
        targetTextArea.setWrapText(true);

        // Define behavior for the source TextArea
        sourceTextArea.setOnDragDetected(event -> {

            // Start a drag-and-drop operation with COPY_OR_MOVE transfer mode
            Dragboard db = sourceTextArea.startDragAndDrop(TransferMode.COPY_OR_MOVE);

            ClipboardContent content = new ClipboardContent();

            // Put the selected text into the clipboard
            content.putString(sourceTextArea.getSelectedText());

            db.setContent(content);

            event.consume();

        });

        // Define behavior for the target TextArea when a drag enters
        targetTextArea.setOnDragOver(event -> {

            // Check if the dragged item is not the target TextArea itself and if it contains text
            if (event.getGestureSource() != targetTextArea && event.getDragboard().hasString()) {
                // Accept the transfer mode (COPY_OR_MOVE in this case)
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();

        });

        // Define behavior for the target TextArea when a drop occurs
        targetTextArea.setOnDragDropped(event -> {

            Dragboard db = event.getDragboard();

            boolean success = false;

            if (db.hasString()) {
                // Append the dropped text to the target TextArea
                targetTextArea.appendText(db.getString());
                success = true;
            }

            // Set the drop completed status
            event.setDropCompleted(success);
            event.consume();

        });

        HBox container = new HBox(10, sourceTextArea, targetTextArea);
        container.setAlignment(Pos.CENTER);

        // Add the HBox container to the center of the BorderPane
        this.parent.setCenter(container);

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