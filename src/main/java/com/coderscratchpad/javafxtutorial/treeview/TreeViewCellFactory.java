package com.coderscratchpad.javafxtutorial.treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-treeview-organizing-your-data-in-hierarchical-structures/">coderscratchpad.com</a>
 */
public class TreeViewCellFactory extends Application {

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

        // Create the root TreeItem
        TreeItem<String> colors = new TreeItem<>("Colors");

        // Add child TreeItems
        TreeItem<String> red = new TreeItem<>("Red");
        TreeItem<String> green = new TreeItem<>("Green");
        TreeItem<String> blue = new TreeItem<>("Blue");
        TreeItem<String> fuchsia = new TreeItem<>("Fuchsia");
        TreeItem<String> brown = new TreeItem<>("Brown");

        colors.getChildren().addAll(red, green, blue, fuchsia, brown);

        // Create the TreeView with the root item
        TreeView<String> treeView = new TreeView<>(colors);

        // Set a cell factory to customize the appearance of TreeItems
        treeView.setCellFactory(new Callback<>() {

            @Override
            public TreeCell<String> call(TreeView<String> param) {

                return new TreeCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {

                        super.updateItem(item, empty);

                        setText(item);

                        if (!empty) {

                            setStyle("-fx-text-fill: %s;".formatted(item));

                        }

                    }

                };
            }
        });

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