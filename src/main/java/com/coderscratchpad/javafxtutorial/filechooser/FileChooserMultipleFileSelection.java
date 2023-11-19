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
import java.util.List;
import java.util.stream.Collectors;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/bringing-power-to-your-ui-javafx-filechooser-demystified/">coderscratchpad.com</a>
 */
public class FileChooserMultipleFileSelection extends Application {

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

        Button button = new Button("Open");

        Label label = new Label("Selected Files: N/A");

        button.setOnAction(actionEvent -> openFile(actionEvent, label));

        // Create the VBox container
        // Add the Button and the Label to the VBox container
        VBox container= new VBox(15, button, label);

        container.setAlignment(Pos.CENTER);

        // Add the VBox container to the BorderPane layout manager
        this.parent.setCenter(container);

    }

    private void openFile(ActionEvent actionEvent, Label label) {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        // Create the file chooser
        FileChooser chooser = new FileChooser();

        // Set title for the file dialog
        chooser.setTitle("Open File");

        // Setting the initial directory
        chooser.setInitialDirectory(new File("C:/Users/edwar/Desktop"));

        // Specifying the types of files to be displayed (All, Text Files, or Images)
        FileChooser.ExtensionFilter allFilter = new FileChooser.ExtensionFilter("All Files (*.*)", "*.*");
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif");

        // Set filters
        chooser.getExtensionFilters().addAll(allFilter, txtFilter, imageFilter);

        // Show the file dialog and get selected files
        List<File> selectedFileList = chooser.showOpenMultipleDialog(stage);

        if (selectedFileList != null && !selectedFileList.isEmpty()) {

            // Convert the selected file list to a string
            String selectedFiles = selectedFileList.stream()
                    .map(File::getAbsolutePath)
                    .collect(Collectors.joining("\n"));

            // Process the selected files
            label.setText("Selected Files: \n\n" + selectedFiles);

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