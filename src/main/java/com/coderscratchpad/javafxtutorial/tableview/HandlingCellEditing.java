package com.coderscratchpad.javafxtutorial.tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tableview-building-interactive-data-tables/">coderscratchpad.com</a>
 */
public class HandlingCellEditing extends Application {

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

        // Enable cell editing for the name column
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Add an event handler to the name column to update the data when editing is finished
        nameColumn.setOnEditCommit(event -> {

            // Get selected person
            Person person = event.getRowValue();

            // Update Person name
            person.setName(event.getNewValue());

        });

        // Enable cell editing for the age column
        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter() {

            @Override
            public Integer fromString(String s) {

                try {
                    return super.fromString(s);
                } catch(NumberFormatException numberFormatException) {
                    return 0;
                }

            }

        }));

        // Add an event handler to the age column to update the data when editing is finished
        ageColumn.setOnEditCommit(event -> {

            // Get selected person
            Person person = event.getRowValue();

            // Update Person age
            person.setAge(event.getNewValue());

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