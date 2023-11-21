package com.coderscratchpad.javafxtutorial.dnd;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/drag-and-drop-in-javafx-simplifying-user-interactions/">coderscratchpad.com</a>
 */
public class SimpleDragAndDrop extends Application {

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

        // Create an ImageView as the drag source with an image
        ImageView dragSource = new ImageView(new Image("image1.jpg"));
        dragSource.setFitHeight(300);
        dragSource.setFitWidth(300);

        // Set an action when the image is detected for dragging
        dragSource.setOnDragDetected(event -> {

            // Start a drag-and-drop operation with COPY transfer mode
            Dragboard db = dragSource.startDragAndDrop(TransferMode.COPY);

            // Define the content to be transferred (an image in this case)
            ClipboardContent content = new ClipboardContent();
            content.putImage(dragSource.getImage());

            // Set the content for the dragboard
            db.setContent(content);

            // Consume the event to indicate that it's being handled
            event.consume();
        });

        // Create a drop target as an ImageView with an image
        ImageView dropTarget = new ImageView(new Image("image6.jpg"));
        dropTarget.setFitHeight(300);
        dropTarget.setFitWidth(300);

        // Set an action when a drag enters the drop target area
        dropTarget.setOnDragOver(event -> {

            // Check if the dragged item is not the drop target itself and if it contains an image
            if (event.getGestureSource() != dropTarget && event.getDragboard().hasImage()) {

                // Accept the transfer mode (COPY in this case)
                event.acceptTransferModes(TransferMode.COPY);
            }

            // Consume the event to indicate that it's being handled
            event.consume();
        });

        // Set an action to handle data drop
        dropTarget.setOnDragDropped(event -> {

            // Get the dragboard from the event
            Dragboard db = event.getDragboard();

            boolean success = false;

            if (db.hasImage()) {

                // Swap the images between drag source and drop target
                dragSource.setImage(dropTarget.getImage());

                // Set the dropped image on the drop target
                dropTarget.setImage(db.getImage());

                success = true;

            }

            // Set the drop completed status
            event.setDropCompleted(success);

            // Consume the event to indicate that it's being handled
            event.consume();
        });

        // Create an HBox container to hold the drag source and drop target
        HBox container = new HBox(10, dragSource, dropTarget);
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