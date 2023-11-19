package com.coderscratchpad.javafxtutorial.treetableview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-treetableview-building-hierarchical-data-displays/">coderscratchpad.com</a>
 */
public class BasicTreeTableView extends Application {

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

        // Create the TreeTableView
        TreeTableView<Employee> treeTableView = new TreeTableView<>();

        TreeTableColumn<Employee, String> nameColumn = new TreeTableColumn<>("Name");
        nameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));

        TreeTableColumn<Employee, String> positionColumn = new TreeTableColumn<>("Position");
        positionColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("position"));

        treeTableView.getColumns().addAll(nameColumn, positionColumn);

        // Create root item
        TreeItem<Employee> rootItem = new TreeItem<>(new Employee("Edward Nyirenda Jr.", "CEO", 0));

        // Add child items
        TreeItem<Employee> managerItem = new TreeItem<>(new Employee("Cherish Nyirenda", "Manager", 0));

        managerItem.getChildren().addAll(
                new TreeItem<>(new Employee("Andrew Phiri", "Employee", 0)),
                new TreeItem<>(new Employee("Benard Zulu", "Employee", 0))
        );

        rootItem.getChildren().add(managerItem);

        treeTableView.setRoot(rootItem);

        // Add the TreeTableView to the BorderPane
        this.parent.setCenter(treeTableView);

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