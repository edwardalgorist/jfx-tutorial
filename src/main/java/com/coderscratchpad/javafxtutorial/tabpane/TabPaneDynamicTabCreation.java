package com.coderscratchpad.javafxtutorial.tabpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/javafx-tabpane-building-user-friendly-tabbed-interfaces/">coderscratchpad.com</a>
 */
public class TabPaneDynamicTabCreation extends Application {

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

        Button addButton = new Button("Add Tab");

        addButton.setOnAction(event -> {

            int tabNumber = tabPane.getTabs().size() + 1;

            // Create new Tab
            Tab newTab = new Tab("New Tab " + tabNumber);

            // Set content for new Tab
            newTab.setContent(new BorderPane(new Label("New Content " + tabNumber)));

            // Add tab to the TabPane
            tabPane.getTabs().add(newTab);

            // Select new Tab
            tabPane.getSelectionModel().select(newTab);

        });

        // Add the TabPane to the BorderPane layout manager
        this.parent.setCenter(tabPane);

        // Add the Button to the BorderPane layout manager
        this.parent.setBottom(addButton);

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