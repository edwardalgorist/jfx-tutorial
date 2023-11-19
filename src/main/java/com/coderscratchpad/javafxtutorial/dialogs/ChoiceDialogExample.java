package com.coderscratchpad.javafxtutorial.dialogs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-dialogs-simplifying-user-interactions-in-your-java-applications/">coderscratchpad.com</a>
 */
public class ChoiceDialogExample extends Application {

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

        Button button = new Button("Open ChoiceDialog");

        button.setOnAction(this::openDialog);

        VBox vBox= new VBox(20, this.label, button);
        vBox.setAlignment(Pos.CENTER);

        this.parent.setCenter(vBox);

    }

    private void openDialog(ActionEvent actionEvent) {

        List<String> choices = new ArrayList<>();

        choices.add("Option 1");
        choices.add("Option 2");
        choices.add("Option 3");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Option 1", choices);

        dialog.setTitle("Choice Dialog");
        dialog.setHeaderText("Select an option:");
        dialog.setContentText("Options:");

        // Get the result of the dialog (user selection) and display it
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(choice -> {

            this.label.setText("User selected: " + choice);

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