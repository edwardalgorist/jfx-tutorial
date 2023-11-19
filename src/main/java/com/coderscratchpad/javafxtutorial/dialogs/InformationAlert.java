package com.coderscratchpad.javafxtutorial.dialogs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-dialogs-simplifying-user-interactions-in-your-java-applications/">coderscratchpad.com</a>
 */
public class InformationAlert extends Application {

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

        Button button = new Button("Open Information Dialog");

        button.setOnAction(this::openDialog);

        this.parent.setCenter(button);

    }

    private void openDialog(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");

        alert.setHeaderText(null);

        alert.setContentText("This is an informational message.");

        alert.showAndWait();

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX Dialogs: Simplifying User Interactions in Your Java Applications");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}