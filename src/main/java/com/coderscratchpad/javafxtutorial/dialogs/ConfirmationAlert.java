package com.coderscratchpad.javafxtutorial.dialogs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-dialogs-simplifying-user-interactions-in-your-java-applications/">coderscratchpad.com</a>
 */
public class ConfirmationAlert extends Application {

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

        Button button = new Button("Open Confirmation Dialog");

        button.setOnAction(this::openDialog);

        this.parent.setCenter(button);

    }

    private void openDialog(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Confirmation");

        alert.setHeaderText(null);

        alert.setContentText("Are you sure you want to proceed?");

        // Handling the user's response
        alert.showAndWait().ifPresent(buttonType -> {

            if (buttonType == ButtonType.OK) {

                // Code to execute when the user clicks the OK button (confirmation action)
                System.out.println("OK Button...");

            } else {

                // Code to execute when the user clicks the Cancel button (cancel action)
                System.out.println("Cancel Button...");

            }

        });

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