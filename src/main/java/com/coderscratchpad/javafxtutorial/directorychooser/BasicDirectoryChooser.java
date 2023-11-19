package com.coderscratchpad.javafxtutorial.directorychooser;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-directorychooser-selecting-directories-the-easy-way/">coderscratchpad.com</a>
 */
public class BasicDirectoryChooser extends Application {

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

        Button button = new Button("Browse...");

        Label label = new Label("No directory selected.");

        button.setOnAction(actionEvent -> this.onBrowse(actionEvent, label));

        // Add the Button and the Label to the VBox container
        VBox container = new VBox(15, button, label);
        container.setAlignment(Pos.CENTER);

        // Add the VBox container to the BorderPane layout manager
        this.parent.setCenter(container);

    }

    private void onBrowse(ActionEvent actionEvent, Label label) {

        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();

        DirectoryChooser directoryChooser = new DirectoryChooser();

        // Set the Dialog title
        directoryChooser.setTitle("Select a Directory");

        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {

            label.setText("Selected Directory: " + selectedDirectory.getAbsolutePath());

        } else {

            label.setText("No directory selected.");

        }

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX DirectoryChooser");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}