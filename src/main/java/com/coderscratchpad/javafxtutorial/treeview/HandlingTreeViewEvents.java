package com.coderscratchpad.javafxtutorial.treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-treeview-organizing-your-data-in-hierarchical-structures/">coderscratchpad.com</a>
 */
public class HandlingTreeViewEvents extends Application {

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

        // Create root item
        TreeItem<String> languages = new TreeItem<>("Languages");

        // Create child items
        TreeItem<String> dart = new TreeItem<>("Dart");

        // Add child items to Dart
        dart.getChildren().addAll(new TreeItem<>("Flutter"));

        TreeItem<String> php = new TreeItem<>("PHP");

        // Add child items to PHP
        php.getChildren().addAll(new TreeItem<>("Laravel"));

        TreeItem<String> javascript = new TreeItem<>("JavaScript");

        // Add child items to JavaScript
        javascript.getChildren().addAll(new TreeItem<>("ReactJS"));

        TreeItem<String> java = new TreeItem<>("Java");

        // Add child items to Java
        java.getChildren().addAll(new TreeItem<>("Hibernate"));

        TreeItem<String> python = new TreeItem<>("Python");

        // Add child items to Python
        python.getChildren().addAll(new TreeItem<>("Django"));

        // Add child items to the root
        languages.getChildren().addAll(dart, php, javascript, java, python);

        // Create TreeView with the root item
        TreeView<String> treeView = new TreeView<>(languages);

        // Handle item selection
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {

                showAlert("Selected Item", newValue.getValue());

            }

        });

        // Handle item expansion/collapse
        treeView.setOnMouseClicked(event -> {

            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

                TreeItem<String> selectedItem = treeView.getSelectionModel().getSelectedItem();

                if (selectedItem != null) {

                    boolean isExpanded = selectedItem.isExpanded();
                    selectedItem.setExpanded(!isExpanded);

                }

            }

        });

        this.parent.setLeft(treeView);

    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("Organizing Your Data in Hierarchical Structures");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}