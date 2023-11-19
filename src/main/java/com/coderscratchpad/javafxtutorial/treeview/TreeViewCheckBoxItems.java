package com.coderscratchpad.javafxtutorial.treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-treeview-organizing-your-data-in-hierarchical-structures/">coderscratchpad.com</a>
 */
public class TreeViewCheckBoxItems extends Application {

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
        CheckBoxTreeItem<String> languages = new CheckBoxTreeItem<>("Languages");

        CheckBoxTreeItem<String> dart = new CheckBoxTreeItem<>("Dart");
        CheckBoxTreeItem<String> php = new CheckBoxTreeItem<>("PHP");
        CheckBoxTreeItem<String> java = new CheckBoxTreeItem<>("Java");
        CheckBoxTreeItem<String> javascript = new CheckBoxTreeItem<>("JavaScript");
        CheckBoxTreeItem<String> python = new CheckBoxTreeItem<>("Python");

        // Add items to root item
        languages.getChildren().addAll(dart, php, java, javascript, python);

        // Create TreeView and root item
        TreeView<String> treeView = new TreeView<>(languages);

        treeView.setCellFactory(CheckBoxTreeCell.forTreeView());

        this.parent.setLeft(treeView);

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