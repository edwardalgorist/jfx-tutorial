package com.coderscratchpad.javafxtutorial.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-a-listview-in-javafx/">coderscratchpad.com</a>
 */
public class ListViewDynamicModification extends Application {

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

        // Buttons to add and remove items
        Button addButton = new Button("Add Language");
        Button removeButton = new Button("Remove Language");

        // Event handling for adding items
        addButton.setOnAction(event -> {

            String newLanguage = "New Language";
            languages.add(newLanguage);
            listView.scrollTo(newLanguage);

        });

        // Event handling for removing items
        removeButton.setOnAction(event -> {

            String selectedLanguage = listView.getSelectionModel().getSelectedItem();

            if (selectedLanguage != null) {
                languages.remove(selectedLanguage);
            }

        });

        // Create a layout and add the buttons to it
        HBox buttonsLayout = new HBox(10, addButton, removeButton);

        buttonsLayout.setPadding(new Insets(10));
        buttonsLayout.setAlignment(Pos.CENTER);

        this.parent.setCenter(listView);

        // Add the buttons to the bottom of the BorderPane
        this.parent.setBottom(buttonsLayout);

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