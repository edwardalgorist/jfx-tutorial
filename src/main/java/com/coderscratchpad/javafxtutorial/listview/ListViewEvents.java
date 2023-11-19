package com.coderscratchpad.javafxtutorial.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-a-listview-in-javafx/">coderscratchpad.com</a>
 */
public class ListViewEvents extends Application {

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

        ObservableList<String> languages = FXCollections.observableArrayList(
                "C++", "Java", "JavaScript", "Python"
        );

        // Create a ListView and set the items
        ListView<String> listView = new ListView<>(languages);

        // Adding a selection listener to respond to selection events
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue != null) {

                        System.out.println("Selected: " + newValue);

                    }

                }

        );

        this.parent.setCenter(listView);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("How to Create a ListView in JavaFX");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}