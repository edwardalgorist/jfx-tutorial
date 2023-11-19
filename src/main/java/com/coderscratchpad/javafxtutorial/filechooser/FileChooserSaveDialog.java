package com.coderscratchpad.javafxtutorial.filechooser;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/bringing-power-to-your-ui-javafx-filechooser-demystified/">coderscratchpad.com</a>
 */
public class FileChooserSaveDialog extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        Button button = new Button("Save");

        Label label = new Label("Saved File: N/A");

        button.setOnAction(actionEvent -> saveFile(actionEvent, label));

        // Create the VBox container
        // Add the Button and the Label to the VBox container
        VBox container= new VBox(15, button, label);

        container.setAlignment(Pos.CENTER);

        // Add the VBox container to the BorderPane layout manager
        this.parent.setCenter(container);

    }

    private void saveFile(ActionEvent actionEvent, Label label) {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        // Create the file chooser
        FileChooser saver = new FileChooser();

        // Set title for the file dialog
        saver.setTitle("Save File");

        // Specify the types of files to be saved (Text Files)
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");

        // Set filters
        saver.getExtensionFilters().addAll(txtFilter);

        // Set the initial file name
        saver.setInitialFileName("new_document.txt");

        File fileToSave = saver.showSaveDialog(stage);

        if (fileToSave  != null) {

            // Save logic here
            label.setText("Saved File: " + fileToSave .getAbsolutePath());

        }

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX FileChooser");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}