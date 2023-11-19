package com.coderscratchpad.javafxtutorial.controlsfx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controlsfx.dialog.FontSelectorDialog;

public class FontSelectionDialogExample extends Application {

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

        // Create the Label
        Label label = new Label("Hello, ControlsFX!");

        // Create the Button
        Button fontButton = new Button("Select Font");

        // Create the VBox container with 10px spacing between Nodes
        // Add the Label and Button to the VBox container
        VBox container = new VBox(10, label, fontButton);
        container.setAlignment(Pos.CENTER);

        fontButton.setOnAction(e -> {

            // Create a FontSelectorDialog, set the Label Font as the default
            FontSelectorDialog fontDialog = new FontSelectorDialog(label.getFont());

            // Update the Label Font
            fontDialog.showAndWait().ifPresent(label::setFont);

        });

        // Add the VBox container to the center of the BorderPane
        this.parent.setCenter(container);

    }

    private void setupStage(Stage stage) {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Font Selection in JavaFX with ControlsFX FontSelectorDialog");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

}