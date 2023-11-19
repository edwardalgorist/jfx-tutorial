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
public class TabPaneDifferentContent extends Application {

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

        // Create tabs
        Tab tab1 = new Tab("Name");
        Tab tab2 = new Tab("Essay");

        TextField textField = new TextField();
        textField.setMaxWidth(300.0);
        textField.setPromptText("Enter Your Name:");

        TextArea textArea = new TextArea();
        textArea.setPromptText("Type Your Essay Here...");

        // Add content to tabs
        tab1.setContent(new BorderPane(textField));
        tab2.setContent(new BorderPane(textArea));

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