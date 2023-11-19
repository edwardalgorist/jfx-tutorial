package com.coderscratchpad.javafxtutorial.tabpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tabpane-building-user-friendly-tabbed-interfaces/">coderscratchpad.com</a>
 */
public class TabPaneEventHandlers extends Application {

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

        TabPane tabPane = new TabPane();

        // Create tabs with icons,
        // Assuming java.png and python.png icons are in the same directory as this Java source file
        Tab tab1 = new Tab("Tab 1");
        tab1.setGraphic(new ImageView(new Image("java.png")));

        Tab tab2 = new Tab("Tab 2");
        tab2.setGraphic(new ImageView(new Image("python.png")));

        // Event handler for tab selection
        tab1.setOnSelectionChanged(event -> {

            if (tab1.isSelected()) {
                System.out.println("Tab 1 is selected.");
            }

        });

        // Event handler for tab deselection
        tab2.setOnSelectionChanged(event -> {

            if (!tab2.isSelected()) {
                System.out.println("Tab 2 is deselected.");
            }

        });

        // Add content to tabs
        tab1.setContent(new BorderPane(new Label("Content 1")));
        tab2.setContent(new BorderPane(new Label("Content 2")));

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(tab1, tab2);

        // Add the TabPane to the BorderPane layout manager
        this.parent.setCenter(tabPane);

    }

    private void setupStage(Stage stage) {

        Scene scene = new Scene(this.parent, 640.0, 480.0);

        // Set the stage title
        stage.setTitle("JavaFX TabPane: Building User-Friendly Tabbed Interfaces");

        // Set the stage scene
        stage.setScene(scene);

        // Center the stage on the screen
        stage.centerOnScreen();

        // Show the stage on the screen
        stage.show();

    }

}