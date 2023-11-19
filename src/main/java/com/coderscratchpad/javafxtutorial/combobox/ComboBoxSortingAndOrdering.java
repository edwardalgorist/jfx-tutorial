package com.coderscratchpad.javafxtutorial.combobox;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/how-to-create-a-combobox-in-javafx/">coderscratchpad.com</a>
 */
public class ComboBoxSortingAndOrdering extends Application {

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
                "JavaScript", "C++", "Java", "Python"
        );

        // Create a ComboBox and add items to it
        ComboBox<String> languageComboBox = new ComboBox<>();

        // Add languages to the ComboBox
        languageComboBox.getItems().addAll(languages);

        // Set Java as the default value for the ComboBox
        languageComboBox.setValue("Java");

        // Enable alphabetical sorting (built-in sorting capability)
        languageComboBox.getItems().sort(String::compareToIgnoreCase);

        this.parent.setCenter(languageComboBox);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("How to Create a ComboBox in JavaFX");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}