package com.coderscratchpad.javafxtutorial.treetableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-treetableview-building-hierarchical-data-displays/">coderscratchpad.com</a>
 */
public class TreeTableViewCustomCellFactories extends Application {

    private final BorderPane parent = new BorderPane();

    @Override
    public void init() throws Exception {
        super.init();
        this.buildUI();
    }

    private void buildUI() {

        // Create the TreeTableView
        TreeTableView<Employee> treeTableView = new TreeTableView<>();

        TreeTableColumn<Employee, String> nameColumn = new TreeTableColumn<>("Name");
        nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        TreeTableColumn<Employee, String> positionColumn = new TreeTableColumn<>("Position");
        positionColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("position"));

        TreeTableColumn<Employee, Double> progressColumn = new TreeTableColumn<>("Progress");
        progressColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("progress"));

        // Custom Cell Factory for the Progress Column
        progressColumn.setCellFactory(column -> new TreeTableCell<>() {

            final ProgressBar progressBar = new ProgressBar();

            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {

                    setGraphic(null);

                } else {

                    progressBar.setProgress(item);
                    setGraphic(progressBar);

                }

            }

        });

        treeTableView.getColumns().addAll(nameColumn, positionColumn, progressColumn);

        // Create root item
        TreeItem<Employee> rootItem = new TreeItem<>(new Employee("Edward Nyirenda Jr.", "CEO", 0.8));

        // Add child items
        TreeItem<Employee> managerItem = new TreeItem<>(new Employee("Cherish Nyirenda", "Manager", 1.0));

        managerItem.getChildren().addAll(
                new TreeItem<>(new Employee("Andrew Phiri", "Employee", 0.9)),
                new TreeItem<>(new Employee("Benard Zulu", "Employee", 0.5))
        );

        rootItem.getChildren().add(managerItem);

        treeTableView.setRoot(rootItem);

        // Add the TreeTableView to the BorderPane
        this.parent.setCenter(treeTableView);

    }

    @Override
    public void start(Stage stage) throws Exception {
        this.setupStage(stage);
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640, 480);

        // Set the stage title
        stage.setTitle("JavaFX TreeTableView: Building Hierarchical Data Displays");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}