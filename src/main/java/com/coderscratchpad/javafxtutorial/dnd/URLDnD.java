package com.coderscratchpad.javafxtutorial.dnd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drag-and-drop-in-javafx-simplifying-user-interactions/">coderscratchpad.com</a>
 */
public class URLDnD extends Application {

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

        // Create a Label as the drop target
        Label targetNode = new Label("Drop here!");

        // Define behavior for the Label when a drag enters
        targetNode.setOnDragOver(event -> {

            if (event.getGestureSource() != targetNode && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();
        });

        // Define behavior for the Label when a drop occurs
        targetNode.setOnDragDropped(event -> {

            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasUrl()) {

                // Process the dropped data here (in this case, it's a URL)
                String data = db.getUrl();

                // Perform necessary actions with the data
                // Update the drop target text with the URL
                targetNode.setText(data);

                success = true;

            }

            // Set the drop completed status
            event.setDropCompleted(success);
            event.consume();
        });

        // Add the Label to the center of the BorderPane
        this.parent.setCenter(targetNode);
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