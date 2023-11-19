package com.coderscratchpad.javafxtutorial.dialogs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-dialogs-simplifying-user-interactions-in-your-java-applications/">coderscratchpad.com</a>
 */
public class TextInputDialogExample extends Application {

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

        Button button = new Button("Open TextInputDialog Dialog");

        button.setOnAction(this::openDialog);

        VBox vBox= new VBox(20, this.label, button);
        vBox.setAlignment(Pos.CENTER);

        this.parent.setCenter(vBox);

    }

    private void openDialog(ActionEvent actionEvent) {

        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Text Input");
        dialog.setHeaderText("Please enter your name:");
        dialog.setContentText("Name:");

        // Get the result of the dialog (user input) and display it
        dialog.showAndWait().ifPresent(name -> this.label.setText("User entered: " + name));

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