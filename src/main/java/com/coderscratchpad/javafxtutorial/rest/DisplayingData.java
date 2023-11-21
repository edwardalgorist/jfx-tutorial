package com.coderscratchpad.javafxtutorial.rest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-and-restful-web-services-integration/">coderscratchpad.com</a>
 */
public class DisplayingData extends Application {

    // The parent layout manager
    private final BorderPane parent = new BorderPane();

    // Create a TableView to display the data
    private final TableView<Post> tableView = new TableView<>();

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the BorderPane as the root
        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("Integrating JavaFX and RESTful Web Services");

        // Set the scene for the stage
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Display the stage
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();

        // Build the user interface
        this.buildUI();

    }

    private void buildUI() {

        TableColumn<Post, Integer> userIdColumn = new TableColumn<>("USER ID");
        TableColumn<Post, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Post, String> titleColumn = new TableColumn<>("Title");
        TableColumn<Post, String> bodyColumn = new TableColumn<>("Body");

        // Define how the columns should retrieve data from the Post class
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        bodyColumn.setCellValueFactory(new PropertyValueFactory<>("body"));

        // Add columns to the TableView
        this.tableView.getColumns().addAll(
                userIdColumn,
                idColumn,
                titleColumn,
                bodyColumn
        );

        // Initially, show a ProgressIndicator to indicate data loading
        this.parent.setCenter(new ProgressIndicator());

    }

}