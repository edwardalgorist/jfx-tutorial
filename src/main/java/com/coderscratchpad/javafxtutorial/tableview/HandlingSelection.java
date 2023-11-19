package com.coderscratchpad.javafxtutorial.tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tableview-building-interactive-data-tables/">coderscratchpad.com</a>
 */
public class HandlingSelection extends Application {

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

        // Sample data
        ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Abel", 3),
                new Person("Benard", 6),
                new Person("Carl", 9),
                new Person("Denis", 12),
                new Person("Edward", 15),
                new Person("Jane", 18),
                new Person("Sam", 21)
        );

        // TableView and columns
        TableView<Person> tableView = new TableView<>();

        // Make TableView editable
        tableView.setEditable(true);

        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Age");

        // Define how to get the values from the Person object
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Add a selection listener to the TableView
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            if (newSelection != null) {

                // Print selected Person name and age to the console
                System.out.printf("{name: %s, age: %d}%n", newSelection.getName(), newSelection.getAge());

            }

        });

        // Add columns to the TableView
        tableView.getColumns().addAll(nameColumn, ageColumn);

        // Add data to the TableView
        tableView.setItems(data);

        this.parent.setCenter(tableView);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX TableView");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}
