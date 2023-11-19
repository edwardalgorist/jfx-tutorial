package com.coderscratchpad.javafxtutorial.customdialogs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/building-javafx-custom-dialogs/">coderscratchpad.com</a>
 */
public class CustomDialogDriverApp extends Application {

    private final BorderPane parent = new BorderPane();

    private Label label;

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

        this.label = new Label();

        Button button = new Button("Open Custom Dialog");

        button.setOnAction(this::openDialog);

        VBox vBox= new VBox(20, this.label, button);
        vBox.setAlignment(Pos.CENTER);

        this.parent.setCenter(vBox);

    }

    private void openDialog(ActionEvent actionEvent) {

        // Create a custom dialog instance
        CustomDialog customDialog = new CustomDialog();

        // Show the custom dialog and wait for the user response
        String result = customDialog.showAndWait().orElse("");

        // Handle the result
        if ("Save".equals(result)) {

            // Perform actions when "Save" is clicked
            this.label.setText("Saving data...");

        } else {

            // Perform actions when "Cancel" is clicked or the dialog is closed
            this.label.setText("Dialog closed or canceled.");

        }

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("Building JavaFX Custom Dialogs");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}